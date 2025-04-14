package br.com.britosoftware.exemplo_base.core.persistence.repositories;

import br.com.britosoftware.exemplo_base.core.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}