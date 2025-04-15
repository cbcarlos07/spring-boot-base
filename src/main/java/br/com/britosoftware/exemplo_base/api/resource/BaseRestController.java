package br.com.britosoftware.exemplo_base.api.resource;


import br.com.britosoftware.exemplo_base.core.commom.exception.ExemploException;
import br.com.britosoftware.exemplo_base.core.commom.exception.ExemploRestException;
import br.com.britosoftware.exemplo_base.core.commom.exception.ExemploRuntimeException;
import org.springframework.http.ResponseEntity;



public class BaseRestController {

    protected <R>ResponseEntity buildResponse(RestFunctionNoArgs<R> f){
        try{
            return ResponseEntity.ok( f.appy() );
        }catch (ExemploException | ExemploRuntimeException e){
            throw new ExemploRestException(e);
        }catch (NullPointerException e){
            throw new ExemploRestException(e);
        }
    }

    protected ResponseEntity buildResponse(RestFunctionVoidNoArg f){
        try{
            f.apply();
            return ResponseEntity.ok(  ).build();
        }catch (ExemploException | ExemploRuntimeException e){
            throw new ExemploRestException(e);
        }catch (NullPointerException e){
            throw new ExemploRestException(e);
        }
    }

    protected interface RestFunctionNoArgs<R> {
        R appy() throws ExemploException;
    }

    protected interface RestFunctionVoidNoArg {
        void apply() throws ExemploException;
    }
}
