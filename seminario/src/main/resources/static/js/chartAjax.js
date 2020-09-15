

 google.charts.load('current', {'packages':['corechart','bar']});

$(function(){
	
	var datos=[
	      ['Alumnos Regulares', 'Repitentes'],
	      ['Work',     11],
	      ['Eat',      2],
	      ['Commute',  2],
	      ['Watch TV', 2],
	      ['Sleep',    7]
	    ];
		/*PRUEBA*/
    $.get(
    		'http://localhost:8080/api/test/cursoMateria',
    		function (data,status){
    			console.log(data);
    			console.log(status);
    		}
    );	
    
    	/*PRUEBA*/    
    
    $('#btn-consultar').click(function(){
    	
    	curso=$('#curso').val();
    	division=$('#division').val();
    	ciclo=$('#ciclo').val();
    	turno=$('#turno').val();
    	anioLectivo=('#anioLectivo').val();
    	opcion=$('#tipo-graf').val();
    	
    	var datosConsulta=curso+'/'+division+'/'+ciclo+'/'+turno+'/'+anioLectivo;
    	
    	switch(opcion){
    	case '1':
    		$.get(
        			'http://localhost:8080/api/desaprobados/'+datosConsulta
        			,function(data){
        				datos=data;
        				graficarBar(datos);
        			});
    		break;
    	case '2':
    		$.get(
        			'http://localhost:8080/api/sobreedad/'+datosConsulta
        			,function(data){
        				datos=data;
        				graficarPie('Sobreedad',datos);
        			});
    		break;
    	case '3':
    		$.get(
    			'http://localhost:8080/api/repitentes/'+datosConsulta
    			,function(data){
    				datos=data;
    				graficarPie('Repitentes',datos);
    			});
    		break;
    	}
    });

	

});//FIN AMBITO DE APLICACION


function graficarPie(titulo,datos){
	function drawChart() {
		
	    //var data = google.visualization.arrayToDataTable(datos);
			
		var data = new google.visualization.DataTable();
		data.addColumn('string','candicion');
		data.addColumn('number','cantidad alumnos');
		
		data.addRows([
			['Aprobados',parseInt(datos[1][0])],
			['Desaprobados',parseInt(datos[1][1])]
					]);
		
	    var options = {
	      title: titulo
	    };
	    
	    var chart = new google.visualization.PieChart(document.getElementById('myChart'));
	
	    chart.draw(data, options);
	  }
	google.charts.setOnLoadCallback(drawChart);
	
	
}


function graficarBar(datos){
	 function drawChart() {
	        var data = google.visualization.arrayToDataTable(datos);

	        var options = {
	          chart: {
	            title: 'Aprobados y desaprobados por materia',
	          }
	        };

	        var chart = new google.charts.Bar(document.getElementById('myChart'));

	        chart.draw(data, google.charts.Bar.convertOptions(options));
	      }
	 google.charts.setOnLoadCallback(drawChart);

}

function getData(url,chart,titulo){
	
	$.get(
		url,
		function (data, status){
			console.log(datos);
			datos=JSON.parse(data);
			chart(titulo,datos);
			console.log(status);
		}
	);
}
