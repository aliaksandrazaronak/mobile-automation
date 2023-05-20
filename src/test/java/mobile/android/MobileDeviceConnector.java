package mobile.android;

import business_objects.MobileDevice;
import org.junit.jupiter.api.extension.Extension;
import utils.ShellCommandsUtils;

import java.util.ArrayList;
import java.util.List;

public class MobileDeviceConnector implements Extension {

    private static final int APPIUM_UIAUTOMATOR_SYSTEM_PORT = 8205;
    private static final String ANDROID_PLATFORM_NAME = "Android";

    private List<String> getListOfConnectedAndroidDevices() {
        return ShellCommandsUtils.execCmd("adb devices");
    }

    public List<MobileDevice> getListOfConnectedAndroidMobileDevices() {
        List<MobileDevice> mobileDeviceList = new ArrayList<>();
        List<String> connectedAndroidDevicesList = getListOfConnectedAndroidDevices();
        int increment = 0;
        for (String device: connectedAndroidDevicesList) {
            MobileDevice mobileDevice = MobileDevice.builder()
                    .udid(device)
                    .platformName(ANDROID_PLATFORM_NAME)
                    .systemPort(APPIUM_UIAUTOMATOR_SYSTEM_PORT + increment)
                    .build();
            mobileDeviceList.add(mobileDevice);
            increment++;
        }
        return mobileDeviceList;
    }
}
