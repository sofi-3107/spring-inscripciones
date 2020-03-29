package com.eet3107.inscripciones.reports;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.services.AlumnoService;
import com.eet3107.inscripciones.services.AlumnoServiceImpl;

import antlr.collections.List;


public class ExportarExcelCsv {
	@Autowired
	static
	AlumnoServiceImpl service;
	
	private final static String DEFAULT_PATH="C:\\Users\\sofi\\Documents\\";

	public static void crearArchivoCSV(String nombreDeArchivo,Iterable<Alumno>alumnos) {
		nombreDeArchivo=DEFAULT_PATH+nombreDeArchivo+".csv";
		crearArchivoCSV(nombreDeArchivo,alumnos,";");
		
	}

	private static void crearArchivoCSV(String file,Iterable<Alumno>alumnos, String delim) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			fw.append("Apellido");
			fw.append(delim);
			fw.append("Nombre");
			fw.append(delim);
			fw.append("DNI");
			fw.append(delim);
			fw.append("Fecha de Nacimiento");
			fw.append(NEXT_LINE);
			for(Alumno alumno : alumnos) {
				fw.append(alumno.getApellido());
				fw.append(delim);
				fw.append(alumno.getNombre());
				fw.append(delim);
				fw.append(alumno.getDni());
				fw.append(delim);
				fw.append(String.valueOf( alumno.getNacimiento()));
				fw.append(NEXT_LINE);
			}
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// Error al crear el archivo, por ejemplo, el archivo 
			// está actualmente abierto.
			e.printStackTrace();
		}
	}

}
