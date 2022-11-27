package com.github.white555gamer.tpams.assets.commands;

import com.github.white555gamer.tpams.TPAMS;
import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.white555gamer.tpams.TPAMS.getTPAMSActive;
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.*;

/**
 * BroadCast Command Class.<br>
 * This Class Controlling BroadCast Command Operation.
 *
 * @since 0.2.0-ALPHA
 */
public class BroadCastMessageCommand implements TabExecutor {

    /**
     * (Public Static Final)<br>
     * This Class's Name.
     *
     * @return This Class Name.
     */
    public static final @NonNls String name() {
        return "BroadCastMessageCommand";
    }

    /**
     * (Public Static Final)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static final @NonNls String commandName() {
        return "broadcastmessage";
    }

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static BroadCastMessageCommand instance = new BroadCastMessageCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private BroadCastMessageCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get BroadCastMessageCommand's instance.
     *
     * @return BroadCastMessageCommand's Singleton Instance.
     * @see BroadCastMessageCommand
     */
    public static BroadCastMessageCommand getInstance() {
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

        String BroadCastMessage = null;

        if (args.length == 0) {
            sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
            return true;
        } else {
            for (int i = 0; i <= args.length - 1; i++) {
                if (i == 0) {
                    BroadCastMessage = args[i];
                } else {
                    BroadCastMessage = BroadCastMessage + " " + args[i];
                }
            }
        }
        Bukkit.getServer().broadcastMessage(BroadCastMessage);
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
     * @return Always Empty List.
     */
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return ImmutableList.of();
    }
}
