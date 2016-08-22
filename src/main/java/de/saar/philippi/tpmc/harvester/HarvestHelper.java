package de.saar.philippi.tpmc.harvester;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class HarvestHelper {
	public static List<BlockPos> getNeighbourBlocks(BlockPos centerPosition, EnumFacing side) {
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
			neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ() - 1));
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

	public static List<BlockPos> get9x9BlockPos(BlockPos sourcePos, int level, EnumFacing side) {
		List<BlockPos> blocks9x9 = new ArrayList<>();
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

		blocks9x9.add(centerPosition);
		blocks9x9.addAll(HarvestHelper.getNeighbourBlocks(centerPosition, side));

		return blocks9x9;
	}
}
