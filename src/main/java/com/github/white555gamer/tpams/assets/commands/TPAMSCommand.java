package com.github.white555gamer.tpams.assets.commands;

import com.github.white555gamer.tpams.TPAMS;
import com.google.common.collect.ImmutableList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.ERROR_NON_CORRECT_ARGS_MESSAGE;
import static com.github.white555gamer.tpams.assets.constants.ConstantProperty.ERROR_PLAYER_NON_EXECUTABLE_MESSAGE;
import static org.bukkit.ChatColor.*;

/**
 * TPAMS Command Class.<br>
 * This Class Controlling Command Operation.
 *
 * @since 0.2.0-SNAPSHOT<br>(Partially 0.1.5-RELEASE & 0.1.6-ALPHA)
 */
public class TPAMSCommand implements TabExecutor {

    /**
     * (Public Static Final)<br>
     * This Class's Name.
     *
     * @return This Class's Name.
     */
    public static final @NonNls String name() {
        return "TPAMSCommand";
    }

    /**
     * (Public Static Final)<br>
     * This Class's Command Name.
     *
     * @return This Class's Command Name.
     */
    public static final @NonNls String commandName() {
        return "tpams";
    }

    /**
     * (Private Static)<br>
     * This Class's Instance.<br>
     * It can get with getInstance Method Only.
     */
    private static TPAMSCommand instance = new TPAMSCommand();

    /**
     * (Private)<br>
     * Private Constructor for Singleton.
     */
    private TPAMSCommand() {
    }

    /**
     * (Public)<br>
     * Getter.<br>
     * This Method allows to you to get TPAMSCommand's instance.
     *
     * @return TPAMSCommand's Singleton Instance.
     * @see TPAMSCommand
     */
    public static TPAMSCommand getInstance() {
        return instance;
    }

