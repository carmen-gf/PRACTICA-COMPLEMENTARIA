package com.ito.musical.util;

import java.util.ArrayList;
import java.util.List;

import com.ito.musical.entidades.Composicion;
import com.ito.musical.entidades.Interprete;

public class AdministradorComposiciones implements IAdministradorComposiciones {
	
	List<Composicion> listadoComposiciones;

	@Override
	public void agregarComposicion(Composicion composicion) {
		listadoComposiciones.add(composicion);
		System.out.println("Composicion [" + composicion.getTitulo() + "] agregada satisfactoriamente.");
	}

	@Override
	public void eliminarComposicion(int numeroComposicion) throws Exception {
		
		if(listadoComposiciones.get(numeroComposicion - 1).getInterpretes().size() > 0)
			throw new Exception("EXCEPCION: No es posible borrar una composicion con interpretes.");
		
		
		listadoComposiciones.remove(numeroComposicion - 1);
		System.out.println("Composicion eliminada satisfactoriamente.");
	}

	@Override
	public void consultarComposiciones() {
		
		System.out.println();
		
		if(listadoComposiciones.size() > 0)
			for (int counter = 0; counter < listadoComposiciones.size(); counter++) { 		      
		          System.out.print("#" + (counter+1) + " " + listadoComposiciones.get(counter)); 		
		      }  
		else System.out.println("NO existen composiciones.");
	}

	@Override
	public void agregarInterprete(int numComposicion, String interprete) {
		listadoComposiciones.get(numComposicion - 1).getInterpretes().add(new Interprete(interprete));
		System.out.println("Interprete [" + interprete + "] agregado satisfactoriamente a la composicion # " + numComposicion + ".");
	}

	@Override
	public void inicializar() {
		System.out.println("Lectura inicial de los datos (composiciones.txt)");
		listadoComposiciones = AdministradorArchivos.obtenerComposiciones();
		if(listadoComposiciones == null) new ArrayList<Composicion>();
	}

	@Override
	public int obtenerNumeroComposiciones() {
		return listadoComposiciones.size();
	}

	@Override
	public void guardarCambios() {
		AdministradorArchivos.guardarComposiciones(listadoComposiciones);
		System.out.println("Cambios guardados. Regresando a menu principal...");
	}

	public void validarComposicionExistente(String titulo) throws Exception {
		
		Composicion nuevaComposicion = new Composicion(titulo);
		
		for (int counter = 0; counter < listadoComposiciones.size(); counter++) { 		      
	          if(listadoComposiciones.get(counter).compareTo(nuevaComposicion) == 0)	
	        	  throw new Exception("EXCEPCION: La composicion [" + titulo + "] ya existe.");
	      } 
		
	}

	@Override
	public void consultarInterpretes(int numeroComposicionSeleccionada) {
		
		System.out.println();
		
		List<Interprete> interpretes = listadoComposiciones.get(numeroComposicionSeleccionada - 1).getInterpretes();
		
		if(interpretes.size() > 0)
			for (int counter = 0; counter < interpretes.size(); counter++) { 		      
		          System.out.print("#" + (counter+1) + " " + interpretes.get(counter) + "\n"); 		
		      }  
		else System.out.println("NO existen interpretes.");
		
	}

	@Override
	public void eliminarInterprete(int numeroComposicionSeleccionada, int numeroInterpreteEliminar) {
		
		listadoComposiciones.get(numeroComposicionSeleccionada - 1).getInterpretes().remove(numeroInterpreteEliminar - 1);
		System.out.println("Interprete eliminado satisfactoriamente.");
	}

	@Override
	public int obtenerNumeroInterpretes(int numeroComposicionSeleccionada) {
		
		return listadoComposiciones.get(numeroComposicionSeleccionada - 1).getInterpretes().size();
	}


}
