package de.saar.philippi.tpmc.blocks;

import de.saar.philippi.tpmc.harvester.Harvester9x9;
import de.saar.philippi.tpmc.harvester.IsHarvester;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BooomBlock extends BasicBlock {

	private final IsHarvester harvester = new Harvester9x9(10);

	public BooomBlock() {
		super(Material.ROCK, "booom");
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {

		// System.out.println("HarvestInfo: " + worldIn.block);
		harvester.harvest(worldIn, pos);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 40, true, true);
	}

}