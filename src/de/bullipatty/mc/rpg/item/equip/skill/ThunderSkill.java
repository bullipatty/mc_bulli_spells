package de.bullipatty.mc.rpg.item.equip.skill;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ThunderSkill extends Skill {

	protected ThunderSkill(Player owner) {
		super(Material.BOOK, owner);
	}
	
	@Override
	public void onQuickSlot(Player player) {
		Block block = player.getTargetBlock(null, 40);
		Location location = block.getLocation();
		location.getWorld().strikeLightning(location);
	}
	
	public static ThunderSkill get(Player owner) {
		return new ThunderSkill(owner);
	}
	
	@Override
	public void updatePopup() {
		setItemLore(getName(), "1");
		super.updatePopup();
	}
	
	@Override
	public String getName() {
		return "Blitz";
	}

}
