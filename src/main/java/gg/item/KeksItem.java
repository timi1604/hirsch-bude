
package gg.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

import gg.procedures.KeksFoodEatenProcedure;

import gg.itemgroup.Timi1604ItemGroup;

import gg.GgModElements;

@GgModElements.ModElement.Tag
public class KeksItem extends GgModElements.ModElement {
	@ObjectHolder("gg:keks")
	public static final Item block = null;
	public KeksItem(GgModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(Timi1604ItemGroup.tab).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("keks");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 6;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				KeksFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
