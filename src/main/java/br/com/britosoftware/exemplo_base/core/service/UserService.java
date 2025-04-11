package br.com.britosoftware.exemplo_base.core.service;

import br.com.britosoftware.exemplo_base.core.persistence.models.User;
import br.com.britosoftware.exemplo_base.core.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Use este método para criar um usuário inicial
    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}