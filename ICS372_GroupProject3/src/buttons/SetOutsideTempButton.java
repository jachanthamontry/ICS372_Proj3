package buttons;

import events.SettingOutsideTemperature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class SetOutsideTempButton extends GUIButton implements EventHandler<ActionEvent>{

	public SetOutsideTempButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent(SettingOutsideTemperature.instance());
	}
}
