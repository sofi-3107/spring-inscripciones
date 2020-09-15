$(function(){
	


	var backgroundColor1= [
	    'rgba(255, 99, 132, 1)',
	    'rgba(255, 99, 132, 1)',
	    'rgba(255, 99, 132, 1)',
	    'rgba(255, 99, 132, 1)',
	    'rgba(255, 99, 132, 1)',
	    'rgba(255, 99, 132, 1)'
	    
	  
	];

	var borderColor1=[
		 'rgba(255, 99, 132, 1)',
		    'rgba(255, 99, 132, 1)',
		    'rgba(255, 99, 132, 1)',
		    'rgba(255, 99, 132, 1)',
		    'rgba(255, 99, 132, 1)',
		    'rgba(255, 99, 132, 1)'
	
	];
	var backgroundColor2= [
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)'
	  
	];

	var borderColor2=[
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)',
		'rgba(54, 162, 235, 1)'
	
	];

	

	var labels=['Matematica','Lengua','Ingles','Fisica','Quimica','TIC'];

	var data1=[12, 19, 3, 5, 2, 3];
	var data2=[3, 9, 13, 5, 12, 1];
	var pieColors=[ 'rgba(255, 99, 132, 1)','rgba(54, 162, 235, 1)','rgba(54, 100, 235, 1)',];
	
	//For a pie chart
	var ctx = document.getElementById('chart').getContext('2d');
	var myPieChart = new Chart(ctx, {
	    type: 'pie',
	    data: {
	        datasets: [{
	            data: [10, 20, 30],
	            backgroundColor:pieColors,
	            borderColor: pieColors,
	            borderWidth: 1
	        }],

	        labels: [
	            'Red',
	            'Yellow',
	            'Blue'
	        ]
	    },
	    options:{
	    	responsive:true,
	    	layout: {
	            padding: {
	                left: 50,
	                right: 0,
	                top: 0,
	                bottom: 0
	            		}
	    			},
	    	 scales: {
	    	            yAxes: [{
	    	                ticks: {
	    	                    beginAtZero: true
	    	                }
	    	            }]
	    	        },
	    	        
	    		}
	   
	});
	
});



function drawBarChart(labels,data1,data1,backgroundColor1,backgroundColor2,borderColor1,borderColor2){
	var ctx = document.getElementById('chart').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: labels,
	        datasets: [{
	            label: 'Aprobados',
	            data: data1,
	            backgroundColor:backgroundColor1,
	            borderColor: borderColor1,
	            borderWidth: 1
	        },
	        {
	        	  label: 'Desaprobados',
	              data: data2,
	              backgroundColor:backgroundColor2,
	              borderColor: borderColor2,
	              borderWidth: 1
	        }
	        ]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});

}





