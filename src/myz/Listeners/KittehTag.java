/**
 * 
 */
package myz.Listeners;

import myz.MyZ;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;

/**
 * @author Jordan
 * 
 */
public class KittehTag implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	private void onNameTagsReceived(PlayerReceiveNameTagEvent e) {
		if (!MyZ.instance.getWorlds().contains(e.getNamedPlayer().getWorld().getName()))
			return;

		Player player = e.getNamedPlayer();

		if (MyZ.instance.isBandit(player))
			e.setTag(ChatColor.RED + e.getTag());
		else if (MyZ.instance.isHealer(player))
			e.setTag(ChatColor.GREEN + e.getTag());
		if (MyZ.instance.isFriend(e.getPlayer().getName(), player.getName()))
			e.setTag(ChatColor.BLUE + e.getTag());
	}

	/**
	 * Color the name of the given player based on bandit/healer definitions.
	 * 
	 * @param player
	 *            The player.
	 */
	public static void colorName(Player player) {
		if (MyZ.instance.isBandit(player) || MyZ.instance.isHealer(player))
			TagAPI.refreshPlayer(player);
	}
}