    /**
     * (Private Static Final)<br>
     * Active String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_ACTIVE = "active";
    /**
     * (Private Static Final)<br>
     * ChangeLog String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_CHANGELOG = "changelog";
    /**
     * (Private Static Final)<br>
     * Help String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_HELP = "help";
    /**
     * (Private Static Final)<br>
     * Test String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String ARGS_LABEL_PING = "ping";

    /**
     * (Private Static Final)<br>
     * BroadCastMessage Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String BROADCASTMESSAGE_COMMAND_NAME = BroadCastMessageCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Fly Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String FLY_COMMAND_NAME = FlyCommand.commandName();
    /**
     * (Private Static Final)<br>
     * FlySpeed Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String FLYSPEED_COMMAND_NAME = FlySpeedCommand.commandName();
    /**
     * (Private Static Final)<br>
     * OldGameMode Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String OLDGAMEMODE_COMMAND_NAME = OldGameModeCommand.commandName();
    /**
     * (Private Static Final)<br>
     * Sneak Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String SNEAK_COMMAND_NAME = SneakCommand.commandName();
    /**
     * (Private Static Final)<br>
     * TPAMS Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String TPAMS_COMMAND_NAME = TPAMSCommand.commandName();
    /**
     * (Private Static Final)<br>
     * WalkSpeed Command Name String Label.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls String WALKSPEED_COMMAND_NAME = WalkSpeedCommand.commandName();

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
     * BroadCastMessage Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String BROADCASTMESSAGE_COMMAND_HELP = YELLOW + "usage" + RESET + ": \n" +
            "/broadcastmessage Hello!\n" +
            "/broadcastmessage Hello World!\n" +
            YELLOW + "description" + RESET + ": \n" +
            "This command allows you to broadcast message.\n" +
            "It is intended for use from Server console.";
    /**
     * (Private Static Final)<br>
     * Fly Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String FLY_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/fly < Player > < true | false | toggle | getboolean >\n" +
            YELLOW + "description" + RESET + ": | \n" +
            "This command allows you to fly without creative or spectator mode.";
    /**
     * (Private Static Final)<br>
     * FlySpeed Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String FLYSPEED_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/flyspeed < Player > < reset | set | min | max | zero | add | sub | getspeed >\n" +
            YELLOW + "description" + RESET + ": |\n" +
            "This command allows you to set flight speed.";
    /**
     * (Private Static Final)<br>
     * OldGameMode Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String OLDGAMEMODE_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/oldgamemode < 0 | 1 | 2 | 3 | s | c | a | sp > < Player >\n" +
            YELLOW + "description" + RESET + ": | \n" +
            "This command allows you to change game mode using old style command.";
    /**
     * (Private Static Final)<br>
     * Sneak Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String SNEAK_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/sneak < Player > < true | false | toggle | getboolean >\n" +
            YELLOW + "description" + RESET + ": |\n" +
            "This command allows you to change sneak mode.";
    /**
     * (Private Static Final)<br>
     * TPAMS Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/tpams active < TPAMS Command > < true | false > \n" +
            "/tpams help < TPAMS Command >\n" +
            "/tpams changelog < Version > < Page >\n" +
            "/tpams test\n" +
            YELLOW + "description" + RESET + ": |\n" +
            "This command allows you to change or see TPAMS settings and more.";
    /**
     * (Private Static Final)<br>
     * WalkSpeed Command Help String.<br>
     * No localization is required.
     */
    private static final @NonNls String WALKSPEED_COMMAND_HELP = YELLOW + "usage" + RESET + ": |\n" +
            "/walkspeed < Player > < reset | set | min | max | zero | add | sub | getspeed >\n" +
            YELLOW + "description" + RESET + ": |\n" +
            "This command allows you to set walk speed.";

    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.1-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHAMGELOG_VERSION001ALPHA_PAGE1 =
            "----------   0.0.1-ALPHA ChangeLog   PAGE   1 / 1 ----------\n" +
                    "TPAMS - 0.0.1 - ALPHA has 2 commands.\n/fly <playername>\n/ heel <playername>\n" +
                    "The command can't be used from the server side. And command message is Japanese. It'll be support for English later. (By Google Translate)";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.1-Beta Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION001BETA_PAGE1 =
            "----------   0.0.1-BETA ChangeLog   PAGE   1 / 2 ----------\n" +
                    "With this update, various commands can be set.\nTPAMS - 0.0.1 - ALPHA only allows to set enabled when using the fly command.\n" +
                    "Now you can enable/disable with \"/fly < true | false >\". Also, when set true, you can set the flight speed like \"/fly true <flyspeed>\"." +
                    "The heel command was a one-way street, just like the previous version of the plug-in, setting it to maximum health, \n" +
                    "but now it can be set or added using \"/ heel <set | add>\" to decide. \"set\" can be specified in the range of 0.0 to 20.0.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.1-Beta Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION001BETA_PAGE2 =
            "----------   0.0.1-BETA ChangeLog   PAGE   2 / 2 ----------\n" +
                    "When adding, you can specify a number in addition to the original health. It is an experimental command because it is not clear what this number needs to be. \n" +
                    "However, if you use \"add\" to get a value greater than 20.0, the value is expected to be 20.0.\n" +
                    "This is because even large numbers can depend on the player's default maximum health.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.2-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION002ALPHA_PAGE1 =
            "----------   0.0.2-ALPHA ChangeLog   PAGE   1 / 2 ----------\n" +
                    "This update addresses an issue where Heel & Fly was not available in previous beta versions.\n\n" +
                    "The important change is that in this update, the heel has been changed to a dedicated command that allows you to quickly recover\n" +
                    "with \"/ heel me\". The health setting command is now \"/ health\".\n\n" +
                    "In addition, the operation of the \"/ fly\" command has been changed to enable / disable only.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.2-Alpha Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION002ALPHA_PAGE2 =
            "----------   0.0.2-ALPHA ChangeLog   PAGE   2 / 2 ----------\n" +
                    "Speed changes at \"/ fly\" have been moved to \"/ fly_speed\".\n" +
                    "Also, \"/ walk_speed\" has been added as the same speed change, so you can change the walking speed.\n" +
                    "<Command>\n/ Flight <true | false> <speed>\n→ / fly <true | false>\nNewcomer\n→ / fly_speed <~ 1.0>\nNewcomer\n" +
                    "→ / walk_speed <~ 1.0>\nNewcomer\n→ Health <Set | Add> <Number>\n/ Heel <set | add> <number>\n→ / heel me ";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.2-Beta Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION002BETA_PAGE1 =
            "----------   0.0.2-BETA ChangeLog   PAGE   1 / 1 ----------\n" +
                    "This plugin adds \"reset\" to \"/ walk_speed\", along with the stability improvements of the previous alpha plugin.\n" +
                    "In addition, the problem that does not work unless it is \"/ heel me\" has been resolved, and it now works with \"/ heel\".\n" +
                    "We have also officially implemented a secretly updated loading message.\n\n" +
                    "<Commands>\n/ walk_speed <~ 1.0>\n→ / walk_speed <~ 1.0 | reset>\n/ heel me\n→ / heel";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-SnapShot Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE1 =
            "----------   0.0.3-SNAPSHOT ChangeLog   PAGE   1 / 3 ----------\n" +
                    "This is just a snapshot of the next implementation.\n" +
                    "This feature is a test version and may not be implemented as is. Also, the snapshot version does not guarantee compatibility with other TPAMS plugins.\n" +
                    "This version implements \"config.yml\". It has existed from previous versions, but you can actually change the settings from this version. In this version,\n" +
                    "you can set a message when a member enters the server. Also, you can set and send a message during \"advancement\". If you know about this \"advancement\"," +
                    "please let me know.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-SnapShot Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE2 =
            "----------   0.0.3-SNAPSHOT ChangeLog   PAGE   2 / 3 ----------\n" +
                    "Also, \"advancement\" does not have a function to send a message to the whole.\n" +
                    "The \"Join\" and \"advancement\" messages are set to \"false\" by default.\n" +
                    "If you change it to \"true\" in the text editor, the process will be executed. You can also make advanced settings for the message.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-SnapShot Page 3 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE3 =
            "----------   0.0.3-SNAPSHOT ChangeLog   PAGE   3 / 3 ----------\n" +
                    "Replacement using detailed \"replace\" is now possible, so messages can be rewritten according to variables using \"/ player /\", [/ server /], etc.\n" +
                    "In addition, you can now change using the game mode numbers used in previous versions of Minecraft. If you use this, use \"/ oldGM <number>\".\n" +
                    "Also implemented a secret command error statement. This is to make it easier to understand the errors caused by not changing the command statement each time.\n" +
                    "\n<commands>\nnew\n→/oldGM <number>";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003ALPHA_PAGE1 =
            "----------   0.0.3-ALPHA ChangeLog   PAGE   1 / 3 ----------\n" +
                    "This TPAMS does not inherit the functionality of previous snapshots.\n" +
                    "Also, config.yml is generated, but it doesn't affect the configuration at all. Also, from this time,\n" +
                    "we decided to temporarily separate the English and Japanese versions.\n" +
                    "You can now also determine who has operator authority, and all commands can only be run by the operator.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-Alpha Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003ALPHA_PAGE2 =
            "----------   0.0.3-ALPHA ChangeLog   PAGE   2 / 3 ----------\n" +
                    "This update allows TPAMS to execute more commands. Previously, you couldn't set \"food level\" just by setting your physical strength, but now you can.\n" +
                    "You can also set the physical fitness scale.\nThe food version of immediate recovery \"satiety\" has been implemented,\n" +
                    "and you can now use the \"recovery\" command to recover both at the same time.\n" +
                    "Also, an important command change is that you must always specify a name after selecting a command.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.0.3-Alpha Page 3 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION003ALPHA_PAGE3 =
            "----------   0.0.3-ALPHA ChangeLog   PAGE   3 / 3 ----------\n" +
                    "Also, the game mode command does not conflict with the original game mode command, so it has been changed to \"oldgamemode\" again.\n" +
                    "\n<commands>\n/fly (<player_name>) <true|false(|getboolean)>\n/fly_speed (<player_name>) <reset|0.1~1.0(|getspeed)>\n" +
                    "/walk_speed (<player_name>) <reset|0.1~1.0(|getspeed)>\n/health (<player_name>) <set|add(|gethealth)> <number value>\n" +
                    "/healthscale (<player_name>) <set|add(|gethealthscale)>\n/food (<player_name>) <set|add(|gethealth)> <number value>\n" +
                    "/heel (<player_name>)\n/satiety (<player_name>)\n/oldgamemode <0(SURVIVAL)|1(CREATIVE)|2(ADVENTURE)|3(SPECTATOR)>";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015ALPHA_PAGE1 =
            "----------   0.1.5-ALPHA ChangeLog   PAGE   1 / 4 ----------\n" +
                    BOLD + "TPAMS is Returned!\n" + RESET + "・Supported version 1.18.1.\n・Commands Updated.\n・New commands came.\n・Some commands deleted or renamed\n" +
                    "\nMany Commands are Updated And Came!\nThe following is a list of commands.\n<Classic Gamemode Command>\n" +
                    "/classic_gamemode < 0 | 1 | 2 | 3 | s | c | a | sp > < PlayerName >\nYou can set a gamemode using the old command arguments option.\n" +
                    "e.g.\n/classic_gamemode 0\n/classic_gamemode 1 EXAMPLE\n<Fake Message Command>\n/fakemsg < PlayerName > < MsgBody >\n" +
                    "You can send a fake message using the name of another user.\nne.g.\n/fakemsg EXAMPLE HELLO\nresult:\n<EXAMPLE...?> HELLO";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Alpha Page 2 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015ALPHA_PAGE2 =
            "----------   0.1.5-ALPHA ChangeLog   PAGE   2 / 4 ----------\n" +
                    "<Fake Name Command>\n/fakename < PlayerName > < fakename >\nYou can set a fake name using the name of another user.\ne.g.\n" +
                    "/fakename EXAMPLE EXAMPLE2\nresult:\nEXAMPLE...?\nn<Fly Command>\n/fly < PlayerName > < true | false | toggle | getboolean >\n" +
                    "\nYou can set/get the player flightable.\ne.g.\n/fly EXAMPLE true\n/fly EXAMPLE getboolean\nresult:\nEXAMPLE's flightable: true\n" +
                    "<Fly Speed Command>\n/fly_speed < PlayerName > < reset | set | min | max | add | sub | getspeed > < 0.1~1.0 >\n" +
                    "You can set/get the player flight speed.\ne.g.\n/fly_speed EXAMPLE set 1\n/fly_speed EXAMPLE min\n/fly_speed EXAMPLE getspeed";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Alpha Page 3 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015ALPHA_PAGE3 =
            "----------   0.1.5-ALPHA ChangeLog   PAGE   3 / 4 ----------\n" +
                    "result:\nEXAMPLE's flight speed is 0.1\n<Walk Speed Command>\n/walk_speed < PlayerName > < reset | set | min | max | add | sub | getspeed > < 0.1~1.0 >\n" +
                    "You can set/get the player walk speed.\ne.g.\n/walk_speed EXAMPLE max\n/walk_speed EXAMPLE getspeed\nresult:\n" +
                    "EXAMPLE's walk speed is 0.2\n<Health Command>\n/health < PlayerName > < set | kill | min | max | add | sub | gethealth > < 0 or more >\n" +
                    "You can set|get the player health.\ne.g.\n/health EXAMPLE set 20\n/health EXAMPLE kill\n/health EXAMPLE gethealth\n" +
                    "result:\nEXAMPLE's health is 20.0\n<Nickname Command>\n/nickname < PlayerName > < nickname >\nYou can set the player nickname.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Alpha Page 4 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015ALPHA_PAGE4 =
            "----------   0.1.5-ALPHA ChangeLog   PAGE   4 / 4 ----------\n" +
                    "e.g.\n/nickname EXAMPLE NICKNAME\nresult:\nNICKNAME(EXAMPLE)\n<Quick Full Food Command>\n/quick_fullfood < PlayerName >\n" +
                    "You can quick recover food point.\ne.g.\n/quick_fullfood\n/quick_fullfood EXAMPLE\n<Quick Full Health Command>\n" +
                    "/quick_fullhealth < PlayerName >\nYou can quick recover health point.\ne.g.\n/quick_fullhealth\n/quick_fullhealth EXAMPLE\n" +
                    "<Quick Recovery Command>\n/quick_recovery < PlayerName >\nYou can quick recover health and food point.\ne.g.\n" +
                    "\n/quick_recovery\n/quick_recovery EXAMPLE";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Beta Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015BETA_PAGE1 =
            "----------   0.1.5-BETA ChangeLog   PAGE   1 / 1 ----------\n" +
                    BOLD + "Beta Update!\n" + RESET + "・Add /fakename_reset command.\n・Add /nickname_reset command.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.5-Release Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION015RELEASE_PAGE1 =
            "----------   0.1.5-RELEASE ChangeLog   PAGE   1 / 1 ----------\n" +
                    BOLD + "A FIRST TPAMS RELEASE IS HERE!\n\n" + RESET +
                    "・FIRST TPAMS RELEASE IS RELEASED!\n・Added TabComplete!!!\n・Added /tpams_changelog Command\n→/tpams_changelog < Version > < Page >\n\n" +
                    "→You can see the TPAMS changelogs.\n\n・Added /tpams_help Command\n→/tpams_help < TPAMS Commands >\n\n→You can see the TPAMS command help.";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.1.6-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION016ALPHA_PAGE1 =
            "----------   0.1.6-ALPHA ChangeLog   PAGE   1 / 1 ----------\n" +
                    "・Added /tpams_playerdata_debug < PlayerName > < Commands >\n・Added /tpams_serverdata_debug < Commands >";
    /**
     * (Private Static Final)<br>
     * TPAMS ChangeLog Version 0.2.0-Alpha Page 1 String.<br>
     * No localization is required.
     */
    private static final @NonNls String TPAMS_CHANGELOG_VERSION020ALPHA_PAGE1 =
            "----------   0.2.0-ALPHA ChangeLog   PAGE   1 / 1 ----------\n" +
                    "New Version TPAMS Arrived!\nTPAMS System was Renewal. And Open Sourced. The TPAMS Command Added. \ne.g. /tpams active < Command > < true | false >\n" +
                    "/tpams help < Command >\n/tpams changelog < Version > < Page >\n/tpams ping\nSome command moved to ServerSDC, WorldSDC, QuickStatusSDC, NameRE, PlayerSDC.\n" +
                    "You can now check TPAMS Source code in https://github.com/WHITE555Gamer/Minecraft-Spigot-TPAMS";

