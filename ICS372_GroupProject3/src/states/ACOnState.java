package states;

import events.SelectOffEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.TemperatureHitsDesiredTemperatureEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class ACOnState extends ThermometerState {
	private static ACOnState instance;
	
	private ACOnState() {
	}
	

    public static ACOnState instance() {
        if (instance == null) {
            instance = new ACOnState();
        }
        return instance;
    }

    @Override
    public void handleEvent(SelectFanEvent event) {
        ThermometerContext.instance().changeState(FanIdleState.instance());
    }
    @Override
    public void handleEvent(SelectHeatEvent event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
    }
    
    @Override
    public void handleEvent(TemperatureHitsDesiredTemperatureEvent event) {
    	if(currentTemperatureValue == desiredTemperatureValue) {
    		ThermometerContext.instance().changeState(ACIdleState.instance());
    	}
    }
    
    @Override
    public void handleEvent(SelectOffEvent event) {
        ThermometerContext.instance().changeState(OffState.instance());
    }

    @Override
    public void handleEvent(SettingCurrentTemperature event) {
    	super.currentTemperatureValue = Integer.parseInt(ThermometerContext.instance().getEntryField());
    	ThermometerContext.instance().showCurrentTemp(currentTemperatureValue);
    }
    @Override
    public void handleEvent(SettingDesiredTemperature event) {
    	super.desiredTemperatureValue = Integer.parseInt(ThermometerContext.instance().getEntryField());
        ThermometerContext.instance().showDesiredTemp(desiredTemperatureValue);
    }

    @Override
    public void handleEvent(SettingOutsideTemperature event) {
    	super.outsideTemperatureValue = Integer.parseInt(ThermometerContext.instance().getEntryField());
        ThermometerContext.instance().showOutsideTemp(outsideTemperatureValue);
    }
	
	@Override
	public void enter() {
		ThermometerContext.instance().showACOn();
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

}
