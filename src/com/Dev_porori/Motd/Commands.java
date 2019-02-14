package com.Dev_porori.Motd;

import static com.Dev_porori.Motd.Util.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("prmotd")) {
			if (!sender.hasPermission("PRMotd.Admin")) {
				sendMessage(sender, "당신은 권한이 없습니다.");
				return false;
			}
			if (args.length == 0) {
				sendMessage(sender, "/PRMotd set [Line1, Line2] [Contents]");
				sendMessage(sender, "/PRMotd view");
				sendMessage(sender, "/PRMotd reload");
				return false;
			}
			if (args[0].equalsIgnoreCase("set")) {
				if (args.length < 3) {
					sendMessage(sender, "/PRMotd set [Line1, Line2] [Contents]");
					return false;
				}
				if (args[1].equalsIgnoreCase("Line1")) {
					StringBuilder sb = new StringBuilder();
					for (int i = 3; i <= args.length; i++)
						sb.append(args[i - 1] + (i == args.length ? "" : " "));
					Main.cf.set("motd.Line-1", String.valueOf(sb));
					sendMessage(sender, "1번 라인의 Motd를 설정하였습니다. §7[ §f" + sb + " §7]");
					Main.instance.saveConfig();
					return false;
				}
				if (args[1].equalsIgnoreCase("Line2")) {
					StringBuilder sb = new StringBuilder();
					for (int i = 3; i <= args.length; i++)
						sb.append(args[i - 1] + (i == args.length ? "" : " "));
					Main.cf.set("motd.Line-2", String.valueOf(sb));
					sendMessage(sender, "2번 라인의 Motd를 설정하였습니다. §7[ §f" + sb + " §7]");
					Main.instance.saveConfig();
					return false;
				}
			}
			if (args[0].equalsIgnoreCase("view")) {
				sendMessage(sender, "§fLine 1 §7: §f" + Main.cf.getString("motd.Line-1"));
				sendMessage(sender, "§fLine 2 §7: §f" + Main.cf.getString("motd.Line-2"));
				return false;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				Main.instance.reloadcf();
				sendMessage(sender, "콘피그를 다시 불러왔습니다.");
				return false;
			}
		}
		return false;
	}

}
