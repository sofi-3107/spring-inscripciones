$(function(){
	google.charts.load('current', {'packages':['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawStuff);

    function drawStuff() {

      var button = document.getElementById('change-chart');
      var chartDiv = document.getElementById('myChart');

      var data = google.visualization.arrayToDataTable([
        ['Materias', 'Aprobados', 'Desaprobados'],
        ['Matematica I', 20, 5],
        ['Lengua I', 24, 1],
        ['Dibujo Tecnico I', 10, 14],
        ['Informatica I', 13, 3],
        ['Taller de Electricidad ', 18, 5]
      ]);
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

    
});