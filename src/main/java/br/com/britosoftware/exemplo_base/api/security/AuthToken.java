package br.com.britosoftware.exemplo_base.api.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {
    private String username;
    private Date expirationDate;
}