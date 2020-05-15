package blue.thejester.badderbaddies.client.render.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class LayerSpiderEyesBlue<T extends EntitySpider> extends LayerSpiderEyesGeneric<T> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/spider_eyes_blue.png");

    public LayerSpiderEyesBlue(RenderSpider<T> spiderRendererIn) {
        super(spiderRendererIn);
    }

    @Override
    protected ResourceLocation getTexture() {
        return TEXTURES;
    }
}
