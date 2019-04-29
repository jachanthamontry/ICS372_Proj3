package events;

public class SelectFanEvent extends ThermometerEvent{
	private static SelectFanEvent instance;
	
	private SelectFanEvent() {
		
	}
	
	public static SelectFanEvent instance() {
		if (instance == null) {
			instance = new SelectFanEvent();
		}
		return instance;
	}
}
