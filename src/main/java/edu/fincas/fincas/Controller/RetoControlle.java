package edu.fincas.fincas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.fincas.fincas.model.Categoria;
import edu.fincas.fincas.model.Cliente;
import edu.fincas.fincas.model.Finca;
import edu.fincas.fincas.model.Mensaje;
import edu.fincas.fincas.model.ReportClients;
import edu.fincas.fincas.model.ReportStatus;
import edu.fincas.fincas.model.Reserva;
import edu.fincas.fincas.service.CategoriaService;
import edu.fincas.fincas.service.ClienteService;
import edu.fincas.fincas.service.FincaService;
import edu.fincas.fincas.service.MensajeService;
import edu.fincas.fincas.service.ReservaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/Category/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria actualizarCategoria(@RequestBody Categoria categoria) {
        
        Categoria cate = categoriaService.actualizar(categoria);
        
        return cate;
    }
    
    @DeleteMapping("/Category/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable Long id) {
        return categoriaService.borrarCategoria(id);
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

    @PutMapping("/Client/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        
        Cliente cli = clienteService.actualizar(cliente);
        
        return cli;
    }

    @DeleteMapping("/Client/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean eliminarCliente(@PathVariable Long id) {
        return clienteService.borrarCliente(id);
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

    @PutMapping("/Farm/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Finca actualizarFinca(@RequestBody Finca finca) {
        
        Finca fin = fincaService.actualizar(finca);
        
        return fin;
    }

    @DeleteMapping("/Farm/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean eliminarFinca(@PathVariable Long id) {
        return fincaService.borrarFinca(id);
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

    @PutMapping("/Message/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mensaje actualizarMensaje(@RequestBody Mensaje mensaje) {
        
        Mensaje men = mensajeService.actualizar(mensaje);
        
        return men;
    }

    @DeleteMapping("/Message/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean eliminarMensaje(@PathVariable Long id) {
        return mensajeService.borrarMensaje(id);
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


    @PutMapping("/Reservation/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reserva actualizarReserva(@RequestBody Reserva reserva) {
        
        Reserva res = reservaService.actualizar(reserva);
        
        return res;
    }

    @DeleteMapping("/Reservation/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean eliminarReserva(@PathVariable Long id) {
        return reservaService.borrarReserva(id);
    }


// Metodos Reto 5

    @GetMapping("/Reservation/report-dates/{ini}/{fin}")
    public List<Reserva> listaReservasFechas(@PathVariable String ini,@PathVariable String fin){
        return reservaService.getReservasFechas(ini,fin);
    }

    @GetMapping("/Reservation/report-status")
    public ReportStatus getReportStatus(){
        return reservaService.getReporteStatus();
    }
    @GetMapping("/Reservation/report-clients")
    public List<ReportClients> getResportTopClientes(){
        return reservaService.getTopClientes();
    }
}
