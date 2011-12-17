package com.turt2live.mea.API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.turt2live.mea.External.Download;
import com.turt2live.mea.External.Unzip;
import com.turt2live.mea.Hook.MeaHook;
import com.turt2live.mea.Logger.MeaLogger;
import com.turt2live.mea.SQL.MeaSQL;
import com.turt2live.mea.plugin.MultiFunction;

public class MeaAPI {

	private MeaHook		hook;
	private MeaLogger	log;
	private Download	download;
	private Unzip		unzip;
	private MeaSQL		sql;
	private JavaPlugin	meaSuite;

	public MeaAPI() {
		meaSuite = (JavaPlugin) Bukkit.getServer().getPluginManager().getPlugin("meaSuite");
		if (meaSuite == null) return;
		hook = new MeaHook(meaSuite);
		sql = new MeaSQL(meaSuite);
	}

	public String addColor(String line, boolean toIRC) {
		line = hook.addColor(line);
		line = MultiFunction.addColor(line, meaSuite);
		if (toIRC) line = MultiFunction.convertToIRCColors(line, meaSuite, true);
		return line;
	}

	public FileConfiguration getConfig(JavaPlugin module) {
		String moduleName = module.getDescription().getName();
		File file = new File(meaSuite.getDataFolder(), (moduleName + ".yml".replaceAll(" ", "_")));
		if (!file.exists()) try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			log(e);
		}
		FileConfiguration config = new YamlConfiguration();
		try {
			config.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log(e);
		} catch (IOException e) {
			e.printStackTrace();
			log(e);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			log(e);
		}
		return config;
	}

	public FileConfiguration getConfig() {
		return meaSuite.getConfig();
	}

	public void reload() {
		meaSuite.reloadConfig();
	}

	public ResultSet SQLSearchQuery(String query) {
		return sql.query(query);
	}

	public void SQLModificationQuery(String query) {
		sql.query(query);
	}

	public void SQLFileParse(File SQLFile) {
		sql.query(SQLFile);
	}

	public void log(Exception e) {
		StackTraceElement stack[] = e.getStackTrace();
		String error = "";
		for (StackTraceElement line : stack)
			error = error + line.toString() + "\r\n";
		log.log(error);
	}

	public void log(String line) {
		log.log(line);
	}

	public void log(String line, File file) {
		MeaLogger.log(line, file, meaSuite);
	}

	public static String timestamp(boolean filemode) {
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Date date = new Date();
		return (filemode) ? (dateFormat.format(date)).replaceAll(" ", "-").replaceAll("\\:", "").replaceAll("\\,", "") : dateFormat.format(date);
	}
}
