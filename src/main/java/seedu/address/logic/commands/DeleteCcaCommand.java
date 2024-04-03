// Part of the code is adpatated from original AB3 Code. All credits and thanks to the original
// CS2103T teaching team for this.
package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CCA;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.CcaContainsKeywordPredicate;
import seedu.address.model.person.Person;


/**
 * Owes the details of the person identified using the displayed index from the address book.
 */
public class DeleteCcaCommand extends Command {
    public static final String COMMAND_WORD = "cca_delete";

    // MESSAGE_USAGE below is modified from my Teammate's (AlphaJae) code
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes a CCA and all its associated members from your contacts."
            + "Parameters: "
            + "[" + PREFIX_CCA + "AMOUNT]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CCA + "NUS Cycling ";

    public static final String MESSAGE_NO_CCA = "A CCA should be provided.";
    private final CcaContainsKeywordPredicate ccas;

    /**
     * @param ccas The matching CCA to delete.
     */
    public DeleteCcaCommand(CcaContainsKeywordPredicate ccas) {
        requireNonNull(ccas);
        this.ccas = ccas;
    }


    // Solution below (equals method) is adapted from original AB3 author lzq.
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCcaCommand // instanceof handles nulls
                && ccas.equals(((DeleteCcaCommand) other).ccas));
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredPersonList(this.ccas);
        List<Person> lastShownList = model.getFilteredPersonList();
        StringBuilder result = new StringBuilder();
        result.append(String.format("Deleting CCA(s) %s and all its members:", this.ccas));

        for (Person personToDelete : lastShownList) {
            // TODO: bug: why does this not delete everything in one go?
            model.deletePerson(personToDelete);
            result.append(String.format("Deleted Person: $%s\n", personToDelete.getName()));
        }

        model.updateFilteredPersonList(this.ccas);
        return new CommandResult(result.toString());
    }

    @Override
    public String toString() {
        return new StringBuilder().append("DeleteCcaCommand{ ")
                .append("cca: ").append(ccas)
                .append("}").toString();
    }
}
