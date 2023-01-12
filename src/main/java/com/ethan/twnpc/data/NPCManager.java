package com.ethan.twnpc.data;

import com.mojang.authlib.GameProfile;
import net.minecraft.network.protocol.game.ClientboundAddPlayerPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NPCManager {

    public void createNPC(Player player){
        // Getting the players information
        CraftPlayer craftPlayer = (CraftPlayer) player;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        // We need to get the server and level from the player sending the command to spawn the npc
        MinecraftServer server = serverPlayer.getServer();
        ServerLevel level = serverPlayer.getLevel();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "NPC");
        ServerPlayer npc = new ServerPlayer(server, level, profile);
        npc.setPos(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getZ());

        // We have to send packets so players can see the NPC

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()){

            CraftPlayer onlineCraft = (CraftPlayer) onlinePlayer;
            ServerPlayer onlineServer = onlineCraft.getHandle();

            ServerGamePacketListenerImpl packetListener = onlineServer.connection;

            //PlayerInfo Packet does something important probably
            packetListener.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));

            //SpawnPlayer Packet brings npc into view
            packetListener.send(new ClientboundAddPlayerPacket(npc));
        }
    }

    public void createNPC(Player player, String name){
        // Getting the players information
        CraftPlayer craftPlayer = (CraftPlayer) player;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        // We need to get the server and level from the player sending the command to spawn the npc
        MinecraftServer server = serverPlayer.getServer();
        ServerLevel level = serverPlayer.getLevel();

        GameProfile profile = new GameProfile(UUID.randomUUID(), name);

        ServerPlayer npc = new ServerPlayer(server, level, profile);
        npc.setPos(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getZ());



        // We have to send packets so players can see the NPC

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()){

            CraftPlayer onlineCraft = (CraftPlayer) onlinePlayer;
            ServerPlayer onlineServer = onlineCraft.getHandle();

            ServerGamePacketListenerImpl packetListener = onlineServer.connection;

            //PlayerInfo Packet does something important probably
            packetListener.send(new ClientboundPlayerInfoUpdatePacket(ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, npc));

            //SpawnPlayer Packet brings npc into view
            packetListener.send(new ClientboundAddPlayerPacket(npc));
        }
    }
}
