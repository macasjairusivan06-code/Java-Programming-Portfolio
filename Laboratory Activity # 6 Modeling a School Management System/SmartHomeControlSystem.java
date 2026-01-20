// =================== PARENT CLASS ======================
class Device {
    private boolean isOn;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void showStatus() {
        System.out.println("Device is " + (isOn ? "ON" : "OFF"));
    }

    // =================== STATIC DEVICE FUNCTIONS ======================

    // Requirement 4b: Turn all devices ON/OFF (static, device-level)
    public static void modifyDevices(Device[] list, boolean turnOn) {
        for (Device d : list) {
            if (turnOn) d.turnOn();
            else d.turnOff();
            d.showStatus(); // still polymorphic
        }
        System.out.println();
    }

    // Requirement 4c: Count devices currently ON (static, device-level)
    public static int countDevicesOn(Device[] list) {
        int count = 0;
        for (Device d : list) {
            if (d.isOn()) count++;
        }
        return count;
    }
}

// =================== AIR CONDITIONER ======================
class AirConditioner extends Device {
    private int fanSpeed;
    private int temperature;

    public AirConditioner(int fanSpeed, int temperature) {
        this.fanSpeed = fanSpeed;
        this.temperature = temperature;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
        showStatus();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        System.out.println("Aircon is " + (isOn() ? "ON" : "OFF") +
                " | Fan Speed: " + fanSpeed + " | Temp: " + temperature);
    }
}

// =================== LAMPSHADE ======================
class LampShade extends Device {
    private int brightness;
    private String lightColor;

    public LampShade(int brightness, String lightColor) {
        this.brightness = brightness;
        this.lightColor = lightColor;
    }

    // copy constructor
    public LampShade(LampShade other) {
        this.brightness = other.brightness;
        this.lightColor = other.lightColor;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        showStatus();
    }

    public void setLightColor(String color) {
        this.lightColor = color;
        showStatus();
    }

    @Override
    public void showStatus() {
        System.out.println("Lampshade is " + (isOn() ? "ON" : "OFF") +
                " | Brightness: " + brightness + "% | Color: " + lightColor);
    }
}

// =================== TELEVISION ======================
class Television extends Device {
    private int channel;
    private int volume;

    public Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        showStatus();
    }

    public void setVolume(int volume) {
        this.volume = volume;
        showStatus();
    }

    @Override
    public void showStatus() {
        System.out.println("TV is " + (isOn() ? "ON" : "OFF") +
                " | Channel: " + channel + " | Volume: " + volume + "%");
    }
}

// =================== MICROWAVE ======================
class Microwave extends Device {
    private int timer = 0;        // DEFAULT VALUES PER REQUIREMENT
    private int temperature = 0;  // DEFAULT VALUES

    public Microwave() {
        // Default constructor required by instructions
    }

    public void setTimer(int timer) {
        this.timer = timer;
        showStatus();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        showStatus();
    }

    @Override
    public void showStatus() {
        System.out.println("Microwave is " + (isOn() ? "ON" : "OFF") +
                " | Timer: " + timer + "s | Temp: " + temperature);
    }
}

// =================== MAIN PROGRAM ======================
public class SmartHomeControlSystem {
    public static void main(String[] args) {

        // Requirement 4a instances
        AirConditioner ac = new AirConditioner(3, 24);
        LampShade lamp1 = new LampShade(100, "Yellow");
        LampShade lamp2 = new LampShade(lamp1); // copy constructor
        Television tv = new Television(1, 10);
        Microwave mw = new Microwave();

        Device[] devices = { ac, lamp1, lamp2, tv, mw };

        Device.modifyDevices(devices, true);   // turn all ON
        Device.modifyDevices(devices, false);  // turn all OFF

        System.out.println("Devices ON: " + Device.countDevicesOn(devices));
    }
}
