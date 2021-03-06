package blue.thejester.badderbaddies.entity.spider;

import blue.thejester.badderbaddies.BadderBaddies;
import blue.thejester.badderbaddies.client.render.cavespider.RenderLeapingCaveSpider;
import blue.thejester.badderbaddies.client.render.spider.RenderLeapingSpider;
import blue.thejester.badderbaddies.entity.LootTables;
import blue.thejester.badderbaddies.entity.ai.EntityAIBigLeapAtTarget;
import blue.thejester.badderbaddies.entity.cavespider.EntityMyCaveSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeapingSpider extends EntityMySpider {
    public static final String NAME = "spider_leaping";

    public LeapingSpider(World worldIn) {
        super(worldIn);
        this.experienceValue += 12;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        super.fall(distance, 0);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIBigLeapAtTarget(this, 0.6F));
    }

    @Override
    protected double healthBoost() {
        return 14;
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
    protected float speedMult() {
        return 1f;
    }

    @Override
    protected float sizeChange() {
        return 1f;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTables.SPIDER_LEAPING;
    }

    public static void registerSelf(int id) {
        ResourceLocation entity_name = new ResourceLocation(BadderBaddies.MODID, NAME);
        EntityRegistry.registerModEntity(entity_name, LeapingSpider.class, NAME, id,
                BadderBaddies.instance, 64, 3, true,
                0x29241f, 0x0a592a);
    }

    @SideOnly(Side.CLIENT)
    public static void registerOwnRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(LeapingSpider.class, RenderLeapingSpider.FACTORY);
    }
}
