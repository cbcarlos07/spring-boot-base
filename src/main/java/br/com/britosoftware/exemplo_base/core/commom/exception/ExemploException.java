package br.com.britosoftware.exemplo_base.core.commom.exception;

import br.com.britosoftware.exemplo_base.core.commom.util.ExemploBundle;

public class ExemploException extends Exception{
    public ExemploException(String msg){
        super(ExemploBundle.findMessage( msg ));
    }

    public ExemploException(String msg, Object... params){
        super(ExemploBundle.findMessage( msg, params ));
    }

    public ExemploException(Throwable e, String msg){
        super(ExemploBundle.findMessage( msg ), e );
    }

    public ExemploException(Throwable e, String msg, Object... params){
        super(ExemploBundle.findMessage( msg, params ), e );
    }

    public ExemploException(String msg, Throwable e){
        super( msg, e );
    }

    public ExemploException(Throwable e){
        super( e );
    }


}
