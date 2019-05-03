package buttons;

import events.SelectOffEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class NoDeviceButton extends GUIButton implements EventHandler<ActionEvent>{

	public NoDeviceButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent(SelectOffEvent.instance());
	}
}
