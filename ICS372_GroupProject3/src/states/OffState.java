package states;

import events.SelectACEvent;
import events.SelectHeatEvent;
import events.SelectFanEvent;

public class OffState extends ThermometerState {
	private static OffState instance;
	
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
	public void enter() {
		ThermometerContext.instance().showNoDevice();
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

}
