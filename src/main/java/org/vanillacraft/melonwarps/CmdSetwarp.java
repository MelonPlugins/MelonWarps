package org.vanillacraft.melonwarps;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CmdSetwarp {
    public static int execute(CommandContext<CommandSourceStack> ctx) {
        if (!(ctx.getSource().getExecutor() instanceof Player player)) {
            ctx.getSource().getSender().sendMessage(Component.text("[Melon] You must be a player to use this command.", NamedTextColor.RED));
            return 2;
        }
        String warpname = ctx.getArgument("warpname", String.class);
        Location location = player.getLocation();
        if (WarpMap.warpMap.containsKey(warpname)) {
            ctx.getSource().getSender().sendMessage(Component.text("[Melon] A warp with that name already exists.", NamedTextColor.RED));
            return 3;
        }
        WarpMap.warpMap.put(warpname, new Warp(location, player.getUniqueId().toString()));
        ctx.getSource().getSender().sendMessage(Component.text("[Melon] Created warp " + warpname, TextColor.fromHexString("#22aaff")));

        return 0;
    }
}
