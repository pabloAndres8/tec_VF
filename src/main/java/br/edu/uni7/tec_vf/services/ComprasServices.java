package br.edu.uni7.tec_vf.services;

import br.edu.uni7.tec_vf.exceptions.ClienteInexistenteException;
import br.edu.uni7.tec_vf.exceptions.ProdutoDesconhecidoException;
import br.edu.uni7.tec_vf.exceptions.QuantidadeZeroException;
import br.edu.uni7.tec_vf.model.Clientes;
import br.edu.uni7.tec_vf.model.Compras;
import br.edu.uni7.tec_vf.model.Produtos;
import br.edu.uni7.tec_vf.repository.ClientesRepository;
import br.edu.uni7.tec_vf.repository.ComprasRepository;
import br.edu.uni7.tec_vf.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasServices {
    private final ComprasRepository comprasRepository;
    private final ProdutosRepository produtosRepository;
    private final ClientesRepository clientesRepository;

    @Autowired
    public ComprasServices(ComprasRepository comprasRepository, ProdutosRepository produtosRepository, ClientesRepository clientesRepository) {
        this.comprasRepository = comprasRepository;
        this.produtosRepository = produtosRepository;
        this.clientesRepository = clientesRepository;
    }

    public List<Compras> list() {
        return comprasRepository.findAll();
    }

    public Compras findById(Integer id) {
        return comprasRepository.findById(id).get();
    }

    public Compras create(Compras compra) {
        double valorTotal = 0;

        Clientes clienteBD = clientesRepository.findByCpf(compra.getCpfCliente());
        if (clienteBD == null) {
            throw new ClienteInexistenteException();
        }
        List<Produtos> produtos = compra.getProdutos();
        if (produtos != null) {
            for (Produtos produto : produtos) {
                Produtos produtoDB = produtosRepository.findById(produto.getId()).get();
                if(produtoDB == null){
                    throw new ProdutoDesconhecidoException();
                }
                else {
                    if (produtoDB.getQuantidade() < produto.getQuantidade()) {
                        throw new QuantidadeZeroException();
                    } else {
                        valorTotal = valorTotal + (produtoDB.getPreco() * produto.getQuantidade());
                        produtoDB.setQuantidade(produtoDB.getQuantidade() - produto.getQuantidade());
                        produtosRepository.save(produtoDB);
                    }
                }
            }
        }
        compra.setValorCompra(valorTotal);
        clienteBD.setGastoTotal(clienteBD.getGastoTotal() + valorTotal);
        clientesRepository.save(clienteBD);
        return comprasRepository.save(compra);

    }

    public Compras update(Compras compra) {
        comprasRepository.save(compra);
        return compra;
    }

    public void remove(Integer id) {
        comprasRepository.deleteById(id);
    }

    public List<Compras> findAllByCpfCliente(String cpfCliente) {
        return comprasRepository.findAllByCpfCliente(cpfCliente);
    }
}
