package states;

import display.ThermometerDisplay;
import events.SelectACEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.SelectOffEvent;
import events.TemperatureHitsDesiredTemperatureEvent;
import events.TemperatureLeavesThresholdEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;
import events.TimerEnds;
import events.TimerTickedEvent;
import timer.Timer;
import timer.Notifiable;

public class ThermometerContext implements Notifiable {
	private ThermometerDisplay display;
	private ThermometerState currentState;
	private static ThermometerContext instance;
	private Timer timer;
	
	 /**
     * Make it a singleton
     */
    private ThermometerContext() {
        instance = this;
        currentState = OffState.instance();
        //the average life expectency of a heater is 15 years. 
        timer = new Timer(this,7884000);
    }
    
    /**
     * Return the instance
     * 
     * @return the object
     */
    public static ThermometerContext instance() {
        if (instance == null) {
            instance = new ThermometerContext();
        }
        return instance;
    }
    
    /**
     * The display could change. So we have to get its reference.
     * 
     * @param display
     *            The current display object
     */
    public void setDisplay(ThermometerDisplay display) {
        this.display = display;
    }

    public void initialize() {
        instance.changeState(OffState.instance());
    }
    
    public void changeState(ThermometerState nextState) {
        currentState.leave();
        currentState = nextState;
        currentState.enter();
    }

    public void handleEvent(SelectOffEvent event) {
    	currentState.handleEvent(event);
    }
    
    public void handleEvent(SelectACEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(SelectFanEvent event) {
        currentState.handleEvent(event);
    }

    public void handleEvent(SelectHeatEvent event) {
        currentState.handleEvent(event);
    }

    public void handleEvent(TemperatureHitsDesiredTemperatureEvent event) {
        currentState.handleEvent(event);
    }

    public void handleEvent(TemperatureLeavesThresholdEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(TimerEnds event) {
        currentState.handleEvent(event);
    }

    public void handleEvent(SettingCurrentTemperature event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(SettingDesiredTemperature event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(SettingOutsideTemperature event) {
        currentState.handleEvent(event);
    	
    }
    
	public void handleEvent(TimerTickedEvent event) {
		currentState.handleEvent(event);
		
	}

	public void showCurrentTemp(int value) {
		display.showCurrentTemp(value);
	}
	
	public void showDesiredTemp(int value) {
		display.showDesiredTemp(value);
	}
	
	public void showOutsideTemp(int value) {
		display.showOutsideTemp(value);
	}
	
	public void showNoDevice() {
		display.showNoDevice();
	}
	
	public void showFanIdle() {
		display.showFanIdle();
	}
	
	public void showFanOn() {
		display.showFanOn();
	}
	
	public void showACIdle() {
		display.showACIdle();
	}
	
	public void showACOn() {
		display.showACOn();
	}
	
	public void showHeaterIdle() {
		display.showHeaterIdle();
	}
	
	public void showHeaterOn() {
		display.showHeaterOn();
	}
	public String getEntryField() {
		return display.getEntryField();
	}

	public int temperatureIncrease(int currentTemp, int outsideTemp) {
		if(currentTemp < outsideTemp)
			currentTemp++;
		return currentTemp;
	}

	public int temperatureDecrease(int currentTemp, int outsideTemp) {
		if(currentTemp > outsideTemp)
			currentTemp--;
		return currentTemp;
	}


	
}
