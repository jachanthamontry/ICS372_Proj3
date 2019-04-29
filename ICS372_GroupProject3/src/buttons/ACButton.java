package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.ThermometerContext;

public class ACButton extends GUIButton implements EventHandler<ActionEvent>{

	public ACButton(String string){
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		ThermometerContext.instance().handleEvent();
	}
}
