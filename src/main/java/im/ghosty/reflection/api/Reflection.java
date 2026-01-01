package im.ghosty.reflection.api;

import org.bukkit.plugin.java.JavaPlugin;

public class Reflection extends JavaPlugin {
	
	private boolean wasInitiated = false;
	
	@Override
	public void onLoad() {
		if (wasInitiated) return;
		wasInitiated = true;
		this.getLogger().info("hiiii i'm cute right? :3");
	}
	
}
