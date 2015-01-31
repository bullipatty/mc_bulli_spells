package de.bullipatty.mc.rpg.item.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.bullipatty.mc.rpg.item.equip.armor.Armor;
import de.bullipatty.mc.rpg.item.equip.materia.magic.ThunderMateria;

public class AdminInventory extends InventoryItem {
	
//	private Inventory _inventory = Bukkit.createInventory(this, 54, getName());
	
	private Inventory _inventory = null;

	protected AdminInventory(Material material, Player owner) {
		super(material, owner);
		_inventory = Bukkit.createInventory(this, 54, getName());
	}

	public static AdminInventory get(Player player) {
		return new AdminInventory(Material.CHEST, player);
	}
	
	@Override
	public String getName() {
		return "Admin Inventar";
	}

	@Override
	public Inventory getInventory() {
		return _inventory;
	}
	
	@Override
	public void onOpen(Player player) {
		_inventory.clear();
		_inventory.addItem(ThunderMateria.get(player), new Armor());
		super.onOpen(player);
	}
}
