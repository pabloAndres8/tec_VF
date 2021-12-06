package br.edu.uni7.tec_vf.services;

import br.edu.uni7.tec_vf.model.Produtos;
import br.edu.uni7.tec_vf.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {
    private final ProdutosRepository produtosRepository;

    @Autowired
    public ProdutosServices(ProdutosRepository produtos){
        this.produtosRepository = produtos;
    }

    public List<Produtos> list(){
        return produtosRepository.findAll();
    }

    public Produtos findById(Integer id){
        return produtosRepository.findById(id).get();
    }

    public Produtos create (Produtos produto){
        return produtosRepository.save(produto);
    }

    public Produtos update(Integer id, Produtos produtos){
        produtosRepository.save(produtos);
        return produtos;
    }

    public void remove(Integer codDeBarra){
        produtosRepository.deleteById(codDeBarra);
    }

    public Produtos findByCodBarras(Integer codBarras){
        return produtosRepository.findById(codBarras).get();
    }


    public List<Produtos> findAllByCodBarra(String codBarra){
        return produtosRepository.findAllByCodBarra(codBarra);
    }

    public List<Produtos> findAllByCategoria(String categoria){
        return produtosRepository.findAllByCategoria(categoria);
    }

    public List<Produtos> findAllByQuantidadeZero(){
        return produtosRepository.findAllByQuantidade(0);
    }


}
