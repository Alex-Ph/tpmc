package de.saar.philippi.tpmc.blocks.harvester.nineblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Harvester3x3 {
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

	public void harvest(World worldIn, BlockPos pos, EnumFacing side) {
		for (int i = 0; i <= level; i++) {

			List<BlockPos> blocks = Harvest3x3Helper.get3x3BlockPos(pos, i, side);

			for (BlockPos blockPos : blocks) {
				harvestBlock(worldIn, blockPos);
			}

			addTools(worldIn, pos, i, side);
		}

	}

	private void harvestBlock(World worldIn, BlockPos blockPosToChange) {
		if (worldIn.getBlockState(blockPosToChange).getBlock().getDefaultState().isFullBlock()) {
			worldIn.destroyBlock(blockPosToChange, true);
		}
	}

	/**
	 * Adds tools like torches
	 *
	 * @param worldIn
	 * @param sourcePos
	 * @param level
	 * @param side
	 */
	private void addTools(World worldIn, BlockPos sourcePos, int level, EnumFacing side) {
		switch (side) {
		case UP:
			BlockPos blockPosLadder = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() - level, sourcePos.getZ());
			setBlock(worldIn, blockPosLadder, Blocks.LADDER);

			if (level % 3 == 0) {
				BlockPos blockPosTorch = new BlockPos(sourcePos.getX() - 3, sourcePos.getY() - level, sourcePos.getZ());

				setBlock(worldIn, blockPosTorch, Blocks.GLOWSTONE);
			}

			break;
		case DOWN:
			BlockPos blockLadder = new BlockPos(sourcePos.getX() - 2, sourcePos.getY() + level, sourcePos.getZ());
			setBlock(worldIn, blockLadder, Blocks.LADDER);

			if (level % 3 == 0) {
				BlockPos blockPosTorch = new BlockPos(sourcePos.getX() - 3, sourcePos.getY() + level, sourcePos.getZ());

				setBlock(worldIn, blockPosTorch, Blocks.GLOWSTONE);
			}
			break;
		case SOUTH:
		case NORTH:
			if (level % 3 == 0) {
				BlockPos blockPosLeft = new BlockPos(sourcePos.getX() - 2, sourcePos.getY(), sourcePos.getZ() - level);
				BlockPos blockPosRight = new BlockPos(sourcePos.getX() - 2, sourcePos.getY(), sourcePos.getZ() + level);

				setBlock(worldIn, blockPosLeft, Blocks.GLOWSTONE);
				setBlock(worldIn, blockPosRight, Blocks.GLOWSTONE);
			}
			break;
		case EAST:
		case WEST:
			if (level % 3 == 0) {
				BlockPos blockPosLeft = new BlockPos(sourcePos.getX() - level, sourcePos.getY(), sourcePos.getZ() - 2);
				BlockPos blockPosRight = new BlockPos(sourcePos.getX() + level, sourcePos.getY(), sourcePos.getZ() - 2);

				setBlock(worldIn, blockPosLeft, Blocks.GLOWSTONE);
				setBlock(worldIn, blockPosRight, Blocks.GLOWSTONE);
			}
			break;
		default:
			break;
		}

	}

	/**
	 * Sets a given block on given position (only if position contains a
	 * fullblock block)
	 *
	 * @param worldIn
	 * @param blockPos
	 * @param block
	 */
	private void setBlock(World worldIn, BlockPos blockPos, Block block) {
		if (worldIn.getBlockState(blockPos).getBlock().getDefaultState().isFullBlock()) {
			worldIn.setBlockState(blockPos, block.getDefaultState());
		}
	}
}
