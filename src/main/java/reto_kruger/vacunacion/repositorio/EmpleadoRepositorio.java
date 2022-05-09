package reto_kruger.vacunacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import reto_kruger.vacunacion.models.Empleado;


public interface EmpleadoRepositorio extends JpaRepository<Empleado, String> {

}
