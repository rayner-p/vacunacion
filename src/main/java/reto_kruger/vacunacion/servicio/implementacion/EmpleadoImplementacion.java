package reto_kruger.vacunacion.servicio.implementacion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_kruger.vacunacion.models.Administrador;
import reto_kruger.vacunacion.models.Empleado;
import reto_kruger.vacunacion.repositorio.AdministradorRepositorio;
import reto_kruger.vacunacion.repositorio.EmpleadoRepositorio;
import reto_kruger.vacunacion.servicio.EmpleadoServicio;

public class EmpleadoImplementacion  implements EmpleadoServicio{
	@Autowired
	private EmpleadoRepositorio repo;
	
	@Override
	public Administrador obtenerEmpleadoID(String cedula) {
		Administrador adm = repo.getById(cedula);
		return adm;
	}

	@Override
	public void actualizarEmpleado(Empleado emple) {
		repo.save(emple);
		
	}

}
