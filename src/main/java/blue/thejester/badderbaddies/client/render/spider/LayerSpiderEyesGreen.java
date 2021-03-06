package blue.thejester.badderbaddies.client.render.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerSpiderEyesGreen extends LayerSpiderEyesGeneric {

    private static final ResourceLocation TEXTURES = new ResourceLocation(BadderBaddies.MODID, "textures/entity/spider_eyes_green.png");

    public LayerSpiderEyesGreen(RenderSpider spiderRendererIn) {
        super(spiderRendererIn);
    }

    @Override
    protected ResourceLocation getTexture() {
        return TEXTURES;
    }
}
