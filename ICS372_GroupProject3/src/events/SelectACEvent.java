package events;

public class SelectACEvent extends ThermometerEvent {
    private static SelectACEvent instance;

    private SelectACEvent() {

    }

    public static SelectACEvent instance() {
        if (instance == null) {
            instance = new SelectACEvent();
        }
        return instance;
    }
}