package de.saar.philippi.tpmc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BasicBlock extends Block {

	public BasicBlock(Material materialIn, String name) {
		super(materialIn);

		setUnlocalizedName(name);
		setRegistryName(name);
	}

}
