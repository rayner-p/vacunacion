package reto_kruger.vacunacion.models;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Administrador {
	
	private @Id String cedula;
	private String nombres;
	private String apellidos;
	private String correoElectronico;

}
