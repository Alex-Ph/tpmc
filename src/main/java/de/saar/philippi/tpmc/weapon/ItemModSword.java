package de.saar.philippi.tpmc.weapon;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
	public ItemModSword(String unlocalizedName, ToolMaterial material) {
		super(material);

		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(unlocalizedName);
	}
}
