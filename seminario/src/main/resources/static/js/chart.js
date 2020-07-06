$(function(){
   
    // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});//importa la api

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table. La ifnormacion bruta es una tabla
        var data = new google.visualization.DataTable();
        //data.addColumn('string', 'Repitencia');// primer parametro es el tipo de dato y el segundo el nombre de la columna
        //data.addColumn('string', 'no repitentes');
        data.addColumn('string','desaprobados materia');
        data.addColumn('number','desaprobados');
          
        data.addRows([
            ['Matematica', 13],
            ['Lengua', 15],
            ['Inglés', 12],
            ['FEC', 5],
            ['Dibujo Técnico I', 8],
          
        ]);

        // Set chart options
        var options = {'title':'Desaprobados 1º1ºCS 1º Trimestre 2020',
                       'width':1200,
                       'height':900,
                        is3D:true};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('myChart'));
        chart.draw(data, options);
      }
});