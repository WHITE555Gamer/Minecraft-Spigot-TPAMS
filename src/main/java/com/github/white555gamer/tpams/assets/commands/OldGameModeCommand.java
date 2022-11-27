package com.github.white555gamer.tpams.assets.commands;

import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.white555gamer.tpams.TPAMS.getTPAMSActive;
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.*;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.GameMode.*;

/**
 * Fly Speed Command Class.<br>
 * This Class Controlling GameMode Using Old Style Command Operation.
 *
 * @since 0.0.3-SNAPSHOT<br>(Reformed 0.2.0-ALPHA)
 */
public class OldGameModeCommand implements TabExecutor {

    /**
     * (Public Static Final)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static final @NonNls String name() {
        return "OldGameModeCommand";
    }

    /**
     * (Public Static Final)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static final @NonNls String commandName() {
        return "oldgamemode";
    }

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static OldGameModeCommand instance = new OldGameModeCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private OldGameModeCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get OldGameModeCommand's instance.
     *
     * @return OldGameModeCommand's Singleton Instance.
     * @see OldGameModeCommand
     */
    public static OldGameModeCommand getInstance() {
        return instance;
    }

    /**
     * (Private Static)<br>
     * Command is active or inactive boolean.<br>
     * It uses getActive/setActive.
     *
     * @see TPAMSCommand
     */
    private static @NonNls boolean isActive = true;

    /**
     * (Private Static)<br>
     * Set Command is active or inactive boolean.<br>
     * It can set Command active or inactive.
     *
     * @see TPAMSCommand
     */
    public static @NonNls void setActive(@NotNull Boolean bool) {
        isActive = bool;
    }

    /**
     * (Private Static)<br>
     * Get TPAMS Command is active or inactive boolean.<br>
     * It can get TPAMS All Command active or inactive.
     *
     * @see TPAMSCommand
     */
    public static @NonNls boolean getActive() {
        return isActive;
    }

