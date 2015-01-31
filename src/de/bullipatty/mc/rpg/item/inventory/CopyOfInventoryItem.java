package de.bullipatty.mc.rpg.item.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import de.bullipatty.mc.rpg.item.Item;

public abstract class CopyOfInventoryItem extends Item implements InventoryHolder {

	private Inventory _inventory = null;
	
	protected CopyOfInventoryItem(Inventory inventory, ItemStack item, Player owner) {
		super(item, owner);
		init(inventory);
	}
	protected CopyOfInventoryItem(Inventory inventory, Material material, Player owner) {
		super(material, owner);
		init(inventory);
	}
	protected CopyOfInventoryItem(Inventory inventory, ItemStack item) {
		super(item);
		init(inventory);
	}
	protected CopyOfInventoryItem(Inventory inventory, Material material) {
		super(material);
		init(inventory);
	}
	private void init(Inventory inventory) {
		_inventory = inventory;
	}

	@Override
	public Inventory getInventory() {
		return _inventory;
	}
	
	
	
	@Override
	public void onQuickSlot(Player player) {
		player.openInventory(getInventory());
		super.onQuickSlot(player);
	}
	
}
