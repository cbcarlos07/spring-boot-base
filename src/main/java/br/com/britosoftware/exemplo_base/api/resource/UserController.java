package br.com.britosoftware.exemplo_base.api.resource;

import br.com.britosoftware.exemplo_base.core.dto.UserDTO;
import br.com.britosoftware.exemplo_base.core.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseRestController{
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity all(){
        return buildResponse(() -> service.all() );
    }

    @PostMapping
    public ResponseEntity create( @RequestBody UserDTO dto){
        return buildResponse( () -> service.create( dto ));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody UserDTO dto){
        return buildResponse(() -> service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return buildResponse(() -> service.delete( id ));
    }

    @PatchMapping("/tratar")
    public ResponseEntity tratarCampos(@RequestBody UserDTO dto){
        return buildResponse(() -> service.tratarCampo(dto) );
    }

}
