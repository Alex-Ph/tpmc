package de.saar.philippi.tpmc.blocks;

import de.saar.philippi.tpmc.harvester.Harvester9x9;
import de.saar.philippi.tpmc.harvester.IsHarvester;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BooomBlock extends BasicBlock {

	private final IsHarvester harvester = new Harvester9x9(10);

	public BooomBlock() {
		super(Material.ROCK, "booom");
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

}