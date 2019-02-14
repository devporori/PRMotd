package com.Dev_porori.Motd;

import static com.Dev_porori.Motd.Util.*;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main instance;
	public static FileConfiguration cf;

	public void onEnable() {
		instance = this;
		createConfig();
		Bukkit.getPluginManager().registerEvents(new ServerListListener(), this);
		getCommand("prmotd").setExecutor(new Commands());
		log("플러그인이 활성화 되었습니다!");
		log("현재 버전 : " + getDescription().getVersion());
	}

	public void reloadcf() {
		reloadConfig();
		cf = getConfig();
	}

	private void createConfig() {
		saveDefaultConfig();
		cf = getConfig();
	}

}
