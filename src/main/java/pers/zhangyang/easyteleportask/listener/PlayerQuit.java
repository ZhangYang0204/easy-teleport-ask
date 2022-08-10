package pers.zhangyang.easyteleportask.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easyteleportask.manager.GamerManager;

@EventListener
public class PlayerQuit implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent event){
        GamerManager.INSTANCE.remove(event.getPlayer());
    }


}
