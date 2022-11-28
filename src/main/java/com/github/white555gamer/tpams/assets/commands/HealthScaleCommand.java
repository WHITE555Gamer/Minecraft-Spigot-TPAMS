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
 * HealthScale Command Class.<br>
 * This Class Controlling HealthScale Command Operation.
 * But now, this command is disabled. Cause: This command causes a lots of bugs.
 *
 * @since 0.0.3-ALPHA<br>(Reformed And Disabled 0.2.0-ALPHA)
 */
public class HealthScaleCommand implements TabExecutor {

    /**
     * (Public Static)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static @NonNls String name() {
        return "HealthScaleCommand";
    }

    /**
     * (Public Static)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static @NonNls String commandName() {
        return "healthscale";
    }

    /**
     * (Private Static Final)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static final HealthScaleCommand instance = new HealthScaleCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private HealthScaleCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get HealthScaleCommand's instance.
     *
     * @return HealthScaleCommand's Singleton Instance.
     * @see HealthScaleCommand
     */
    public static HealthScaleCommand getInstance() {
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
     * Minimum Double.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Double MINIMUM_HEALTH = 1d;
    /**
     * (Private Static Final)<br>
     * Default Double.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Double DEFAULT_HEALTH = 20d;

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
     * GetHealthScale String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_GETHEALTHSCALE = "gethealthscale";


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
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力スケールが初期化されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力スケールが初期化されました。");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって初期化されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s health scale has been reset.");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって初期化されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s health scale has been reset.");
                    player.sendMessage("体力スケールが" + sender.getName() + "によって初期化されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health scale has been reset.");
        } else {
            sender.sendMessage(player.getName() + "'s health scale has been reset.");
            player.sendMessage("The health scale has been reset by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send set message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender      CommandSender.
     * @param player      Player.
     * @param beforeHealth Health Scale Before Changes.
     * @param afterHealth  Health Scale After Changes.
     */
    private static @Nls void sendSetMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Double beforeHealth, @NotNull Double afterHealth) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力スケールが" + beforeHealth + "から" + afterHealth + "に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力スケールが" + beforeHealth + "から" + afterHealth + "設定されました。");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                    } else {
                        sender.sendMessage("The health scale has been set " + afterHealth + " from " + beforeHealth + ".");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                    }
                } else {
                    sender.sendMessage("The health scale has been set " + afterHealth + " from " + beforeHealth + ".");
                    player.sendMessage("体力スケールが" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health scale has been set " + afterHealth + " from " + beforeHealth + ".");
        } else {
            sender.sendMessage(player.getName() + "'s health scale has been set " + afterHealth + " from " + beforeHealth + ".");
            player.sendMessage("The health scale has been set " + afterHealth + " from " + beforeHealth + " by " + sender.getName() + ".");
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
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力スケールが最小に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力スケールが最小に設定されました。");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって最小に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s health scale has been set Minimum.");
                        player.sendMessage("体力スケールが" + sender.getName() + "によって最小に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s health scale has been set Minimum.");
                    player.sendMessage("体力スケールが" + sender.getName() + "によって最小に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health scale has been set Minimum.");
        } else {
            sender.sendMessage(player.getName() + "'s health scale has been set Minimum.");
            player.sendMessage("The health scale has been set Minimum by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send get health scale message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendGetHealthScaleMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Double health) {
        if (sender instanceof Player) {
            if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                if (sender.getName().equalsIgnoreCase(player.getName())) {
                    sender.sendMessage("体力スケール: " + health);
                } else {
                    sender.sendMessage(player.getName() + "の体力スケール: " + health);
                }
            } else {
                if (sender.getName().equalsIgnoreCase(player.getName())) {
                    sender.sendMessage("Health Scale: " + health);
                } else {
                    sender.sendMessage(player.getName() + "'s Health Scale: " + health);
                }
            }
        } else {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("Health Scale: " + health);
            } else {
                sender.sendMessage(player.getName() + "'s Health Scale: " + health);
            }
        }
    }


    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(
            ARGS_LABEL_DEFAULT, ARGS_LABEL_RESET, ARGS_LABEL_SET, ARGS_LABEL_MIN, ARGS_LABEL_ADD, ARGS_LABEL_SUB, ARGS_LABEL_GETHEALTHSCALE);

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

        sender.sendMessage("This command is invalid. Cause: This command causes a lot of bugs.");
        return true;

        /*if (!getTPAMSActive()) {
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
                    sendGetHealthScaleMessage(sender, player, player.getHealthScale());
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 1:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                } else {
                    sendGetHealthScaleMessage(sender, player, player.getHealthScale());
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
                        player.setHealthScale(DEFAULT_HEALTH);
                        sendResetMessage(sender, player);
                        return true;
                    case ARGS_LABEL_MIN:
                        player.setHealthScale(MINIMUM_HEALTH);
                        sendMinimumMessage(sender, player);
                        return true;
                    case ARGS_LABEL_GETHEALTHSCALE:
                        sendGetHealthScaleMessage(sender, player, player.getHealthScale());
                        return true;
                }
            case 3:
                BigDecimal beforeHealthScale;
                BigDecimal afterHealthScale;
                BigDecimal calcHealthScale;

                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                beforeHealthScale = BigDecimal.valueOf(player.getHealthScale());
                try {
                    calcHealthScale = BigDecimal.valueOf(Double.parseDouble(args[2]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                if (calcHealthScale.doubleValue() < 1) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_SET:
                        player.setHealthScale(calcHealthScale.doubleValue());
                        sendSetMessage(sender, player, beforeHealthScale.doubleValue(), calcHealthScale.doubleValue());
                        return true;
                    case ARGS_LABEL_ADD:
                        afterHealthScale = beforeHealthScale.add(calcHealthScale);
                        if (afterHealthScale.doubleValue() < 1) {
                            afterHealthScale = BigDecimal.valueOf(1);
                        }
                        player.setHealthScale(afterHealthScale.doubleValue());
                        sendSetMessage(sender, player, beforeHealthScale.doubleValue(), afterHealthScale.doubleValue());
                        return true;
                    case ARGS_LABEL_SUB:
                        afterHealthScale = beforeHealthScale.subtract(calcHealthScale);
                        if (afterHealthScale.doubleValue() < 1) {
                            afterHealthScale = BigDecimal.valueOf(1);
                        }
                        player.setHealthScale(afterHealthScale.doubleValue());
                        sendSetMessage(sender, player, beforeHealthScale.doubleValue(), afterHealthScale.doubleValue());
                        return true;
                }
        }
        sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
        return true;*/
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

        return ImmutableList.of();

        /*if (args.length == 1) {
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
        }*/
    }
}
