package com.ito.musical.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ito.musical.entidades.Composicion;

public class AdministradorArchivos {
	
	public static void guardarComposiciones(List<Composicion> composiciones) {
		
		try {
		    FileOutputStream fos = new FileOutputStream("composiciones.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    for(int i = 0; i < composiciones.size(); i++) {
		    	oos.writeObject(composiciones.get(i));
		    }
		    	
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public static List<Composicion> obtenerComposiciones() {
		
		List<Composicion> composiciones = new ArrayList<Composicion>();
		try {
			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("composiciones.txt"));
			composiciones = new ArrayList<Composicion>();
		    Object obj = null;
		    while ((obj = inputStream.readObject()) != null) {
				  if (obj instanceof Composicion) {
					  composiciones.add((Composicion)obj);
				  }
			}
		    inputStream.close();
			
		}catch (Exception e) {}
		
	return composiciones;
	}
}
