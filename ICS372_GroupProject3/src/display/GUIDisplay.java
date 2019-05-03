package display;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.ThermometerContext;
import buttons.ACButton;
import buttons.FanButton;
import buttons.GUIButton;
import buttons.HeaterButton;
import buttons.SetCurrentRoomTempButton;
import buttons.SetDesiredRoomTempButton;
import buttons.SetOutsideTempButton;
import buttons.NoDeviceButton;



public class GUIDisplay extends Application implements ThermometerDisplay {

	private int currentTemp = 0;
	private GUIButton heaterButton;
	private GUIButton acButton;
	private GUIButton fanButton;
	private GUIButton noDeviceButton;
	private GUIButton setOutsideTempButton;
	private GUIButton setDesiredTempButton;
	private GUIButton setCurrentRoomTempButton;
    private Text temperatureLabel = new Text("Temperature");
    private Text currentTempLabel = new Text("Current Temp 0");
    private Text desiredTempLabel = new Text("Desired Temp 0");
    private Text outsideTempLabel = new Text("Outside Temp 0");
    private Text noDeviceLabel = new Text("No Device is on");
    private TextField tempEntryField = new TextField();
    GridPane userInterfaceGrid = new GridPane();
    private static ThermometerDisplay display;
    private ThermometerContext thermometerContext;
    
    public static ThermometerDisplay getInstance() {
    	return display;
    }
    
    @Override
    public void start(Stage primaryStage) {
    	thermometerContext = ThermometerContext.instance();
    	thermometerContext.setDisplay(this);
    	display = this;
    	heaterButton = new HeaterButton("Heater");
    	acButton = new ACButton("AC");
    	fanButton = new FanButton("Fan");
    	noDeviceButton = new NoDeviceButton("No Device");
    	setOutsideTempButton = new SetOutsideTempButton("Set Outside Temp");
    	setDesiredTempButton = new SetDesiredRoomTempButton("Set Desired Room Temp");
    	setCurrentRoomTempButton = new SetCurrentRoomTempButton("Set Current Room Temp");
    	
    	GridPane pane = new GridPane();
    	pane.setHgap(10);
    	pane.setVgap(10);
    	pane.setPadding(new Insets(10, 10, 10, 10));
    	pane.add(temperatureLabel, 0, 0);
    	pane.add(tempEntryField, 1, 0);
    	pane.add(setCurrentRoomTempButton, 2, 0);
    	pane.add(setOutsideTempButton, 3, 0);
    	pane.add(setDesiredTempButton, 4, 0);
    	pane.add(heaterButton, 0, 1);
    	pane.add(acButton, 1, 1);
    	pane.add(fanButton, 2, 1);
    	pane.add(noDeviceButton, 3, 1);
    	pane.add(currentTempLabel, 0, 2);
    	pane.add(desiredTempLabel, 1, 2);
    	pane.add(outsideTempLabel, 2, 2);
    	pane.add(noDeviceLabel, 3, 2);	
    	
    	Scene scene = new Scene(pane);
    
    	primaryStage.setScene(scene);
		primaryStage.setTitle("Group Project 3");
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
	        public void handle(WindowEvent window) {
				System.exit(0);
			}
	    });
    }
    
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void showCurrentTemp(int value) {
		// TODO Auto-generated method stub
		currentTempLabel.setText("Current Temp " + value);
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

	

}
