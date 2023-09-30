package twilightforest.entity.finalcastle;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.TFSounds;
import twilightforest.TwilightForestMod;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.ITFCharger;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFHarbingerCube extends EntityMob  implements ITFCharger {

	public static final ResourceLocation LOOT_TABLE = TwilightForestMod.prefix("entities/harbinger_cube");
	private static final DataParameter<Boolean> CHARGING = EntityDataManager.createKey(EntityTFMinotaur.class, DataSerializers.BOOLEAN);

	public EntityTFHarbingerCube(World world) {
		super(world);
		this.setSize(1.9F, 2.4F);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAITFChargeAttack(this, 4.0F, 1.0F,0.0F,256.0F,true));
		this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(CHARGING, false);
	}

	@Override
	public boolean isCharging() {
		return dataManager.get(CHARGING);
	}

	@Override
	public void setCharging(boolean flag) {
		dataManager.set(CHARGING, flag);
	}
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		boolean success = super.attackEntityAsMob(entity);

		if (success && this.isCharging()) {
			entity.motionY += 0.4;
			playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		}

		return success;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (isCharging()) {
			this.limbSwingAmount += 0.6;
			playSound(TFSounds.HARBINGER_CUBE_CHARGE, getSoundVolume() * 4F, getSoundPitch());
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return TFSounds.HARBINGER_CUBE_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return TFSounds.HARBINGER_CUBE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() { return TFSounds.HARBINGER_CUBE_DEATH; }

	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		playSound(TFSounds.HARBINGER_CUBE_STEP, 0.15F, 0.8F);
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LOOT_TABLE;
	}
}
