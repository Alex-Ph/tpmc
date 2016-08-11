package de.saar.philippi.tpmc.proxy;

import de.saar.philippi.tpmc.TpmcMod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClientData() {
		registerItems(TpmcMod.gabbaItem);

		registerBlock(TpmcMod.gabbaBlock);
	}

	private void registerItems(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}

	private void registerBlock(Block block) {
		Item itemFromBlock = Item.getItemFromBlock(block);

		if (itemFromBlock == null) {
			return;
		}

		registerItems(itemFromBlock);
	}
}