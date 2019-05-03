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
        ThermometerContext.instance().changeState(SelectACEvent.instance());
    }

    /**
     * handle cook request
     * 
     */

    @Override
    public void handleEvent(SelectHeatEvent event) {
        ThermometerContext.instance().changeState(SelectHeatEvent.instance());
    }
    
    @Override
    public void handleEvent(SelectFanEvent event) {
        ThermometerContext.instance().changeState(SelectFanEvent.instance());
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
