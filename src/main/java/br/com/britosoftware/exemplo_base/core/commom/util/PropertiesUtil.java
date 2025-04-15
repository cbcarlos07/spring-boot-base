package br.com.britosoftware.exemplo_base.core.commom.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PropertiesUtil {
    public PropertiesUtil(){}

    public static PropertieSolver load(String propFileName){
        return new PropertieSolver(ResourceBundle.getBundle( propFileName ));
    }

    public static final class PropertieSolver {
        private ResourceBundle bundle;

        public PropertieSolver(){}

        private PropertieSolver(ResourceBundle bundle){
            this.bundle = bundle;
        }

        public String get(String key, Object... params){
            return MessageFormat.format( bundle.getString( key ), params );
        }
    }
}
