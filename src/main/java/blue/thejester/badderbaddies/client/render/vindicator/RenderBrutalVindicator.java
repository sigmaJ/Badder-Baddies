package blue.thejester.badderbaddies.client.render.vindicator;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.vindicator.BrutalVindicator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVindicator;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderBrutalVindicator extends RenderVindicator {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/vindicator_brutal.png");

    public RenderBrutalVindicator(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMob entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderBrutalVindicator.Factory FACTORY = new RenderBrutalVindicator.Factory();

    public static class Factory implements IRenderFactory<BrutalVindicator> {
        @Override
        public Render<? super BrutalVindicator> createRenderFor(RenderManager renderManager) {
            return new RenderBrutalVindicator(renderManager);
        }
    }
}
