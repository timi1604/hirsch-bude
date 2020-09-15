
package gg.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import gg.itemgroup.Timi1604ItemGroup;

import gg.GgModElements;

@GgModElements.ModElement.Tag
public class ToastItem extends GgModElements.ModElement {
	@ObjectHolder("gg:toast")
	public static final Item block = null;
	public ToastItem(GgModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(Timi1604ItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(30f).build()));
			setRegistryName("toast");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 70;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
