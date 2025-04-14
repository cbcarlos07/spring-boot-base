package br.com.britosoftware.exemplo_base.api.resource;


import org.springframework.http.ResponseEntity;



public class BaseRestController {

    protected <R>ResponseEntity buildResponse(RestFunctionNoArgs<R> f){
        //try{
            return ResponseEntity.ok( f.appy() );
        //}catch (Exception e){}
    }

    protected ResponseEntity buildResponse(RestFunctionVoidNoArg f){
        //try{
        f.apply();
        return ResponseEntity.ok(  ).build();
        //}catch (Exception e){}
    }

    protected interface RestFunctionNoArgs<R> {
        R appy();
    }

    protected interface RestFunctionVoidNoArg {
        void apply();
    }
}