    /**
     * (Private)<br>
     * TPAMS Version Enum Including ChangeLogs.<br>
     * No localization is required as it is used only internally.
     */
    private enum TPAMSVersions {
        Version001Alpha(0, "0.0.1-ALPHA", 1),
        Version001Beta(1, "0.0.1-BETA", 2),
        Version002Alpha(2, "0.0.2-ALPHA", 2),
        Version002Beta(3, "0.0.2-BETA", 1),
        Version003SnapShot(4, "0.0.3-SNAPSHOT", 3),
        Version003Alpha(5, "0.0.3-ALPHA", 3),
        Version015Alpha(6, "0.1.5-ALPHA", 4),
        Version015Beta(7, "0.1.5-BETA", 1),
        Version015Release(8, "0.1.5-RELEASE", 1),
        Version016Alpha(9, "0.1.6-ALPHA", 1),
        Version020Alpha(10, "0.2.0-ALPHA", 1);

        /**
         * (Private Final)<br>
         * TPAMS Version Index In Enum Including ChangeLogs.<br>
         * No localization is required as it is used only internally.
         */
        private final Integer index;
        /**
         * (Private Final)<br>
         * TPAMS Version String In Enum Including ChangeLogs.<br>
         * No localization is required as it is used only internally.
         */
        private final String version;
        /**
         * (Private Final)<br>
         * TPAMS Version Page In Enum Including ChangeLogs.<br>
         * No localization is required as it is used only internally.
         */
        private final Integer page;

