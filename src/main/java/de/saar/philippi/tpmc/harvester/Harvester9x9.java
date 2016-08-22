package de.saar.philippi.tpmc.harvester;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
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
	public void harvest(World worldIn, BlockPos pos, EnumFacing side) {
		System.out.println("Side: " + side);

		for (int i = 0; i <= level; i++) {

			List<BlockPos> blocks = HarvestHelper.get9x9BlockPos(pos, i, side);

			blocks.forEach(blockPosToChange -> worldIn.destroyBlock(blockPosToChange, true));

			addHarvestStuff(worldIn, pos, i, side);
		}

	}

	private void addHarvestStuff(World worldIn, BlockPos sourcePos, int level, EnumFacing side) {
		switch (side) {
		case UP:
			BlockPos blockPosUp = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() - level, sourcePos.getZ());
			worldIn.setBlockState(blockPosUp, Blocks.LADDER.getDefaultState());
			break;
		case DOWN:
			BlockPos blockPosDown = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() + level, sourcePos.getZ());
			worldIn.setBlockState(blockPosDown, Blocks.LADDER.getDefaultState());
			break;
		case SOUTH:
		case NORTH:
			if (level % 3 == 0) {
				BlockPos blockPosLeft = new BlockPos(sourcePos.getX() - 2, sourcePos.getY(), sourcePos.getZ() - level);
				BlockPos blockPosRight = new BlockPos(sourcePos.getX() - 2, sourcePos.getY(), sourcePos.getZ() + level);

				if (worldIn.getBlockState(blockPosLeft).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosLeft, Blocks.TORCH.getDefaultState());
				}

				if (worldIn.getBlockState(blockPosRight).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosRight, Blocks.TORCH.getDefaultState());
				}
			}
			break;
		case EAST:
		case WEST:
			if (level % 3 == 0) {
				BlockPos blockPosLeft = new BlockPos(sourcePos.getX() - level, sourcePos.getY(), sourcePos.getZ() - 2);
				BlockPos blockPosRight = new BlockPos(sourcePos.getX() + level, sourcePos.getY(), sourcePos.getZ() - 2);

				if (worldIn.getBlockState(blockPosLeft).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosLeft, Blocks.TORCH.getDefaultState());
				}

				if (worldIn.getBlockState(blockPosRight).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosRight, Blocks.TORCH.getDefaultState());
				}
			}
			break;
		default:
			break;
		}

	}
}
