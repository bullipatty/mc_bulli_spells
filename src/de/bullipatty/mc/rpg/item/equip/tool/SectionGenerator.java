package de.bullipatty.mc.rpg.item.equip.tool;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.bullipatty.mc.rpg.item.Item;
import de.bullipatty.mc.rpg.util.Target;

public class SectionGenerator extends Item {

	protected SectionGenerator(Player owner) {
		super(Material.STICK, owner);
	}
	
	@Override
	public String getName() {
		return "SectionGenerator";
	}
	
	public SectionGenerator get(Player owner) {
		return new SectionGenerator(owner);
	}
	
	@Override
	public void onInteract(Player player, Target target) {
	//	Location location = target.getLocation();
	//	World world = location.getWorld();
	//	world.regenerateChunk(location.getBlockX(), location.getBlockZ());
	//	world.lo
	}
	
}
