package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;
import javafx.application.Platform;
import org.fxmisc.easybind.EasyBind;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.transaction.Transaction;


/**
 * Panel containing the list of transactions.
 */
public class TransactionListPanel extends UiPart<Region> {
    private static final String FXML = "TransactionListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(seedu.address.ui.TransactionListPanel.class);

    @javafx.fxml.FXML
    private ListView<TransactionCard> transactionListView;

    public TransactionListPanel(ObservableList<Transaction> transactionList) {
        super(FXML);
        setConnections(transactionList);
        registerAsAnEventHandler(this);
    }
    private void setConnections(ObservableList<Transaction> transactionList) {
        ObservableList<TransactionCard> mappedList = EasyBind.map(transactionList, (transaction) -> new TransactionCard(
                transaction, transactionList.indexOf(transaction) + 1));
        transactionListView.setItems(mappedList);
        transactionListView.setCellFactory(listView -> new TransactionListViewCell());
    }


    private void setEventHandlerForSelectionChangeEvent() {
    }

    /**
     * Scrolls to the {@code PersonCard} at the {@code index} and selects it.
     */
    private void scrollTo(int index) {
    }

    @Subscribe
    private void handleJumpToListRequestEvent(JumpToListRequestEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        //scrollTo(event.targetIndex);
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TransactionCard}.
     */
    class TransactionListViewCell extends ListCell<TransactionCard> {

        @Override
        protected void updateItem(TransactionCard transaction, boolean empty) {
            super.updateItem(transaction, empty);

            if (empty || transaction == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(transaction.getRoot());
            }
        }
    }
}

