package seedu.address.logic.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import seedu.address.model.person.Balance;
import seedu.address.model.person.Person;
import seedu.address.model.transaction.Amount;

/**
 * Contains utility methods used for calculating balances of Persons.
 */
public class BalanceCalculationUtil {

    private static final int NUMBER_OF_DECIMAL_PLACES = 2;

    /**
     * Returns an updated balance for {@code payer}
     */
    public static Balance calculatePayerBalance(Amount amount, Person payer, int numberOfInvolvedPersons) {
        Double amountToAdd = Double.valueOf(amount.value)
                * (numberOfInvolvedPersons - 1)
                / numberOfInvolvedPersons;
        Double updatedBalanceValue = Double.valueOf(payer.getBalance().value) + amountToAdd;
        updatedBalanceValue = round(updatedBalanceValue, NUMBER_OF_DECIMAL_PLACES);

        DecimalFormat formatter = new DecimalFormat("#.00");
        return new Balance(String.valueOf(formatter.format(updatedBalanceValue)));
    }

    /**
     * Returns an updated balance for {@code payee}
     */
    public static Balance calculatePayeeBalance(Amount amount, Person payee, int numberOfInvolvedPersons) {
        Double amountToSubtract = Double.valueOf(amount.value) / numberOfInvolvedPersons;
        Double updatedBalanceValue = Double.valueOf(payee.getBalance().value) - amountToSubtract;
        updatedBalanceValue = round(updatedBalanceValue, NUMBER_OF_DECIMAL_PLACES);

        DecimalFormat formatter = new DecimalFormat("#.00");
        return new Balance(String.valueOf(formatter.format(updatedBalanceValue)));
    }

    private static double round(double value, int places) {
        BigDecimal amount = new BigDecimal(value);
        amount = amount.setScale(places, RoundingMode.HALF_UP);
        return amount.doubleValue();
    }

}


