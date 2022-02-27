package com.empresa.projeto.api;

import com.empresa.projeto.interceptor.InterpectadorDeAcessos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("acessos")
@RestController
public class AcessosRest {

    @GetMapping
    public List<InterpectadorDeAcessos.Acesso> getAcessos() {
        return InterpectadorDeAcessos.acessos;
    }

}
