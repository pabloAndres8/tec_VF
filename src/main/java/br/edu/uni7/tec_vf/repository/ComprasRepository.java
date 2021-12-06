package br.edu.uni7.tec_vf.repository;

import br.edu.uni7.tec_vf.model.Compras;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@Repository
public interface ComprasRepository extends MongoRepository<Compras, Integer> {
    List<Compras> findAllByCpfCliente(String cpfCliente);
}
