package states;

import events.SelectACEvent;
import events.SelectHeatEvent;
import events.SelectFanEvent;
import events.SettingCurrentTemperature;
import events.SettingDesiredTemperature;
import events.SettingOutsideTemperature;

public class OffState extends ThermometerState {
	private static OffState instance;
	private int temperatureValue;
	
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
    public void handleEvent(SettingCurrentTemperature event) {
    	
    	temperatureValue = Integer.parseInt(ThermometerContext.instance().getEntryField());
    	ThermometerContext.instance().showCurrentTemp(temperatureValue);
    }
    @Override
    public void handleEvent(SettingDesiredTemperature event) {
        ThermometerContext.instance().changeState(HeaterIdleState.instance());
    }
    
    @Override
    public void handleEvent(SettingOutsideTemperature event) {
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
