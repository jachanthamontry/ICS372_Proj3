package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectHeatEvent;
import events.TimerEnds;
import events.TimerTickedEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;
import timer.Notifiable;
import timer.Timer;

public class FanIdleState extends ThermometerState implements Notifiable{
	private static FanIdleState instance;
	private int fantimer;
	
	private FanIdleState() {
	}
	

    public static FanIdleState instance() {
        if (instance == null) {
            instance = new FanIdleState();
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
    public void handleEvent(SelectHeatEvent event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
    }
    @Override
    public void handleEvent(TimerEnds event) {
        ThermometerContext.instance().changeState(FanOnState.instance());
    }
    
    public void handleEvent(TimerTickedEvent event) {
    	fantimer++;
    	
    	if(fantimer == 10) {
    		 ThermometerContext.instance().changeState(FanOnState.instance());
    	}
    	
    	if(currentTemperatureValue < outsideTemperatureValue) {
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

		ThermometerContext.instance().showFanIdle();
	}

	@Override
	public void leave() {
		fantimer = 0;
	}

}
