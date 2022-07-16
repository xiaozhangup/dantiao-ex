package com.valorin.event.game;

import com.valorin.Main;
import com.valorin.arenas.Arena;
import com.valorin.arenas.ArenaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventInteract implements Listener {
    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getName();
        ArenaManager arenaManager = Main.getInstance().getArenaManager();
        if (arenaManager.isPlayerBusy(playerName)) {
            Arena arena = arenaManager.getArena(arenaManager.getPlayerOfArena(playerName));
            if (arena.getStage() == 0) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(ignoreCancelled = true , priority = EventPriority.HIGHEST)
    public void breakblock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getName();
        ArenaManager arenaManager = Main.getInstance().getArenaManager();
        if (arenaManager.isPlayerBusy(playerName)) {
            Arena arena = arenaManager.getArena(arenaManager.getPlayerOfArena(playerName));
            if (arena.getStage() == 0) {
                e.setCancelled(true);
            }
        }
    }
}
