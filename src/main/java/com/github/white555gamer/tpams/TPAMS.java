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
     * (Private Static Final)<br>
     * TPAMS Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see TPAMSCommand
     */
    private static final @NonNls String TPAMS_COMMAND_LABEL = TPAMSCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Broadcast Message Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see BroadCastMessageCommand
     */
    private static final @NonNls String BROADCAST_MESSAGE_COMMAND_LABEL = BroadCastMessageCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Fly Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see FlyCommand
     */
    private static final @NonNls String FLY_COMMAND_LABEL = FlyCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Fly Speed Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see FlySpeedCommand
     */
    private static final @NonNls String FLY_SPEED_COMMAND_LABEL = FlySpeedCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Sneak Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see SneakCommand
     */
    private static final @NonNls String SNEAK_COMMAND_LABEL = SneakCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Old GameMode Command Label.<br>
     * It uses getCommand.setExecutor in onEnable Method.
     *
     * @see OldGameModeCommand
     */
    private static final @NonNls String OLD_GAMEMODE_COMMAND = OldGameModeCommand.commandName();

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static TPAMS instance;

    /**
     * (Public)<br>
     * Public Constructor for Singleton.<br>
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

    private static BroadCastMessageCommand broadCastMessageCommand;
    private static FlyCommand flyCommand;
    private static FlySpeedCommand flySpeedCommand;
    private static SneakCommand sneakCommand;
    private static OldGameModeCommand oldGameModeCommand;
    private static TPAMSCommand tpamsCommand;

    public static BroadCastMessageCommand getBroadCastMessageCommand() {
        return broadCastMessageCommand;
    }
    public static FlyCommand getFlyCommand() {
        return flyCommand;
    }
    public static FlySpeedCommand getFlySpeedCommand() {
        return flySpeedCommand;
    }
    public static SneakCommand getSneakCommand() {
        return sneakCommand;
    }
    public static OldGameModeCommand getOldGameModeCommand() {
        return oldGameModeCommand;
    }
    public static TPAMSCommand getTPAMSCommand() {
        return tpamsCommand;
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
     *         <li>SneakCommand</li>
     *         <li>OldGameModeCommand</li>
     *         <li>TPAMSCommand</li>
     *     </ul>
     *     </li>
     *     <li></li>
     * </ul>
     * @see BroadCastMessageCommand
     * @see FlyCommand
     * @see FlySpeedCommand
     * @see SneakCommand
     * @see OldGameModeCommand
     * @see TPAMSCommand
     */
    @Override
    public void onEnable() {
        getLogger().info("Beginning Enable Plugin...");

        broadCastMessageCommand = new BroadCastMessageCommand();
        flyCommand = new FlyCommand();
        flySpeedCommand = new FlySpeedCommand();
        sneakCommand = new SneakCommand();
        oldGameModeCommand = new OldGameModeCommand();
        tpamsCommand = new TPAMSCommand();

        getCommand(BROADCAST_MESSAGE_COMMAND_LABEL).setExecutor(broadCastMessageCommand);
        getCommand(FLY_COMMAND_LABEL).setExecutor(flyCommand);
        getCommand(FLY_SPEED_COMMAND_LABEL).setExecutor(flySpeedCommand);
        getCommand(SNEAK_COMMAND_LABEL).setExecutor(sneakCommand);
        getCommand(OLD_GAMEMODE_COMMAND).setExecutor(oldGameModeCommand);
        getCommand(TPAMS_COMMAND_LABEL).setExecutor(tpamsCommand);

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
