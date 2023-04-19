/**
 * PROGRAMA DE EJEMPLO DE USO DE LA CLASE ARRAYLIST, 
   QUE SIMULA UNA SENCILLA AGENDA DE CONTACTOS
 */
package usoarraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class UsoArrayList {

	//Declaramos estas dos referencias como estaticas, para poder usarlas en todos los metodos
	static Scanner sc;
	static ArrayList<Persona> listaPersonas;

	public static void main(String[] args) {

		//Inicializamos la lista y la lectura por teclado
		listaPersonas = new ArrayList<>();
		sc = new Scanner(System.in);
		int opcion;

		do {
			//Al inicio de cada iteracion mostramos el menu, y recogemos la opcion
			menu();
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				listarPersonas();
				break;
			case 2:
				aniadirPersona();
				break;
			case 3:
				eliminarPersona();
				break;
			case 4:
				eliminarTodas();
				break;

			default:
				System.out.println("Opcion no valida. Introduzca una opcion valida, por favor.");
			}

		} while (opcion != 0);
		
		sc.close();

	}

	/*
	 * METODO QUE IMPRIME EL MENU
	 */
	public static void menu() {
		System.out.println("AGENDA DE CONTACTOS");
		System.out.println("===================");
		System.out.println("1. Listar todos los contactos");
		System.out.println("2. Añadir un contacto");
		System.out.println("3. Eliminar un contacto");
		System.out.println("4. Eliminar todos los contactos");
		System.out.println("0. Salir del programa\n\n");
		System.out.print("Introduzca una opcion: ");

	}

	/*
	 * METODO QUE LISTA TODOS LOS CONTACTOS DE LA AGENDA
	 * O MUESTRA UN MENSAJE SI NO HAY NINGUNO QUE MOSTRAR
	 */
	public static void listarPersonas() {
		if (listaPersonas.isEmpty()) {
			System.out.println("La agenda no tiene contactos\n");
		} else {
			for (int i = 0; i < listaPersonas.size(); i++) {
				Persona p = listaPersonas.get(i);
				System.out.printf("%d %s %s (%s) %n", i, p.getNombre(), p.getApellidos(), p.getTelefono());
			}
			System.out.println("");
		}
	}

	/*
	 * METODO QUE RECOGE LOS DATOS DEL USUARIO
	 * PARA AÑADIR UNA NUEVA PERSONA, Y LA INSERTA EN LA LISTA
	 */
	public static void aniadirPersona() {
		System.out.println("\n\nAÑADIR NUEVO CONTACTO");
		System.out.print("Introduzca el nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca los apellidos: ");
		String apellidos = sc.nextLine();
		System.out.print("Introduzca su numero de telEfono: ");
		String telefono = sc.nextLine();

		listaPersonas.add(new Persona(nombre, apellidos, telefono));
		
		System.out.println("");
		
	}

	/*
	 * METODO QUE ELIMINA UNA PERSONA DE LA AGENDA
	 * EN FUNCION DE UNA POSICION RECOGIDA DEL TECLADO
	 */
	public static void eliminarPersona() {
		System.out.println("\n\nELIMINAR CONTACTO");
		System.out.print("Introduzca la posicion del contacto: ");
		int posicion = Integer.parseInt(sc.nextLine());
		if (posicion < 0 || posicion >= listaPersonas.size()) {
			System.out.println("Posicion erronea");
		} else {
			System.out.print("Está usted seguro de querer eliminar el contacto? (S/N): ");
			String siono = sc.nextLine();
			if (siono.equalsIgnoreCase("S")) {
				listaPersonas.remove(posicion);
			}
		}
		System.out.println("");


	}

	/*
	 * METODO QUE ELIMINA TODOS LOS CONTACTOS DE LA AGENDA
	 * PREVIA CONFIRMACION DE LA OPERACION
	 */
	public static void eliminarTodas() {
		System.out.println("\n\nELIMINAR CONTACTO");
		System.out.print("Está usted seguro de querer eliminar el contacto? (S/N): ");
		String siono = sc.nextLine();
		if (siono.equalsIgnoreCase("S")) {
			listaPersonas.clear();
		}
		System.out.println("");

	}

}
