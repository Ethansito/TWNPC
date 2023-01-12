package com.ethan.twnpc.data;


import net.minecraft.server.level.ServerPlayer;

public class NPC {
    ServerPlayer npc;
    String name;
    String texture;
    String signature;

    public NPC(ServerPlayer npc, String name, String texture, String signature) {
        this.npc = npc;
        this.name = name;
        this.texture = texture;
        this.signature = signature;
    }

    public ServerPlayer getNpc() {
        return npc;
    }

    public void setNpc(ServerPlayer npc) {
        this.npc = npc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
