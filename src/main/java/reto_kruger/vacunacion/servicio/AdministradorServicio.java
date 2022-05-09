package reto_kruger.vacunacion.servicio;

import java.util.List;

import reto_kruger.vacunacion.models.Administrador;

public interface AdministradorServicio {
	
	
	public Administrador guardarAdministrador(Administrador administrador);
	/**
	 * 
	 */
	void actualizarEmpleado(Administrador admin);
	
	/**
	 * 
	 */
	void eliminarEmpleado(String cedula);	
	
	/**
	 * @throws Exception 
	 * 
	 */
	public Administrador obtenerAdministradorCedula(String ced) throws Exception;
	/**
	 * Método que permite valida el numero de cedula ingresado por el cliente
	 * 
	 * @param cedula que ingresa el usuario por la caja de texto
	 * @return cedula correcta o no en base al metodo.
	 * @throws Exception captura algún error que pueda ocurrir al momento de
	 *                   utilizar el metodo
	 */
	public default  boolean validadorDeCedula(String cedula) throws Exception {

		boolean cedulaCorrecta = false;
		System.out.println("INGRESA VALIDACION CEDULA");
		// System.out.println("ESTO CEDULA INGRESADA " + cedula);
		try {
			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
				System.out.println("ESTAS EN EL VALIDADAOR?");
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			cedulaCorrecta = false;
			throw new Exception("Error cedula  " + err.getMessage());
		}
		if (!cedulaCorrecta) {
			return cedulaCorrecta;
		}
		return cedulaCorrecta;
	}
	
	/**
	 * Metodo que nos permite generar un nombre de usuario aleatorio
	 * 
	 * @param cedula   que el usuario haya ingresado en la creacion de la cuenta
	 * @param nombre   que haya ingresado el usuario en la creacion de la cuenta
	 * @param apellido que haya ingresado el usuario en la creacion de la cuent
	 * @return Nos devuele un nombre de usuario en base al nombre y apellido que se
	 *         haya ingresado
	 */
	public static  String generarNombreUsuario(String cedula, String nombre, String apellido) {
		String finalin = "";
		try {
			System.out.println(cedula);
			System.out.println(nombre);
			System.out.println(apellido);
			String ud = cedula.substring(cedula.length() - 1);
			String resultadoNombre = nombre.substring(0, 1);
			int it = 0;
			for (int i = 0; i < apellido.length(); i++) {
				if (apellido.charAt(i) == 32) {
					it = i;
				}
			}
			String a = "";
			if (it == 0) {
				a = apellido.substring(0, apellido.length());
			} else {
				a = apellido.substring(0, it);
			}
			System.out.println(resultadoNombre);
			finalin = resultadoNombre.toLowerCase() + a.toLowerCase() + ud;
		} catch (Exception e) {
			System.out.println("Debe ingresar una cedula primero");
		}
		return finalin;

	}
	/**
	 * Metodo que nos permite calcular la edad de la persona en base a la fecha
	 * ingresada e un usuario
	 * 
	 *
	 * @param fechaNacimiento La fecha de nacimiento del Empleado
	 */
	public static boolean validarIngresoNumeros(String datos) {
		if (datos.matches("[0-9]*"))
			System.out.println("Es un número");
		else
			System.out.println("No es un número");
		return true;

	}

	/**
	 * Metodo que nos permite validar que solo ingrese letras el usuario
	 * 
	 *
	 * @param datos La cadena de texto que se quiere validar
	 */
	public static boolean validarIngresoLetras(String datos) {
		if (datos.matches("/[A-Za-z ñ]+/")) {
			System.out.println("LETRAS VALIDAS");
		} else {
			System.out.println("No validas letras");
		}
		return true;
	}

	/**
	 * Metodo que nos permite validar el ingreso de correos electronicos de un
	 * usuario
	 * 
	 *
	 * @param correo El correo que se quiere validar
	 */
	public static boolean validarIngresoCorreo(String correo) {
		if (correo.matches("[^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$]")) {
			System.out.println("Correo valido");
		} else {
			System.out.println("Correo no valido");
		}
		return true;
	}
	/**
	 * Metodo que nos permite generar una contrasenia aleatorio para los usuarios y
	 * empleados del sistema
	 * 
	 * 
	 *
	 * @param clave cadena de texto que contiene la nueva contrasenia para los
	 *              usuarios
	 */
	public static String generarContrasenia() {
		String simbolos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz0123456789!#$%&()*+,-./:;<=>?@_";

		int tam = simbolos.length() - 1;
		System.out.println(tam);
		String clave = "";
		for (int i = 0; i < 10; i++) {
			int v = (int) Math.floor(Math.random() * tam + 1);
			clave += simbolos.charAt(v);
		}

		return clave;
	}
	

}
