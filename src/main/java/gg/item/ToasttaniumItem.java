
package gg.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import gg.itemgroup.DItemGroup;

import gg.GgModElements;

@GgModElements.ModElement.Tag
public class ToasttaniumItem extends GgModElements.ModElement {
	@ObjectHolder("gg:toasttanium")
	public static final Item block = null;
	public ToasttaniumItem(GgModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(DItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(9f).setAlwaysEdible().build()));
			setRegistryName("toasttanium");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 64;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Harder then steel"));
		}
	}
}
