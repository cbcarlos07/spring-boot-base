package br.com.britosoftware.exemplo_base.api.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Gera um token Base64 para o usuário
    public String generateToken(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24); // Token válido por 24 horas

        AuthToken token = new AuthToken(username, calendar.getTime());

        try {
            String tokenJson = objectMapper.writeValueAsString(token);
            return Base64.getEncoder().encodeToString(tokenJson.getBytes());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    // Valida o token e retorna o username se válido
    public String validateToken(String token) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(token);
            String decodedToken = new String(decodedBytes);

            AuthToken authToken = objectMapper.readValue(decodedToken, AuthToken.class);

            if (authToken.getExpirationDate().before(new Date())) {
                return null; // Token expirado
            }

            return authToken.getUsername();
        } catch (Exception e) {
            return null; // Token inválido
        }
    }
}