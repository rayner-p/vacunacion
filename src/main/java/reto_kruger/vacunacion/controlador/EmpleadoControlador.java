package reto_kruger.vacunacion.controlador;

import java.util.List;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reto_kruger.vacunacion.models.Administrador;
import reto_kruger.vacunacion.models.Empleado;
import reto_kruger.vacunacion.repositorio.AdministradorRepositorio;
import reto_kruger.vacunacion.repositorio.EmpleadoRepositorio;
import reto_kruger.vacunacion.servicio.EmpleadoServicio;

public class EmpleadoControlador {

	@Autowired
	private EmpleadoServicio servicio;

	private final EmpleadoRepositorio repository;

	EmpleadoControlador(EmpleadoRepositorio repository) {
		this.repository = repository;
	}

	@GetMapping("/empleados")
	List<Empleado> all() {
		return repository.findAll();
	}

	@PutMapping("/actualizar/{cedula}")
	public String actualizar(@ModelAttribute Empleado emp) {
		servicio.actualizarEmpleado(emp);

		return "Actualizado";
	}

	

	@GetMapping("/empleado/{cedula}")
	Administrador one(@PathVariable String id) {
		return repository.findById(id).orElseThrow();
	}

}
