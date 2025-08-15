package com.programacao.web.fatec.api_fatec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/testeCliente1/")
    public String listarCliente(){

        return "Teste Cliente1";

    }

    @GetMapping("/testeCliente2/{nome}")
    public String testeCliente2(@PathVariable String nome){

        return nome;

    }

    

}
