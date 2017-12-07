package sample.Exams;

import Dao.ExamenDao;
import Entity.Examen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Callback;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExamsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridpane;

    ExamenDao examenDao = new ExamenDao();




    @FXML
    private ComboBox<Examen> classCombo;

    @FXML
    private ComboBox<Examen> moduleCombo;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        gridpane.setVgap(120);
        gridpane.setHgap(5);
        gridpane.setPadding(new Insets(60,0,0,0));



        fillData();
        fillComboClass();
        fillComboModule();

        classCombo.getSelectionModel().selectedIndexProperty().addListener(observable -> System.out.println( classCombo.getSelectionModel().getSelectedItem()));
        moduleCombo.getSelectionModel().selectedItemProperty().addListener(observable -> System.out.println( moduleCombo.getSelectionModel().getSelectedItem()));

    }



    private GridPane getItem(Examen e){

        Button b = new Button("Details");
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    createDialog(e).showAndWait();
                }
            });


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        //class
        grid.add(new Label("Class :"), 0, 0);
        grid.add(new Label(e.getClasss()), 1, 0);
        //module
        grid.add(new Label("Module :"), 0, 1);
        grid.add(new Label(e.getModule()), 1, 1);
        //salle
        grid.add(new Label("Salle"), 0, 2);
        grid.add(new Label(e.getSalle()), 1, 2);
        //Responsable
        grid.add(new Label("Responsable"), 0, 3);
        grid.add(new Label(e.getResponsable()), 1, 3);
        //Button
        grid.add(b, 1, 4);
        if (e.getIdTag().equals("")){
            grid.setStyle("-fx-background-color: #ff8566;");
        }else {
            grid.setStyle("-fx-background-color: #48643e;");

        }

        return grid;

    }

    private void fillData(){

        List<Examen> examenList =examenDao.getExams();

        int cols=3, colCnt = 0, rowCnt = 0;
        for (int i=0; i<examenList.size(); i++) {

                gridpane.add(getItem(examenList.get(i)), colCnt, rowCnt);
                colCnt++;
                if (colCnt>cols) {
                    rowCnt++;
                    colCnt=0;
                }

            System.out.println(colCnt+"         "+rowCnt);
        }
    }


    private Dialog<Examen> createDialog(Examen e){
        // Create the custom dialog.
        Dialog<Examen> dialog = new Dialog<>();
        dialog.setTitle("Details Examen");
        dialog.setHeaderText(e.getClasss());

        ButtonType loginButtonType = new ButtonType("Valider", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        //class
        grid.add(new Label("Class :"), 0, 0);
        grid.add(new Label(e.getClasss()), 1, 0);
        //module
        grid.add(new Label("Module :"), 0, 1);
        grid.add(new Label(e.getModule()), 1, 1);
        //salle
        grid.add(new Label("Salle"), 0, 2);
        grid.add(new Label(e.getSalle()), 1, 2);
        //Responsable
        grid.add(new Label("Responsable"), 0, 3);
        grid.add(new Label(e.getResponsable()), 1, 3);
        dialog.getDialogPane().setContent(grid);

      return dialog;
    }



    private void fillComboClass(){

        classCombo.getItems().setAll(examenDao.getExams());
        classCombo.setButtonCell(new ExamenClassListCell());

        classCombo.setCellFactory(new Callback<ListView<Examen>, ListCell<Examen>>() {

            @Override
            public ListCell<Examen> call(ListView<Examen> listView) {
                return new ExamenClassListCell();
            }
        });
    }

    private void fillComboModule(){

        moduleCombo.getItems().setAll(examenDao.getExams());
        moduleCombo.setButtonCell(new ExaamenModuleListCell());
        moduleCombo.setCellFactory(new Callback<ListView<Examen>, ListCell<Examen>>() {

            @Override
            public ListCell<Examen> call(ListView<Examen> listView) {
                return new ExaamenModuleListCell();
            }
        });
    }





}


class ExamenClassListCell extends ListCell<Examen> {

    @Override
    protected void updateItem(Examen item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (!empty && item != null) {
            final String text = String.format("%s", item.getClasss());
            setText(text);
        }
    }


}

class ExaamenModuleListCell extends ListCell<Examen> {

    @Override
    protected void updateItem(Examen item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (!empty && item != null) {
            final String text = String.format("%s", item.getModule());
            setText(text);
        }
    }
}