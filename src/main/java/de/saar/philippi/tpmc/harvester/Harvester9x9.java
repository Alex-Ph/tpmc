package de.saar.philippi.tpmc.harvester;

import java.util.List;

import de.saar.philippi.tpmc.Direction;
import de.saar.philippi.tpmc.blocks.helper.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Harvester9x9 implements IsHarvester {
	private int level;

	/**
	 * Creates Harvester
	 *
	 * @param level
	 *            depth for harvesting
	 */
	public Harvester9x9(int level) {
		this.level = level;
	}

	@Override
	public void harvest(World worldIn, BlockPos pos) {
		for (int i = 0; i <= level; i++) {

			List<BlockPos> blocks = BlockHelper.get9x9BlockPos(pos, i, Direction.Y);

			blocks.forEach(blockPosToChange -> worldIn.destroyBlock(blockPosToChange, true));

			addHarvestStuff(worldIn, pos, i, Direction.Y);
		}

	}

	private void addHarvestStuff(World worldIn, BlockPos sourcePos, int level, Direction direction) {
		switch (direction) {
		case Y:
			BlockPos blockPos = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() - level, sourcePos.getZ());
			worldIn.setBlockState(blockPos, Blocks.LADDER.getDefaultState());
			break;

		default:
			break;
		}

	}
}
