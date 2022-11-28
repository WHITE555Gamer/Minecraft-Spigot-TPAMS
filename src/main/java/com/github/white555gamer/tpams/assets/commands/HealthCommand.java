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
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.ERROR_NON_CORRECT_ARGS_MESSAGE;
import static org.bukkit.Bukkit.getServer;

/**
 * Health Command Class.<br>
 * This Class Controlling Health Command Operation.
 *
 * @since 0.0.2-ALPHA<br>(Reformed 0.2.0-ALPHA)
 */
public class HealthCommand implements TabExecutor {

    /**
     * (Public Static)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static @NonNls String name() {
        return "HealthCommand";
    }

    /**
     * (Public Static)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static @NonNls String commandName() {
        return "health";
    }

    /**
     * (Private Static Final)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static final HealthCommand instance = new HealthCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private HealthCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get HealthCommand's instance.
     *
     * @return HealthCommand's Singleton Instance.
     * @see HealthCommand
     */
    public static HealthCommand getInstance() {
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
     * Zero Double.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Double ZERO_HEALTH = 0d;
    /**
     * (Private Static Final)<br>
     * Minimum Double.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls Double MINIMUM_HEALTH = 1d;

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
     * Zero String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_KILL = "kill";
    /**
     * (Private Static Final)<br>
     * GetHealth String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_GETHEALTH = "gethealth";


    /**
     * (Private Static)<br>
     * This method send set message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender       CommandSender.
     * @param player       Player.
     * @param beforeHealth Health Before Changes.
     * @param afterHealth  Health After Changes.
     */
    private static @Nls void sendSetMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Double beforeHealth, @NotNull Double afterHealth) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力が" + beforeHealth + "から" + afterHealth + "に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力が" + beforeHealth + "から" + afterHealth + "設定されました。");
                        player.sendMessage("体力が" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                    } else {
                        sender.sendMessage("The health has been set " + afterHealth + " from " + beforeHealth + ".");
                        player.sendMessage("体力が" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                    }
                } else {
                    sender.sendMessage("The health has been set " + afterHealth + " from " + beforeHealth + ".");
                    player.sendMessage("体力速度が" + sender.getName() + "によって" + beforeHealth + "から" + afterHealth + "に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health has been set " + afterHealth + " from " + beforeHealth + ".");
        } else {
            sender.sendMessage(player.getName() + "'s health has been set " + afterHealth + " from " + beforeHealth + ".");
            player.sendMessage("The health has been set " + afterHealth + " from " + beforeHealth + " by " + sender.getName() + ".");
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
                sender.sendMessage("体力が最小に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力が最小に設定されました。");
                        player.sendMessage("体力が" + sender.getName() + "によって最小に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s health has been set Minimum.");
                        player.sendMessage("体力が" + sender.getName() + "によって最小に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s health has been set Minimum.");
                    player.sendMessage("体力が" + sender.getName() + "によって最小に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health has been set Minimum.");
        } else {
            sender.sendMessage(player.getName() + "'s health has been set Minimum.");
            player.sendMessage("The health has been set Minimum by " + sender.getName() + ".");
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
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力が最大に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力が最大に設定されました。");
                        player.sendMessage("体力が" + sender.getName() + "によって最大に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s health has been set Maximum.");
                        player.sendMessage("体力が" + sender.getName() + "によって最大に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s health has been set Maximum.");
                    player.sendMessage("体力が" + sender.getName() + "によって最大に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health has been set Maximum.");
        } else {
            sender.sendMessage(player.getName() + "'s health has been set Maximum.");
            player.sendMessage("The health has been set Maximum by " + sender.getName() + ".");
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
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("体力が0に設定されました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "の体力が0に設定されました。");
                        player.sendMessage("体力が" + sender.getName() + "によって0に設定されました。");
                    } else {
                        sender.sendMessage(player.getName() + "'s health has been set 0.");
                        player.sendMessage("体力が" + sender.getName() + "によって0に設定されました。");
                    }
                } else {
                    sender.sendMessage(player.getName() + "'s health has been set 0.");
                    player.sendMessage("体力が" + sender.getName() + "によって0に設定されました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("The health has been set 0.");
        } else {
            sender.sendMessage(player.getName() + "'s health has been set 0.");
            player.sendMessage("The health has been set 0 by " + sender.getName() + ".");
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
    private static @Nls void sendKillMessage(@NotNull CommandSender sender, @NotNull Player player) {
        if (player.getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage(player.getName() + "をキルしました。");
            } else {
                if (sender instanceof Player) {
                    if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                        sender.sendMessage(player.getName() + "をキルしました。");
                        player.sendMessage(sender.getName() + "によってキルされました。");
                    } else {
                        sender.sendMessage("Killed " + player.getName() + ".");
                        player.sendMessage(sender.getName() + "によってキルされました。");
                    }
                } else {
                    sender.sendMessage("Killed " + player.getName());
                    player.sendMessage(sender.getName() + "によってキルされました。");
                }
            }
        } else if (sender.getName().equalsIgnoreCase(player.getName())) {
            sender.sendMessage("Killed " + player.getName() + ".");
        } else {
            sender.sendMessage("Killed " + player.getName() + ".");
            player.sendMessage(player.getName() + " is killed by " + sender.getName() + ".");
        }
    }

