google.charts.load('current', {packages: ['corechart', 'bar']});


	var test=[
		['1º',20],
		['2º',30],
		['3º',8]
	];

	var notas=[
		['Matematica',20,10],
		['Lengua',5,10],
		['Ingles',2,8],
		['Dibujo Tecnico',12,3]
	];
	
	
	$(function(){

		 
		 google.charts.setOnLoadCallback(drawStuff(notas));
		  var tipo=$('#tipo-graf').val();
		  switch(tipo){
		  case '1':
			 
			  google.charts.setOnLoadCallback(drawStuff(info));
			  break;
		  case '2':
			  
			  google.charts.setOnLoadCallback(drawChart('Repitentes',test));
			  break;
		  case '3':
			  
			  google.charts.setOnLoadCallback(drawChart('Sobreedad',test));
			  break;
			  default:
				  console.log('No entro a ningun case');
		  }

		  
		  $('#btn-consultar').click(function(){
			  console.log('boton');
			  google.charts.setOnLoadCallback(drawStuff(info));
		  });

		  
		  
		

	  });//FINA MBITO DE APLICACION

	  /*función que llama gráfico de barras*/
	  function drawStuff(notas) {
		  
		  //Carga de datos 
		  var data = new google.visualization.DataTable();
	        data.addColumn('string', 'Materias');
	        data.addColumn('number', 'Aprobados');
	        data.addColumn('number', 'Desaprobados');
	        
	        data.addRows(notas);
	  	
	    var chartDiv = document.getElementById('myChart');


	    var classicOptions = {
	              width: 900,
	              series: {
	                0: {targetAxisIndex: 0},
	                1: {targetAxisIndex: 1}
	              },
	              title: 'Cantidad de Alumnos aprobados y desaprobados por materia',
	              vAxes: {
	                // Adds titles to each axis.
	                0: {title: 'aprobados'},
	                1: {title: 'desaprobados'}
	              }
	            };

	      var classicChart = new google.visualization.ColumnChart(chartDiv);
	      classicChart.draw(data, classicOptions);
	  };
	

  
  /*Función que llama al gráfico circular*/
  function drawChart(title,datos) {

	  //Carga de datos
	  var data = google.visualization.arrayToDataTable(datos);
      var options = {
        title: title
      };

      var chart = new google.visualization.PieChart(document.getElementById('myChart'));

      chart.draw(data, options);
    };
  
  

  
	
	

	
  
 

    
