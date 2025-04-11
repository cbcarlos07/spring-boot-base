package br.com.britosoftware.exemplo_base.core.service;

import br.com.britosoftware.exemplo_base.core.dto.BasicInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class InitService {

    public BasicInfoDTO info (){
        return new BasicInfoDTO("Bem-vindo à api de Exemplo de Springboot");
    }
}
