package de.saar.philippi.tpmc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public abstract class BasicBlock extends Block {

	public BasicBlock(Material materialIn, String name) {
		super(materialIn);

		setUnlocalizedName(name);
		setRegistryName(name);

		setHarvestLevel("pickaxe", 0);
	}

	public ItemBlock asItemBlock() {
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(getRegistryName());

		return itemBlock;
	}
}
