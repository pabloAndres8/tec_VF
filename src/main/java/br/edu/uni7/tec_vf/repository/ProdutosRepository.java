package br.edu.uni7.tec_vf.repository;

import br.edu.uni7.tec_vf.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos,Integer> {

    List<Produtos> findAllByCodBarra(String codBarra);

    List<Produtos> findAllByCategoria(String categoria);

    List<Produtos> findAllByQuantidade(Integer quantidade);

}
