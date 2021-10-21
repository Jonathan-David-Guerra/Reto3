package edu.fincas.fincas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Cliente;


@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteCrudRepository clienteRepository;

    public List<Cliente> getALLClientes(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente saveCliente(Cliente entityCliente){
        return clienteRepository.save(entityCliente);
    }

    public void borrarPorIdCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
