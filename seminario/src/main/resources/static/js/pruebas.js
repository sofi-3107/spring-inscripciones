

$(document).ready(function(){
    
	$('input').each(function(){
		$(this).val('');
	});
	
    var fecha= new Date();
    var formatedDate= fecha.getFullYear+"-"+fecha.getDay+"-"+fecha.getMonth;
    console.log(formatedDate);
    
    
    /*Modal*/
    
    $('#consulta-dni').click(function (){
        $('#modal1').modal({backdrop:true});
        
    });
    $('#consulta-an').click(function (){
        $('#modal2').modal({backdrop:true});
        
    });
    $('#consulta-cd').click(function (){
        $('#modal3').modal({backdrop:true});
        
    });
    
    //CHARTS
    
    
    
    
    
    
});//FIN 
    




    
