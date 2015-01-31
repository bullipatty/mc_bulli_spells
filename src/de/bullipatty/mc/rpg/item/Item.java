package de.bullipatty.mc.rpg.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import de.bullipatty.mc.rpg.util.ItemLore;
import de.bullipatty.mc.rpg.util.Target;

public class Item extends ItemStack {
	
	private static HashMap<Long, Item> _items = new HashMap<Long, Item>();
	
	private ItemLore _lore = new ItemLore();

	private long _id = 0;
	
	private OfflinePlayer _owner = null;
	
	public static final Item get(ItemStack item) {
		long id = getIDFromItemStack(item);
		if(_items.containsKey(id))
			return _items.get(id);
		else if(item != null)
			return new Item(item);
		else
			return null;
	}
	
	public static final Item get(ItemStack item, Player owner) {
		long id = getIDFromItemStack(item);
		if(_items.containsKey(id))
			return _items.get(id);
		else if(item != null)
			return new Item(item, owner);
		else
			return null;
	}
	
	@SuppressWarnings("unused")
	private static long _nextID = 0;

	private static synchronized long getNextID() {
		return Long.parseLong(RandomStringUtils.random(8, true, true), 36);
		//return _nextID++;
	}

	protected Item(ItemStack item, Player owner) {
		super(item);
		init(owner);
	}
	protected Item(Material material, Player owner) {
		super(material);
		init(owner);
	}
	protected Item(ItemStack item) {
		super(item);
		init(null);
	}
	protected Item(Material material) {
		super(material);
		init(null);
	}
	
	private void init(Player owner) {
		long id = getNextID();
		_id = id;
		_owner = owner;
		_items.put(id, this);
		_lore = new ItemLore(this);
		_lore.set("ID", getIDString());
		if(owner != null)
			_lore.set("Besitzer", _owner.getName());
		updatePopup();
	}
	
	public long getID() {
		return _id;
	}
	
	public String getIDString() {
		return Long.toString(_id, 36).toUpperCase();
	}
	
	public String getDisplayName(){
		return getItemMeta().getDisplayName();
	}
	
	public void setDisplayName(String displayName) {
		ItemMeta itemMeta = getItemMeta();
		if(displayName != null && itemMeta != null) {
			itemMeta.setDisplayName(displayName);
			setItemMeta(itemMeta);
		}
	}

	@Override
	public ItemMeta getItemMeta() {
		ItemMeta itemMeta = super.getItemMeta();
		if(itemMeta == null)
			itemMeta = Bukkit.getItemFactory().getItemMeta(getType());
		return itemMeta;
	}
	
	public List<String> getLore(){
		ItemMeta itemMeta = getItemMeta();
		List<String> lore = itemMeta.getLore();
		if(lore == null) lore = new ArrayList<String>();
		return lore;
	}
	
	public void setItemLore(String key, String val) {
		_lore.set(key, val);
	}
	
	public String getName() {
		return getType().name();
	}
	
	public OfflinePlayer getOwner() {
		return _owner;
	}

	public void setLore(List<String> lore) {
		ItemMeta itemMeta = getItemMeta();
		if(lore != null && itemMeta != null) {
			itemMeta.setLore(lore);
			this.setItemMeta(itemMeta);
		}
	}

	public void updatePopup() {
		setDisplayName(getName());
		setLore(_lore.getLore());
	}
	
	static protected long getIDFromItemStack(ItemStack stack) {
		ItemLore lore = new ItemLore(stack);
		if(lore.has("ID")) {
			String s = lore.get("ID");
			return Long.parseLong(s, 36);
		}
		return -1;
	}
	
	public void onQuickSlot(Player player) {
		
	}
	
	public void onInteract(Player player, Target target) {
		
	}
	
	public void onBowShot(Player player, float force, Projectile projectile) {
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> s = super.serialize();
		s.put("owner", _owner.getName());
		s.put("id", _id);
		return s;
	}
	
	public static Item deserialize(Map<String, Object> args) {
		ItemStack stack = ItemStack.deserialize(args);
		return new Item(stack, args);
	}
	
	public Item(ItemStack stack, Map<String, Object> args) {
	}
	
}
