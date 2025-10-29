package org.vanillacraft.melonwarps;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class CmdDelwarp {
    public static int execute(CommandContext<CommandSourceStack> ctx) {
        String warpname = ctx.getArgument("warpname", String.class);
        if (WarpMap.warpMap.containsKey(warpname)) {
            WarpMap.warpMap.remove(warpname);
            ctx.getSource().getSender().sendMessage(Component.text("[Melon] Deleted warp " + warpname, TextColor.fromHexString("#22aaff")));
        } else {
            ctx.getSource().getSender().sendMessage(Component.text("[Melon] That warp does not exist", TextColor.fromHexString("#ffaa33")));
        }

        return 0;
    }
}
