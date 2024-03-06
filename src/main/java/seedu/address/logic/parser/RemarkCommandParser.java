// Retrieved from https://github.com/se-edu/addressbook-level3/commit/dc6d5139d08f6403da0ec624ea32bd79a2ae0cbf#diff-a8e35af8f9c251525063fae36c9852922a7e7195763018eacec60f3a4d87c594
// Full credits to them.
// Also following tutorial from https://nus-cs2103-ay2324s2.github.io/tp/tutorials/AddRemark.html.
package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new {@code RemarkCommand} object
 */
public class RemarkCommandParser implements Parser<RemarkCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code RemarkCommand}
     * and returns a {@code RemarkCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RemarkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        Prefix remarkPrefix = new Prefix("remark");
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, remarkPrefix);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format("INVALID INPUT", "remark <index> <thing>"), ive);
        }

        String remark = argMultimap.getValue(remarkPrefix).orElse("");

        return new RemarkCommand(index, remark);
    }
}