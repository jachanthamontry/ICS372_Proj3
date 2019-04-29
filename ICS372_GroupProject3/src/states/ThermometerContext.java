package states;

import display.ThermometerDisplay;

public class ThermometerContext {
	private ThermometerDisplay display;
	//private State thign currentState;
	private static ThermometerContext instance;
	
	
	 /**
     * Make it a singleton
     */
    private ThermometerContext() {
        instance = this;
        //currentState = DoorClosedState.instance();
    }
    
    /**
     * Return the instance
     * 
     * @return the object
     */
    public static ThermometerContext instance() {
        if (instance == null) {
            instance = new ThermometerContext();
        }
        return instance;
    }
    
    /**
     * The display could change. So we have to get its refrence.
     * 
     * @param display
     *            The current display object
     */
    public void setDisplay(ThermometerDisplay display) {
        this.display = display;
    }
}
