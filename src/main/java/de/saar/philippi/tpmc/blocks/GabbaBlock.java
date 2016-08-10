package de.saar.philippi.tpmc.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class GabbaBlock extends BasicBlock {

	public GabbaBlock() {
		super(Material.ROCK, "gabba_ore");
	}

	public ItemBlock asItemBlock() {
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(getRegistryName());

		return itemBlock;
	}

}
