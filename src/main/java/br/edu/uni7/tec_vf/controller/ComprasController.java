package br.edu.uni7.tec_vf.controller;

import br.edu.uni7.tec_vf.model.Clientes;
import br.edu.uni7.tec_vf.model.Compras;
import br.edu.uni7.tec_vf.services.ComprasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ComprasController {

    private final ComprasServices service;

    @Autowired
    public ComprasController(ComprasServices service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.GET)
    public List<Compras> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "compras/{id}", method = RequestMethod.GET)
    public Compras findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.POST)
    public Compras create(@RequestBody Compras compra){
        return service.create(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compras/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable UUID uuid, @RequestBody Compras compra){
        compra.setUuid(uuid);
        service.update(compra);
    }

    @ResponseBody
    @RequestMapping(value = "compras/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id){
        service.remove(id);
    }

    @ResponseBody
    @RequestMapping(value = "compras/cpf/{cpfCliente}", method = RequestMethod.GET)
    public List<Compras> findById(@PathVariable String cpfCliente){
        return service.findAllByCpfCliente(cpfCliente);
    }
}
