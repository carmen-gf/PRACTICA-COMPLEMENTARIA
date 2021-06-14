package com.ito.musical.util;

import com.ito.musical.entidades.Composicion;

public interface IAdministradorComposiciones {
	
	void inicializar();
	int obtenerNumeroComposiciones();
	int obtenerNumeroInterpretes(int numeroComposicionSeleccionada);
	void agregarComposicion(Composicion composicion);
	void eliminarComposicion(int numeroComposicion) throws Exception;
	void validarComposicionExistente(String titulo) throws Exception;
	void consultarComposiciones();
	void agregarInterprete(int numComposicion, String interprete);
	void consultarInterpretes(int numeroComposicionSeleccionada);
	void eliminarInterprete(int numeroComposicionSeleccionada, int numeroInterpreteEliminar);
	void guardarCambios();

}
