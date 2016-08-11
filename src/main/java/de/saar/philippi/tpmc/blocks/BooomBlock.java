package de.saar.philippi.tpmc.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BooomBlock extends BasicBlock {

	public BooomBlock() {
		super(Material.ROCK, "booom");
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		worldIn.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 40, true, true);
	}

}
