package blue.thejester.badderbaddies;

import blue.thejester.badderbaddies.core.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashSet;
import java.util.Set;

@Mod(modid = BadderBaddies.MODID, name = BadderBaddies.NAME, version = BadderBaddies.VERSION, dependencies = BadderBaddies.DEPENDS)
public class BadderBaddies
{
    public static final String MODID = "badderbaddies";
    public static final String NAME = "Badder Baddies";
    public static final String VERSION = "1.0";
    public static final String DEPENDS = "";

    public static Logger logger;

    public static Set<String> subtilesForCreativeMenu = new LinkedHashSet();

    // The instance of your mod that Forge uses.  Optional.
    @Mod.Instance(BadderBaddies.MODID)
    public static BadderBaddies instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="blue.thejester.badderbaddies.core.ClientOnlyProxy", serverSide="blue.thejester.badderbaddies.core.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        proxy.preInit();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
