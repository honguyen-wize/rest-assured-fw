package common;

import java.util.ResourceBundle;

public class Utils {

    private static ResourceBundle bundle = ResourceBundle.getBundle("global");

    public static String getGlobalVariable(String key){
        return bundle.getString(key);
    }
}
