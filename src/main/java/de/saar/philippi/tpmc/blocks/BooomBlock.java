package de.saar.philippi.tpmc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BooomBlock extends BasicBlock {

	public BooomBlock() {
		super(Material.ROCK, "booom");
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {

		for (int i = 0; i <= 10; i++) {
			BlockPos blockPos = new BlockPos(pos.getX(), pos.getY() - i, pos.getZ());

			removeBlock(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ() + 1, worldIn);
			removeBlock(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1, worldIn);
			removeBlock(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ() + 1, worldIn);

			removeBlock(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ(), worldIn);
			removeBlock(blockPos.getX(), blockPos.getY(), blockPos.getZ(), worldIn);
			removeBlock(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ(), worldIn);

			removeBlock(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ() - 1, worldIn);
			removeBlock(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1, worldIn);
			removeBlock(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ() - 1, worldIn);

			setBlockTo(blockPos.getX() - 2, blockPos.getY(), blockPos.getZ(), worldIn, Blocks.LADDER);
		}

	}

	private void setBlockTo(int x, int y, int z, World worldIn, Block block) {
		BlockPos blockPos = new BlockPos(x, y, z);
		worldIn.setBlockState(blockPos, block.getDefaultState());
	}

	private void removeBlock(int x, int y, int z, World worldIn) {
		BlockPos blockPos = new BlockPos(x, y, z);
		// IBlockState ladderBlockState = worldIn.getBlockState(blockPos);
		// worldIn.setBlockState(blockPos,
		// ladderBlockState.getBlock().harvestBlock(worldIn, player, pos, state,
		// te, stack););
		worldIn.setBlockToAir(blockPos);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 40, true, true);

		givegGlowingPotionEffect();

	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		givegGlowingPotionEffect();
	}

	private void givegGlowingPotionEffect() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;

		player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 1));
	}

}
