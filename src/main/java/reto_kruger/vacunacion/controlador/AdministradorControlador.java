package reto_kruger.vacunacion.controlador;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.annotation.RequestMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reto_kruger.vacunacion.models.Administrador;
import reto_kruger.vacunacion.repositorio.AdministradorRepositorio;
import reto_kruger.vacunacion.servicio.AdministradorServicio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/admin/rest")
public class AdministradorControlador {
	@Autowired
	private AdministradorServicio servicio;

	private final AdministradorRepositorio repository ;
	
	AdministradorControlador(AdministradorRepositorio repository) {
	    this.repository = repository;
	  }
	
	@GetMapping("/")
	public String Inicio() {
		return "homePage";
	}

	@PostMapping("/crear")
	public String saveInvoice(@ModelAttribute Administrador adm, Model model) {
	
		servicio.guardarAdministrador(adm);

		return "Guardado";
	}

	@GetMapping("/employees")
	List<Administrador> all() {
		return repository.findAll();
	}



	@PutMapping("/actualizar/{cedula}")
	 public String actualizar(
	            @ModelAttribute Administrador admi
	            ) {
	       servicio.actualizarEmpleado(admi);
	       
	       return "Actualizado Admin";
	    }
	@DeleteMapping("/eliminar/{cedula}")
	void  eliminar(@RequestParam String id) {
		try {
			servicio.eliminarEmpleado(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@GetMapping("/administrador/{cedula}")
	  Administrador one(@PathVariable String id) {
	    
	    return repository.findById(id)
	      .orElseThrow();
	  }


}
