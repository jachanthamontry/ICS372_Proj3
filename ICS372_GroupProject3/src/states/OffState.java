package states;

import events.SelectACEvent;
import events.SelectHeatEvent;
import events.SelectFanEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class OffState extends ThermometerState implements Notifiable{
	private static OffState instance;
	private Timer timer;
	
	private OffState() {
	}
	

    public static OffState instance() {
        if (instance == null) {
            instance = new OffState();
            
        }
        
        return instance;
    }

    @Override
    public void handleEvent(SelectACEvent event) {
        ThermometerContext.instance().changeState(ACIdleState.instance());
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
        ThermometerContext.instance().showOutsideTemp(super.outsideTemperatureValue);
		System.out.println("offstate temp: " + outsideTemperatureValue);
        
    }
    
    public void handleEvent(TimerTickedEvent event) {
    	
    	if(currentTemperatureValue < outsideTemperatureValue) {
    		currentTemperatureValue = ThermometerContext.instance().temperatureIncrease(currentTemperatureValue, outsideTemperatureValue);
    	}
    	if(currentTemperatureValue > outsideTemperatureValue) {
    		currentTemperatureValue = ThermometerContext.instance().temperatureDecrease(currentTemperatureValue, outsideTemperatureValue);
    	}
    	ThermometerContext.instance().showCurrentTemp(currentTemperatureValue);
 
    }
	
	@Override
	public void enter() {
		
		System.out.println("get time: " + timer.getTimeValue());
		ThermometerContext.instance().showNoDevice();

	}

	@Override
	public void leave() {
		
		
	}

}
