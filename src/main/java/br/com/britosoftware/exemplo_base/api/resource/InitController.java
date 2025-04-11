package br.com.britosoftware.exemplo_base.api.resource;

import br.com.britosoftware.exemplo_base.core.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class InitController extends  BaseRestController {

    @Autowired
    private InitService service;

    @GetMapping
    public ResponseEntity info (){
        return buildResponse( () -> service.info() );
    }

}
