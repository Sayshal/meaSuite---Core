package me.turt2live.meaSuite.plugin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.plugin.java.JavaPlugin;
import org.jibble.pircbot.Colors;

import me.turt2live.meaSuite.Math.Expression;

public class MultiFunction {

	public static String merge(String array[], int startAt) {
		String message = "";
		for (int i = startAt; i < array.length; i++)
			message = message.concat(array[i] + " ");
		return message;
	}

	public static String addColor(String message, JavaPlugin plugin) {
		String colorSeperator = plugin.getConfig().getString("meaSuite.colorVariable");
		message = message.replaceAll(colorSeperator + "0", ChatColor.getByCode(0x0).toString());
		message = message.replaceAll(colorSeperator + "1", ChatColor.getByCode(0x1).toString());
		message = message.replaceAll(colorSeperator + "2", ChatColor.getByCode(0x2).toString());
		message = message.replaceAll(colorSeperator + "3", ChatColor.getByCode(0x3).toString());
		message = message.replaceAll(colorSeperator + "4", ChatColor.getByCode(0x4).toString());
		message = message.replaceAll(colorSeperator + "5", ChatColor.getByCode(0x5).toString());
		message = message.replaceAll(colorSeperator + "6", ChatColor.getByCode(0x6).toString());
		message = message.replaceAll(colorSeperator + "7", ChatColor.getByCode(0x7).toString());
		message = message.replaceAll(colorSeperator + "8", ChatColor.getByCode(0x8).toString());
		message = message.replaceAll(colorSeperator + "9", ChatColor.getByCode(0x9).toString());
		message = message.replaceAll(colorSeperator + "a", ChatColor.getByCode(0xA).toString());
		message = message.replaceAll(colorSeperator + "b", ChatColor.getByCode(0xB).toString());
		message = message.replaceAll(colorSeperator + "c", ChatColor.getByCode(0xC).toString());
		message = message.replaceAll(colorSeperator + "d", ChatColor.getByCode(0xD).toString());
		message = message.replaceAll(colorSeperator + "e", ChatColor.getByCode(0xE).toString());
		message = message.replaceAll(colorSeperator + "f", ChatColor.getByCode(0xF).toString());
		message = message.replaceAll(colorSeperator + "A", ChatColor.getByCode(0xA).toString());
		message = message.replaceAll(colorSeperator + "B", ChatColor.getByCode(0xB).toString());
		message = message.replaceAll(colorSeperator + "C", ChatColor.getByCode(0xC).toString());
		message = message.replaceAll(colorSeperator + "D", ChatColor.getByCode(0xD).toString());
		message = message.replaceAll(colorSeperator + "E", ChatColor.getByCode(0xE).toString());
		message = message.replaceAll(colorSeperator + "F", ChatColor.getByCode(0xF).toString());
		return message;
	}

	public static String removeColor(String message, JavaPlugin plugin) {
		String colorSeperator = plugin.getConfig().getString("meaSuite.colorVariable");
		message = message.replaceAll(colorSeperator + "0", "");
		message = message.replaceAll(colorSeperator + "1", "");
		message = message.replaceAll(colorSeperator + "2", "");
		message = message.replaceAll(colorSeperator + "3", "");
		message = message.replaceAll(colorSeperator + "4", "");
		message = message.replaceAll(colorSeperator + "5", "");
		message = message.replaceAll(colorSeperator + "6", "");
		message = message.replaceAll(colorSeperator + "7", "");
		message = message.replaceAll(colorSeperator + "8", "");
		message = message.replaceAll(colorSeperator + "9", "");
		message = message.replaceAll(colorSeperator + "a", "");
		message = message.replaceAll(colorSeperator + "b", "");
		message = message.replaceAll(colorSeperator + "c", "");
		message = message.replaceAll(colorSeperator + "d", "");
		message = message.replaceAll(colorSeperator + "e", "");
		message = message.replaceAll(colorSeperator + "f", "");
		message = message.replaceAll(colorSeperator + "A", "");
		message = message.replaceAll(colorSeperator + "B", "");
		message = message.replaceAll(colorSeperator + "C", "");
		message = message.replaceAll(colorSeperator + "D", "");
		message = message.replaceAll(colorSeperator + "E", "");
		message = message.replaceAll(colorSeperator + "F", "");
		message = ChatColor.stripColor(message);
		message = Colors.removeFormattingAndColors(message);
		return message;
	}

