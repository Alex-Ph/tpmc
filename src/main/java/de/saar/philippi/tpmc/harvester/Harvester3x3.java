package de.saar.philippi.tpmc.harvester;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Harvester3x3 implements IsHarvester {
	private int level;

	/**
	 * Creates Harvester
	 *
	 * @param level
	 *            depth for harvesting
	 */
	public Harvester3x3(int level) {
		this.level = level;
	}

	@Override
	public void harvest(World worldIn, BlockPos pos, EnumFacing side) {
		for (int i = 0; i <= level; i++) {

			List<BlockPos> blocks = HarvestHelper.get3x3BlockPos(pos, i, side);

			blocks.forEach(blockPosToChange -> harvestBlock(worldIn, blockPosToChange));

			addHarvestStuff(worldIn, pos, i, side);
		}

	}

	private void harvestBlock(World worldIn, BlockPos blockPosToChange) {
		if (worldIn.getBlockState(blockPosToChange).getBlock().getDefaultState().isFullBlock()) {
			worldIn.destroyBlock(blockPosToChange, true);
		}
	}

	private void addHarvestStuff(World worldIn, BlockPos sourcePos, int level, EnumFacing side) {
		switch (side) {
		case UP:
			BlockPos blockPosUp = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() - level, sourcePos.getZ());
			worldIn.setBlockState(blockPosUp, Blocks.LADDER.getDefaultState());

			if (level % 3 == 0) {
				BlockPos blockPosTorch = new BlockPos(sourcePos.getX() - 3, sourcePos.getY() - level, sourcePos.getZ());

				if (worldIn.getBlockState(blockPosTorch).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosTorch, Blocks.TORCH.getDefaultState());
				}
			}

			break;
		case DOWN:
			BlockPos blockLadder = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() + level, sourcePos.getZ());
			worldIn.setBlockState(blockLadder, Blocks.LADDER.getDefaultState());

			if (level % 3 == 0) {
				BlockPos blockPosTorch = new BlockPos(sourcePos.getX() - 3, sourcePos.getY() + level, sourcePos.getZ());

				if (worldIn.getBlockState(blockPosTorch).getBlock().getDefaultState().isFullBlock()) {
					worldIn.setBlockState(blockPosTorch, Blocks.TORCH.getDefaultState());
				}
			}
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
