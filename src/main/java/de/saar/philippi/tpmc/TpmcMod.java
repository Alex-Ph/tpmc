package de.saar.philippi.tpmc;

import de.saar.philippi.tpmc.proxy.CommonProxy;
import de.saar.philippi.tpmc.tpmc.TpmcModRegistry;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TpmcMod.MODID, version = TpmcMod.VERSION, name = "Tpmc")
public class TpmcMod {
	public static final String MODID = "tpmc";
	public static final String VERSION = "1.0";

	public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", 3, 1000, 15.0F, 4.0F, 30);

	@SidedProxy(clientSide = "de.saar.philippi.tpmc.proxy.ClientProxy", serverSide = "de.saar.philippi.tpmc.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		TpmcModRegistry.registerBlocks();

		// GameRegistry.register(new ItemModSword("tutorial_sword", TUTORIAL));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		TpmcModRegistry.registerRecipes();

		proxy.registerClientData();
	}
}