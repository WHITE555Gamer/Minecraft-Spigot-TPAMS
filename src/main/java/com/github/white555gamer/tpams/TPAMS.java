package com.github.white555gamer.tpams;

import com.github.white555gamer.tpams.assets.commands.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Main Class. <br>
 * TPAMS.jar Start First of This TPAMS Class.
 *
 * @author WHITE(formaly known as WHERE_WHITE_, WHERE_WHITE_KUN, WHITE555Gamer)
 * @version 0.2.0-ALPHA
 * @since 0.0.1-SNAPSHOT
 */
public final class TPAMS extends JavaPlugin {

    /**
     * (Public Static)<br>
     * This Class's Name.
     *
     * @return This Class's Name.
     */
    public static final @NonNls String name() {
        return "TPAMS";
    }

    /**
     * (Private Static)<br>
     * TPAMS Command is active or inactive boolean.<br>
     * It uses getTPAMSActive/setTPAMSActive.
     *
     * @see TPAMSCommand
     */
    private static @NonNls boolean isActive = true;

    /**
     * (Private Static)<br>
     * Set TPAMS Command is active or inactive boolean.<br>
     * It can set TPAMS All Command active or inactive.
     *
     * @see TPAMSCommand
     */
    public static @NonNls void setTPAMSActive(@NotNull Boolean bool) {
        isActive = bool;
    }

    /**
     * (Private Static)<br>
     * Get TPAMS Command is active or inactive boolean.<br>
     * It can get TPAMS All Command active or inactive.
     *
     * @see TPAMSCommand
     */
    public static @NonNls boolean getTPAMSActive() {
        return isActive;
    }

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static TPAMS instance;

    /**
     * (Public)<br>
     * Public Constructor for Singleton.
     * For Singleton, It needs Private Constructor but when run this plugin, the error message show "Cannot access TPAMS cause Private Constructor".
     */
    public TPAMS() {
        instance = this;
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get TPAMS's instance.
     *
     * @return TPAMS's Singleton Instance.
     * @see TPAMS
     */
    public static TPAMS getInstance() {
        return instance;
    }

    /**
     * (Public)<br>
     * onEnable method.<br>
     * This method execute below order.<br>
     * <ul>
     *     <li>SetExecutor
     *     <ul>
     *         <li>BroadcastMessageCommand</li>
     *         <li>FlyCommandCommand</li>
     *         <li>FlySpeedCommandCommand</li>
     *         <li>OldGameModeCommand</li>
     *         <li>SneakCommand</li>
     *         <li>TPAMSCommand</li>
     *         <li>WalkSpeedCommand</li>
     *     </ul>
     *     </li>
     *     <li></li>
     * </ul>
     *
     * @see BroadCastMessageCommand
     * @see FlyCommand
     * @see FlySpeedCommand
     * @see OldGameModeCommand
     * @see SneakCommand
     * @see TPAMSCommand
     * @see WalkSpeedCommand
     */
    @Override
    public void onEnable() {
        getLogger().info("Beginning Enable Plugin...");

        getCommand(BroadCastMessageCommand.commandName()).setExecutor(BroadCastMessageCommand.getInstance());
        getCommand(FlyCommand.commandName()).setExecutor(FlyCommand.getInstance());
        getCommand(FlySpeedCommand.commandName()).setExecutor(FlySpeedCommand.getInstance());
        getCommand(OldGameModeCommand.commandName()).setExecutor(OldGameModeCommand.getInstance());
        getCommand(SneakCommand.commandName()).setExecutor(SneakCommand.getInstance());
        getCommand(TPAMSCommand.commandName()).setExecutor(TPAMSCommand.getInstance());
        getCommand(WalkSpeedCommand.commandName()).setExecutor(WalkSpeedCommand.getInstance());

        getLogger().info("Finishing Enable Plugin...");
    }

    /**
     * (Public)<br>
     * onLoad method.
     */
    @Override
    public void onLoad() {
        getLogger().info("Beginning Load Plugin...");
        getLogger().info("Finishing Load Plugin...");
    }

    /**
     * (Public)<br>
     * onDisable method.
     */
    @Override
    public void onDisable() {
        getLogger().info("Beginning Disable Plugin...");
        getLogger().info("Finishing Disble Plugin...");
    }
}
