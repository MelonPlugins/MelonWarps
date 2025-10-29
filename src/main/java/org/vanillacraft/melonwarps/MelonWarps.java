package org.vanillacraft.melonwarps;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class MelonWarps extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigurationSerialization.registerClass(Warp.class);
        WarpMap.load(this);

        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {

            LiteralArgumentBuilder<CommandSourceStack> cmdWarp = Commands.literal("warp")
                    .requires(ctx -> ctx.getSender().hasPermission("melon.warps.warp"))
                    .then(Commands.argument("warpname", StringArgumentType.word())
                            .executes(CmdWarp::execute));

            LiteralArgumentBuilder<CommandSourceStack> cmdWarps = Commands.literal("warps")
                    .requires(ctx -> ctx.getSender().hasPermission("melon.warps.warps"))
                    .executes(CmdWarps::execute);

            LiteralArgumentBuilder<CommandSourceStack> cmdSetwarp = Commands.literal("setwarp")
                    .requires(ctx -> ctx.getSender().hasPermission("melon.warps.setwarp"))
                    .then(Commands.argument("warpname", StringArgumentType.word())
                            .executes(CmdSetwarp::execute));

            LiteralArgumentBuilder<CommandSourceStack> cmdDelwarp = Commands.literal("delwarp")
                    .requires(ctx -> ctx.getSender().hasPermission("melon.warps.delwarp"))
                    .then(Commands.argument("warpname", StringArgumentType.word())
                            .executes(CmdDelwarp::execute));

            commands.registrar().register(cmdSetwarp.build());
            commands.registrar().register(cmdDelwarp.build());
            commands.registrar().register(cmdWarp.build());
            commands.registrar().register(cmdWarps.build());
        });
    }

    @EventHandler
    public void onWorldSave(WorldSaveEvent event) {
        WarpMap.save(this);
    }

    @Override
    public void onDisable() {
        WarpMap.save(this);
    }
}
