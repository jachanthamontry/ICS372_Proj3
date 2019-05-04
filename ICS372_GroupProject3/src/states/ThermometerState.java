package states;

import events.SelectACEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.SelectOffEvent;
import events.TemperatureHitsDesiredTemperatureEvent;
import events.TemperatureLeavesThresholdEvent;
import events.TimerEnds;
import events.TimerTickedEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;
import timer.Timer;


public abstract class ThermometerState{

	protected static int currentTemperatureValue = 0 ; 
	protected static int desiredTemperatureValue = 0;
	protected static int outsideTemperatureValue = 0;
	protected Timer temperatureTimer;
 
    public abstract void enter();

    public abstract void leave();

    public void handleEvent(SelectOffEvent event) {

    }

    public void handleEvent(SelectACEvent event) {

    }

    public void handleEvent(SelectFanEvent event) {

    }
    
    public void handleEvent(SelectHeatEvent event) {

    }

    public void handleEvent(TemperatureHitsDesiredTemperatureEvent event) {

    }

    public void handleEvent(TemperatureLeavesThresholdEvent event) {

    }

    public void handleEvent(TimerEnds event) {

    }
    
    public void handleEvent(TimerTickedEvent event) {

    }
    
    public void handleEvent(SettingCurrentTemperature event) {
    	
    }
    
    public void handleEvent(SettingDesiredTemperature event) {
    	
    }
    
    public void handleEvent(SettingOutsideTemperature event) {
    	
    }
    
}