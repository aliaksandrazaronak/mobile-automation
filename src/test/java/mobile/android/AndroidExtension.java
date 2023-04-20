package mobile.android;

import business_objects.MobileDevice;
import org.junit.jupiter.api.extension.Extension;
import utils.ShellCommandsUtils;

import java.util.ArrayList;
import java.util.List;

public class AndroidExtension implements Extension {

    private static final int APPIUM_UIAUTOMATOR_SYSTEM_PORT = 8205;

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
                    .systemPort(APPIUM_UIAUTOMATOR_SYSTEM_PORT + increment)
                    .build();
            mobileDeviceList.add(mobileDevice);
            increment++;
        }
        return mobileDeviceList;
    }
}
