package br.com.britosoftware.exemplo_base.core.commom;

public class Util {

    public static boolean isNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String str){
        return str != null || !str.isEmpty();
    }

    public static boolean isNullOrEmpty(Object obj){
        return obj == null;
    }

}
