package br.edu.uni7.tec_vf.controller;

import br.edu.uni7.tec_vf.model.Clientes;
import br.edu.uni7.tec_vf.services.ClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientesController {

    private final ClientesServices service;

    @Autowired
    public ClientesController(ClientesServices service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "clientes", method = RequestMethod.GET)
    public List<Clientes> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "clientes/{id}", method = RequestMethod.GET)
    public Clientes findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "clientes", method = RequestMethod.POST)
    public Clientes create(@RequestBody Clientes cliente) {
        return service.create(cliente);
    }

    @ResponseBody
    @RequestMapping(value = "clientes/{id}",method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
             service.remove(id);
    }

    @ResponseBody
    @RequestMapping(value = "clientes/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable Integer id,@RequestBody Clientes cliente){
        cliente.setId(id);
        service.update(cliente);
    }

    @ResponseBody
    @RequestMapping(value = "clientes/cpf/{cpf}",method = RequestMethod.GET)
    public Clientes findByCpf(@PathVariable String cpf){
        return service.findByCpf(cpf);
    }

}
