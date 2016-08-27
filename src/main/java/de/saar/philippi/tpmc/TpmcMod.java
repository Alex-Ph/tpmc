package de.saar.philippi.tpmc;

import de.saar.philippi.tpmc.blocks.Harvest10UnitsBlock;
import de.saar.philippi.tpmc.proxy.CommonProxy;
import de.saar.philippi.tpmc.tabs.GabbaCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TpmcMod.MODID, version = TpmcMod.VERSION, name = "Tpmc")
public class TpmcMod {
	public static final String MODID = "tpmc";
	public static final String VERSION = "1.0";

	public static final Harvest10UnitsBlock harvest10Block = new Harvest10UnitsBlock();

	@SidedProxy(clientSide = "de.saar.philippi.tpmc.proxy.ClientProxy", serverSide = "de.saar.philippi.tpmc.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final CreativeTabs gabbaCreativeTab = new GabbaCreativeTab();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// Blocks
		GameRegistry.register(harvest10Block);

		// ItemBlock
		GameRegistry.register(harvest10Block.asItemBlock());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		// Receipe
		GameRegistry.addShapedRecipe(new ItemStack(harvest10Block), "dd", "dd", 'd', Blocks.DIRT);

		proxy.registerClientData();
	}
}