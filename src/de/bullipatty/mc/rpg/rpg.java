package de.bullipatty.mc.rpg;

import java.util.Iterator;
import java.util.List;


import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import de.bullipatty.mc.rpg.event.EventReceiver;

public class rpg extends JavaPlugin {
    public void onEnable() {
    //	ChunkGenerator generator = new RPGChunkGenerator();
    //	WorldCreator creator = new WorldCreator("test");
    //	creator.generator(generator);
    //	getServer().createWorld(creator);
    	
    	getServer().setDefaultGameMode(GameMode.ADVENTURE);
    	List<World> worlds = getServer().getWorlds();
    	Iterator<World> worlditerator = worlds.iterator();
    	while(worlditerator.hasNext()) {
    		World world = worlditerator.next();
    		
    		world.setGameRuleValue("commandBlockOutput", "false");
    		world.setGameRuleValue("keepInventory", "true");
    		world.setGameRuleValue("mobGriefing", "false");
    		world.setGameRuleValue("doMobSpawning", "false");
    		world.setGameRuleValue("doFireTick", "false");
    		world.setGameRuleValue("doTileDrops", "true");
    		world.setGameRuleValue("doMobLoot", "true");
    	}
        new EventReceiver(this);
    };
    public void onDisable() {
    	
    };
}
