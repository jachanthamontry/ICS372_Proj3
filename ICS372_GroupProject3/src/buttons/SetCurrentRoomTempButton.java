package buttons;

import events.SettingCurrentTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class SetCurrentRoomTempButton extends GUIButton implements EventHandler<ActionEvent>{

	public SetCurrentRoomTempButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent(SettingCurrentTemperature.instance());
	}
}
