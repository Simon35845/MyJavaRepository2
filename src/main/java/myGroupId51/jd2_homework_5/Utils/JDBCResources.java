package myGroupId51.jd2_homework_5.Utils;

import java.util.ResourceBundle;

public class JDBCResources {
    private static final String DATABASE_RESOURCE = "database";
    private static final String URL_KEY = "url";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(DATABASE_RESOURCE);
    private static final String URL = getValue(URL_KEY);
    private static final String USER = getValue(USER_KEY);
    private static final String PASSWORD = getValue(PASSWORD_KEY);

    private static String getValue(String key) {
        return resourceBundle.getString(key);
    }

    public static String getURL() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
