package de.saar.philippi.tpmc.blocks.harvester.nineblocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class Harvest3x3Helper {

	/**
	 * Gets all all block from given source (including)
	 *
	 * @param sourcePos
	 *            source block position
	 * @param level
	 *            level to determine from which level the block positiong should
	 *            be returned
	 * @param side
	 *            the side where the player clicks at the harvestblock
	 *
	 * @return a list of block position or null
	 */
	static List<BlockPos> get3x3BlockPos(BlockPos sourcePos, int level, EnumFacing side) {
		List<BlockPos> blocks3x3 = new ArrayList<BlockPos>();
		BlockPos centerPosition = null;

		switch (side) {
		case UP:
			centerPosition = new BlockPos(sourcePos.getX(), sourcePos.getY() - level, sourcePos.getZ());
			break;
		case DOWN:
			centerPosition = new BlockPos(sourcePos.getX(), sourcePos.getY() + level, sourcePos.getZ());
			break;
		case NORTH:
			centerPosition = new BlockPos(sourcePos.getX(), sourcePos.getY(), sourcePos.getZ() + level);
			break;
		case SOUTH:
			centerPosition = new BlockPos(sourcePos.getX(), sourcePos.getY(), sourcePos.getZ() - level);
			break;
		case EAST:
			centerPosition = new BlockPos(sourcePos.getX() - level, sourcePos.getY(), sourcePos.getZ());
			break;
		case WEST:
			centerPosition = new BlockPos(sourcePos.getX() + level, sourcePos.getY(), sourcePos.getZ());
			break;
		default:
			centerPosition = sourcePos;
			break;
		}

		blocks3x3.add(centerPosition);
		blocks3x3.addAll(Harvest3x3Helper.getNeighborBlocks(centerPosition, side));

		return blocks3x3;
	}

	/**
	 * Get all neighbor blocks depending on given parameters
	 *
	 * @param centerPosition
	 *            source block
	 * @param side
	 *            side from where the player hit the block
	 * @return
	 */
	private static List<BlockPos> getNeighborBlocks(BlockPos centerPosition, EnumFacing side) {
		List<BlockPos> neigbours = new ArrayList<BlockPos>();
		switch (side) {
		case UP:
		case DOWN:
			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ() + 1));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() + 1));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ() + 1));

			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ()));

			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ() - 1));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() - 1));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ() - 1));
			break;
		case SOUTH:
		case NORTH:
			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY() - 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() - 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY() - 1, centerPosition.getZ()));

			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ()));

			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY() + 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() + 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY() + 1, centerPosition.getZ()));

			break;
		case WEST:
		case EAST:
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() - 1, centerPosition.getZ() - 1));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() - 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() - 1, centerPosition.getZ() + 1));

			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() - 1));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() + 1));

			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() + 1, centerPosition.getZ() - 1));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() + 1, centerPosition.getZ()));
			neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY() + 1, centerPosition.getZ() + 1));

			break;
		default:
			break;
		}

		return neigbours;
	}
}
