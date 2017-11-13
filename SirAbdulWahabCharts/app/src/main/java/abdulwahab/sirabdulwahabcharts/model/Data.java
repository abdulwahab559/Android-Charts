package abdulwahab.sirabdulwahabcharts.model;

/**
 * Created by LENOVO on 11/12/2017.
 */

public class Data {

    private String id;
    private int temperature;
    private int deviceId;
    private String sensorDate;

    public Data() {
        id = "";
        temperature = 0;
        deviceId = 0;
        sensorDate = "";
    }

    public Data(String id, int temperature, int deviceId, String sensorDate) {
        this.id = id;
        this.temperature = temperature;
        this.deviceId = deviceId;
        this.sensorDate = sensorDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getSensorDate() {
        return sensorDate;
    }

    public void setSensorDate(String sensorDate) {
        this.sensorDate = sensorDate;
    }
}
