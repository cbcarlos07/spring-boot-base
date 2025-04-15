package br.com.britosoftware.exemplo_base.core.commom.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.MissingResourceException;

import br.com.britosoftware.exemplo_base.core.commom.Util;
import br.com.britosoftware.exemplo_base.core.commom.util.PropertiesUtil.PropertieSolver;
public final class ExemploBundle {
    private static final Collection<PropertieSolver> _SOLVERS = new ArrayList<>();
    private static final PropertieSolver _MESSAGE = PropertiesUtil.load( "bundles/message" );
    private static final PropertieSolver _SISTEMA = PropertiesUtil.load( "bundles/system-msg" );

    static{
        _SOLVERS.add( _MESSAGE );
        _SOLVERS.add( _SISTEMA );
    }

    private ExemploBundle(){}

    public static String getMsgOrKey(PropertieSolver propSolver, String key, Object... params ){
        String msg;
        try{
            msg = propSolver.get( key, params );
            if( Util.isNullOrEmpty( msg ) ){
                msg = key;
            }
        }catch (MissingResourceException e){
            msg = key;
        }
        return msg;
    }

    public static String findMessage(String key, Object... params) {
        String msg = "";
        for(PropertieSolver propSolver: _SOLVERS){
            msg = getMsgOrKey(propSolver, key, params );
            if( !msg.equals(key) ){
                break;
            }
        }
        return msg;
    }

    public static String system( String key, Object... params ){
        return getMsgOrKey( _SISTEMA, key, params );
    }
}
