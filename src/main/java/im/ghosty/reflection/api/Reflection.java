package im.ghosty.reflection.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Reflection {

	private static Plugin initiator;
	
	/**
	 * Initializes Reflection API.
	 * @param plugin The plugin that was used to start the initialization
	 */
	public static void initialize(Plugin plugin) {
		if(initiator != null) throw new ReflectionAlreadyInitializedException();
		if(plugin == null) throw new NullPointerException("plugin must be defined.");
		initiator = plugin;
		
		Bukkit.getConsoleSender().sendMessage("Real plugin loaded!");
	}
	
	/**
	 * This Exception is thrown when Reflection API has already been initialized.
	 * @see Reflection#initialize(Plugin)
	 */
	public static class ReflectionAlreadyInitializedException extends RuntimeException {
		
		public ReflectionAlreadyInitializedException() {
			super("Reflection was already initialized using '" + initiator.getName() + "'.");
		}
		
	}

}
