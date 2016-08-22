package de.saar.philippi.tpmc.harvester;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IsHarvester {
	/**
	 * this method triggers the harvesting
	 * 
	 * @param worldIn
	 * @param pos
	 */
	void harvest(World worldIn, BlockPos pos);
}
