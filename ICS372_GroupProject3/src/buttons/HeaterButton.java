package buttons;

import events.SelectHeatEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class HeaterButton extends GUIButton implements EventHandler<ActionEvent>{

	public HeaterButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent(SelectHeatEvent.instance());
	}
}
