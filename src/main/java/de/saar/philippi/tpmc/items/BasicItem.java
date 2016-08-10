package de.saar.philippi.tpmc.items;

import net.minecraft.item.Item;

public abstract class BasicItem extends Item {

	public BasicItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}

}
