package seedu.address.logic.commands;

import static seedu.address.commons.core.Messages.MESSAGE_SAME_SCREEN;
import static seedu.address.commons.core.Messages.MESSAGE_SWITCH_SUCCESS;
import static seedu.address.logic.commands.util.CommandUtil.getCommandResult;

import seedu.address.model.Model;
import seedu.address.ui.tabs.TabName;

/**
 * Switch the screen to a a certain tab.
 */
public class SwitchCommand extends Command {

    public static final String COMMAND_WORD = "switch";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Switch to the desired tab.\n"
        + "Parameters: TAB_NAME.\n"
        + "Example: " + COMMAND_WORD + " com";

    public final String sameScreenText;
    public final String switchedScreenText;

    private final TabName tabName;

    /**
     * Creates a SwitchCommand to switch {@code tabName}.
     */
    public SwitchCommand(TabName tabName) {
        this.tabName = tabName;
        sameScreenText = String.format(MESSAGE_SAME_SCREEN, tabName.toString());
        switchedScreenText = String.format(MESSAGE_SWITCH_SUCCESS, tabName.toString());
    }

    @Override
    public CommandResult execute(Model model) {

        TabName currentTab = model.getTabName();
        String resultMessage;

        if (tabName.equals(currentTab)) {
            resultMessage = sameScreenText;
        } else {
            resultMessage = switchedScreenText;
        }
        return getCommandResult(model, resultMessage, tabName);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof SwitchCommand // instanceof handles nulls
            && tabName.equals(((SwitchCommand) other).tabName)); // state check
    }
}