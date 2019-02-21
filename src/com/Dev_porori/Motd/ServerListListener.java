package com.Dev_porori.Motd;

import static com.Dev_porori.Motd.Util.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Main.cf.set("players." + e.getPlayer().getAddress().getAddress().getHostAddress().replace(".", "-"),
				e.getPlayer().getName());
		Main.instance.saveConfig();
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onServerPing(ServerListPingEvent e) {
		String ip = String.valueOf(e.getAddress().getHostAddress()).replace(".", "-");
		String motd1 = replacePlayerName(replaceColor(Main.cf.getString("motd.Line-1")), ip);
		String motd2 = replacePlayerName(replaceColor(Main.cf.getString("motd.Line-2")), ip);
		e.setMotd(motd1 + "\n" + motd2);
	}

	private static String replacePlayerName(String contents, String ip) {
		return contents.replace("%player%",
				Main.cf.getString("players." + ip) != null ? Main.cf.getString("players." + ip) : "");
	}

}
