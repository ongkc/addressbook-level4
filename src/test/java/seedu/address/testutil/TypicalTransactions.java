package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.transaction.Transaction;
import seedu.address.model.util.SampleDataUtil;
//@author ongkc
/**
 * A utility class containing a list of {@code Transaction} objects to be used in tests.
 */
public class TypicalTransactions {

    private static Transaction T1 = null;
    private static Transaction T2 = null;
    private static Transaction T3 = null;
    private static Transaction T4 = null;
    private static Transaction T5 = null;

    private static Person person1 = SampleDataUtil.getSamplePersons()[0];
    private static Person person2 = SampleDataUtil.getSamplePersons()[1];
    private static Person person3 = SampleDataUtil.getSamplePersons()[2];
    private static Person person4 = SampleDataUtil.getSamplePersons()[3];
    private static Person person5 = SampleDataUtil.getSamplePersons()[4];
    private static Person person6 = SampleDataUtil.getSamplePersons()[5];

    private static UniquePersonList payee2 = new UniquePersonList();
    private static UniquePersonList payee4 = new UniquePersonList();
    private static UniquePersonList payee6 = new UniquePersonList();
    private static UniquePersonList payeeAlice = new UniquePersonList();
    private static UniquePersonList payeeBenson = new UniquePersonList();

    static {
        try {
            payee2.add(person2);
            payee4.add(person4);
            payee6.add(person6);
            payeeAlice.add(TypicalPersons.ALICE);
            payeeBenson.add(TypicalPersons.BENSON);

            T1 = new TransactionBuilder().withPayer(person1).withAmount("5.62")
                    .withDescription("Boat trip").withPayees(payee2).build();
            T2 = new TransactionBuilder().withPayer(person3).withAmount("123.45")
                    .withDescription("Food for barbecue").withPayees(payee4).build();
            T3 = new TransactionBuilder().withPayer(person5).withAmount("10.00")
                    .withDescription("Open air concert").withPayees(payee6).build();
            T4 = new TransactionBuilder().withPayer(TypicalPersons.ALICE).withAmount("9999")
                    .withDescription("Transport")
                    .withPayees(payeeBenson).build();
            T5 = new TransactionBuilder().withPayer(TypicalPersons.ALICE)
                    .withAmount("9999").withDescription("Dinner")
                    .withPayees(payeeBenson).build();
        } catch (DuplicatePersonException dpe) {
            dpe.printStackTrace();
        }
    }

    private TypicalTransactions() { } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Transaction transaction : getTypicalTransactions()) {
            ab.addTransaction(transaction);
        }
        return ab;
    }

    public static List<Transaction> getTypicalTransactions() {
        return new ArrayList<>(Arrays.asList(T1, T2, T3, T4, T5));
    }

    public static List<UniquePersonList> getTypicalPayees() {
        return new ArrayList<>(Arrays.asList(payee2, payee4, payee6, payeeAlice, payeeBenson));
    }
}
