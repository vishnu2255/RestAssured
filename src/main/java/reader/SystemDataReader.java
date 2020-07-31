package reader;

/**
 * Class to read System environment variables and Properties
 */
public class SystemDataReader {

    private static final String envPropertyName = "test_env";
    private static final String baseUrlPropertyName = "test_baseURL";

    /**
     * Method to retrieve System properties corresponding to the key.
     */
    public static String getTestDataFromSystem(String key) {
//        String value;
//        value = System.getenv(key);
//        return (HelperUtils.isUsable(value)) ? value : System.getProperty(key);
        return null;
    }

    public static String getEnvName() {
        return getTestDataFromSystem(envPropertyName);
    }

    public static String getBaseUrl() {
        return getTestDataFromSystem(baseUrlPropertyName);
    }
}