    /**
     * (Private Static)<br>
     * This method send get health message to sender or sender and player.<br>
     * Localization is required as it is used user-visible string.
     *
     * @param sender CommandSender.
     * @param player Player.
     */
    private static @Nls void sendGetHealthMessage(@NotNull CommandSender sender, @NotNull Player player, @NotNull Double health) {
        if (sender instanceof Player) {
            if (((Player) sender).getLocale().equalsIgnoreCase(LOCALE_JAPANESE)) {
                if (sender.getName().equalsIgnoreCase(player.getName())) {
                    sender.sendMessage("体力: " + health);
                } else {
                    sender.sendMessage(player.getName() + "の体力: " + health);
                }
            } else {
                if (sender.getName().equalsIgnoreCase(player.getName())) {
                    sender.sendMessage("Health: " + health);
                } else {
                    sender.sendMessage(player.getName() + "'s Health: " + health);
                }
            }
        } else {
            if (sender.getName().equalsIgnoreCase(player.getName())) {
                sender.sendMessage("Health: " + health);
            } else {
                sender.sendMessage(player.getName() + "'s Health: " + health);
            }
        }
    }

    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(
            ARGS_LABEL_SET, ARGS_LABEL_MIN, ARGS_LABEL_MAX, ARGS_LABEL_ZERO, ARGS_LABEL_KILL, ARGS_LABEL_ADD, ARGS_LABEL_SUB, ARGS_LABEL_GETHEALTH);

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
                    sendGetHealthMessage(sender, player, player.getHealth());
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 1:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                } else {
                    sendGetHealthMessage(sender, player, player.getHealth());
                }
                return true;
            case 2:
                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_MIN:
                        player.setHealth(MINIMUM_HEALTH);
                        sendMinimumMessage(sender, player);
                        return true;
                    case ARGS_LABEL_MAX:
                        player.setHealth(player.getHealthScale());
                        sendMaximumMessage(sender, player);
                        return true;
                    case ARGS_LABEL_ZERO:
                        player.setHealth(ZERO_HEALTH);
                        sendZeroMessage(sender, player);
                        return true;
                    case ARGS_LABEL_KILL:
                        player.setHealth(ZERO_HEALTH);
                        sendKillMessage(sender, player);
                        return true;
                    case ARGS_LABEL_GETHEALTH:
                        sendGetHealthMessage(sender, player, player.getHealth());
                        return true;
                }
            case 3:
                BigDecimal beforeHealth;
                BigDecimal afterHealth;
                BigDecimal calcHealth;

                player = Bukkit.getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(ERROR_PLAYER_NOT_FOUND_MESSAGE);
                    return true;
                }
                beforeHealth = BigDecimal.valueOf(player.getHealth());
                try {
                    calcHealth = BigDecimal.valueOf(Double.parseDouble(args[2]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                if (calcHealth.doubleValue() < 0 || calcHealth.doubleValue() > player.getHealthScale()) {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
                switch (args[1]) {
                    case ARGS_LABEL_SET:
                        player.setHealth(calcHealth.doubleValue());
                        sendSetMessage(sender, player, beforeHealth.doubleValue(), calcHealth.doubleValue());
                        return true;
                    case ARGS_LABEL_ADD:
                        afterHealth = beforeHealth.add(calcHealth);
                        if (afterHealth.doubleValue() < 0) {
                            afterHealth = BigDecimal.valueOf(0);
                        } else if (calcHealth.doubleValue() > player.getHealthScale()) {

                        }
                        player.setHealth(afterHealth.doubleValue());
                        sendSetMessage(sender, player, beforeHealth.doubleValue(), calcHealth.doubleValue());
                        return true;
                    case ARGS_LABEL_SUB:
                        afterHealth = beforeHealth.subtract(calcHealth);
                        if (afterHealth.doubleValue() < 0 || calcHealth.doubleValue() > player.getHealthScale()) {
                            afterHealth = BigDecimal.valueOf(0);
                        }
                        player.setHealth(afterHealth.doubleValue());
                        sendSetMessage(sender, player, beforeHealth.doubleValue(), calcHealth.doubleValue());
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
