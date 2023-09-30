package twilightforest.entity.finalcastle;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import twilightforest.client.particle.TFParticleType;

//summon twilightforest:bursting_cube ~ ~ ~ {direction:[0.0,0.0,0.0]}
public class EntityTFBurstingCube extends EntityFireball {
    private int ticksInAir;
    public int explosionPower = 1;
    public EntityTFBurstingCube(World p_i1767_1_) {
        super(p_i1767_1_);
    }

    @SideOnly(Side.CLIENT)
    public EntityTFBurstingCube(World p_i1768_1_, double p_i1768_2_, double p_i1768_4_, double p_i1768_6_, double p_i1768_8_, double p_i1768_10_, double p_i1768_12_) {
        super(p_i1768_1_, p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_, p_i1768_10_, p_i1768_12_);
    }

    public EntityTFBurstingCube(World p_i1769_1_, EntityLivingBase p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(p_i1769_1_, p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_);
    }
    @Override
    public void onUpdate() {
        if (this.world.isRemote || (this.shootingEntity == null || !this.shootingEntity.isDead) && this.world.isBlockLoaded(new BlockPos(this))) {

            ++this.ticksInAir;
            //TODO:Bounce off the wall
            RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, true, false, this.shootingEntity);
            if (raytraceresult != null && !ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
                this.onImpact(raytraceresult);
            }

            this.posX += this.motionX;
            this.posZ += this.motionZ;
            ProjectileHelper.rotateTowardsMovement(this, 0.2F);
            float f = this.getMotionFactor();
            if (this.isInWater()) {
                for(int i = 0; i < 4; ++i) {
                    float f1 = 0.25F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
                }

                f = 0.8F;
            }

            this.motionX += this.accelerationX;
            this.motionZ += this.accelerationZ;
            this.motionX *= (double)f;
            this.motionZ *= (double)f;
            for (int i = 0; i < 3; i++) {
                float px = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.75F;
                float py = this.getEyeHeight() - 0.25F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.75F;
                float pz = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.75F;

                TwilightForestMod.proxy.spawnParticle(TFParticleType.ANNIHILATE, this.lastTickPosX + px, this.lastTickPosY + py, this.lastTickPosZ + pz, 0, 0, 0);
            }
            this.setPosition(this.posX, this.posY, this.posZ);
        } else {
            this.setDead();
        }

    }

    protected void onImpact(RayTraceResult p_onImpact_1_) {
        if (!this.world.isRemote) {
            if (p_onImpact_1_.entityHit != null) {
                p_onImpact_1_.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);
                this.applyEnchantments(this.shootingEntity, p_onImpact_1_.entityHit);
            }

            boolean flag = ForgeEventFactory.getMobGriefingEvent(this.world, this.shootingEntity);
            this.world.newExplosion((Entity)null, this.posX, this.posY, this.posZ, (float)this.explosionPower, flag, flag);
            this.setDead();
        }

    }

    public static void registerFixesTFBurstingCube(DataFixer p_registerFixesTFBurstingCube_0_) {
        EntityFireball.registerFixesFireball(p_registerFixesTFBurstingCube_0_, "Fireball");
    }
    @Override
    public boolean attackEntityFrom(DamageSource p_attackEntityFrom_1_, float p_attackEntityFrom_2_) {
        if (this.isEntityInvulnerable(p_attackEntityFrom_1_)) {
            return false;
        } else {
            this.markVelocityChanged();
            if (p_attackEntityFrom_1_.getTrueSource() != null) {
                Vec3d vec3d = p_attackEntityFrom_1_.getTrueSource().getLookVec();
                if (vec3d != null) {
                    this.motionX = vec3d.x;
                    this.motionZ = vec3d.z;
                    this.accelerationX = this.motionX * 0.1;
                    this.accelerationZ = this.motionZ * 0.1;
                }

                if (p_attackEntityFrom_1_.getTrueSource() instanceof EntityLivingBase) {
                    this.shootingEntity = (EntityLivingBase)p_attackEntityFrom_1_.getTrueSource();
                }

                return true;
            } else {
                return false;
            }
        }
    }
    protected boolean isFireballFiery() {
        return false;
    }
}
