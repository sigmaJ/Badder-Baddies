package blue.thejester.badderbaddies.entity.enderman;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.enderman.RenderBlenderman;
import blue.thejester.badderbaddies.client.render.enderman.RenderSlenderman;
import blue.thejester.badderbaddies.entity.LootTables;
import com.google.common.base.Predicates;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Slenderman extends EntityMyEnderman {

    public static final String NAME = "enderman_slenderman";

    public Slenderman(World worldIn) {
        super(worldIn);
        this.experienceValue += 12;
    }

    @Override
    protected double healthBoost() {
        return 24;
    }

    @Override
    protected int damageBoost() {
        return 4;
    }

    @Override
    protected float magicDamage() {
        return 2;
    }

    protected Slenderman createInstance() {
        return new Slenderman(this.world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.ENDERMAN_SLENDERMAN;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if(flag && entityIn instanceof EntityLivingBase) {
            ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 2 * 20));
        }
        return flag;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, Slenderman.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x000000, 0xffffff);    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(Slenderman.class, RenderSlenderman.FACTORY);
    }
}
