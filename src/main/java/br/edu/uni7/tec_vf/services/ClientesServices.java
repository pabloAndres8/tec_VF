package br.edu.uni7.tec_vf.services;


import br.edu.uni7.tec_vf.model.Clientes;
import br.edu.uni7.tec_vf.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServices {

    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesServices(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public List<Clientes> list(){
        return clientesRepository.findAll();
    }

    public Clientes findById(Integer id){
        return clientesRepository.findById(id).get();
    }

    public Clientes create (Clientes cliente){
        return clientesRepository.save(cliente);
    }

    public Clientes update(Clientes clientes){
        return clientesRepository.save(clientes);

    }

    public void remove(Integer codDeBarra){
        clientesRepository.deleteById(codDeBarra);
    }

    public Clientes findByCpf(String cpf){
        return clientesRepository.findByCpf(cpf);
    }

}
