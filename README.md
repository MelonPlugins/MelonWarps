# MelonWarps

> Part of the **Melon Plugins** project - Paper and Folia-compatible plugins for
> easy Minecraft server admin.
> - [MelonPlugins on GitHub](https://github.com/MelonPlugins)
> - [MelonPlugins on Hangar](https://hangar.papermc.io/Melon)
> - [MelonPlugins documentation](https://dylancode.dev/docs/melon)

MelonWarps allows you to create vanilla-style warps - waypoints to public
locations, **without** ruining the fun of vanilla transport by allowing players
to teleport everywhere.

It acts as a *directory* for public places, but players still have to make their
own way to the warps. Think of it as server-side waypoints.

***Melon is in active development. Many features will be lacking, please request
any features on our [GitHub page](https://github.com/MelonPlugins/MelonWarps)***

## Commands

| Command   | Usage                  | Permission node        | Description                                                      |
|-----------|------------------------|------------------------|------------------------------------------------------------------|
| `/warps`   | `/warps`              | `melon.warps.warps`    | List all warps on the server                                     |
| `/warp`    | `/warp <warpName>`    | `melon.warps.warp`     | Get the coordinates to a warp                                    |
| `/setwarp` | `/setwarp <warpName>` | `melon.warps.setwarp`  | Create a warp at the current location with the specified name.   |
| `/delwarp` | `/delwarp <warpName>` | `melon.warps.delwarp`  | Delete the warp with the specified name. |

## Version compatibility

`MelonWarps` is compatible with any version above `1.21`. Versions below do not
have the correct dependencies, particularly with the Brigadier API, and so no
support will be offered for versions pre-1.21. You are welcome to try to change
the code to support previous versions.

Any version *above* 1.21 should work perfectly fine - report any issues on our GitHub!

> - Paper: works perfectly.
> - Most forks of paper (e.g. Purpur/Leaf): *usually* works perfectly.
> - Folia: *usually* works perfectly.
> <br/><br/>
> - Bukkit: will not work, as this is a Paper plugin.
> - Spigot: will not work, as this is a Paper plugin.
> - Fabric: will not work, as this is a plugin and not a mod.
> - Forge: will not work, as this is a plugin and not a mod.
> - Sponge/Loofah: will not work, as this is a Paper plugin.
