package pers.zhangyang.easyteleportask.listener.manageteleportaskpageteleportaskoptionpage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pers.zhangyang.easylibrary.annotation.EventListener;
import pers.zhangyang.easylibrary.annotation.GuiDiscreteButtonHandler;
import pers.zhangyang.easylibrary.util.MessageUtil;
import pers.zhangyang.easylibrary.yaml.MessageYaml;
import pers.zhangyang.easyteleportask.domain.Gamer;
import pers.zhangyang.easyteleportask.domain.ManageTeleportAskPageTeleportAskOptionPage;
import pers.zhangyang.easyteleportask.domain.TeleportAsk;
import pers.zhangyang.easyteleportask.enumeration.AskTypeEnum;
import pers.zhangyang.easyteleportask.manager.GamerManager;
import pers.zhangyang.easyteleportask.manager.TeleportAskManager;

import java.util.List;

@EventListener
public class PlayerClickManageTeleportAskPageTeleportAskOptionPageDenyTeleportAsk implements Listener {
    @GuiDiscreteButtonHandler(guiPage = ManageTeleportAskPageTeleportAskOptionPage.class,slot = 23,closeGui = false,refreshGui = true)
    public void on(InventoryClickEvent event){

        ManageTeleportAskPageTeleportAskOptionPage manageTeleportAskPageTeleportAskOptionPage= (ManageTeleportAskPageTeleportAskOptionPage) event.getInventory().getHolder();
        Player viewer= (Player) event.getWhoClicked();

        assert manageTeleportAskPageTeleportAskOptionPage != null;

        if (!TeleportAskManager.INSTANCE.getTeleportAskList().contains(manageTeleportAskPageTeleportAskOptionPage.getAsk())){
            List<String> list = MessageYaml.INSTANCE.getStringList("message.chat.notExistTeleportAsk");
            MessageUtil.sendMessageTo(viewer, list);
            return;
        }

        if (!manageTeleportAskPageTeleportAskOptionPage.getAsk().getTarget().equals(viewer)){
            List<String> list = MessageYaml.INSTANCE.getStringList("message.chat.notTargetWhenDenyTeleportAsk");
            MessageUtil.sendMessageTo(viewer, list);
            return;
        }
        TeleportAskManager.INSTANCE.getTeleportAskList().remove(manageTeleportAskPageTeleportAskOptionPage.getAsk());


        List<String> list = MessageYaml.INSTANCE.getStringList("message.chat.denyTeleportAsk");
        MessageUtil.sendMessageTo(viewer, list);
    }

}
