package de.bullipatty.mc.rpg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.inventory.ItemStack;

public class ItemLore{
	
	private HashMap<String, String> _map = new HashMap<String, String>();
	
	public ItemLore() {
	}
	
	public ItemLore(List<String> list) {
		parseList(list);
	}
	
	public ItemLore(ItemStack stack) {
		if(stack != null && stack.hasItemMeta() && stack.getItemMeta().hasLore())
			parseList(stack.getItemMeta().getLore());
	}
	
	public ItemLore set(String key, String val) {
		_map.put(key, val);
		return this;
	}
	
	public String get(String key) {
		if(_map.containsKey(key))
			return _map.get(key);
		else
			return null;
	}
	
	public boolean has(String key) {
		return _map.containsKey(key);
	}
	
	public List<String> getLore() {
		List<String> out = new ArrayList<String>();
		for(Entry<String, String> e: _map.entrySet()) {
			out.add(e.getKey()+": "+e.getValue());
		}
		return out;
	}
	
	private void parseList(List<String> list) {
		for(String s: list) {
			String[] strarr = s.split("[:]\\s");
			if(strarr.length == 2) {
				_map.put(strarr[0], strarr[1]);
			}
		}
	}
}
