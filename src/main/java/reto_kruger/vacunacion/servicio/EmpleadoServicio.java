package reto_kruger.vacunacion.servicio;

import java.util.List;

import reto_kruger.vacunacion.models.Administrador;
import reto_kruger.vacunacion.models.Empleado;

public interface EmpleadoServicio {
	//public List<Administrador> getAllInvoices();
	public Administrador obtenerEmpleadoID(String cedula);
	public void actualizarEmpleado(Empleado emple);
}
