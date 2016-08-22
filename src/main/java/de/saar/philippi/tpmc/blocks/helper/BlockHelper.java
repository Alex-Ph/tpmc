package de.saar.philippi.tpmc.blocks.helper;

import java.util.ArrayList;
import java.util.List;

import de.saar.philippi.tpmc.Direction;
import net.minecraft.util.math.BlockPos;

public class BlockHelper {
	public static List<BlockPos> getNeighbourBlocks(BlockPos centerPosition) {
		List<BlockPos> neigbours = new ArrayList<BlockPos>();
		neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ() + 1));
		neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() + 1));
		neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ() + 1));

		neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ()));
		neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ()));

		neigbours.add(new BlockPos(centerPosition.getX() - 1, centerPosition.getY(), centerPosition.getZ() - 1));
		neigbours.add(new BlockPos(centerPosition.getX(), centerPosition.getY(), centerPosition.getZ() - 1));
		neigbours.add(new BlockPos(centerPosition.getX() + 1, centerPosition.getY(), centerPosition.getZ() - 1));

		return neigbours;
	}

	public static List<BlockPos> get9x9BlockPos(BlockPos sourcePos, int level, Direction direction) {
		List<BlockPos> blocks9x9 = new ArrayList<>();
		BlockPos centerPosition = null;
		List<BlockPos> neigbours = new ArrayList<>();

		switch (direction) {
		case Y:
			centerPosition = new BlockPos(sourcePos.getX(), sourcePos.getY() - level, sourcePos.getZ());
			neigbours = BlockHelper.getNeighbourBlocks(centerPosition);

			break;

		default:
			centerPosition = sourcePos;
			break;
		}

		blocks9x9.add(centerPosition);
		blocks9x9.addAll(neigbours);

		return blocks9x9;
	}
}
