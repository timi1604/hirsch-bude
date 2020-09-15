
package gg.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import gg.itemgroup.Timi1604ItemGroup;

import gg.GgModElements;

@GgModElements.ModElement.Tag
public class GgItem extends GgModElements.ModElement {
	@ObjectHolder("gg:gg")
	public static final Item block = null;
	public GgItem(GgModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(Timi1604ItemGroup.tab).maxStackSize(64));
			setRegistryName("gg");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
