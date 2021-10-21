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





    public Cliente actualizar(Cliente cliente) {
        if(cliente.getIdClient() != null){
            Optional<Cliente> oCliente = clienteRepository.getCliente(cliente.getIdClient());
            if(!oCliente.isEmpty()){
                Cliente c = oCliente.get();
                if(cliente.getEmail()!= null){
                    c.setEmail(cliente.getEmail());
                }
                if(cliente.getPassword()!= null){
                    c.setPassword(cliente.getPassword());
                }
                if(cliente.getName()!= null){
                    c.setName(cliente.getName());
                }
                if(cliente.getAge() != null){
                    c.setAge(cliente.getAge());
                }
                if(cliente.getMessages()!= null){
                    c.setMessages(cliente.getMessages());
                }
                if(cliente.getReservations() != null){
                    c.setReservations(cliente.getReservations());
                }

                return clienteRepository.saveCliente(c);
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.getCliente(id);
    }

    public boolean borrarCliente(Long id){
        Boolean borrado =  getCliente(id).map(c -> {
            clienteRepository.borrarPorIdCliente(id);
            return true;
        }).orElse(false);
        return borrado;
    }

}