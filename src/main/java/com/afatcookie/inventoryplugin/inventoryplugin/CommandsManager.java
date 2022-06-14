package com.afatcookie.inventoryplugin.inventoryplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsManager implements CommandExecutor {

    MessageManager messageManager = new MessageManager(Inventoryplugin.getPlugin());
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            System.out.println("Only players can run this command!");
        }else{
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("ToggleInv")){
                if (!messageManager.GetNoticeStatus(player)){
                    player.sendMessage(ColorCoding.ColorMessage("&aFull Inventory Messages Enabled!"));
                    messageManager.SetNoticeStatus(player, true);
                }else{
                    player.sendMessage(ColorCoding.ColorMessage("&aFull Inventory Messages Disabled!"));
                    messageManager.SetNoticeStatus(player, false);
                }
            }
            //In need of repair lololol
            /*if (command.getName().equalsIgnoreCase("ReloadInvConfig")){
                if (!player.hasPermission("InventoryFull.admin")){
                    player.sendMessage("You don't have access to use this command!");
                }else{
                    Inventoryplugin.getPlugin().saveDefaultConfig();
                    player.sendMessage(ColorCoding.ColorMessage("&aReloaded Config!"));
                }
            }*/

        }
        return false;
    }
    public static void CommandList(Inventoryplugin inventoryplugin){
        AddCommand(inventoryplugin, "ToggleInv");
       // AddCommand(inventoryplugin, "ReloadInvConfig");
    }
    //Easy way to register Commands
    public static void AddCommand(Inventoryplugin plugin, String CommandName){
        plugin.getCommand(CommandName).setExecutor(new CommandsManager());
    }
}
