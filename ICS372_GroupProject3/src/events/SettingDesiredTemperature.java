package events;

public class SettingDesiredTemperature extends ThermometerEvent {
    private static SettingDesiredTemperature instance;

    private SettingDesiredTemperature() {

    }

    public static SettingDesiredTemperature instance() {
        if (instance == null) {
            instance = new SettingDesiredTemperature();
        }
        return instance;
    }
}