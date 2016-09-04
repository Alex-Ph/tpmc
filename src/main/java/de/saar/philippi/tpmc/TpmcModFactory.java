package de.saar.philippi.tpmc;

import de.saar.philippi.tpmc.blocks.harvester.Harvest10UnitsBlock;
import de.saar.philippi.tpmc.tabs.GabbaCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TpmcModFactory {
	private static final Harvest10UnitsBlock harvest10Block = new Harvest10UnitsBlock();

	// this stuff inits and creates the tab and with this it becomes visible
	public static final CreativeTabs gabbaCreativeTab = new GabbaCreativeTab();

	public static Harvest10UnitsBlock getHarvest10block() {
		return harvest10Block;
	}

	public static CreativeTabs getGabbacreativetab() {
		return gabbaCreativeTab;
	}

	public static void registerBlocks() {
		// Blocks
		GameRegistry.register(TpmcModFactory.getHarvest10block());

		// ItemBlock
		GameRegistry.register(TpmcModFactory.getHarvest10block().asItemBlock());
	}

	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(TpmcModFactory.getHarvest10block()), "dd", "dd", 'd', Blocks.DIRT);

	}
}
