package states;

import events.SelectOffEvent;
import events.SelectACEvent;
import events.SelectHeatEvent;
import events.TimerEnds;

public class FanIdleState extends ThermometerState {
	private static FanIdleState instance;
	
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
    
	@Override
	public void enter() {
		ThermometerContext.instance().showFanIdle();
		
	}


	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}


}
