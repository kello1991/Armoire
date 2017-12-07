package sample.ExamsDate;

import Dao.ExamenDao;
import Entity.Examen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.joda.time.Interval;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class ExamsDateController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridpane;

    private final ExamenDao examenDao = new ExamenDao();

    @FXML
    private DatePicker datePiker ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //initial fill data
        fillData(examenDao.getExams());
        datePiker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                fillData(examenDao.getExamsByDate(Date.valueOf( t1 )));

            }
        });

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
        //salle
        grid.add(new Label("Heure Examen"), 0, 3);
        grid.add(new Label(e.getDateHeur().toString()), 1, 3);
        grid.add(b, 1, 4);



        grid.setStyle("-fx-background-color: "+getColorItem(e));


        //Button

        return grid;

    }

    private void fillData(List<Examen> examenList){

        gridpane.setVgap(170);
        gridpane.setHgap(5);
        gridpane.setPadding(new Insets(80,0,0,0));
        gridpane.getChildren().clear();

        int cols=3, colCnt = 0, rowCnt = 0;
        for (int i=0; i<examenList.size(); i++) {
                if (!examenList.get(i).getIdTag().equals("")){
                gridpane.add(getItem(examenList.get(i)), colCnt, rowCnt);
                colCnt++;
                if (colCnt>cols) {
                    rowCnt++;
                    colCnt=0;
                }
                }
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
        //date
        grid.add(new Label("Date Examen"), 0, 4);
        grid.add(new Label(e.getDateHeur().toString()), 1, 4);
        dialog.getDialogPane().setContent(grid);

      return dialog;
    }

    @FXML
    public void clear(ActionEvent event) throws Exception{

        fillData(examenDao.getExams());
    }


    private long getDateLong(Date d , String s, long du){
        String numberOnly= s.replaceAll("[^0-9]", "");
        int hours =Integer.parseInt(numberOnly.charAt(0)+""+numberOnly.charAt(1));
        int minutes =Integer.parseInt(numberOnly.charAt(2)+""+numberOnly.charAt(3));


        return d.getTime()+((hours*60)+minutes+du)*60000;
    }

    private String getColorItem (Examen e){
        Interval interval;
        Date now = new Date(System.currentTimeMillis());
        if (getDateLong(e.getDateHeur(),e.getHeure(),e.getDuree()) < now.getTime()  ) {
            System.out.println("Before");
            interval = new Interval(getDateLong(e.getDateHeur(),e.getHeure(),0),now.getTime() );
            return "#336699";//blue
        }
        else {if (getDateLong(e.getDateHeur(),e.getHeure(),0) < now.getTime()   ) {
            return "#F78F1E"; //orange

        }}


        return "#7ABA7A"; //vert




    }



}
