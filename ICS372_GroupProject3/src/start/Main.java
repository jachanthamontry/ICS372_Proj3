package start;
	
import display.GUIDisplay;
import display.ThermometerDisplay;
import states.ThermometerContext;
import timer.Clock;
import javafx.application.Application;

public class Main {
	 public static void main(String[] args) {
	        Clock.instance();
	        new Thread() {
	            @Override
	            public void run() {
	                Application.launch(GUIDisplay.class, null);
	            }
	        }.start();
	        try {
	            while (GUIDisplay.getInstance() == null) {
	                Thread.sleep(1000);
	            }
	        } catch (InterruptedException ie) {
	        }
	        ThermometerDisplay display = GUIDisplay.getInstance();
	        ThermometerContext.instance().setDisplay(display);
	    }
}
