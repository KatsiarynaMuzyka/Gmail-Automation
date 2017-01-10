package by.epam.gmail.automation.property;

import java.util.ResourceBundle;


public class PropertyProvider {

        private static final String USER = "user";
        private static final ResourceBundle bundle = ResourceBundle.getBundle(USER);

        public static String getProperty(String propertyName) {
            return bundle.getString(propertyName);
        }
}