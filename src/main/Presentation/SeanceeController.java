package Presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Seance;
import Service.SeanceService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.JSType;

/**
 * FXML Controller class
 *
 * @author Mnif
 */
public class SeanceeController implements Initializable {
    @FXML
    private TableView<Seance> tableSeance;
    @FXML
    private TableColumn<Seance, String> listFilm;
    @FXML
    private TableColumn<Seance, String> listSalle;
    @FXML
    private TableColumn<Seance, String> listDate;
    private ObservableList<Seance> data;  
 SeanceService seanceService= new SeanceService();
   Seance seance = new Seance();
    @FXML
    private TextField recherchetext;
    @FXML
    private ImageView titre1;
    @FXML
    private ImageView exitbtn;
    @FXML
    private ImageView retourBtn;
    @FXML
    private Button rr;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          data = FXCollections.observableArrayList();
 
     loadDataFromDatabase();
     setsCllTable();
       FilteredList<Seance> FilteredData= new FilteredList<>(data , e-> true);
       recherchetext.setOnKeyReleased(e->{
           recherchetext.textProperty().addListener((ObservableValue, oldValue, newValue)->{
                   FilteredData.setPredicate((Predicate<? super Seance>) seance -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if ((seance.getFilm().toLowerCase().contains(newValue)) ){
                        return true;
                    }
                    else if(seance.getSalle().toLowerCase().contains(lowerCaseFilter)){
                        return true ;
                    }
                   if(JSType.toString(seance.getDate_seance()).toLowerCase().contains(lowerCaseFilter)){
                        return true ;}
                  
                  
                    return false;

           });
       });
           SortedList<Seance> SortedData = new SortedList<>(FilteredData)  ; 
                    SortedData.comparatorProperty().bind(tableSeance.comparatorProperty());
                    tableSeance.setItems(SortedData);
 });
        // TODO
    }    

    private void loadDataFromDatabase() {
          List<Seance> listSeance =seanceService.afficherSeance();
        for(Seance e:listSeance){
            System.out.println(e);
            data.add(e);
        }
           tableSeance.setItems(data);
       
    }

    private void setsCllTable() {
           listFilm.setCellValueFactory(new PropertyValueFactory<>("film"));
       listSalle.setCellValueFactory(new PropertyValueFactory<>("salle"));
       listDate.setCellValueFactory(new PropertyValueFactory<>("date_seance"));
       
    }

    @FXML
    private void exitbtn(MouseEvent event) { 
            Stage stage = (Stage) retourBtn.getScene().getWindow();
           stage.close();
    }

    @FXML
    private void retourBtn(MouseEvent event) throws IOException {
          Pagination p = new Pagination("/fxml/AcceuilCC.fxml");
          ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void rr(ActionEvent event) throws IOException {
         Pagination p = new Pagination("/fxml/AcceuilCC.fxml");
          ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    
}
