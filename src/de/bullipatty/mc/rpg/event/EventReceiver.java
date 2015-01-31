package de.bullipatty.mc.rpg.event;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

import de.bullipatty.mc.rpg.item.Item;
import de.bullipatty.mc.rpg.item.inventory.AdminInventory;
import de.bullipatty.mc.rpg.item.inventory.InventoryItem;
import de.bullipatty.mc.rpg.item.inventory.SkillBook;
import de.bullipatty.mc.rpg.util.SpellRecipe;
import de.bullipatty.mc.rpg.util.Target;

public class EventReceiver implements Listener {
	
	public EventReceiver(JavaPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(new EventReceiver(plugin), plugin);	
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onCraftItemEvent(CraftItemEvent evt){
		
		Player player = null;
		if(evt.getWhoClicked() instanceof Player)
			player = (Player) evt.getWhoClicked();
		else return;
		player.sendMessage("CraftItemEvent");
		
		if(evt.getRecipe() instanceof SpellRecipe) {
			SpellRecipe recipe = (SpellRecipe) evt.getRecipe();
			recipe.setResultFor(evt.getInventory());
		}
    }

	@EventHandler(priority = EventPriority.HIGH)
    public void onPrepareItemCraftEvent(PrepareItemCraftEvent evt){
		
		Player player = null;
		if(evt.getViewers().get(0) instanceof Player)
			player = (Player) evt.getViewers().get(0);
		else return;
		player.sendMessage("PrepareItemCraftEvent");
		
		if(evt.getRecipe() instanceof SpellRecipe) {
			SpellRecipe recipe = (SpellRecipe) evt.getRecipe();
			recipe.setResultFor(evt.getInventory());
		}
    }

	@EventHandler(priority = EventPriority.HIGH)
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent evt){
		int newSlot = evt.getNewSlot();
		Player player = evt.getPlayer();
		Inventory inventory = player.getInventory();
		Item item = Item.get(inventory.getItem(newSlot));
		if(newSlot != 0 && item != null) {
			item.onQuickSlot(player);
		} else if(newSlot == 8) {
			player.openInventory(player.getEnderChest());
		}
		player.getInventory().setHeldItemSlot(0);
		evt.setCancelled(true);
    }

	@EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent evt){
		Player player = evt.getPlayer();
		Block block = evt.getClickedBlock();
		Item item = Item.get(player.getItemInHand());
		item.onInteract(player, Target.get(block));
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEntityEvent evt){
		Player player = evt.getPlayer();
		Entity entity = evt.getRightClicked();
		Item item = Item.get(player.getItemInHand());
		item.onInteract(player, Target.get(entity));
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoinEvent(PlayerJoinEvent evt){
		Player player = (Player) evt.getPlayer();
		Inventory inventory = player.getInventory();
		inventory.clear();
		if(player.isOp())
			inventory.setItem(8, AdminInventory.get(player));
		inventory.setItem(7, SkillBook.get(player));
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onEntityShootBowEvent(EntityShootBowEvent evt){
		LivingEntity entity = evt.getEntity();
		if(entity instanceof Player) {
			Player player = (Player) entity;
			Item item = Item.get(evt.getBow());
			item.onBowShot(player, evt.getForce(), (Projectile) evt.getProjectile());
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onInventoryOpenEvent(InventoryOpenEvent evt){
		Player player = (Player) evt.getPlayer();
		Inventory inventory = evt.getInventory();
		InventoryHolder holder = inventory.getHolder();
		if(holder instanceof InventoryItem) {
			((InventoryItem) holder).onOpen(player);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onInventoryCloseEvent(InventoryCloseEvent evt){
		Player player = (Player) evt.getPlayer();
		Inventory inventory = evt.getInventory();
		InventoryHolder holder = inventory.getHolder();
		if(holder instanceof InventoryItem) {
			((InventoryItem) holder).onClose(player);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onInventoryMoveItemEvent(InventoryMoveItemEvent evt){
		InventoryHolder holder = evt.getDestination().getHolder();
		Player[] players = Bukkit.getOnlinePlayers();
		for(Player player: players) {
			player.sendMessage("InventoryMoveItemEvent");
		}
		if(holder instanceof InventoryItem) {
			((InventoryItem) holder).onAddItem(evt);
		}
	}

	@EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClickEvent(InventoryClickEvent evt){
	}
}
