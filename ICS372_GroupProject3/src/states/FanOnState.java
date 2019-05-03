package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectHeatEvent;
import events.TimerEnds;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class FanOnState extends ThermometerState {
	private static FanOnState instance;
	
	private FanOnState() {
	}
	

    public static FanOnState instance() {
        if (instance == null) {
            instance = new FanOnState();
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
        ThermometerContext.instance().changeState(FanIdleState.instance());
    }


	@Override
	public void enter() {
		ThermometerContext.instance().showFanOn();
		
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
