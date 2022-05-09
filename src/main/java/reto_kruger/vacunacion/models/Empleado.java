package reto_kruger.vacunacion.models;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter

public class Empleado  extends Administrador {
	
	private Date fechaNacimiento;
	private String direccionDomicilio;
	private String telefonoMovil;
	private String estadoVacunacion;
	private String tipoVacuna ;
	private Date fechaVacunacion;
	private int numeroDosis;

}
