package edu.fincas.fincas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.Cliente;
import edu.fincas.fincas.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes(){
        return clienteRepository.getALLClientes();
    }

    public Cliente guardarCliente(Cliente cliente){
    
        if (cliente != null){
            if (cliente.getIdClient() != null){
                Optional<Cliente> optional = clienteRepository.getCliente(cliente.getIdClient());
                if(optional.isEmpty()){
                    return clienteRepository.saveCliente(cliente);
                }else{
                    return cliente;
                }
            }else{
                return clienteRepository.saveCliente(cliente);
            }
        }
        
        return null;
    }


}