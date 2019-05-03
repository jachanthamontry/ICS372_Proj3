package display;

public interface ThermometerDisplay {

	public void showCurrentTemp(int value);
	
	public void showDesiredTemp(int value);
	
	public void showOutsideTemp(int value);
	
	public void showNoDevice();
	
	public void showFanIdle();
	
	public void showFanOn();
	
	public void showACIdle();
	
	public void showACOn();
	
	public void showHeaterIdle();
	
	public void showHeaterOn();
	
	public String getEntryField();
}
	
	
