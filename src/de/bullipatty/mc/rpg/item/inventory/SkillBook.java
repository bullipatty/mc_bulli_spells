package de.bullipatty.mc.rpg.item.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.bullipatty.mc.rpg.item.Item;
import de.bullipatty.mc.rpg.item.equip.Slotted;
import de.bullipatty.mc.rpg.item.equip.materia.magic.MagicMateria;
import de.bullipatty.mc.rpg.item.equip.skill.Skill;

public class SkillBook extends InventoryItem {
	
	private Inventory _inventory = null;

	public SkillBook(Player owner) {
		super(Material.BOOK, owner);
		_inventory = Bukkit.createInventory(this, 54, getName());
		updatePopup();
	}
	
	public static SkillBook get(Player owner) {
		SkillBook spellBook = new SkillBook(owner);
		return spellBook;
	}
	
	@Override
	public String getName() {
		return "Skill Buch";
	}

	@Override
	public Inventory getInventory() {
		return _inventory;
	}
	
	@Override
	public void onOpen(Player player) {
		Player owner = getOwner().getPlayer();
		ItemStack[] stacks = owner.getInventory().getArmorContents();
		_inventory.clear();
		for(ItemStack is1: stacks) {
			Item armor = Item.get(is1);
			if(armor instanceof Slotted) {
				ItemStack[] slots = ((Slotted) armor).getInventory().getContents();
				for(ItemStack is2: slots) {
					Item item = Item.get(is2);
					if(item instanceof MagicMateria) {
						_inventory.addItem(((MagicMateria) item).getSkill(owner));
					}
				}
			}
		}
	}
	
	@Override
	public void onAddItem(InventoryMoveItemEvent event) {
		Item item = Item.get(event.getItem());
		if(!(item instanceof Skill))
			event.setCancelled(true);
		super.onAddItem(event);
	}
	
	@Override
	protected boolean isValidItem(Item item) {
		if(item instanceof Skill)
			return true;
		return false;
	}

}
