package io.testomat.common.pw;

public class Configuration {

    public static String baseUrl = null; // This will be null by default
    public static boolean headless = true;
    public static boolean devTools = false;
    public static boolean isMobile = false;
    public static double defaultTimeout = 4000.0;
    public static double poolingInterval = 0;

    public static double browserToStartTimeout = 40000.0;

    public static String tracesPath = System.getProperty("user.dir") + "/target/pw"; //for gradle /build/pw
    public static boolean saveTraces = true;

    public static String executablePath = null; //System.getProperty("browser_executable_path")

}
