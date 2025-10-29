package org.vanillacraft.melonwarps;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Warp implements ConfigurationSerializable {
    public Location location;
    public String ownerUuid;

    public Warp(Location location, String ownerUuid) {
        this.location = location;
        this.ownerUuid = ownerUuid;
    }

    public void teleportTo(Entity entity) {
        entity.teleportAsync(location).thenAccept(res -> {});
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of("location", location, "ownerUuid", ownerUuid);
    }

    public static Warp deserialize(Map<String, Object> map) {
        return new Warp((Location) map.get("location"), (String) map.get("ownerUuid"));
    }
}
