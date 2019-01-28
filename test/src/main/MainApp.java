package main;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import start.ObjectProperty;
import start.ViewerController;

public class MainApp extends Application {

	static WordVO[]unit;
    private Stage primaryStage;
	private AnchorPane rootLayout;
    WordService wordService=new WordService();

    public static ObservableList<ObjectProperty> wordTable = FXCollections.observableArrayList();
    public ObservableList<ObjectProperty> todayWordTable = FXCollections.observableArrayList();
    public MainApp() {
        unit=new WordVO[0];
        
		FileRead fileRead=new FileRead();
	    WordService.process(fileRead); 
	     
	    for (int i=0;i<unit.length;i++) {
	    	wordTable.add(new ObjectProperty(unit[i].getWord(),unit[i].getMeaning()));
    	}
	    
	    int count=5;
	    Random ran=new Random();
	    for (int i=0;i<count;i++) {
	    int r=ran.nextInt(unit.length);
		todayWordTable.add(new ObjectProperty(unit[r].getWord(),unit[r].getMeaning()));
	    } 
    }
    
	public ObservableList<ObjectProperty> getWordData() {
        return wordTable;
    }

	public ObservableList<ObjectProperty> getTodayWordData() {
        return todayWordTable;
    }

    @Override
    public void start(Stage primaryStage)  {
        
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Japanese Words");
  
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/start/Viewer.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            ViewerController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 메인 스테이지를 반환한다.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {

        launch(args);
        
		FileWrite fileWrite=new FileWrite();
	    WordService.process(fileWrite); 
    }
}