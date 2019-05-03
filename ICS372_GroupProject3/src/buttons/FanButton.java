package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class FanButton extends GUIButton implements EventHandler<ActionEvent>{

	public FanButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		//ThermometerContext.instance().handleEvent();
		System.out.println("moo");
	}
}
