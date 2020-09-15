package xom.eet3107.inscripciones.auxiliar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.CursoRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor

public class CalculosDeFecha {

	
	
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
	public static Curso getCursoAnioLectivoAnterior(Set<TrayectoriaAcademica>inscripciones) {
		Calendar fechaActual= Calendar.getInstance();		
		String anioActual=Integer.toString(fechaActual.get(Calendar.YEAR)-1);
		Curso curso=null;
		for(TrayectoriaAcademica inscripcion:inscripciones) {
			if(inscripcion.getFechaInscripcion().substring(0,4).equals(anioActual)) {
				curso=inscripcion.getCurso();
			}
		}
		return curso;
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
	
	//CALCULAR EDAD, no es la edad actual. Es la edad hasta Junio 
	//en el curso.
	
	public static int calcularEdadEnCurso(String fechaNacimiento) {
		Calendar hoy=Calendar.getInstance();
		
		int anio=Integer.parseInt(fechaNacimiento.substring(0,4));
		int mes=Integer.parseInt(fechaNacimiento.substring(5,7))-1;
		int dia=Integer.parseInt(fechaNacimiento.substring(8,10));
		
		Calendar nac=Calendar.getInstance();
		nac.set(anio, mes,dia);
		int edad=hoy.get(Calendar.MONTH)+1-nac.get(Calendar.MONTH)+1;
		if(nac.get(Calendar.MONTH)>6) {
			++edad;
		}		
		return edad;
	}
	
	//Recibe ya los alumnos del curso del año lectivo correspondiente
	public static int[]cantidadSobreedadEnCurso(List<TrayectoriaAcademica> alumnosCurso,Curso curso){
		int[]sobreedad=new int[2];
		int cantSobreedad=0;
		int edadIdeal=curso.getEdadIdeal();
		int cantEdadNormal=alumnosCurso.size();
		for(TrayectoriaAcademica alumno : alumnosCurso) {
			if(calcularEdadEnCurso(alumno.getAlumno().getFechaNacimiento())>edadIdeal) {
				++cantSobreedad;
			}
		}
		cantEdadNormal=-cantSobreedad;
		sobreedad[0]=cantSobreedad;
		sobreedad[1]=cantEdadNormal;
		return sobreedad;
		
	}
	
	
	
}
