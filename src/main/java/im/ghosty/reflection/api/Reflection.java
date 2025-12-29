package im.ghosty.reflection.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Reflection {

	private static Plugin initiator;
	
	public static void initialize(Plugin plugin) {
		if(initiator != null) throw new ReflectionAlreadyInitializedException();
		if(plugin == null) throw new RuntimeException("plugin must be defined.");
		initiator = plugin;
		
		Bukkit.getConsoleSender().sendMessage("Real plugin loaded!");
	}
	
	public static class ReflectionAlreadyInitializedException extends RuntimeException {
		
		public ReflectionAlreadyInitializedException() {
			super("Reflection was already initialized using '" + initiator.getName() + "'.");
		}
		
	}

}
