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
        val swapItem = event.itemToSwap
        val handItem = event.itemInHand

        if (swapItem.type != Material.AIR) {
            val swapItemTypeIsElytra = swapItem.type == Material.ELYTRA
            val handItemTypeIsElytra = handItem.type == Material.ELYTRA

            if (swapItemTypeIsElytra != handItemTypeIsElytra) {
                event.isCancelled = true
            }
        }
    }
}