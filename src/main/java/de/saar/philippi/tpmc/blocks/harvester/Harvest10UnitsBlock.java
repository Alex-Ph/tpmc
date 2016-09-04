package de.saar.philippi.tpmc.blocks.harvester;

import de.saar.philippi.tpmc.blocks.harvester.nineblocks.Harvester3x3;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This Block destroys 3x3x10 (10 = level) blocks depending on the clicked side
 * of this block
 *
 * @author AlexP
 *
 */
public class Harvest10UnitsBlock extends Block {

	private final Harvester3x3 harvester = new Harvester3x3(10);

	public Harvest10UnitsBlock() {
		super(Material.ROCK);

		setNames("harvest10Block");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	private void setNames(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

		harvester.harvest(worldIn, pos, side);

		return true;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 40, true, true);
	}

	public ItemBlock asItemBlock() {
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(getRegistryName());

		return itemBlock;
	}

}