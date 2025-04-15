package br.com.britosoftware.exemplo_base.core.commom.exception;

import br.com.britosoftware.exemplo_base.core.commom.util.ExemploBundle;

public class ExemploRuntimeException extends RuntimeException{
    private final String codMsg;

    public ExemploRuntimeException(Exception e){
        super( e );
        codMsg = null;
    }

    public ExemploRuntimeException(String msg){
        this(null, msg);
    }

    public ExemploRuntimeException(String msg, Object... params){
        this(null, msg, params);
    }

    public ExemploRuntimeException(Throwable e, String msg){
        this(e, msg, "CHECKMISSINGPARAMS" );
    }

    public ExemploRuntimeException(Throwable e, String msg, Object... params){
        super(ExemploBundle.findMessage( msg, params ), e );
        codMsg = msg;
    }

    public String getCodMsg() {
        return codMsg;
    }


}
