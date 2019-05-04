package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectFanEvent;
import events.TemperatureLeavesThresholdEvent;
import events.TimerTickedEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class HeaterIdleState extends ThermometerState {
	private static HeaterIdleState instance;
	
	private HeaterIdleState() {
	}
	

    public static HeaterIdleState instance() {
        if (instance == null) {
            instance = new HeaterIdleState();
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
    public void handleEvent(TemperatureLeavesThresholdEvent event) {
        ThermometerContext.instance().changeState(HeaterOnState.instance());
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
    	
    	if(currentTemperatureValue < outsideTemperatureValue) {
    		if(currentTemperatureValue <= desiredTemperatureValue - 3) {
    			ThermometerContext.instance().changeState(HeaterOnState.instance());
        	}
    		currentTemperatureValue = ThermometerContext.instance().temperatureIncrease(currentTemperatureValue, outsideTemperatureValue);
    	}
    	
    	if(currentTemperatureValue > outsideTemperatureValue) {
    		if(currentTemperatureValue <= desiredTemperatureValue - 3) {
    			ThermometerContext.instance().changeState(HeaterOnState.instance());
        	}
    		currentTemperatureValue = ThermometerContext.instance().temperatureDecrease(currentTemperatureValue, outsideTemperatureValue);
    	}
    	
  	
    	System.out.println("current: " + currentTemperatureValue);
		System.out.println("outside: " + outsideTemperatureValue);
		System.out.println("desired: " + desiredTemperatureValue);	
    	
    	ThermometerContext.instance().showCurrentTemp(currentTemperatureValue);
    }
	
	@Override
	public void enter() {
		ThermometerContext.instance().showHeaterIdle();
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
