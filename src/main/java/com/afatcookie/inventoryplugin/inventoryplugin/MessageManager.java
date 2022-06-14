package com.afatcookie.inventoryplugin.inventoryplugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class MessageManager {

    public static HashMap<UUID, Boolean> InvMessageToggle = new HashMap<>();

    Inventoryplugin inventoryplugin;

    public MessageManager(Inventoryplugin inventoryplugin){
        this.inventoryplugin = inventoryplugin;
    }


    //Compilation of All notices That can be sent
    public void SendNotice(Player player){
        if (!GetNoticeStatus(player)) return;
        ChatNotice(player);
        TitleNotice(player);
        ActionBarNotice(player);
        //SendSound(player);
    }



    //Sends Chat Messages based off Config files. Also checks if chat messages are enabled
    private void ChatNotice(Player player){
        if (!GetBooleanAtPath("chatmessage")) return;
        player.sendMessage(GetStringAtPath("chatmessagelineone"));
        player.sendMessage(GetStringAtPath("chatmessagelinetwo"));
        player.sendMessage(GetStringAtPath("chatmessagelinethree"));
    }
    //Sends Title/subtitle messages based off Config files. Also Checks if title/subtitle messages are enabled
    private void TitleNotice(Player player){
        if (!GetBooleanAtPath("titlemessage")) return;
        player.sendTitle(GetStringAtPath("headtitle"), GetStringAtPath("subtitle"), 20, 40, 20);
    }
    //Sends Actionbar messages based off Config Files. Also Checks if ActionBar messages are enabled
    private void ActionBarNotice(Player player){
        if (!GetBooleanAtPath("actionbaractivation")) return;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(GetStringAtPath("actionbarmessage")));
    }

    //GETTERS AND SETTERS

    //Gets String at specific Config Path
    private String GetStringAtPath(String StringPath){
        return ColorCoding.ColorMessage(Inventoryplugin.getPlugin().getConfig().getString(StringPath));
    }

    //Gets boolean at specific Config Path
    private Boolean GetBooleanAtPath(String StringPath){
        return Inventoryplugin.getPlugin().getConfig().getBoolean(StringPath);
    }

    //Gets Player's Notice Status/ Returns true if player wants notices
    public Boolean GetNoticeStatus(Player player){
        return InvMessageToggle.get(player.getUniqueId());
    }
    //Sets Player's Notice Status
    public void SetNoticeStatus(Player player, Boolean Status){
        InvMessageToggle.put(player.getUniqueId(), Status);
    }

    //Sends notice sound if desired/ Disabled Until figured out how to send only once
    /*private void SendSound(Player player){
        if (!GetBooleanAtPath("soundtoggle")) return;
        try {
            player.getWorld().playSound(player.getLocation(), Sound.valueOf(GetStringAtPath("soundmade")), 5, 10);
        }catch (IllegalArgumentException e){
            player.sendMessage("Error in Sound");
        }
    }*/
}
