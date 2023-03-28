package ru.midoritroop;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

import static java.lang.System.exit;

public class RMan {

    public static final class color {
        public static java.awt.Color darkCyan = new java.awt.Color(66, 122, 171, 134);
        public static java.awt.Color lightBlueBtn = new java.awt.Color(162, 226, 245);
        public static java.awt.Color greyCyan = new java.awt.Color(42, 55, 63);
        public static java.awt.Color greyExitButton = new java.awt.Color(81, 90, 101);
        public static java.awt.Color background = new java.awt.Color(234, 255, 255);
        public static java.awt.Color textColor = new java.awt.Color(0x3d74a6);
        public static java.awt.Color btmTopBars = new java.awt.Color(197, 230, 236);
    }

    private static volatile RMan instance;

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

    private RMan() {}

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

    public static String getString(String category, String key) {
        return stringIndex.get(category).get(key);
    }

    public static String getPath(String key) {
        return stringIndex.get("paths").get(key);
    }
}
