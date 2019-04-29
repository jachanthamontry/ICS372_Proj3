package display;

public class Thermometer implements ThermometerDisplay{
	public enum States{HEATER_ON_STATE, AC_ON_STATE, FAN_ON_STATE, NO_DEVICE_STATE};
	private int tempEntry, currentTemp, outsideTemp, desiredtemp;
	private States currentState;
	private static Thermometer instance;
	private ThermometerDisplay display;
	
	public Thermometer () {
		
	}
	
	@Override
	public void showCurrentTemp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showDesiredTemp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showOutsideTemp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showDevice() {
		// TODO Auto-generated method stub
		
	}
}
