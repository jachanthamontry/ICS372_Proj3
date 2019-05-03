package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectFanEvent;
import events.TemperatureLeavesThresholdEvent;
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
	public void enter() {
		ThermometerContext.instance().showHeaterIdle();
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
