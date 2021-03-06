package blue.thejester.badderbaddies.entity.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.enderman.RenderBlenderman;
import blue.thejester.badderbaddies.client.render.enderman.RenderRenderman;
import blue.thejester.badderbaddies.entity.LootTables;
import com.google.common.base.Predicates;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Renderman extends EntityMyEnderman {

    public static final String NAME = "enderman_renderman";

    public Renderman(World worldIn) {
        super(worldIn);
        this.experienceValue += 18;
    }

    @Override
    protected double healthBoost() {
        return 40;
    }

    @Override
    protected int damageBoost() {
        return 6;
    }

    @Override
    protected float magicDamage() {
        return 4;
    }

    protected Renderman createInstance() {
        return new Renderman(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.ENDERMAN_RENDERMAN;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Renderman.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xff00ff, 0x000000);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Renderman.class, RenderRenderman.FACTORY);
    }
}
