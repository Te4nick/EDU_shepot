package ru.midoritroop;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ResourceManager {

    public static final class Color {
        public static java.awt.Color darkCyan = new java.awt.Color(66, 122, 171, 134);
        public static java.awt.Color lightBlueBtn = new java.awt.Color(162, 226, 245);
        public static java.awt.Color greyCyan = new java.awt.Color(42, 55, 63);
        public static java.awt.Color greyExitButton = new java.awt.Color(81, 90, 101);
        public static java.awt.Color background = new java.awt.Color(234, 255, 255);
        public static java.awt.Color textColor = new java.awt.Color(0x3d74a6);
        public static java.awt.Color btmTopBars = new java.awt.Color(197, 230, 236);
    }

    private static volatile ResourceManager instance;

    public static ResourceManager getInstance() {
        ResourceManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ResourceManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ResourceManager();
                }
            }
        }
        return localInstance;
    }


    private final static Logger log = Logger.getLogger(ResourceManager.class.getName());
    private final static String stringsPath = ".\\src\\main\\resources\\strings.properties";
    private final static String resourcesPath = ".\\src\\main\\resources\\resources_paths.properties";
    private final static Properties strings = new Properties();
    private final static Properties resources = new Properties();

    private ResourceManager() {}

    public static String string(String string) {
        if (strings.isEmpty()) try {
            strings.load(new FileInputStream(stringsPath));
        } catch (IOException e) {
            log.log(Level.SEVERE, stringsPath + " not found");
            System.exit(1);
        }
        return strings.getProperty(string);
    }

    public static void buildStrings() {
        resources.putAll(Map.of(
                "mainMenuDesc", "<html>Автоматизированный комплекс<br>для проведения акустических<br>и виброакустических измерений<br>''ШЕПОТ''</html>",
                "review", "Обзор"));
    }

    public static String path(String string) {

        if (resources.isEmpty()) try {
            resources.load(new FileInputStream(resourcesPath));
        } catch (IOException e) {
            log.log(Level.SEVERE, resourcesPath + " not found");
            System.exit(1);
        }
        return resources.getProperty(string);
    }
}
