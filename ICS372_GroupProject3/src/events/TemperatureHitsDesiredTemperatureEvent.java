package events;

public class TemperatureHitsDesiredTemperatureEvent extends ThermometerEvent{
	private static TemperatureHitsDesiredTemperatureEvent instance;
	
	private TemperatureHitsDesiredTemperatureEvent() {
		
	}
	
	public static TemperatureHitsDesiredTemperatureEvent instance() {
		if (instance == null) {
			instance = new TemperatureHitsDesiredTemperatureEvent();
		}
		return instance;
	}
}
