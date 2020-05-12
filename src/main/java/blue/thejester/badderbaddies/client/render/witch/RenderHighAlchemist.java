package blue.thejester.badderbaddies.client.render.witch;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.entity.witch.HighAlchemist;
import blue.thejester.badderbaddies.entity.witch.PreparedWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderHighAlchemist extends RenderWitch {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(BadderBaddies.MODID, "textures/entity/witch_high_alchemist.png");

    public RenderHighAlchemist(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return TEXTURE_LOCATION;
    }

    public static final RenderHighAlchemist.Factory FACTORY = new RenderHighAlchemist.Factory();

    public static class Factory implements IRenderFactory<HighAlchemist> {
        @Override
        public Render<? super HighAlchemist> createRenderFor(RenderManager renderManager) {
            return new RenderHighAlchemist(renderManager);
        }
    }
}