        /**
         * TPAMS Versions Constructor In Enum Including ChangeLogs.<br>
         * No localization is required as it is used only internally.
         *
         * @param index   Index
         * @param version Version String
         * @param page    Page
         */
        TPAMSVersions(Integer index, String version, Integer page) {
            this.index = index;
            this.version = version;
            this.page = page;
        }
    }

    private static @NonNls String transBoolean2Active(@NotNull Boolean bool) {
        if (bool) {
            return "Active";
        } else {
            return "Inactive";
        }
    }

    private static @NonNls Boolean transString2Boolean(@NotNull String string) {
        Boolean isActive;
        switch (string) {
            case ARGS_LABEL_TRUE:
                isActive = true;
                break;
            case ARGS_LABEL_FALSE:
                isActive = false;
                break;
            default:
                isActive = null;
                break;
        }
        return isActive;
    }

    private static @NonNls void sendPageNotFoundMessage(@NotNull CommandSender sender, @NotNull Integer integer) {
        sender.sendMessage("Page Not Found. ( 1 ~ " + integer + " )");
    }

    /**
     * (Private Static Final)<br>
     * Command Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> COMMAND_SUGGESTIONS = ImmutableList.of(ARGS_LABEL_ACTIVE, ARGS_LABEL_CHANGELOG, ARGS_LABEL_HELP, ARGS_LABEL_PING);
    /**
     * (Private Static Final)<br>
     * TPAMS Commands List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> TPAMS_COMMANDS_LIST =
            ImmutableList.of(BROADCASTMESSAGE_COMMAND_NAME, FLY_COMMAND_NAME, FLYSPEED_COMMAND_NAME, OLDGAMEMODE_COMMAND_NAME, SNEAK_COMMAND_NAME,
                    TPAMS_COMMAND_NAME, WALKSPEED_COMMAND_NAME);
    /**
     * (Private Static Final)<br>
     * TPAMS Versions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> TPAMS_VERSIONS_LIST =
            ImmutableList.of(TPAMSVersions.Version001Alpha.version, TPAMSVersions.Version001Beta.version, TPAMSVersions.Version002Alpha.version, TPAMSVersions.Version002Beta.version,
                    TPAMSVersions.Version003SnapShot.version, TPAMSVersions.Version003Alpha.version, TPAMSVersions.Version015Alpha.version, TPAMSVersions.Version015Beta.version,
                    TPAMSVersions.Version015Release.version, TPAMSVersions.Version016Alpha.version, TPAMSVersions.Version020Alpha.version);
    /**
     * (Private Static Final)<br>
     * Number Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> NUMBER_SUGGESTIONS = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    /**
     * (Private Static Final)<br>
     * Boolean Suggestions List.<br>
     * No localization is required as it is used only internally.
     */
    private static final @NonNls List<String> BOOLEAN_SUGGESTIONS = ImmutableList.of(ARGS_LABEL_TRUE, ARGS_LABEL_FALSE);

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

