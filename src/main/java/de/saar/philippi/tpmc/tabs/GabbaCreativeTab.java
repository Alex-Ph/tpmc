package de.saar.philippi.tpmc.tabs;

import de.saar.philippi.tpmc.TpmcModFactory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GabbaCreativeTab extends CreativeTabs {

	public GabbaCreativeTab() {
		super("gabba");

		TpmcModFactory.getHarvest10block().setCreativeTab(this);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TpmcModFactory.getHarvest10block());
	}

}
