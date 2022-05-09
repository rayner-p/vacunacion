package reto_kruger.vacunacion.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import reto_kruger.vacunacion.models.Administrador;

public interface AdministradorRepositorio extends JpaRepository<Administrador, String> {

}