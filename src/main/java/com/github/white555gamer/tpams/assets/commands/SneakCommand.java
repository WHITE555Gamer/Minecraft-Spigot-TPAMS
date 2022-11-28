package com.github.white555gamer.tpams.assets.commands;

import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.white555gamer.tpams.TPAMS.getTPAMSActive;
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.*;
import static org.bukkit.Bukkit.getServer;

/**
 * Sneak Command Class.<br>
 * This Class Controlling Command Operation.
 *
 * @since Before 0.2.0-SNAPSHOT But Disabled.<br>(Reformed 0.2.0-ALPHA)
 */
public class SneakCommand implements TabExecutor {

    /**
     * (Public Static)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static @NonNls String name() {
        return "SneakCommand";
    }

    /**
     * (Public Static)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static @NonNls String commandName() {
        return "sneak";
    }

    /**
     * (Private Static Final)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static final SneakCommand instance = new SneakCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private SneakCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get SneakCommand's instance.
     *
     * @return SneakCommand's Singleton Instance.
     * @see SneakCommand
     */
    public static SneakCommand getInstance() {
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
     * True String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_TRUE = "true";
    /**
     * (Private Static Final)<br>
     * False String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_FALSE = "false";
    /**
     * (Private Static Final)<br>
     * Toggle String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_TOGGLE = "toggle";
    /**
     * (Private Static Final)<br>
     * Get Boolean String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_GETBOOLEAN = "getboolean";

    /**
     * (Private Static)<br>
     * This method send enable sneak message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static void sendEnableMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("スニークが有効化されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "のスニークが有効化されました。");
                        player.sendMessage("スニークが" + sender.getName() + "によって有効化されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s sneak has been enabled.");
                        player.sendMessage("スニークが" + sender.getName() + "によって有効化されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s sneak has been enabled.");
                    player.sendMessage("スニークが" + sender.getName() + "によって有効化されました。");
                }
            }
        } else {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("The sneak has been enabled.");
            } else {
                sender.sendMessage(player.getName() + "'s sneak has been enabled.");
                player.sendMessage("The sneak has been enabled by " + sender.getName() + ".");
            }
        }
    }

    /**
     * (Private Static)<br>
     * This method send disable sneak message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static void sendDisableMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("スニークが無効化されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "のスニークが無効化されました。");
                        player.sendMessage("スニークが" + sender.getName() + "によって無効化されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s sneak has been disabled.");
                        player.sendMessage("スニークが" + sender.getName() + "によって無効化されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s sneak has been disabled.");
                    player.sendMessage("スニークが" + sender.getName() + "によって無効化されました。");
                }
            }
        } else {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("The sneak has been disabled.");
            } else {
                sender.sendMessage(player.getName() + "'s sneak has been disabled.");
                player.sendMessage("The sneak has been disabled by " + sender.getName() + ".");
            }
        }
    }

    /**
     * (Private Static)<br>
     * This method send toggle sneak message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static void sendToggleMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Boolean bool) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                if (bool) {
                    sender.sendMessage("スニークが切り替えられました。現在: 有効");
                } else {
                    sender.sendMessage("スニークが切り替えられました。現在: 無効");
                }
            } else {
                if (bool) {
                    if (sender instanceof Player) {
                        if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                            sender.sendMessage(player.getName() + "のスニークが切り替えられました。現在: 有効");
                            player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 有効");
                        } else {
                            sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Enable");
                            player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 有効");
                        }
                    } else {
                        sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Enable");
                        player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 有効");
                    }
                } else {
                    if (sender instanceof Player) {
                        if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                            sender.sendMessage(player.getName() + "のスニークが切り替えられました。現在: 無効");
                            player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 無効");
                        } else {
                            sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Disable");
                            player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 無効");
                        }
                    } else {
                        sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Disable");
                        player.sendMessage("スニークが" + sender.getName() + "によって切り替えられました。現在: 無効");
                    }
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            if (bool) {
                sender.sendMessage("The sneak has been toggled. Now: Enable");
            } else {
                sender.sendMessage("The sneak has been toggled. Now: Disable");
            }
        } else {
            if (bool) {
                sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Enable");
                player.sendMessage("The sneak has been toggled by " + sender.getName() + ". Now: Enable");
            } else {
                sender.sendMessage(player.getName() + "'s sneak has been toggled. Now: Disable");
                player.sendMessage("The sneak has been toggled by " + sender.getName() + ". Now: Disable");
            }
        }
    }

    /**
     * (Private Static)<br>
     * This method send get boolean sneak message to sender.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static void sendGetBooleanMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Boolean bool) {
        if (sender.getName().equalsIgnoreCase(player.getName())) {
            if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                if (bool) {
                    sender.sendMessage("スニーク: 有効");
                } else {
                    sender.sendMessage("スニーク: 無効");
                }
            } else {
                if (bool) {
                    sender.sendMessage("Sneak: Enable");
                } else {
                    sender.sendMessage("Sneak: Disable");
                }
            }
        } else {
            if (sender instanceof Player) {
                if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                    if (bool) {
                        sender.sendMessage(player.getName() + "のスニーク: 有効");
                    } else {
                        sender.sendMessage(player.getName() + "のスニーク: 無効");
                    }
                } else {
                    if (bool) {
                        sender.sendMessage(player.getName() + "'s Sneak: Enable");
                    } else {
                        sender.sendMessage(player.getName() + "'s Sneak: Disable");
                    }
                }
            } else {
                if (bool) {
                    sender.sendMessage(player.getName() + "'s Sneak: Enable");
                } else {
                    sender.sendMessage(player.getName() + "'s Sneak: Disable");
                }
            }
        }
    }

    /**
     * (Private Static Final)<br>
     * Already enable string message.<br>
     * Localization is required as it is used user-visible string but this can't implement localization because CommandSender doesn't have getLocale() method.
     */
    private static final String ALREADY_ENABLE_MESSAGE = "Already Enable.";
    /**
     * (Private Static Final)<br>
     * Already disable string message.<br>
     * Localization is required as it is used user-visible string but this can't implement localization because CommandSender doesn't have getLocale() method.
     */
    private static final @NonNls String ALREADY_DISABLE_MESSAGE = "Already Disable.";
    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(ARGS_LABEL_TRUE, ARGS_LABEL_FALSE, ARGS_LABEL_TOGGLE, ARGS_LABEL_GETBOOLEAN);

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
                    sendGetBooleanMessage(sender, player, player.isSneaking());
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 1:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                } else {
                    sendGetBooleanMessage(sender, player, player.isSneaking());
                }
                return true;
            case 2:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_TRUE:
                        if (player.getAllowFlight()) {
                            sender.sendMessage(ALREADY_ENABLE_MESSAGE);
                            return true;
                        }
                        player.setSneaking(true);
                        sendEnableMessage(sender, player);
                        return true;
                    case ARGS_LABEL_FALSE:
                        if (!player.getAllowFlight()) {
                            sender.sendMessage(ALREADY_DISABLE_MESSAGE);
                            return true;
                        }
                        player.setSneaking(false);
                        sendDisableMessage(sender, player);
                        return true;
                    case ARGS_LABEL_TOGGLE:
                        player.setSneaking(!player.isSneaking());
                        sendToggleMessage(sender, player, player.isSneaking());
                        return true;
                    case ARGS_LABEL_GETBOOLEAN:
                        sendGetBooleanMessage(sender, player, player.isSneaking());
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
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(String::toLowerCase).collect(Collectors.toList());
            } else {
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(String::toLowerCase).filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        } else if (args.length == 2) {
            if (args[1].length() == 0) {
                return COMMAND_SUGGESTIONS;
            } else {
                return COMMAND_SUGGESTIONS.stream().filter(s -> s.startsWith(args[1].toLowerCase())).collect(Collectors.toList());
            }
        } else {
            return ImmutableList.of();
        }
    }
}
