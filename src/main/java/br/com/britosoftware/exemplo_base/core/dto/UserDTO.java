package br.com.britosoftware.exemplo_base.core.dto;

import br.com.britosoftware.exemplo_base.core.persistence.models.User;
import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;

    public User toEntity(){
        User user = new User();
        user.setUsername( username );
        user.setPassword( BCrypt.hashpw( password, BCrypt.gensalt() ) );
        return user;
    }

    public boolean checkPassword(){
        return BCrypt.hashpw( getPassword(), BCrypt.gensalt() ).equals( getPassword() );
    }

    public String encryptPassword(String pwd){
        return BCrypt.hashpw( pwd, BCrypt.gensalt() );
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
