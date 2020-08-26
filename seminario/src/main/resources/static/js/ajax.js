$(function(){
	
	
	
	/*Alumno reinscripto, trae los datos*/
	var reinscripto=$('#reinscripto');
	reinscripto.change(
			function(){
				if($('#reinscripto').prop('checked')&&$('#dni').val()!=''){
					ajaxRequestDni('http://localhost:8080/api/getByDni/'+$('#dni').val());
				}				
			}
		
	
	);
	
	/*para delete update*/
	var buscar=$('#buscar');
	buscar.change(function(){
		if(buscar.prop('checked')&&$('#dni').val()!=''){
			ajaxRequestDni('http://localhost:8080/api/getByDni/'+$('#dni').val());
		}	
	});
	/*Controla edad máxima por curso*/
	 var nacimiento=$('#nacimiento');
	 var curso=$('#curso');
	 var division=$('#division');
	 var ciclo=$('#ciclo');
	 var turno=$('#turno');
	 
	 nacimiento.change(				
			 function(){
				 $('#ageMsg').text('');	
				 $('#btn-inscribir').attr('disabled',false);
				 console.log('http://localhost:8080/api/getEdadMax/'+curso.val()+'/'+ciclo.val());
				 ajaxMaxAge('http://localhost:8080/api/getEdadMax/'+curso.val()+'/'+ciclo.val(),nacimiento.val());				 
			 }
	 );
	/*Controla el cupo disponible en el curso*/
	 if(division.val()!=''){
	 $('#curso-grupo').change(function(){
		 var anioLectivo=$('#anioLectivo');
		 console.log('http://localhost:8080/api/getCantEnCurso/'+curso.val()+'/'+division.val()+'/'+ciclo.val()+'/'+turno.val()+'/'+anioLectivo.val());
		 var url='http://localhost:8080/api/getCantEnCurso/'+curso.val()+'/'+division.val()+'/'+ciclo.val()+'/'+turno.val()+'/'+anioLectivo.val();
		 ajaxCantEnAula(url);
	 });
	 }
	 //Carga las divisones para el curso

	 console.log(curso.val()+' '+ciclo.val()+' '+turno.val());
	 var urlDiv='http://localhost:8080/api/getDivisiones/'+curso.val()+'/'+ciclo.val()+'/'+turno.val();
	 console.log(urlDiv);
	$('.lista-divisiones').change(
			function(){
		$('#division').load(urlDiv);
		
	}
	);
		
	

	
	});//FIN AMBITO APLICACION

	
		




	/*Funciones de peticion asincrona*/

		function ajaxRequestDni(url){
			console.log(url);
		//BUSCAMOS SI EL ALUMNO YA EXISTE CON SU DNI;ALUMNO REINSCRIPTO
			$.ajax({			
				url:url,			
				type:'GET',		
				success:function(data){
					console.log(data.nombre);
					foundByDni(data);
				},					
				error:function(xhr,status){
					console.log('xhr: '+status+' status: '+status);
					errorFoundByDni(xhr,status);
				}
			});
			
		}
		
		//consultamos la edad maxima del alumno para el curso en cuestion
		function ajaxMaxAge(url,fechaNac){
			$.ajax({
				url:url,
				type:'GET',
				success:function(data){
					console.log(data);
					console.log(calcularEdad(fechaNac));
					if(calcularEdad(fechaNac)>parseInt(data)){
						console.log('sobreedad');
						$('#ageMsg').text('Edad máxima permitida: '+data+','+'edad del alumno después de Junio: '+calcularEdad(fechaNac));
						$('#btn-inscribir').attr('disabled',true);
					}else{
						console.log('Ta ben de edad');
					}

				},
				error:function(xhr,status){
					console.log(xhr,status);
				}
			});
		}
		//consultamos la cantidad de alumnos inscriptos y el cupo maximo del curso y devuelve true si hay lugar false si no hay
		function ajaxCantEnAula(url){
			$.ajax({
				url:url,
				type:'GET',
				success:function(data){					
					if(data){
						alert('En buena hora, hay lugar en este curso');
					}else{
						alert('El curso ya no tiene lugar disponible, por favor intente en otra división y/o turno');
					}
				},
				error:function(xhr,status){
					console.log('xhr: '+xhr+'status'+status);
				}
			});
		}
		

		
		function calcularEdad(fecha){
			anio=fecha.substring(0,4);
			mes=fecha.substring(5,7);
			hoy=new Date().getFullYear();
			if(parseInt(mes)<=6){
				return hoy-parseInt(anio)+1;
			}else{
				return hoy-parseInt(anio);
			}
		}

		function foundByDni(data){
			console.log(data);
			$('#id').val(data.id);
			$('#nombre').val(data.nombre);
			$('#apellido').val(data.apellido);
			$('#nacimiento').val(data.fechaNacimiento);
			console.log(dateFormatter(data.fechaNacimiento));
		}
		
		function errorFoundByDni(xhr,status){
			alert('xhr: '+status+'status: '+status);
		};
		
	function dateFormatter(cadena){
			anio=cadena.substring(0,4);
			mes=cadena.substring(5,7);
			dia=cadena.substring(8,10);
			return dia+'-'+mes+'-'+anio;
		}
	
	
		
		