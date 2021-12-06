package br.edu.uni7.tec_vf.controller;

import br.edu.uni7.tec_vf.model.Produtos;
import br.edu.uni7.tec_vf.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutosController {

    private final ProdutosServices service;

    @Autowired
    public ProdutosController(ProdutosServices service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "produtos", method = RequestMethod.GET)
    public List<Produtos> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "produtos/{id}", method = RequestMethod.GET)
    public Produtos findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "produtos", method = RequestMethod.POST)
    public Produtos create(@RequestBody Produtos produto) {
        return service.create(produto);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/{codBarra}",method = RequestMethod.GET)
    public Produtos findByCodBarras(@PathVariable Integer codBarra){
        return service.findByCodBarras(codBarra);
    }


    @ResponseBody
    @RequestMapping(value = "produtos/{codBarra}",method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer codBarra){
        service.remove(codBarra);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/{id}", method = RequestMethod.PUT)
    public Produtos update(@PathVariable Integer id, @RequestBody Produtos produto) {
        produto.setId(id);
        return service.update(id,produto);
    }
    @ResponseBody
    @RequestMapping(value = "produtos/codBarra/{codBarra}", method = RequestMethod.GET)
    public List<Produtos> findAllByCodigoDeBarra(@PathVariable String codBarra){
        return service.findAllByCodBarra(codBarra);
    }


    @ResponseBody
    @RequestMapping(value = "produtos/categoria/{categoria}", method = RequestMethod.GET)
    public List<Produtos> findAllByCategoria(@PathVariable String categoria){
        return service.findAllByCategoria(categoria);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/quantidadezero", method = RequestMethod.GET)
    public List<Produtos> findAllByQuantidadeZero(){
        return service.findAllByQuantidadeZero();
    }


}
