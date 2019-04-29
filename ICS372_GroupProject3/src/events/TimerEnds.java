package events;

public class TimerEnds extends ThermometerEvent{
	private static TimerEnds instance;
	
	private TimerEnds() {
		
	}
	
	public static TimerEnds instance() {
		if (instance == null) {
			instance = new TimerEnds();
		}
		return instance;
	}
}
