package events;

public class SettingCurrentTemperature extends ThermometerEvent {
    private static SettingCurrentTemperature instance;

    private SettingCurrentTemperature() {

    }

    public static SettingCurrentTemperature instance() {
        if (instance == null) {
            instance = new SettingCurrentTemperature();
        }
        return instance;
    }
}