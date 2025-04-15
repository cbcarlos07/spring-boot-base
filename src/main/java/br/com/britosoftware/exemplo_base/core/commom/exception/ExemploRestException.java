package br.com.britosoftware.exemplo_base.core.commom.exception;

import br.com.britosoftware.exemplo_base.core.commom.util.ExemploBundle;
import org.springframework.http.HttpStatus;

public class ExemploRestException extends RuntimeException{

    private final String codMsg;

    public ExemploRestException(String msg){
        super(ExemploBundle.findMessage( msg ));
        codMsg = msg;
    }

    public ExemploRestException(String msg, Object... params){
        super(ExemploBundle.findMessage( msg, params ));
        codMsg = msg;
    }

    public ExemploRestException(Throwable e, String msg){
        super(ExemploBundle.findMessage( msg ), e );
        codMsg = msg;
    }

    public ExemploRestException(Throwable e, String msg, Object... params){
        super(ExemploBundle.findMessage( msg, params ), e );
        codMsg = msg;
    }

    public ExemploRestException(String msg, Throwable e){
        super( msg, e );
        codMsg = msg;
    }

    public ExemploRestException(Exception e){
        super( e );
        codMsg = null;
    }

    public String getCodMsg(){
        return codMsg;
    }
}
