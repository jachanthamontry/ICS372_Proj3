package events;

public class SettingOutsideTemperature extends ThermometerEvent {
    private static SettingOutsideTemperature instance;

    private SettingOutsideTemperature() {

    }

    public static SettingOutsideTemperature instance() {
        if (instance == null) {
            instance = new SettingOutsideTemperature();
        }
        return instance;
    }
}