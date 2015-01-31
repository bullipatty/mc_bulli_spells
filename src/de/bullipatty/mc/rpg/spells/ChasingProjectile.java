package de.bullipatty.mc.rpg.spells;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.bullipatty.mc.rpg.util.BulliVector;

public class ChasingProjectile implements Spell{
	
	private static HashMap<Projectile, ChasingProjectile> projectiles;
	
	public ChasingProjectile(JavaPlugin plugin, LivingEntity target, Projectile projectile) {
		ChasingProjectileTask task = new ChasingProjectileTask((LivingEntity)target, projectile);
       	task.runTaskTimer(plugin, 1, 1);
       	projectiles.put(projectile, this);
	}
	
	private class ChasingProjectileTask extends BukkitRunnable {
		
		private LivingEntity _target;
		private Projectile _projectile;
		private int c = 0;
		private int minc = 30;
		private int midc = 60;
		private int maxc = 100;
		//Vector _vector;
		
		public ChasingProjectileTask(LivingEntity target, Projectile projectile) {
			_target = target;
			_projectile = projectile;
		}

		@Override
		public void run() {
			if(_projectile != null && _projectile.isValid() && _projectile.getVelocity().length() > 0.1
					&& _target != null && _target.isValid() && !_target.isDead() && c < maxc) {
				Vector vector = _target.getEyeLocation().subtract(_projectile.getLocation()).toVector();
				BulliVector velocity = new BulliVector(_projectile.getVelocity());
				if(c < minc)
					velocity.spinTo(2, vector);
				else if(c < midc)
					velocity.spinTo(0+(midc-c-minc)*(2d/(midc-minc)), vector);
				else
					velocity.spinTo(0, vector);
				velocity.normalize();
				if(velocity.length() == velocity.length())
					_projectile.setVelocity(velocity);
				c++;
			}else{
				this.cancel();
			}
		}
		
		
	}
	
	public static final String name = "Chasing Arrow";

	public static void load(JavaPlugin plugin) {
		projectiles = new HashMap<Projectile, ChasingProjectile>();
		plugin.getServer().getPluginManager().registerEvents(new ChasingProjectileListener(plugin), plugin);
	}
	
	private static class ChasingProjectileListener implements Listener {
		
		private JavaPlugin _plugin;
		
		public ChasingProjectileListener(JavaPlugin plugin) {
			_plugin = plugin;
		}

	    @SuppressWarnings("unused")
		@EventHandler
	    public void onEntityShootBowEvent(EntityShootBowEvent evt){
	    	
	    		Projectile projectile = (Projectile) evt.getProjectile();
	    		LivingEntity shooter = projectile.getShooter();
	    		if(shooter instanceof Player) {
	    			Player player = (Player) shooter;
	    			
		    		ItemStack item = player.getItemInHand();
		        	ItemMeta meta = item.getItemMeta();
		        	List<String> lorelist = meta.getLore();
		        	Iterator<String> loreiterator = lorelist.iterator();
		        	String[] args;
		        	int lvl;
		        	int exp;
			        while(loreiterator.hasNext()){
			        	String lore = loreiterator.next();
			        	args = lore.split("|");
			        	if(args[0]=="Chasing Arrow" && args.length == 3) {
			        		lvl = Integer.parseInt(args[1]);
			        		exp = Integer.parseInt(args[2]);
			        	}
			        }
		        	
		        //	lore.contains("Chasing Arrow");
				    List<Entity> list = shooter.getNearbyEntities(20, 20, 20);
			        Iterator<Entity> iterator = list.iterator();
		    		int c = 0;
			        while(iterator.hasNext() && c < 2){
			        	Entity target = iterator.next();
			        	if(player.hasLineOfSight(target) && target instanceof LivingEntity && !target.equals(player)) {
			        		c++;
					      	new ChasingProjectile(_plugin, (LivingEntity)target, projectile);
			        	}
		    		}
	    		}
	    }

	}

	@Override
	public long getExpToLvl(int lvl) {
		return 100 << lvl;
	}

}
