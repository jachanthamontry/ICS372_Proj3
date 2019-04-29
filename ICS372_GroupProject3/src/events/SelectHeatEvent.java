package events;

public class SelectHeatEvent extends ThermometerEvent{
	private static SelectHeatEvent instance;
	
	private SelectHeatEvent() {
		
	}
	
	public static SelectHeatEvent instance() {
		if (instance == null) {
			instance = new SelectHeatEvent();
		}
		return instance;
	}
}
