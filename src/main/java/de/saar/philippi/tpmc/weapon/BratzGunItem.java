package de.saar.philippi.tpmc.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class BratzGunItem extends ItemSword {

	private static final ToolMaterial BRATZMATERIAL = EnumHelper.addToolMaterial("BRATZMATERIAL", 3, 1000, 15.0F, 4.0F,
			30);

	public BratzGunItem() {
		super(BRATZMATERIAL);

		setNames("bratzgun");

		setCreativeTab(CreativeTabs.COMBAT);
	}

	private void setNames(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

		return super.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {

		playerIn.playSound(SoundEvents.ENTITY_GUARDIAN_ATTACK, 2.0F, 1.0F);

		// TODO: let a block fly here and get its position to bratz (-->
		// eventhandler??)

		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}
