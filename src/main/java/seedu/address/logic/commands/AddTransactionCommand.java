package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.model.transaction.Transaction;

public class AddTransactionCommand extends UndoableCommand{

    public static final String COMMAND_WORD = "Transaction";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new transaction to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_AMOUNT + "AMOUNT "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_NAME + "NAME "
            + "Example: " + COMMAND_WORD + "paid by: "
            + PREFIX_NAME+ "John Doe "
            + PREFIX_AMOUNT + "3456.78 "
            + PREFIX_DESCRIPTION + "for dinner meal"
            + PREFIX_NAME + "Tom Riddle"
            + PREFIX_NAME + "Harry Potter";


    public static final String MESSAGE_SUCCESS = "New transaction added";

    private final Transaction toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddTransactionCommand(Transaction transaction) {
        requireNonNull(transaction);
        toAdd = transaction;
    }

    @Override
    public CommandResult executeUndoableCommand() {
        requireNonNull(model);
        model.addTransaction(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTransactionCommand // instanceof handles nulls
                && toAdd.equals(((AddTransactionCommand) other).toAdd));
    }
}
