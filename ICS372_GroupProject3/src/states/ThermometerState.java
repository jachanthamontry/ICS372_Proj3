package states;

import events.SelectACEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.SelectOffEvent;
import events.TemperatureHitsDesiredTemperatureEvent;
import events.TemperatureLeavesThresholdEvent;
import events.TimerEnds;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;


public abstract class ThermometerState{

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
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
    
    public void handleEvent(SettingCurrentTemperature event) {
    	
    }
    
    public void handleEvent(SettingDesiredTemperature event) {
    	
    }
    
    public void handleEvent(SettingOutsideTemperature event) {
    	
    }
}