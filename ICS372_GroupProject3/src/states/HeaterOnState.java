package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectFanEvent;
import events.TemperatureHitsDesiredTemperatureEvent;
import events.TimerTickedEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class HeaterOnState extends ThermometerState {
	private static HeaterOnState instance;
	
	private HeaterOnState() {
	}
	

    public static HeaterOnState instance() {
        if (instance == null) {
            instance = new HeaterOnState();
        }
        return instance;
    }

    @Override
    public void handleEvent(SelectOffEvent event) {
        ThermometerContext.instance().changeState(OffState.instance());
    }
    @Override
    public void handleEvent(SelectACEvent event) {
        ThermometerContext.instance().changeState(ACIdleState.instance());
    }

    @Override
    public void handleEvent(SelectFanEvent event) {
        ThermometerContext.instance().changeState(FanIdleState.instance());
    }
    @Override
    public void handleEvent(TemperatureHitsDesiredTemperatureEvent event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
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
    
    public void handleEvent(TimerTickedEvent event) {
    	
    	if(currentTemperatureValue < desiredTemperatureValue) {
    		currentTemperatureValue = ThermometerContext.instance().temperatureIncrease(currentTemperatureValue, desiredTemperatureValue);
    		if(currentTemperatureValue == desiredTemperatureValue ) {
    			ThermometerContext.instance().changeState(HeaterIdleState.instance());
        	}
    	}
    	
    	ThermometerContext.instance().showCurrentTemp(currentTemperatureValue);
    }
	
	@Override
	public void enter() {
		ThermometerContext.instance().showHeaterOn();
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
