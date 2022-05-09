package reto_kruger.vacunacion.servicio.implementacion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import reto_kruger.vacunacion.models.Administrador;
import reto_kruger.vacunacion.repositorio.AdministradorRepositorio;
import reto_kruger.vacunacion.servicio.AdministradorServicio;

public class AdministradorImplementacion  implements AdministradorServicio{
	@Autowired
	private AdministradorRepositorio repo;
	
	
	@Override
	public void actualizarEmpleado(Administrador admin) {
		repo.save(admin);
		
	}

	@Override
	public void eliminarEmpleado(String cedula) {
		 try {
			repo.delete(obtenerAdministradorCedula(cedula));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	@Override
	public Administrador guardarAdministrador(Administrador administrador) {
		return repo.save(administrador);
		
	}

	@Override
	public Administrador obtenerAdministradorCedula(String ced) throws Exception  {
		 Optional<Administrador> administra = repo.findById(ced);
	       if(administra.isPresent()) {
	           return administra.get();
	       } else {
	           throw new Exception( "No administrador con ese num de cedula ");
	       }
		
	}

	

}
