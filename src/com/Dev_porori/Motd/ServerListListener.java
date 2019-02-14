package com.Dev_porori.Motd;

import static com.Dev_porori.Motd.Util.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onServerPing(ServerListPingEvent e) {
		String motd1 = replaceColor(Main.cf.getString("motd.Line-1"));
		String motd2 = replaceColor(Main.cf.getString("motd.Line-2"));
		e.setMotd(motd1 + "\n" + motd2);
	}

}
