package ru.midoritroop;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

/**
 * RMan - Resource Manager for the whole project.
 * Realized as Singleton Pattern to have only instance of global Manager
 */
public class RMan {

    /**
     * Inner color class serves enum function to use previously declared colors in whole project
     */
    public static final class color {
        public static Color darkCyan = new java.awt.Color(66, 122, 171, 134);
        public static Color lightBlueBtn = new java.awt.Color(162, 226, 245);
        public static Color greyCyan = new java.awt.Color(42, 55, 63);
        public static Color lightPurple = new Color(103, 82, 128);;
        public static Color greyExitButton = new java.awt.Color(81, 90, 101);
        public static Color background = new java.awt.Color(237, 239, 246);
        public static Color textDarkBlue = new java.awt.Color(0x3d74a6);
        public static Color textLilac = new Color(0x6e67a0);
        public static Color btmTopBars = new Color(193, 197, 220);
    }

    private static volatile RMan instance;

    /**
     * Returns one and only instance of RMan
     * @return Only instance of RMan
     */
    public static RMan getInstance() {
        RMan localInstance = instance;
        if (localInstance == null) {
            synchronized (RMan.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RMan();
                }
            }
        }
        return localInstance;
    }

    private final static Logger log = Logger.getLogger(RMan.class.getName());
    private final static String stringsRU = ".\\src\\main\\resources\\strings\\ru.json";

    private static Map<String, Map<String, String>> stringIndex;

    /**
     * Private constructor for Singleton Pattern realization
     */
    private RMan() {}

    /**
     * Initiates import of JSON string file into project. Must be called before any usage of other methods.
     */
    public static void buildStrings() {
        try {
            Gson gson = new Gson();
            JsonReader ruReader = new JsonReader(new FileReader(stringsRU));
            stringIndex = gson.fromJson(ruReader, HashMap.class);
        } catch (FileNotFoundException f) {
            log.log(Level.SEVERE, "File not found %s".formatted(stringsRU));
            exit(404);
        }
    }

    /**
     * Returns string value from JSON file
     * @param category Category name as Class name of desired Frame class
     * @param key Key of desired string in category
     * @return Desired string value
     */
    public static String getString(String category, String key) {
        return stringIndex.get(category).get(key);
    }

    /**
     * Returns path of file in res folder written in JSON file
     * @param key Key of desired file to get path of
     * @return Desired file relative project path
     */
    public static String getPath(String key) {
        return stringIndex.get("paths").get(key);
    }
}
