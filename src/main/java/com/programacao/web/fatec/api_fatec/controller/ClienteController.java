package com.programacao.web.fatec.api_fatec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacao.domain.cliente.ClienteRepository;
import com.programacao.web.fatec.api_fatec.entities.Cliente;

import jakarta.annotation.PostConstruct;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final List<Cliente> listaDeCliente = new ArrayList<>();

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(){
        listaDeCliente.add(new Cliente(1L, "Alex", null));

        Cliente cliente2 = new Cliente(null, null, null);
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEndereco(null);
        listaDeCliente.add(cliente2);
    }

    @GetMapping("/listarClientes/")
    public List<Cliente> listarClientes(){

        return clienteRepository.findAll();
    }

    // @GetMapping("listarClientes")
    //public List<Cliente> listarClientes(){
    //    return listaDeCliente;
    //}


    @GetMapping("/testeCliente1/")
    public String listarCliente(){

        return "Teste Cliente1";

    }

    @GetMapping("/testeCliente2/{nome}")
    public String testeCliente2(@PathVariable String nome){

        return nome;

    }

    @PostMapping("")
    public Cliente createCliente(@RequestBody Cliente cliente) {

        listaDeCliente.add(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id){

        for(Cliente cliente: listaDeCliente){
            if(cliente.getId()==id){
                listaDeCliente.remove(cliente);
                return "OK";
            }

        }
        return "Não encontrado ID:"+ id;
    }


    @PutMapping("/{id}")
    public String alterarCliente(@PathVariable Long id, @RequestBody Cliente entity){

        
        for(Cliente cliente: listaDeCliente){
            if(cliente.getId()==id){
                cliente.setId(id);
                cliente.setNome(entity.getNome());

                return "encontrou";
            }
        }
    return "Não encontrado id:" +id;

    }

    @PostConstruct
    public void dadosIniciais(){
        clienteRepository.save(new Cliente(null, "Alex", "rua xxx"));
        clienteRepository.save(new Cliente(null, "Alex 1", "rua xxx1"));
        clienteRepository.save(new Cliente(null, "Alex 2", "rua xxx2"));
        clienteRepository.save(new Cliente(null, "Alex 3", "rua xxx4"));
    }

    

        

}

