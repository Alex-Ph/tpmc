package de.saar.philippi.tpmc.tpmc;

import de.saar.philippi.tpmc.blocks.harvester.Harvest10UnitsBlock;

public class TpmcModFactory {
	private static final Harvest10UnitsBlock HARVEST_10BLOCKS = new Harvest10UnitsBlock();

	public static Harvest10UnitsBlock getHarvest10block() {
		return HARVEST_10BLOCKS;
	}
}