	public static String convertToIRCColors(String message, JavaPlugin plugin, boolean isInBukkitFormat) {
		if (!isInBukkitFormat) message = MultiFunction.addColor(message, plugin);
		message = message.replaceAll(ChatColor.getByCode(0x0).toString(), Colors.BLACK);
		message = message.replaceAll(ChatColor.getByCode(0x1).toString(), Colors.DARK_BLUE);
		message = message.replaceAll(ChatColor.getByCode(0x2).toString(), Colors.DARK_GREEN);
		message = message.replaceAll(ChatColor.getByCode(0x3).toString(), Colors.TEAL);
		message = message.replaceAll(ChatColor.getByCode(0x4).toString(), Colors.RED);
		message = message.replaceAll(ChatColor.getByCode(0x5).toString(), Colors.DARK_BLUE);
		message = message.replaceAll(ChatColor.getByCode(0x6).toString(), Colors.OLIVE);
		message = message.replaceAll(ChatColor.getByCode(0x7).toString(), Colors.DARK_GRAY);
		message = message.replaceAll(ChatColor.getByCode(0x8).toString(), Colors.DARK_GRAY);
		message = message.replaceAll(ChatColor.getByCode(0x9).toString(), Colors.BLUE);
		message = message.replaceAll(ChatColor.getByCode(0xA).toString(), Colors.GREEN);
		message = message.replaceAll(ChatColor.getByCode(0xB).toString(), Colors.CYAN);
		message = message.replaceAll(ChatColor.getByCode(0xC).toString(), Colors.RED);
		message = message.replaceAll(ChatColor.getByCode(0xD).toString(), Colors.MAGENTA);
		message = message.replaceAll(ChatColor.getByCode(0xE).toString(), Colors.YELLOW);
		message = message.replaceAll(ChatColor.getByCode(0xF).toString(), Colors.WHITE);
		return message;
	}

	public static void fireFeature(Player player) {
		Location location = player.getLocation();
		location.setY(location.getY() + 0.5);
		for (int i = 0; i < 2; i++) {
			LivingEntity entity = player.getWorld().spawnCreature(location, CreatureType.SHEEP);
			Sheep sheep = (Sheep) entity;
			Random rand = new Random(System.currentTimeMillis());
			DyeColor colors[] = DyeColor.values();
			int index = rand.nextInt(colors.length);
			sheep.setColor(colors[index]);
		}
	}

	public static String playerName(String name) {
		if (!name.equalsIgnoreCase("global") && !name.equalsIgnoreCase("all")) {
			List<Player> names = Bukkit.matchPlayer(name);
			if (names.size() > 0) name = names.get(0).getName();
		}
		return name;
	}

	public static String getPre(JavaPlugin plugin) {
		String name = addColor(plugin.getConfig().getString("meaSuite.prename"), plugin);
		return name;
	}

	public static boolean isLetter(String letter) {
		boolean isLetter = false;
		if (letter.equalsIgnoreCase("a") ||
				letter.equalsIgnoreCase("b") ||
				letter.equalsIgnoreCase("c") ||
				letter.equalsIgnoreCase("d") ||
				letter.equalsIgnoreCase("e") ||
				letter.equalsIgnoreCase("f") ||
				letter.equalsIgnoreCase("g") ||
				letter.equalsIgnoreCase("h") ||
				letter.equalsIgnoreCase("i") ||
				letter.equalsIgnoreCase("j") ||
				letter.equalsIgnoreCase("k") ||
				letter.equalsIgnoreCase("l") ||
				letter.equalsIgnoreCase("m") ||
				letter.equalsIgnoreCase("n") ||
				letter.equalsIgnoreCase("o") ||
				letter.equalsIgnoreCase("p") ||
				letter.equalsIgnoreCase("q") ||
				letter.equalsIgnoreCase("r") ||
				letter.equalsIgnoreCase("s") ||
				letter.equalsIgnoreCase("t") ||
				letter.equalsIgnoreCase("u") ||
				letter.equalsIgnoreCase("v") ||
				letter.equalsIgnoreCase("w") ||
				letter.equalsIgnoreCase("x") ||
				letter.equalsIgnoreCase("y") ||
				letter.equalsIgnoreCase("z")) isLetter = true;
		return isLetter;
	}

	public static String encodePassword(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] sha1hash = new byte[40];
			md.update(input.getBytes("iso-8859-1"), 0, input.length());
			sha1hash = md.digest();
			StringBuffer buf = new StringBuffer();
			for (byte element : sha1hash) {
				int halfbyte = (element >>> 4) & 0x0F;
				int two_halfs = 0;
				do {
					if ((0 <= halfbyte) && (halfbyte <= 9)) buf.append((char) ('0' + halfbyte));
					else buf.append((char) ('a' + (halfbyte - 10)));
					halfbyte = element & 0x0F;
				} while (two_halfs++ < 1);
			}
			input = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return input;
	}

	public static double convertTime(String command) {
		command = command.replaceAll("y", "*31536000000+");
		command = command.replaceAll("mo", "*2628000000+");
		command = command.replaceAll("w", "*604800000+");
		command = command.replaceAll("d", "*86400000+");
		command = command.replaceAll("h", "*3600000+");
		command = command.replaceAll("m", "*60000+");
		command = command.replaceAll("s", "*1000+");
		command = command.substring(0, command.length() - 1);
		Double ret = 0.0;
		ret = new Expression(command).resolve();
		// System.out.println(ret/1000);
		return ret;
	}
}
