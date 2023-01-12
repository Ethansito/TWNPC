package com.ethan.twnpc;

import com.ethan.twnpc.commands.NPCCommand;
import com.ethan.twnpc.commands.NPCTest;
import com.ethan.twnpc.data.NPC;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TWNPC extends JavaPlugin {
    public static List<NPC> npcList;


    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("npc").setExecutor(new NPCCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
