package timer;

import events.TimerEnds;


/**
 * An entity that can be notified of timing events
 * 
 * @author 
 *
 */
public interface Notifiable {
   
    /**
     * Process timer runs out event
     */
    public void handleEvent(TimerEnds event);
}
