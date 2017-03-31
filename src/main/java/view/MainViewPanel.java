package view;

import controller.ProcessController;
import entities.NumberLottery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import tools.NumberOperation;
import tools.StringUtils;

import java.util.ArrayList;

/**
 * Created by XTR100 on 12/11/2016.
 */
public class MainViewPanel {

    @FXML
    private TextField textFieldNumero;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<NumberLotteryEntityView> tableNumbers;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> morningNumberColumn;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> nightNumberColumn;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> dateColumn;

    @FXML
    private Button searchButtonTab2;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> nightNumberColumnTab2;

    @FXML
    private TextField textFieldNumeroTab2;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> dateColumnTab2;

    @FXML
    private TableView<NumberLotteryEntityView> tableNumbersTab2;

    @FXML
    private TableColumn<NumberLotteryEntityView, String> morningNumberColumnTab2;

    public void searchActionClickTab1() {
        System.out.println("PULSASTE!!!");

        NumberLottery numberLottery = new NumberLottery();


        ObservableList<NumberLotteryEntityView> observableList = FXCollections.observableArrayList();

        ProcessController processController = new ProcessController();
        ArrayList<NumberLottery> result = processController.getListNumberFromNumber(textFieldNumero.getText());

        for (NumberLottery numero :
                result) {
            observableList.add(new NumberLotteryEntityView(numero));
        }


        dateColumn.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("date"));
        morningNumberColumn.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("numberMorning"));
        nightNumberColumn.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("numberNight"));

        tableNumbers.setItems(observableList);

    }


    public void searchActionClickTab2() {
        System.out.println("PULSASTE_TAB2!!!");

        NumberLottery numberLottery = new NumberLottery();


        ObservableList<NumberLotteryEntityView> observableList = FXCollections.observableArrayList();

        ProcessController processController = new ProcessController();
        ArrayList<NumberLottery> result = processController.getAllNumbers();



        for (NumberLottery numero :
                result) {
            observableList.add(new NumberLotteryEntityView(numero));
        }


        tableNumbersTab2.setItems(observableList);
        dateColumnTab2.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("date"));

        morningNumberColumnTab2.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("numberMorning"));
        morningNumberColumnTab2.setCellFactory(new Callback<TableColumn<NumberLotteryEntityView, String>, TableCell<NumberLotteryEntityView, String>>() {
            public TableCell<NumberLotteryEntityView, String> call(TableColumn<NumberLotteryEntityView, String> param) {
                return new TableCell<NumberLotteryEntityView, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!isEmpty()) {
                            boolean flag = false;
                            String number = StringUtils.getStringFromArray(item.split("-"));

                            NumberOperation numberOperation = new NumberOperation();
                            for (String list: numberOperation.getPermutedNumber(textFieldNumeroTab2.getText())){
                                if (list.equals(number)){
                                    flag = true;
                                }

                            }


                            if (flag) {
                                this.setStyle("-fx-background-color:cornflowerblue;-fx-font-weight:bold;");
//                                setStyle("-fx-text-fill: blue; -fx-font-weight:bold;");
//                                setTextFill(Color.DARKBLUE);

                            }else {
                                setStyle("");
                            }
                            setText(item);
                        }
                    }
                };
            }
        });


        nightNumberColumnTab2.setCellValueFactory(new PropertyValueFactory<NumberLotteryEntityView, String>("numberNight"));
        nightNumberColumnTab2.setCellFactory(new Callback<TableColumn<NumberLotteryEntityView, String>, TableCell<NumberLotteryEntityView, String>>() {
            public TableCell<NumberLotteryEntityView, String> call(TableColumn<NumberLotteryEntityView, String> param) {
                return new TableCell<NumberLotteryEntityView, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!isEmpty()) {
                            boolean flag = false;
                            String number = StringUtils.getStringFromArray(item.split("-"));
                            NumberOperation numberOperation = new NumberOperation();
                            for (String list: numberOperation.getPermutedNumber(textFieldNumeroTab2.getText())){
                                if (list.equals(number)){
                                    flag = true;
                                }

                            }
                            if (flag) {
                                System.out.println("Entro en flag");
                                this.setStyle("-fx-background-color:cornflowerblue;-fx-font-weight:bold;");
//                                setStyle("-fx-text-fill: blue; -fx-font-weight:bold;");

                            }else {
                                setStyle("");
                            }
                            setText(item);
                        }
                    }
                };
            }
        });



    }
}
