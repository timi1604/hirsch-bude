
package gg.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import gg.item.ButtonItem;

import gg.GgModElements;

@GgModElements.ModElement.Tag
public class SupFuel extends GgModElements.ModElement {
	public SupFuel(GgModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ButtonItem.block, (int) (1)).getItem())
			event.setBurnTime(75000);
	}
}
