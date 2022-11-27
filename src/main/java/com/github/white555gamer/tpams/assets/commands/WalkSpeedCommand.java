package com.github.white555gamer.tpams.assets.commands;

import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.white555gamer.tpams.TPAMS.getTPAMSActive;
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.*;
import static org.bukkit.Bukkit.getServer;

/**
 * Walk Speed Command Class.<br>
 * This Class Controlling Walk Speed Command Operation.
 *
 * @since 0.0.2-ALPHA<br>(Reformed 0.2.0-ALPHA)
 */
public class WalkSpeedCommand implements TabExecutor {


    /**
     * (Public Static Final)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static final @NonNls String name() {
        return "WalkSpeedCommand";
    }

    /**
     * (Public Static Final)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static final @NonNls String commandName() {
        return "walkspeed";
    }

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static WalkSpeedCommand instance = new WalkSpeedCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private WalkSpeedCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get WalkSpeedCommand's instance.
     *
     * @return WalkSpeedCommand's Singleton Instance.
     * @see WalkSpeedCommand
     */
    public static WalkSpeedCommand getInstance() {
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
     * Zero Float.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Float ZERO_FLIGHT_SPEED = 0f;
    /**
     * (Private Static Final)<br>
     * Minimum Float.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Float MINIMUM_FLIGHT_SPEED = 0.1f;
    /**
     * (Private Static Final)<br>
     * Maximum Float.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Float MAXIMUM_FLIGHT_SPEED = 1f;
    /**
     * (Private Static Final)<br>
     * Default Float.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Float DEFAULT_FLIGHT_SPEED = 0.1f;

    /**
     * (Private Static Final)<br>
     * Default String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_DEFAULT = "default";
    /**
     * (Private Static Final)<br>
     * Reset String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_RESET = "reset";
    /**
     * (Private Static Final)<br>
     * Set String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SET = "set";
    /**
     * (Private Static Final)<br>
     * Min String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_MIN = "min";
    /**
     * (Private Static Final)<br>
     * Max String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_MAX = "max";
    /**
     * (Private Static Final)<br>
     * Add String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_ADD = "add";
    /**
     * (Private Static Final)<br>
     * Sub String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_SUB = "sub";
    /**
     * (Private Static Final)<br>
     * Zero String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_ZERO = "zero";
    /**
     * (Private Static Final)<br>
     * GetSpeed String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_GETSPEED = "getspeed";

    /**
     * (Private Static)<br>
     * This method send reset message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendResetMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("歩行速度が初期化されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の歩行速度が初期化されました。");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって初期化されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s walk speed has been reset.");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって初期化されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s walk speed has been reset.");
                    player.sendMessage("歩行速度が" + sender.getName() + "によって初期化されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("The walk speed has been reset.");
        } else {
            sender.sendMessage(player.getName() + "'s walk speed has been reset.");
            player.sendMessage("The walk speed has been reset by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send set message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender      CommandSender.
     * @param player      Player.
     * @param beforeSpeed Speed Before Changes.
     * @param afterSpeed  Speed After Changes.
     */
    private static @Nls void sendSetMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Float beforeSpeed, @NotNull Float afterSpeed) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("歩行速度が" + beforeSpeed + "から" + afterSpeed + "に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の歩行速度が" + beforeSpeed + "から" + afterSpeed + "設定されました。");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって" + beforeSpeed + "から" + afterSpeed + "に設定されました。");
                    } else {
                        sender.sendMessage("The walk speed has been set " + afterSpeed + " from " + beforeSpeed + ".");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって" + beforeSpeed + "から" + afterSpeed + "に設定されました。");
                    }
                } else {
                    sender.sendMessage("The walk speed has been set " + afterSpeed + " from " + beforeSpeed + ".");
                    player.sendMessage("歩行速度が" + sender.getName() + "によって" + beforeSpeed + "から" + afterSpeed + "に設定されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("The walk speed has been set " + afterSpeed + " from " + beforeSpeed + ".");
        } else {
            sender.sendMessage(player.getName() + "'s walk speed has been set " + afterSpeed + " from " + beforeSpeed + ".");
            player.sendMessage("The walk speed has been set " + afterSpeed + " from " + beforeSpeed + " by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send set minimum message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendMinimumMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("歩行速度が最小に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の歩行速度が最小に設定されました。");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって最小に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s walk speed has been set Minimum.");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって最小に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s walk speed has been set Minimum.");
                    player.sendMessage("飛行速度が" + sender.getName() + "によって最小に設定されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("The walk speed has been set Minimum.");
        } else {
            sender.sendMessage(player.getName() + "'s walk speed has been set Minimum.");
            player.sendMessage("The walk speed has been set Minimum by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send set maximum message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendMaximumMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("歩行速度が最大に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の歩行速度が最大に設定されました。");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって最大に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s walk speed has been set Maximum.");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって最大に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s walk speed has been set Maximum.");
                    player.sendMessage("歩行速度が" + sender.getName() + "によって最大に設定されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("The walk speed has been set Maximum.");
        } else {
            sender.sendMessage(player.getName() + "'s walk speed has been set Maximum.");
            player.sendMessage("The walk speed has been set Maximum by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send set 0 message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendZeroMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName() == player.getName()) {
                sender.sendMessage("歩行速度が0に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の歩行速度が0に設定されました。");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって0に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s walk speed has been set 0.");
                        player.sendMessage("歩行速度が" + sender.getName() + "によって0に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s walk speed has been set 0.");
                    player.sendMessage("歩行速度が" + sender.getName() + "によって0に設定されました。");
                }
            }
        } else if (sender.getName() == player.getName()) {
            sender.sendMessage("The walk speed has been set 0.");
        } else {
            sender.sendMessage(player.getName() + "'s walk speed has been set 0.");
            player.sendMessage("The walk speed has been set 0 by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send get speed message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendGetSpeedMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Float speed) {
        if (sender instanceof Player) {
            if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                sender.sendMessage("歩行速度: " + speed);
            } else {
                sender.sendMessage("Walk Speed: " + speed);
            }
        } else {
            sender.sendMessage("Walk Speed: " + speed);
        }
    }

    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(
            ARGS_LABEL_DEFAULT, ARGS_LABEL_RESET, ARGS_LABEL_SET, ARGS_LABEL_MIN, ARGS_LABEL_MAX, ARGS_LABEL_ZERO, ARGS_LABEL_ADD, ARGS_LABEL_SUB, ARGS_LABEL_GETSPEED);


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
                    sendGetSpeedMessage(sender, player, player.getWalkSpeed());
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 1:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                } else {
                    sendGetSpeedMessage(sender, player, player.getWalkSpeed());
                }
                return true;
            case 2:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_DEFAULT:
                    case ARGS_LABEL_RESET:
                        player.setWalkSpeed(DEFAULT_FLIGHT_SPEED);
                        sendResetMessage(sender, player);
                        return true;
                    case ARGS_LABEL_MIN:
                        player.setWalkSpeed(MINIMUM_FLIGHT_SPEED);
                        sendMinimumMessage(sender, player);
                        return true;
                    case ARGS_LABEL_MAX:
                        player.setWalkSpeed(MAXIMUM_FLIGHT_SPEED);
                        sendMaximumMessage(sender, player);
                        return true;
                    case ARGS_LABEL_ZERO:
                        player.setWalkSpeed(ZERO_FLIGHT_SPEED);
                        sendZeroMessage(sender, player);
                    case ARGS_LABEL_GETSPEED:
                        sendGetSpeedMessage(sender, player, player.getWalkSpeed());
                        return true;
                }
            case 3:
                BigDecimal beforeSpeed;
                BigDecimal afterSpeed;
                BigDecimal calcSpeed;

                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                beforeSpeed = BigDecimal.valueOf(player.getWalkSpeed());
                try {
                    calcSpeed = BigDecimal.valueOf(Float.parseFloat(args[2]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                if (calcSpeed.floatValue() < 0 || calcSpeed.floatValue() > 1) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_SET:
                        player.setWalkSpeed(calcSpeed.floatValue());
                        sendSetMessage(sender, player, beforeSpeed.floatValue(), calcSpeed.floatValue());
                        return true;
                    case ARGS_LABEL_ADD:
                        afterSpeed = beforeSpeed.add(calcSpeed);
                        if (afterSpeed.intValue() < 0) {
                            afterSpeed = BigDecimal.valueOf(0);
                        } else if (afterSpeed.floatValue() > 1) {
                            afterSpeed = BigDecimal.valueOf(1);
                        }
                        player.setWalkSpeed(afterSpeed.floatValue());
                        sendSetMessage(sender, player, beforeSpeed.floatValue(), afterSpeed.floatValue());
                        return true;
                    case ARGS_LABEL_SUB:
                        afterSpeed = beforeSpeed.subtract(calcSpeed);
                        if (afterSpeed.intValue() < 0) {
                            afterSpeed = BigDecimal.valueOf(0);
                        } else if (afterSpeed.floatValue() > 1) {
                            afterSpeed = BigDecimal.valueOf(1);
                        }
                        player.setWalkSpeed(afterSpeed.floatValue());
                        sendSetMessage(sender, player, beforeSpeed.floatValue(), afterSpeed.floatValue());
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
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(s -> s.toLowerCase()).collect(Collectors.toList());
            } else {
                return getServer().getOnlinePlayers().stream().map(Player::getName).map(s -> s.toLowerCase()).filter(s -> s.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
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
