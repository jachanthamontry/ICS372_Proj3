package buttons;

import events.SettingDesiredTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class SetDesiredRoomTempButton extends GUIButton implements EventHandler<ActionEvent>{

	public SetDesiredRoomTempButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent(SettingDesiredTemperature.instance());
	}
}
