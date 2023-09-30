package twilightforest.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import twilightforest.TwilightForestMod;
import twilightforest.client.model.entity.ModelTFCubeOfAnnihilation;
import twilightforest.entity.finalcastle.EntityTFBurstingCube;
import twilightforest.entity.finalcastle.EntityTFRovingCube;

public class RenderTFBurstingCube extends Render<EntityTFBurstingCube> {

	private static final ResourceLocation textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
	private final ModelBase model = new ModelTFCubeOfAnnihilation();

	public RenderTFBurstingCube(RenderManager manager) {
		super(manager);
	}

	@Override
	public void doRender(EntityTFBurstingCube entity, double x, double y, double z, float yaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);

		this.bindEntityTexture(entity);

		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		GlStateManager.rotate(MathHelper.wrapDegrees(((float) x + (float) z + ((Entity) entity).ticksExisted + partialTicks) * 11F), 0, 1, 0);

		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GlStateManager.translate(0F, 0.25F, 0F);
		this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, partialTicks, 0.0625F / 2F);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();

		GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTFBurstingCube entity) {
		return textureLoc;
	}
}
