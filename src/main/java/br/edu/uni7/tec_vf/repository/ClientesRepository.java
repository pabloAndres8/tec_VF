package br.edu.uni7.tec_vf.repository;


import br.edu.uni7.tec_vf.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository <Clientes,Integer> {
    Clientes findByCpf(String cpf);
}
