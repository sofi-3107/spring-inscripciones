package com.eet3107.inscripciones.service;




import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;



public interface InscripcionesService {


	Integer getMaxAgeCurso(String  curso,String division);
	
	Integer getMaxCupo(String  curso,String division,String ciclo,Character turno);
	
	Alumno findAlumnoByDni(String dni);
	
	void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) throws IOException;
	
	void reinscribirAlumno( Alumno al,TrayectoriaAcademica tya,Curso curso);
	
	Boolean hayLugarenCurso(String nombreCurso,String division,String ciclo,Character turno,String anioLectivo);
	
	Map<String,List<Integer>>aprobadosDesaprobadosPorMateriaCurso(Curso curso,List<Materia>planDeEstudios,String anioLectivo,int trimestre);
	
	

}
