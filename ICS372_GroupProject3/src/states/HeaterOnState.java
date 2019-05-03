package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectFanEvent;
import events.TemperatureHitsDesiredTemperatureEvent;

public class HeaterOnState extends ThermometerState {
	private static HeaterOnState instance;
	
	private HeaterOnState() {
	}
	

    public static HeaterOnState instance() {
        if (instance == null) {
            instance = new HeaterOnState();
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
    public void handleEvent(TemperatureHitsDesiredTemperatureEvent event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
    }

	@Override
	public void enter() {
		ThermometerContext.instance().showHeaterOn();
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
