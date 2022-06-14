package com.afatcookie.inventoryplugin.inventoryplugin;

import org.bukkit.ChatColor;

public class ColorCoding {

    //Color Coding Messages
    public static String ColorMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
