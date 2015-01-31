package de.bullipatty.mc.rpg.item.equip;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import de.bullipatty.mc.rpg.item.Item;
import de.bullipatty.mc.rpg.item.equip.materia.Materia;
import de.bullipatty.mc.rpg.item.inventory.InventoryItem;

public class Slotted extends InventoryItem {
	
	private Inventory _inventory = null;

	public Slotted(Material material) {
		super(material);
		_inventory = Bukkit.createInventory(this, 9, getName());
	}

	@Override
	public Inventory getInventory() {
		return _inventory;
	}

	@Override
	protected boolean isValidItem(Item item) {
		if(item instanceof Materia)
			return true;
		return false;
	}

}
