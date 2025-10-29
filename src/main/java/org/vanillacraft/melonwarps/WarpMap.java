package org.vanillacraft.melonwarps;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class WarpMap {
    public static ConcurrentHashMap<String, Warp> warpMap = new ConcurrentHashMap<>();

    public static void save(MelonWarps plugin) {
        YamlConfiguration config = new YamlConfiguration();
        config.createSection("warps");
        for (String warpName : warpMap.keySet()) {
            config.set("warps." + warpName, warpMap.get(warpName));
        }
        File file = new File(plugin.getDataFolder(), "warps.yml");
        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().severe("Failed to save warps");
            throw new RuntimeException(e);
        }
    }

    public static void load(MelonWarps plugin) {
        File file = new File(plugin.getDataFolder(), "warps.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            warpMap = new ConcurrentHashMap<>();
            return;
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        ConcurrentHashMap<String, Warp> map = new ConcurrentHashMap<>();
        for (String warpName : config.getConfigurationSection("warps").getKeys(false)) {
            map.put(warpName, (Warp)config.get("warps." + warpName));
        }
        warpMap = map;
    }
}
