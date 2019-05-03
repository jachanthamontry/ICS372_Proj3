package events;

public class SelectOffEvent extends ThermometerEvent{
	private static SelectOffEvent instance;
	
	private SelectOffEvent() {
		
	}
	
	public static SelectOffEvent instance() {
		if (instance == null) {
			instance = new SelectOffEvent();
		}
		return instance;
	}
}
