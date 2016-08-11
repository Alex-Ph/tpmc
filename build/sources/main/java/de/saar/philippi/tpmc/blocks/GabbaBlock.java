package de.saar.philippi.tpmc.blocks;

import java.util.List;
import java.util.Random;

import de.saar.philippi.tpmc.TpmcMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GabbaBlock extends BasicBlock {

	public GabbaBlock() {
		super(Material.ROCK, "gabba_ore");
	}

	public ItemBlock asItemBlock() {
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(getRegistryName());

		return itemBlock;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return TpmcMod.gabbaItem;
	}

	@Override
	public int quantityDropped(Random random) {
		return 2;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add("Bla bla");
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		// worldIn.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 7,
		// true, true);
		worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX() + 1, pos.getY(), pos.getZ(), true));
	}

}
