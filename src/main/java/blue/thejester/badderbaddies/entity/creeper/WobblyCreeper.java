package blue.thejester.badderbaddies.entity.creeper;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.creeper.RenderWobblyCreeper;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WobblyCreeper extends EntityMyCreeper {

    public static final String NAME = "creeper_wobbly";

    public WobblyCreeper(World worldIn) {
        super(worldIn);
        this.experienceValue += 22;
    }

    @Override
    protected double healthBoost() {
        return 12;
    }

    @Override
    protected int fuseTimer() {
        return 30;
    }

    protected WobblyCreeper createInstance() {
        return new WobblyCreeper(this.world);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!world.isRemote) {
            if(world.rand.nextInt() % 256 == 0) {
                this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 50, 3));
            }
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.CREEPER_WOBBLY;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, WobblyCreeper.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0xdc90ed, 0x58258b);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(WobblyCreeper.class, RenderWobblyCreeper.FACTORY);
    }
}
