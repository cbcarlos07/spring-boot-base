
package br.com.britosoftware.exemplo_base.core.service;

import br.com.britosoftware.exemplo_base.core.commom.Util;
import br.com.britosoftware.exemplo_base.core.commom.exception.ExemploRuntimeException;
import br.com.britosoftware.exemplo_base.core.dto.UserDTO;
import br.com.britosoftware.exemplo_base.core.persistence.models.User;
import br.com.britosoftware.exemplo_base.core.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> all(){
        return repository.findAll();
    }

    public User create(UserDTO data){
        return repository.save( data.toEntity() );
    }

    public User update(Integer id, UserDTO dto){
        User user = repository.findById( id ).orElse(null);
        if( !Util.isNullOrEmpty( user ) ){
            if( Util.isNotNullOrEmpty( dto.getUsername() ) ){
                user.setUsername( dto.getUsername() );
            }

            if( Util.isNotNullOrEmpty( dto.getPassword() ) ){
                user.setPassword( dto.encryptPassword( dto.getPassword() ) );
            }

        }

        assert user != null;
        return repository.save( user );
    }

    public void delete(Integer id){
        User user =  repository.findById( id ).orElse(null);
        assert user != null;
        repository.delete( user );
    }

    public void tratarCampo(UserDTO data){
        List<String> fields = new ArrayList<>();
        if( Util.isNullOrEmpty( data.getUsername() ) ){
            fields.add( "username" );
        }

        if( Util.isNullOrEmpty( data.getPassword() ) ){
            fields.add( "password" );
        }

        if( Util.isNotNullOrEmpty( fields ) ){
            throw new ExemploRuntimeException("erro.parametros.obrigatorios", String.join(",", fields));
        }

    }
}