package org.vanillacraft.melonwarps;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;

public class CmdWarp {
    public static int execute(CommandContext<CommandSourceStack> ctx) {
        String warpname = ctx.getArgument("warpname", String.class);
        ctx.getSource().getSender().sendMessage(warpInfo(warpname));
        return 0;
    }

    public static Component warpInfo(String warpname) {
        Warp warp = WarpMap.warpMap.get(warpname);
        if (warp == null) {
            return Component.text("[Melon] That warp does not exist.", NamedTextColor.GOLD);
        }
        Location location = warp.location;
        return Component.text("[Melon] " + warpname
                + " is at " + location.blockX() + ", " + location.blockY() + ", " + location.blockZ() + " (" + location.getWorld().getName() + ")",
                TextColor.fromHexString("#22aaff"));

    }
}
