package edu.fincas.fincas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.fincas.fincas.model.Categoria;
import edu.fincas.fincas.model.Cliente;
import edu.fincas.fincas.model.Finca;
import edu.fincas.fincas.model.Mensaje;
import edu.fincas.fincas.model.Reserva;
import edu.fincas.fincas.service.CategoriaService;
import edu.fincas.fincas.service.ClienteService;
import edu.fincas.fincas.service.FincaService;
import edu.fincas.fincas.service.MensajeService;
import edu.fincas.fincas.service.ReservaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RetoControlle {
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FincaService fincaService;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private ReservaService reservaService;

// CATEGORIA CONTROLLER
    @GetMapping("/Category/all")
    public List<Categoria> listarCategorias(){
        return categoriaService.getCategorias();
    }

    @PostMapping("/Category/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        
        Categoria cate = categoriaService.guardarCategoria(categoria);
        
        return cate;
    }
    

// CLIENTE CONTROLLER
    @GetMapping("/Client/all")
    public List<Cliente> listarClientes(){
        return clienteService.getClientes();
    }

    @PostMapping("/Client/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        
        Cliente cli = clienteService.guardarCliente(cliente);
        
        return cli;
    }

// FINCA CONTROLLER
    @GetMapping("/Farm/all")
    public List<Finca> listarFincas(){
        return fincaService.getFincas();
    }

    @PostMapping("/Farm/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca guardarFinca(@RequestBody Finca finca) {
        
        Finca finc = fincaService.guardarFinca(finca);
        
        return finc;
    }

// MENSAJE CONTROLLER
    @GetMapping("/Message/all")
    public List<Mensaje> listarMensajes(){
        return mensajeService.getMensajes();
    }

    @PostMapping("/Message/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
        
        Mensaje men = mensajeService.guardaMensajee(mensaje);
        
        return men;
    }

// RESERVA CONTROLLER
    @GetMapping("/Reservation/all")
    public List<Reserva> listarReservas(){
        return reservaService.getReservas();
    }

    @PostMapping("/Reservation/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        
        Reserva res = reservaService.guardarReserva(reserva);
        
        return res;
    }

}
