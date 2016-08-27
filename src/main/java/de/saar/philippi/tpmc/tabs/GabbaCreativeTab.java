package de.saar.philippi.tpmc.tabs;

import de.saar.philippi.tpmc.TpmcMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GabbaCreativeTab extends CreativeTabs {

	public GabbaCreativeTab() {
		super("gabba");

		TpmcMod.booomBlock.setCreativeTab(this);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TpmcMod.booomBlock);
	}

}
