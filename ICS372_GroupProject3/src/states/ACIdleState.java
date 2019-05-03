package states;

import events.SelectOffEvent;
import events.SelectFanEvent;
import events.SelectHeatEvent;
import events.TemperatureLeavesThresholdEvent;
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

	@Override
	public void enter() {
		ThermometerContext.instance().showACIdle();
		
	}

	@Override
	public void leave() {
		
	}

}
