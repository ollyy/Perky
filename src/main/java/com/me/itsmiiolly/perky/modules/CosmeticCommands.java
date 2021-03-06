package com.me.itsmiiolly.perky.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.me.itsmiiolly.perky.Core;
import com.me.itsmiiolly.perky.PerkyModule;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandPermissions;

public class CosmeticCommands extends PerkyModule {
	
    @Override
    public void load(Core instance) {        
    }

    @Override
    public void unload(Core instance) {        
    }

	
	@SuppressWarnings("deprecation")
	@Command(
    	    aliases = {"hug"},
            desc = "Send a hug!",
            min = 1,
            max = 1)
    @CommandPermissions("perky.hug")
    public static void hug(CommandContext args, CommandSender sender) throws Exception {
    	if (args.argsLength() > 0) {
    		String name = args.getString(0);
    		Player target = Bukkit.getPlayer(name);
    		if (target != null) {
    			sender.sendMessage(ChatColor.LIGHT_PURPLE + "Successfully sent hug to " + target.getName());
    			target.sendMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " gives you a hug!");
    			target.playEffect(target.getLocation(), Effect.HEART, 5);
    			target.playEffect(target.getEyeLocation(), Effect.HEART, 5);
    		}
    	
        }
    }
	@Command(
            aliases = {"hello"},
            desc = "Send a friendly hello!",
            min = 1,
            max = 1)
    @CommandPermissions("perky.hello")
    public static void hello(CommandContext args, CommandSender sender) throws Exception {
        if (args.argsLength() > 0) {
            String name = args.getString(0);
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(name);
            if (target != null) {
                sender.sendMessage(ChatColor.GREEN + "Successfully sent hello to " + target.getName());
                target.sendMessage(ChatColor.GREEN + sender.getName() + " gives you a friendly hello!");
                target.playSound(target.getLocation(), Sound.ORB_PICKUP, 10, 1);
            }
        }
    }
}
