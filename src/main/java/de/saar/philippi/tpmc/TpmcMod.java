package de.saar.philippi.tpmc;

import de.saar.philippi.tpmc.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TpmcMod.MODID, version = TpmcMod.VERSION, name = "Tpmc")
public class TpmcMod {
	public static final String MODID = "tpmc";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "de.saar.philippi.tpmc.proxy.ClientProxy", serverSide = "de.saar.philippi.tpmc.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		TpmcModFactory.registerBlocks();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		TpmcModFactory.registerRecipes();

		proxy.registerClientData();
	}
}