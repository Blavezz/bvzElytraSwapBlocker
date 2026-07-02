package dev.blavez.elytraSwapBlocker

import io.papermc.paper.event.player.PlayerSwapWithEquipmentSlotEvent
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class ElytraSwapBlocker : JavaPlugin(), Listener {

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this, this)
        this.logger.info("bvzElytraSwapBlocker has been enabled!")
    }

    @EventHandler
    fun onPlayerSwapWithEquipmentSlot(event: PlayerSwapWithEquipmentSlotEvent) {
        if (event.itemToSwap.type == Material.ELYTRA || event.itemInHand.type == Material.ELYTRA) event.isCancelled = true
    }
}