        switch (args.length) {
            case 1:
                if (args[0].equalsIgnoreCase(ARGS_LABEL_PING)) {
                    sender.sendMessage("[TPAMS] Pong!");
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 2:
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE)) {
                    if (sender instanceof ConsoleCommandSender) {
                        if (args[1].equalsIgnoreCase(BROADCASTMESSAGE_COMMAND_NAME)) {
                            sender.sendMessage("BroadCastMessage Command Status: " + transBoolean2Active(BroadCastMessageCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(FLY_COMMAND_NAME)) {
                            sender.sendMessage("Fly Command Status: " + transBoolean2Active(FlyCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(FLYSPEED_COMMAND_NAME)) {
                            sender.sendMessage("FlySpeed Command Status: " + transBoolean2Active(FlySpeedCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(OLDGAMEMODE_COMMAND_NAME)) {
                            sender.sendMessage("OldGameMode Command Status: " + transBoolean2Active(OldGameModeCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(SNEAK_COMMAND_NAME)) {
                            sender.sendMessage("Sneak Command Status: " + transBoolean2Active(SneakCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(TPAMS_COMMAND_NAME)) {
                            sender.sendMessage("TPAMS All Command Status: " + transBoolean2Active(TPAMS.getTPAMSActive()));
                        } else if (args[1].equalsIgnoreCase(WALKSPEED_COMMAND_NAME)) {
                            sender.sendMessage("WalkSpeed Command Status: " + transBoolean2Active(WalkSpeedCommand.getActive()));
                        } else {
                            sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                        }
                    } else {
                        sender.sendMessage(ERROR_PLAYER_NON_EXECUTABLE_MESSAGE);
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_HELP)) {
                    if (args[1].equalsIgnoreCase(BROADCASTMESSAGE_COMMAND_NAME)) {
                        sender.sendMessage(BROADCASTMESSAGE_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(FLY_COMMAND_NAME)) {
                        sender.sendMessage(FLY_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(FLYSPEED_COMMAND_NAME)) {
                        sender.sendMessage(FLYSPEED_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(OLDGAMEMODE_COMMAND_NAME)) {
                        sender.sendMessage(OLDGAMEMODE_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(SNEAK_COMMAND_NAME)) {
                        sender.sendMessage(SNEAK_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(TPAMS_COMMAND_NAME)) {
                        sender.sendMessage(TPAMS_COMMAND_HELP);
                    } else if (args[1].equalsIgnoreCase(WALKSPEED_COMMAND_NAME)) {
                        sender.sendMessage(WALKSPEED_COMMAND_HELP);
                    } else {
                        sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    }
                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                }
                return true;
            case 3:
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE)) {
                    if (sender instanceof ConsoleCommandSender) {
                        Boolean isActive = transString2Boolean(args[2]);
                        if (isActive == null) {
                            sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                            return true;
                        }
                        if (args[1].equalsIgnoreCase(BROADCASTMESSAGE_COMMAND_NAME)) {
                            BroadCastMessageCommand.setActive(isActive);
                            sender.sendMessage("BroadCastMessage Command Status: " + transBoolean2Active(BroadCastMessageCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(FLY_COMMAND_NAME)) {
                            FlyCommand.setActive(isActive);
                            sender.sendMessage("Fly Command Status: " + transBoolean2Active(FlyCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(FLYSPEED_COMMAND_NAME)) {
                            FlySpeedCommand.setActive(isActive);
                            sender.sendMessage("FlySpeed Command Status: " + transBoolean2Active(FlySpeedCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(OLDGAMEMODE_COMMAND_NAME)) {
                            OldGameModeCommand.setActive(isActive);
                            sender.sendMessage("OldGameMode Command Status: " + transBoolean2Active(OldGameModeCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(SNEAK_COMMAND_NAME)) {
                            SneakCommand.setActive(isActive);
                            sender.sendMessage("Sneak Command Status: " + transBoolean2Active(SneakCommand.getActive()));
                        } else if (args[1].equalsIgnoreCase(TPAMS_COMMAND_NAME)) {
                            TPAMS.setTPAMSActive(isActive);
                            sender.sendMessage("TPAMS All Command Status: " + transBoolean2Active(TPAMS.getTPAMSActive()));
                        } else if (args[1].equalsIgnoreCase(WALKSPEED_COMMAND_NAME)) {
                            WalkSpeedCommand.setActive(isActive);
                            sender.sendMessage("WalkSpeed Command Status: " + transBoolean2Active(WalkSpeedCommand.getActive()));
                        } else {
                            sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                        }
                    } else {
                        sender.sendMessage(ERROR_PLAYER_NON_EXECUTABLE_MESSAGE);
                    }
                    return true;

                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_CHANGELOG)) {

                    if (args[1].equalsIgnoreCase(TPAMSVersions.Version001Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version001Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHAMGELOG_VERSION001ALPHA_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version001Alpha.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version001Beta.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version001Beta.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION001BETA_PAGE1);
                        } else if (args[2].equalsIgnoreCase("2")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION001BETA_PAGE2);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version001Beta.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version002Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version002Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION002ALPHA_PAGE1);
                        } else if (args[2].equalsIgnoreCase("2")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION002ALPHA_PAGE2);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version002Alpha.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version002Beta.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version002Beta.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION002BETA_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version002Beta.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version003SnapShot.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version003SnapShot.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE1);
                        } else if (args[2].equalsIgnoreCase("2")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE2);
                        } else if (args[2].equalsIgnoreCase("3")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003SNAPSHOT_PAGE3);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version003SnapShot.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version003Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version003Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003ALPHA_PAGE1);
                        } else if (args[2].equalsIgnoreCase("2")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003ALPHA_PAGE2);
                        } else if (args[2].equalsIgnoreCase("3")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION003ALPHA_PAGE3);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version003Alpha.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version015Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version015Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015ALPHA_PAGE1);
                        } else if (args[2].equalsIgnoreCase("2")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015ALPHA_PAGE2);
                        } else if (args[2].equalsIgnoreCase("3")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015ALPHA_PAGE3);
                        } else if (args[2].equalsIgnoreCase("4")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015ALPHA_PAGE4);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version015Alpha.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version015Beta.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version015Beta.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015BETA_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version015Beta.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version015Release.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version015Release.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION015RELEASE_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version015Release.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version016Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version016Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION016ALPHA_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version016Alpha.page);
                        }
                    } else if (args[1].equalsIgnoreCase(TPAMSVersions.Version020Alpha.version) || args[1].equalsIgnoreCase("index:" + TPAMSVersions.Version020Alpha.index)) {
                        if (args[2].equalsIgnoreCase("1")) {
                            sender.sendMessage(TPAMS_CHANGELOG_VERSION020ALPHA_PAGE1);
                        } else {
                            sendPageNotFoundMessage(sender, TPAMSVersions.Version020Alpha.page);
                        }
                    } else {
                        sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    }
                    return true;

                } else {
                    sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                    return true;
                }
            default:
                sender.sendMessage(ERROR_NON_CORRECT_ARGS_MESSAGE);
                return true;
        }
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
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE) | args[0].equalsIgnoreCase(ARGS_LABEL_HELP)) {
                    return TPAMS_COMMANDS_LIST;
                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_CHANGELOG)) {
                    return TPAMS_VERSIONS_LIST;
                }
                return ImmutableList.of();
            } else {
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE) | args[0].equalsIgnoreCase(ARGS_LABEL_HELP)) {
                    return TPAMS_COMMANDS_LIST.stream().filter(s -> s.startsWith(args[1].toLowerCase())).collect(Collectors.toList());
                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_CHANGELOG)) {
                    return NUMBER_SUGGESTIONS.stream().filter(s -> s.startsWith(args[1].toLowerCase())).collect(Collectors.toList());
                }
                return ImmutableList.of();
            }
        } else if (args.length == 3) {
            if (args[2].length() == 0) {
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE)) {
                    return BOOLEAN_SUGGESTIONS;
                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_CHANGELOG)) {
                    return NUMBER_SUGGESTIONS;
                } else {
                    return ImmutableList.of();
                }
            } else {
                if (args[0].equalsIgnoreCase(ARGS_LABEL_ACTIVE)) {
                    return BOOLEAN_SUGGESTIONS.stream().filter(s -> s.startsWith(args[2].toLowerCase())).collect(Collectors.toList());
                } else if (args[0].equalsIgnoreCase(ARGS_LABEL_CHANGELOG)) {
                    return NUMBER_SUGGESTIONS.stream().filter(s -> s.startsWith(args[2])).collect(Collectors.toList());
                } else {
                    return ImmutableList.of();
                }
            }
        } else {
            return ImmutableList.of();
        }
    }
}