    /**
     * (Private Static Final)<br>
     * Survival String Number Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SURVIVAL_NUMBER = "0";
    /**
     * (Private Static Final)<br>
     * Survival String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SURVIVAL_STRING = "s";
    /**
     * (Private Static Final)<br>
     * Creative String Number Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_CREATIVE_NUMBER = "1";
    /**
     * (Private Static Final)<br>
     * Creative String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_CREATIVE_STRING = "c";
    /**
     * (Private Static Final)<br>
     * Adventure String Number Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_ADVENTURE_NUMBER = "2";
    /**
     * (Private Static Final)<br>
     * Adventure String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_ADVENTURE_STRING = "a";
    /**
     * (Private Static Final)<br>
     * Spectator String Number Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SPECTATOR_NUMBER = "3";
    /**
     * (Private Static Final)<br>
     * Spectator String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SPECTATOR_STRING = "sp";

    /**
     * (Private Static)<br>
     * This method send set game mode message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender   CommandSender.
     * @param player   Player.
     * @param gameMode GameMode.
     */
    private static @Nls void sendSetGameModeMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull GameMode gameMode) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("ゲームモードが" + gameMode.name() + "に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "のゲームモードを" + gameMode.name() + "に設定しました。");
                        player.sendMessage("ゲームモードが" + sender.getName() + "によって" + gameMode.name() + "に設定されました。");
                    } else {
                        sender.sendMessage("Set " + player.getName() + "'s GameMode to " + gameMode.name() + " mode.");
                        player.sendMessage("ゲームモードが" + sender.getName() + "によって" + gameMode.name() + "に設定されました。");
                    }
                } else {
                    sender.sendMessage("Set " + player.getName() + "'s GameMode to " + gameMode.name() + " mode.");
                    player.sendMessage("ゲームモードが" + sender.getName() + "によって" + gameMode.name() + "に設定されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("Set own GameMode to " + gameMode.name() + " mode.");
        } else {
            sender.sendMessage("Set " + player.getName() + "'s GameMode to " + gameMode.name() + " mode.");
            player.sendMessage("Set own GameMode to " + gameMode.name() + " mode by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send get game mode message to sender.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender   CommandSender.
     * @param player   Player.
     * @param gameMode GameMode.
     */
    private static @Nls void sendGetGameModeMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull GameMode gameMode) {
        if (sender instanceof Player) {
            if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                sender.sendMessage("ゲームモード: " + gameMode.name());
            } else {
                sender.sendMessage("GameMode: " + gameMode.name());
            }
        } else {
            sender.sendMessage("GameMode: " + gameMode.name());
        }
    }

    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(
            ARGS_LABEL_SURVIVAL_NUMBER, ARGS_LABEL_SURVIVAL_STRING, ARGS_LABEL_CREATIVE_NUMBER, ARGS_LABEL_CREATIVE_STRING,
            ARGS_LABEL_ADVENTURE_NUMBER, ARGS_LABEL_ADVENTURE_STRING, ARGS_LABEL_SPECTATOR_NUMBER, ARGS_LABEL_SPECTATOR_STRING);

    /**
     * (Public)<br>
     * onCommand method.
     *
     * @param sender  CommandSender.
     * @param command Command.
     * @param label   Label.
     * @param args    Args.
     * @return Always Return True.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!getTPAMSActive()) {
            sender.sendMessage(ERROR_TPAMS_COMMAND_INACTIVE_MESSAGE);
            return true;
        }

        if (!isActive) {
            sender.sendMessage(ERROR_COMMAND_INACTIVE_MESSAGE);
            return true;
        }

        Player player;

        switch (args.length) {
            case 0:
                if (sender instanceof Player) {
                    player = (Player) sender;
                    sendGetGameModeMessage(sender, player, player.getGameMode());
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 1:
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ERROR_SERVER_NON_EXECUTABLE_MESSAGE);
                    return true;
                }
                player = (Player) sender;
                switch (args[0]) {
                    case "0":
                    case "s":
                        player.setGameMode(SURVIVAL);
                        sendSetGameModeMessage(sender, player, SURVIVAL);
                        return true;
                    case "1":
                    case "c":
                        player.setGameMode(CREATIVE);
                        sendSetGameModeMessage(sender, player, CREATIVE);
                        return true;
                    case "2":
                    case "a":
                        player.setGameMode(ADVENTURE);
                        sendSetGameModeMessage(sender, player, ADVENTURE);
                        return true;
                    case "3":
                    case "sp":
                        player.setGameMode(SPECTATOR);
                        sendSetGameModeMessage(sender, player, SPECTATOR);
                        return true;
                }
            case 2:
                player = Bukkit.getPlayer(args[1]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                switch (args[0]) {
                    case "0":
                    case "s":
                        player.setGameMode(SURVIVAL);
                        sendSetGameModeMessage(sender, player, SURVIVAL);
                        return true;
                    case "1":
                    case "c":
                        player.setGameMode(CREATIVE);
                        sendSetGameModeMessage(sender, player, CREATIVE);
                        return true;
                    case "2":
                    case "a":
                        player.setGameMode(ADVENTURE);
                        sendSetGameModeMessage(sender, player, ADVENTURE);
                        return true;
                    case "3":
                    case "sp":
                        player.setGameMode(SPECTATOR);
                        sendSetGameModeMessage(sender, player, SPECTATOR);
                        return true;
                }
        }
        sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
        return true;
    }

    /**
     * (Public)<br>
     * onTabComplete Method.
     *
     * @param sender  CommandSender.
     * @param command Command.
     * @param label   Label.
     * @param args    Args.
     * @return List of Elements that tab complete.
     */
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (args[0].length() == 0) {
                return COMMAND_SUGGESTIONS;
            } else {
                return COMMAND_SUGGESTIONS.stream().filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        } else if (args.length == 2) {
            if (args[1].length() == 0) {
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(s -> s.toLowerCase()).collect(Collectors.toList());
            } else {
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(s -> s.toLowerCase()).filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        } else {
            return ImmutableList.of();
        }
    }
}
