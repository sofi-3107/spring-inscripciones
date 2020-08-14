$(function(){
	
	
	

	var reinscripto=$('#reinscripto');
	reinscripto.change(
			function(){
				if($('#reinscripto').prop('checked')&&$('#dni').val()!=''){
					ajaxRequest('http://localhost:8080/api/getByDni/'+$('#dni').val());
				}				
			}
	
	);
		
	
		
	

	
	});//FIN AMBITO APLICACION

		function ajaxRequest(url){
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
		
		