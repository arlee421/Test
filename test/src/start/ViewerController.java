package start;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.MainApp;


public class ViewerController  implements Initializable {
	
	@FXML
    private TableView<ObjectProperty> wordTable;
    @FXML
    private TableColumn<ObjectProperty, String> wordColumn;
    @FXML
    private TableColumn<ObjectProperty, String> meaningColumn;
	@FXML
    private TableView<ObjectProperty> todayWordTable;
    @FXML
    private TableColumn<ObjectProperty, String> todayWordColumn;
    @FXML
    private TableColumn<ObjectProperty, String> todayMeaningColumn;
    @FXML
    private TextField wordField;
    @FXML   
    private TextField meaningField;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
//    @FXML
//    private Button exitButton;
 
    public MainApp mainApp;


//    RandomAction randomAction=new RandomAction();   
//    WordService.process(randomAction);

    @Override
	public void initialize(URL location, ResourceBundle resources) {
         // Initialize the whole word table with the two columns.
         wordColumn.setCellValueFactory(cellData -> cellData.getValue().wordProperty());
         meaningColumn.setCellValueFactory(cellData -> cellData.getValue().meaningProperty());
 
         todayWordColumn.setCellValueFactory(cellData -> cellData.getValue().wordProperty());
          todayMeaningColumn.setCellValueFactory(cellData -> cellData.getValue().meaningProperty()); 
          
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
             @Override
             public void handle(MouseEvent event) {
            	 wordTable.getItems().add(new ObjectProperty(new SimpleStringProperty(wordField.getText()), new SimpleStringProperty(meaningField.getText())));   
            	 wordField.clear();
            	 meaningField.clear();		
        	} });  
        
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
      	  @Override
      	public void handle(ActionEvent events) {
      		 int selectedIndex = wordTable.getSelectionModel().getSelectedIndex();
      		  wordTable.getItems().remove(selectedIndex);
      	  }});   
        
//        exitButton.setOnAction(new EventHandler<ActionEvent>() {
//        	  @Override
//        	public void handle(ActionEvent events) {
//        		  Stage stage = (Stage) exitButton.getScene().getWindow();
//        		  stage.close();
//        	  }}); 
        
    }
	

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        wordTable.setItems(mainApp.getWordData());
        todayWordTable.setItems(mainApp.getTodayWordData());
        
        
    }	

}

     