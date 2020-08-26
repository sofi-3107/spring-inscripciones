package xom.eet3107.inscripciones.auxiliar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor

public class CheckPreviousInscripciones {

	
	
	// Devuelve true si el alumno ya se inscribio en este mismo año
	// Con este método en el Controlador chequeamos si el alumno ya tiene inscripcion en el año en cuestion
	public static boolean checkInCurrentYear(Set<TrayectoriaAcademica>inscripciones,String currentInsc) {
		
		Calendar inscripcionActual=Calendar.getInstance();
		Calendar calendar=Calendar.getInstance();
		//Calendar fechaActual=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		
		for(TrayectoriaAcademica inscripcion : inscripciones) {
			calendar.set(Calendar.YEAR, Integer.valueOf(inscripcion.getFechaInscripcion().substring(0, 4)));
			inscripcionActual.set(Calendar.YEAR, Integer.valueOf(currentInsc));
			System.out.println("inscripcion.getFecha: "+inscripcion.getFechaInscripcion());
			System.out.println("anio inscripcion en set: "+sdf.format(calendar.getTime()));
			System.out.println("fecha inscripcion actual: "+sdf.format(inscripcionActual.getTime()));
			if(	sdf.format(inscripcionActual.getTime()).equals(sdf.format(calendar.getTime()))) {
				return true;
			}		
			
		}
		
		return false;
	}
	
	
	public static boolean isAlreadyinCurrentPeriod(Set<TrayectoriaAcademica>inscripciones,String anioLectivo) {
		
		for(TrayectoriaAcademica tya:inscripciones) {
			tya.getAnioLectivo().equals(anioLectivo);
			return true;
		}
		
		return false;
	}
	
	//Devuelve el id del ultimo curso en que se ha inscripto
	//Como durante la inscripcion ya se controla que no se inscriba 2 veces el mismo año
	//directamente buscamos el año anterior
	public static String getCursoAnioLectivoAnterior(Set<TrayectoriaAcademica>inscripciones) {
		Calendar fechaActual= Calendar.getInstance();		
		String anioActual=Integer.toString(fechaActual.get(Calendar.YEAR)-1);
		String idCurso="";
		for(TrayectoriaAcademica inscripcion:inscripciones) {
			if(inscripcion.getFechaInscripcion().substring(0,4).equals(anioActual)) {
				idCurso=inscripcion.getCurso();
			}
		}
		return idCurso;
	}
	
	//Busca la inscripcion de un alumno en un año en particular
	public static TrayectoriaAcademica getInscripcionAlumnoAnio(String anio,Alumno alumno) {
		TrayectoriaAcademica inscripcionBuscada=null;
		for(TrayectoriaAcademica inscripcion:alumno.getInscripciones()) {
			if(inscripcion.getFechaInscripcion().substring(0, 4).equals(anio)) {
				inscripcionBuscada=inscripcion;
			}
		}
		return inscripcionBuscada;
	}
	
	
}
