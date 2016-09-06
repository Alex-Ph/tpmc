package de.saar.philippi.tpmc.tpmc;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TpmcModRegistry {
	public static void registerBlocks() {
		// Blocks
		GameRegistry.register(TpmcModFactory.getHarvest10block());

		// ItemBlock
		GameRegistry.register(TpmcModFactory.getHarvest10block().asItemBlock());
	}

	public static void registerRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(TpmcModFactory.getHarvest10block()), "dd", "dd", 'd', Blocks.DIRT);
	}

	public static void registerItems() {
		GameRegistry.register(TpmcModFactory.getBratzGunItem());

	}
}
