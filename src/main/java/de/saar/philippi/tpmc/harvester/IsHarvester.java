package de.saar.philippi.tpmc.harvester;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IsHarvester {
	/**
	 * this method triggers the harvesting
	 *
	 * @param worldIn
	 * @param pos
	 * @param side
	 *            side where the user clicked on the block
	 */
	void harvest(World worldIn, BlockPos pos, EnumFacing side);
}
