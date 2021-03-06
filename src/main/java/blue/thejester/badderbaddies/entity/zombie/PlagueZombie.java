package blue.thejester.badderbaddies.entity.zombie;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.zombie.RenderPlagueZombie;
import blue.thejester.badderbaddies.client.render.zombie.RenderReachingZombie;
import blue.thejester.badderbaddies.entity.LootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlagueZombie extends EntityMyZombie {
    public static final String NAME = "zombie_plague";

    public PlagueZombie(World worldIn) {
        super(worldIn);
        this.experienceValue += 12;
    }

    @Override
    protected double healthBoost() {
        return 16;
    }

    @Override
    protected int damageBoost() {
        return 6;
    }

    @Override
    protected float magicDamage() {
        return 3;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, 80));
        }
        return flag;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.ZOMBIE_PLAGUE;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, PlagueZombie.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x009f9f, 0x65ff3d);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(PlagueZombie.class, RenderPlagueZombie.FACTORY);
    }
}
