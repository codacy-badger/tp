package seedu.address.logic.parser.add;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_ITEM_TYPE;
import static seedu.address.model.util.ItemUtil.APPLICATION_ALIAS;
import static seedu.address.model.util.ItemUtil.COMPANY_ALIAS;
import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
import static seedu.address.model.util.ItemUtil.PROFILE_ALIAS;

import seedu.address.logic.commands.add.AddCommandAbstract;
import seedu.address.logic.commands.add.AddInternshipCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments for item type and returns AddCommandAbstract Object.
 */
public class AddCommandParserWrapper implements Parser<AddCommandAbstract> {

    private static final int ITEM_TYPE_INDEX = 0;
    private static final int COMMAND_DETAILS_INDEX = 1;
    private static final int NUMBER_OF_ARGUMENTS_TYPES = 2;

    /**
     * Parses the given {@code String} of arguments for the item type
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommandAbstract parse(String args) throws ParseException {

        String[] argumentTypes = args.strip().split(" ", NUMBER_OF_ARGUMENTS_TYPES);
        String itemType = argumentTypes[ITEM_TYPE_INDEX];

        checkItemTypePresent(itemType);
        String commandDetails = getCommandDetails(argumentTypes);
        switch (itemType) {
        case COMPANY_ALIAS:
            return new AddCompanyCommandParser().parse(commandDetails);
        case INTERNSHIP_ALIAS:
            return new AddInternshipCommand("Not an internship added");
        case APPLICATION_ALIAS:
            return new AddApplicationCommandParser().parse(commandDetails);
        case PROFILE_ALIAS:
            return new AddProfileCommandParser().parse(commandDetails);
        default:
            throw new ParseException(MESSAGE_INVALID_ITEM_TYPE);
        }
    }

    private void checkItemTypePresent(String itemType) throws ParseException {
        if (itemType.trim().isEmpty()) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, AddCommandAbstract.MESSAGE_USAGE));
        }
    }

    private String getCommandDetails(String[] argumentTypes) {
        String dummy = "";
        if (argumentTypes.length < NUMBER_OF_ARGUMENTS_TYPES) {
            return dummy; // if the user only entered the command word and the item type (did not enter details),
            // then provide this dummy string so that the relevant parser will show its error message.
        } else {
            return " " + argumentTypes[COMMAND_DETAILS_INDEX];
        }
    }
}
