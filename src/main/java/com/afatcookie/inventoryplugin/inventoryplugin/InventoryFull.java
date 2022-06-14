package com.afatcookie.inventoryplugin.inventoryplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class InventoryFull implements Listener {
    MessageManager messageManager = new MessageManager(Inventoryplugin.getPlugin());

    //If player has full inventory, returns true; Otherwise returns false
    public static boolean HasFullInventory(Player player){
        return player.getInventory().firstEmpty() == -1;
    }

    @EventHandler
    //Checks for full inventory on block break. Also enters them into messages if haven't been done so already
    public void OnBlockBreak(BlockBreakEvent e){
        final Player player = e.getPlayer();
        if (HasFullInventory(player)){
            if (messageManager.GetNoticeStatus(player) == null){
                MessageManager.InvMessageToggle.putIfAbsent(player.getUniqueId(), true);
            }
            messageManager.SendNotice(player);
        }
    }
}
