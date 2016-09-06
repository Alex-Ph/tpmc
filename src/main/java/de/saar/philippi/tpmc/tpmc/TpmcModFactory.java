package de.saar.philippi.tpmc.tpmc;

import de.saar.philippi.tpmc.blocks.harvester.Harvest10UnitsBlock;
import de.saar.philippi.tpmc.weapon.BratzGunItem;

public class TpmcModFactory {
	private static final Harvest10UnitsBlock HARVEST_10BLOCKS = new Harvest10UnitsBlock();
	private static final BratzGunItem BRATZGUNITEM = new BratzGunItem();

	public static Harvest10UnitsBlock getHarvest10block() {
		return HARVEST_10BLOCKS;
	}

	public static BratzGunItem getBratzGunItem() {
		return BRATZGUNITEM;
	}
}
