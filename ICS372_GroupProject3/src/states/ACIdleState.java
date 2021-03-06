package states;

import events.SelectOffEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.TemperatureLeavesThresholdEvent;
import events.TimerTickedEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class ACIdleState extends ThermometerState {
	private static ACIdleState instance;
	private ACIdleState() {
	}
	

    public static ACIdleState instance() {
        if (instance == null) {
            instance = new ACIdleState();
        }
        return instance;
    }

    @Override
    public void handleEvent(SelectOffEvent event) {
        ThermometerContext.instance().changeState(OffState.instance());
    }

    @Override
    public void handleEvent(SelectHeatEvent event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
    }
    
    @Override
    public void handleEvent(SelectFanEvent event) {
        ThermometerContext.instance().changeState(FanIdleState.instance());
    }
    
    @Override
    public void handleEvent(TemperatureLeavesThresholdEvent event) {
    	ThermometerContext.instance().changeState(ACOnState.instance());
    }

    public void handleEvent(TimerTickedEvent event) {
    	if(currentTemperatureValue <= outsideTemperatureValue) {
    		if(currentTemperatureValue >= desiredTemperatureValue + 3) {
    			ThermometerContext.instance().changeState(ACOnState.instance());
        	}
    		
    		currentTemperatureValue = ThermometerContext.instance().temperatureIncrease(currentTemperatureValue, outsideTemperatureValue);
    	}
    	
    	if(currentTemperatureValue > outsideTemperatureValue) {
    		currentTemperatureValue = ThermometerContext.instance().temperatureDecrease(currentTemperatureValue, outsideTemperatureValue);
    	
    	}
    	
    	ThermometerContext.instance().showCurrentTemp(currentTemperatureValue);
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
		ThermometerContext.instance().showACIdle();
	}

	@Override
	public void leave() {
		
	}

}
