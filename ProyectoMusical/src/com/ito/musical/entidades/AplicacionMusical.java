package com.ito.musical.entidades;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.ito.musical.util.*;

public class AplicacionMusical {
	
	static AdministradorComposiciones administradorComposiciones = new AdministradorComposiciones();
	static Scanner entradaTeclado = new Scanner( System.in );
	
	public static void main(String args[]) throws ParseException, IOException, ClassNotFoundException, InterruptedException {
		
		Integer opcionGeneral;
		administradorComposiciones.inicializar();
		
		do {
			Thread.sleep(2000);
			System.out.print("\n" + "********** APLICACION MUSICAL ************" + "\n" +
							        "------------------------------------------" + "\n" +
							        "********** 1. ALTA DE COMPOSICION ********" + "\n" +
							        "********** 2. ALTA DE INTERPRETE *********" + "\n" +
							        "********** 3. BAJA DE COMPOSICION ********" + "\n" +
							        "********** 4. BAJA DE INTERPRETE *********" + "\n" +
							        "********** 5. CONSULTAR COMPOSICIONES ****" + "\n" +
							        "------------------------------------------" + "\n" +
							        "********** 6. GUARDAR CAMBIOS ************" + "\n" +
							        "------------------------------------------" + "\n" +
							        "********** 7. SALIR **********************" + "\n" +
							        "------------------------------------------" + "\n" +
							        "********** Elija la opcion: ");
		
			opcionGeneral = Integer.parseInt(entradaTeclado.nextLine());
			
			switch (opcionGeneral)
			{
			    case 1:
			    	agregarComposicion(); break;
			    case 2:
			    	agregarInterprete(); break;
			    case 3:
			    	eliminarComposicion(); break;
			    case 4:
			        eliminarInterprete(); break;
			    case 5:
			        consultarComposiciones(); break;    
			    case 6:
			        guardarCambios(); break; 
			    case 7:
			    	salir(); break;
			    default:
			    	opcionIncorrecta(); break;
			}
			
		} while(opcionGeneral != 7);
		
		entradaTeclado.close();
	}


	private static void agregarInterprete() {
		
		int numeroComposiciones = administradorComposiciones.obtenerNumeroComposiciones();
		
		if(numeroComposiciones < 1) {
			System.out.println("NO existen composiciones. NO es posible agregar interprete.");
			return;
		}
		
		administradorComposiciones.consultarComposiciones();
		System.out.print("Digite el numero de composicion a seleccionar: ");
		int numeroComposicionSeleccionada  = Integer.valueOf(entradaTeclado.nextLine());
		
		if(numeroComposicionSeleccionada > numeroComposiciones || numeroComposicionSeleccionada < 1) {
			System.out.println("Numero de composicion incorrecto. Regresando a menu principal...");
			return;
		}
		
		System.out.print("Introduce el nombre del interprete: ");
		String interprete  = entradaTeclado.nextLine();
		administradorComposiciones.agregarInterprete(numeroComposicionSeleccionada, interprete);
	}

	private static void salir() {
		System.out.println("Saliendo de la aplicacion ...");
	}

	private static void opcionIncorrecta() {
		System.out.println("Opcion invalida. Intente nuevamente: ");
	}

	private static void consultarComposiciones() {
		administradorComposiciones.consultarComposiciones();
	}

	private static void eliminarComposicion() {
		
		int numeroComposiciones = administradorComposiciones.obtenerNumeroComposiciones();
		
		if(numeroComposiciones < 1) {
			System.out.println("NO existen composiciones. NO es posible dar de baja alguna de ellas.");
			return;
		}
		
		administradorComposiciones.consultarComposiciones();
		System.out.print("Digite el numero de composicion a borrar: ");
		int numeroComposicionSeleccionada  = Integer.valueOf(entradaTeclado.nextLine());
		
		if(numeroComposicionSeleccionada > numeroComposiciones || numeroComposicionSeleccionada < 1) {
			System.out.println("Numero de composicion incorrecto. Regresando a menu principal...");
			return;
		}
		
		try {
			administradorComposiciones.eliminarComposicion(numeroComposicionSeleccionada);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Regresando a menu principal...");
		}
		
		
	}
	
	private static void eliminarInterprete() {
		
		int numeroComposiciones = administradorComposiciones.obtenerNumeroComposiciones();
		
		if(numeroComposiciones < 1) {
			System.out.println("NO existen composiciones. NO es posible eliminar interprete.");
			return;
		}
		
		administradorComposiciones.consultarComposiciones();
		System.out.print("Digite el numero de composicion a seleccionar: ");
		int numeroComposicionSeleccionada  = Integer.valueOf(entradaTeclado.nextLine());
		
		if(numeroComposicionSeleccionada > numeroComposiciones || numeroComposicionSeleccionada < 1) {
			System.out.println("Numero de composicion incorrecto. Regresando a menu principal...");
			return;
		}
		
		int numeroInterpretes = administradorComposiciones.obtenerNumeroInterpretes(numeroComposicionSeleccionada);
		
		administradorComposiciones.consultarInterpretes(numeroComposicionSeleccionada);
		System.out.print("Digite el numero de interprete a eliminar: ");
		int numeroInterpreteEliminar  = Integer.valueOf(entradaTeclado.nextLine());
		
		if(numeroInterpreteEliminar > numeroInterpretes || numeroInterpreteEliminar < 1) {
			System.out.println("Numero de interprete incorrecto. Regresando a menu principal...");
			return;
		}
		
		administradorComposiciones.eliminarInterprete(numeroComposicionSeleccionada, numeroInterpreteEliminar);
	}

	private static void agregarComposicion() throws ParseException {

		boolean existente;
		String titulo;
		
		do {
			System.out.print("Introduce el titulo: ");
			titulo  = entradaTeclado.nextLine();
			try {
				administradorComposiciones.validarComposicionExistente(titulo);
				existente = false; //Sino existe error, no hay duplicado.
			} catch(Exception e) {
				System.out.println(e.getMessage());
				existente = true; //Si ocurrio una excepcion es que la composicion ya existe.
			}
			
		} while(existente);
		
		System.out.print("Introduce la duracion: ");
		Float duracion  = Float.valueOf(entradaTeclado.nextLine());
		
		System.out.print("Introduce el genero: ");
		String genero  = entradaTeclado.nextLine();
		
		System.out.print("Introduce fecha de registro (dd/MM/yyyy): ");
		Date fechaRegistro  = new SimpleDateFormat("dd/MM/yyyy").parse(entradaTeclado.nextLine());
		
		System.out.print("Introduce fecha de estreno (dd/MM/yyyy): ");
		Date fechaEstreno  = new SimpleDateFormat("dd/MM/yyyy").parse(entradaTeclado.nextLine());

		Composicion nuevaComposicion = new Composicion();
		nuevaComposicion.setTitulo(titulo);
		nuevaComposicion.setDuracion(duracion);
		nuevaComposicion.setGenero(genero);
		nuevaComposicion.setFechaRegistro(fechaRegistro);
		nuevaComposicion.setFechaEstreno(fechaEstreno);
		
		administradorComposiciones.agregarComposicion(nuevaComposicion);
	}
	
	private static void guardarCambios() {
		
		administradorComposiciones.guardarCambios();
	}

}
