package br.com.britosoftware.exemplo_base.core.commom;

import java.util.Collection;

public class Util {

    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String str){
        return str != null || !str.isEmpty();
    }

    public static boolean isNullOrEmpty(Object obj){
        return obj == null;
    }

    public  static boolean isNotNullOrEmpty(Collection<?> collection){
        return !isNullOrEmpty(collection);
    }


}
