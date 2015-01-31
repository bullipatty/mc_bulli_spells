package de.bullipatty.mc.rpg.item.inventory;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import de.bullipatty.mc.rpg.item.Item;


@SuppressWarnings("rawtypes")
public abstract class InventoryItem extends Item implements InventoryHolder {
	
	protected InventoryItem(Material material, Player owner) {
		super(material, owner);
	}
	protected InventoryItem(Material material) {
		super(material);
	}
	
	public void onOpen(Player player) {}

	public void onClose(Player player) {
		Inventory inventory = getInventory();
		for(int i = 0; i < inventory.getSize(); i++) {
			Item item = Item.get(inventory.getItem(i));
			if(!isValidItem(item)) {
				Player owner = getOwner().getPlayer();
				inventory.clear(i);
				HashMap<Integer, ItemStack> fails = owner.getInventory().addItem(item);
				if(fails.size() == 0)
					owner.sendMessage("Einige Items wurden in das Spielerinventar verschoben.");
				else
					owner.sendMessage("Einige Items konnten nicht in das Spielerinventar verschoben werden.");
			}
		}
	}
	
	public void onAddItem(InventoryMoveItemEvent event) {
		Item item = Item.get(event.getItem());
		if(item instanceof InventoryItem)
			event.setCancelled(true);
	}
	
	@Override
	public void onQuickSlot(Player player) {
		player.openInventory(getInventory());
		super.onQuickSlot(player);
	}
	
	protected Class[] invalidClass() {
		return null;
	}

	protected Class[] validClass() {
		return null;
	}
	
	protected boolean isValidItem(Item item) {
		boolean isValid = true;
		Class[] valid = validClass();
		if(valid.length > 0)
			for(Class c: valid)
				if(!c.isInstance(item))
					isValid = false;
		for(Class c: invalidClass())
			if(c.isInstance(item))
				isValid = false;
		return isValid;
	}
		
}
