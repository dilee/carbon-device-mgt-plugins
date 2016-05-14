package org.wso2.carbon.mdm.services.android.omadm.operations.util;

/**
 * OMADM Operation CSPs
 */
public class OperationCodes {

    public static enum Info {
        DEV_ID("./DevInfo/DevId"),
        MANUFACTURER("./DevInfo/Man"),
        DEVICE_MODEL("./DevInfo/Mod"),
        DM_VERSION("./DevInfo/DmV"),
        LANGUAGE("./DevInfo/Lang"),
        IMSI("./DevInfo/Ext/Identity/IMSI"),
        IMEI("./DevInfo/Ext/Identity/IMEI"),
        SOFTWARE_VERSION("./DevDetail/SwV"),
        VENDOR("./DevDetail/OEM"),
        MAC_ADDRESS("./DevDetail/Ext/WLANMACAddress"),
        RESOLUTION("./DevDetail/Ext/Microsoft/Resolution"),
        DEVICE_NAME("./DevDetail/Ext/Microsoft/DeviceName"),
        LOCK_PIN("./Vendor/MSFT/RemoteLock/NewPINValue"),
        LOCK_RESET("./Vendor/MSFT/RemoteLock/LockAndResetPIN"),
        CAMERA("./DevInfo/Ext/Config/AllowCamera"),
        CAMERA_STATUS("./DevInfo/Ext/Config/AllowCamera"),
        LONGITUDE("./DevInfo/Ext/Location/Longitude"),
        LATITUDE("./DevInfo/Ext/Location/Latitude");

        private final String code;

        Info(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

    }

    public static enum Command {
        DEVICE_RING("./Vendor/MSFT/RemoteRing/Ring"),
        DEVICE_LOCK("./Vendor/MSFT/RemoteLock/Lock"),
        WIPE_DATA("./Vendor/MSFT/RemoteWipe/doWipe"),
        DISENROLL("./Vendor/MSFT/DMClient/Unenroll"),
        LOCK_RESET("./Vendor/MSFT/RemoteLock/LockAndResetPIN"),
        CAMERA("./Vendor/MSFT/PolicyManager/My/Camera/AllowCamera"),
        ENCRYPT_STORAGE("./Vendor/MSFT/PolicyManager/My/Security/RequireDeviceEncryption"),
        CAMERA_STATUS("./Vendor/MSFT/PolicyManager/Device/Camera/AllowCamera"),
        ENCRYPT_STORAGE_STATUS("./Vendor/MSFT/PolicyManager/Device/Security/RequireDeviceEncryption"),
        DEVICE_PASSWORD_ENABLE("./Vendor/MSFT/PolicyManager/My/DeviceLock/DevicePasswordEnabled"),
        DEVICE_PASSCODE_DELETE("./Vendor/MSFT/PolicyManager/My/DeviceLock");

        private final String code;

        Command(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

    }

    public static enum Configure {
        WIFI("./Vendor/MSFT/WiFi/Profile/MyNetwork/WlanXml"),
        CAMERA("./DevConfig/Camera"),
        CAMERA_STATUS("./DevConfig/Camera"),
        ENCRYPT_STORAGE("./Vendor/MSFT/PolicyManager/My/Security/RequireDeviceEncryption"),
        ENCRYPT_STORAGE_STATUS("./Vendor/MSFT/PolicyManager/Device/Security/RequireDeviceEncryption"),
        PASSWORD_MAX_FAIL_ATTEMPTS("./Vendor/MSFT/PolicyManager/My/DeviceLock/MaxDevicePasswordFailedAttempts"),
        DEVICE_PASSWORD_ENABLE("./Vendor/MSFT/PolicyManager/My/DeviceLock/DevicePasswordEnabled"),
        SIMPLE_PASSWORD("./Vendor/MSFT/PolicyManager/My/DeviceLock/AllowSimpleDevicePassword"),
        MIN_PASSWORD_LENGTH("./Vendor/MSFT/PolicyManager/My/DeviceLock/MinDevicePasswordLength"),
        Alphanumeric_PASSWORD("./Vendor/MSFT/PolicyManager/My/DeviceLock/AlphanumericDevicePasswordRequired"),
        PASSWORD_EXPIRE("./Vendor/MSFT/PolicyManager/My/DeviceLock/DevicePasswordExpiration"),
        PASSWORD_HISTORY("./Vendor/MSFT/PolicyManager/My/DeviceLock/DevicePasswordHistory"),
        MAX_PASSWORD_INACTIVE_TIME("./Vendor/MSFT/PolicyManager/My/DeviceLock/MaxInactivityTimeDeviceLock"),
        MIN_PASSWORD_COMPLEX_CHARACTERS("./Vendor/MSFT/PolicyManager/My/DeviceLock/MinDevicePasswordComplexCharacters");

        private final String code;

        Configure(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }
}
