package org.vanillacraft.melonwarps;

import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public class CmdWarps {
    public static int execute(CommandContext<CommandSourceStack> ctx) {
        StringBuilder msg = new StringBuilder("[Melon] Warps: ");
        for (String warpName : WarpMap.warpMap.keySet()) {
            Warp warp = WarpMap.warpMap.get(warpName);
            msg.append(warpName).append(", ");
        }
        msg.delete(msg.length() - 2, msg.length());
        ctx.getSource().getSender().sendMessage(Component.text(
                msg.toString(),
                TextColor.fromHexString("#22aaee")));
        return 0;
    }
}
