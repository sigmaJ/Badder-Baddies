package blue.thejester.badderbaddies.client.render.stray;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSlimingStrayClothing implements LayerRenderer<EntityStray> {
    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/stray_sliming_rags.png");
    private final RenderLivingBase<?> renderer;
    private final ModelSkeleton layerModel = new ModelSkeleton(0.25F, true);

    public LayerSlimingStrayClothing(RenderLivingBase<?> p_i47183_1_)
    {
        this.renderer = p_i47183_1_;
    }

    public void doRenderLayer(EntityStray entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(TEXTURES);
        this.layerModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
