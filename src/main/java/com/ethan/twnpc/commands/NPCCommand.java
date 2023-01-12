package com.ethan.twnpc.commands;

import com.ethan.twnpc.data.NPCManager;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NPCCommand implements CommandExecutor {
    NPCManager npcManager = new NPCManager();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Getting the players information
        Player player = (Player) sender;
        CraftPlayer craftPlayer = (CraftPlayer) player;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        // NPCs without name use "NPC" as default
        if (args[0].equals("create")){
            if (args.length > 1){npcManager.createNPC(player, args[1]);
            }else{npcManager.createNPC(player);}
        }

        return false;
    }
}
