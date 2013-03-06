package me.microgeek.plugins.simplesign;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author microgeek
 */
public class SimpleSign extends JavaPlugin implements Listener {

	/* (non-Javadoc)
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 */
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	/**
	 * Handle sign placement
	 * @param e Event to handle
	 */
	public void onSignPlace(SignChangeEvent e) {
		if(e.getPlayer().hasPermission("simplesign.color") || e.getPlayer().isOp()) {
			int index = 0;
			for(String s : e.getLines()) {
				e.setLine(index, ChatColor.translateAlternateColorCodes('&', s));
				index++;
			}
		}
	}
	
}
