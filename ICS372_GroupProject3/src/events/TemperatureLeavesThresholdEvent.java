package events;

public class TemperatureLeavesThresholdEvent extends ThermometerEvent{
	private static TemperatureLeavesThresholdEvent instance;
	
	private TemperatureLeavesThresholdEvent() {
		
	}
	
	public static TemperatureLeavesThresholdEvent instance() {
		if (instance == null) {
			instance = new TemperatureLeavesThresholdEvent();
		}
		return instance;
	}
}
