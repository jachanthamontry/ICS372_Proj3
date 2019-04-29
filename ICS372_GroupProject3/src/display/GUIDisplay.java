package display;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDisplay extends Application implements ThermometerDisplay, EventHandler<ActionEvent> {

	private Button heaterButton = new Button("Heater");
    private Button acButton = new Button("AC");
    private Button fanButton = new Button("Fan");
    private Button noDeviceButton = new Button("No Device");
    private Button setCurrentButton = new Button("Set Current Room Temp");
    private Button setOutsideButton = new Button("Set Outside Temp");
    private Button setDesiredButton = new Button("Set Desired Room Temp");
    private Text temperatureLabel = new Text("Temperature");
    private Text currentTempLabel = new Text("Current Temp ");
    private Text desiredTempLabel = new Text("Desired Temp ");
    private Text outsideTempLabel = new Text("Outside Temp ");
    private Text noDeviceLabel = new Text("No Device is on");
    private TextField tempEntryField = new TextField();
    GridPane userInterfaceGrid = new GridPane();
    
    public static ThermometerDisplay getInstance() {
    	return display;
    }
    
    @Override
    public void start(Stage primaryStage) {
    	userInterfaceGrid.setHgap(10); //horizontal gap in pixels => that's what you are asking for
		userInterfaceGrid.setVgap(10); //vertical gap in pixels
		
		userInterfaceGrid.add(temperatureLabel, 0, 0);
		userInterfaceGrid.add(tempEntryField, 1, 0);
		userInterfaceGrid.add(setCurrentButton, 2, 0);
		userInterfaceGrid.add(setOutsideButton, 3, 0);
		userInterfaceGrid.add(setDesiredButton, 4, 0);
        
        userInterfaceGrid.add(heaterButton, 0, 1);
        userInterfaceGrid.add(acButton, 1, 1);
        userInterfaceGrid.add(fanButton, 2, 1);
        userInterfaceGrid.add(noDeviceButton, 3, 1);
      
        userInterfaceGrid.add(currentTempLabel, 0, 2);
        userInterfaceGrid.add(desiredTempLabel, 1, 2);
        userInterfaceGrid.add(outsideTempLabel, 2, 2);
        userInterfaceGrid.add(noDeviceLabel, 3, 2);
        
		Scene scene = new Scene(userInterfaceGrid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		//this is able to work and does something
		heaterButton.setOnAction(value -> {
			System.out.println("hi im james");
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Group Project 3");
		primaryStage.show();
    }
    
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void showCurrentTemp() {
		// TODO Auto-generated method stub
		
		System.out.println("moo");
	}

	@Override
	public void showDesiredTemp() {
		// TODO Auto-generated method stub
		System.out.println("moo");
	}

	@Override
	public void showOutsideTemp() {
		// TODO Auto-generated method stub
		System.out.println("moo");
	}

	@Override
	public void showDevice() {
		// TODO Auto-generated method stub
		System.out.println("moo");
	}

	
	//haven't foudn out how to use this yet
	@Override
	public void handle(ActionEvent event) {
		
		if(event.getSource().equals(heaterButton)) {
			System.out.println("moo");
			currentTempLabel.setText("blah");
		}
		else {
			System.out.println("baa");
		}
		
		
	/*	public void handle(ActionEvent event){
			if(event.getSource().equals(doorCloser)){
				microwave.doorClosed();
			}else if(event.getSource().equals(doorOpener)){
				microwave.doorOpened(); */
	}

}
