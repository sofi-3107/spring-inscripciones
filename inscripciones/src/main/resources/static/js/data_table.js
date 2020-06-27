$(function(){

      ajaxAllAndId('http://localhost:8080/api/users/find',mapById,5);

     /* $.ajax({
            url:'http://localhost:8080/api/usuarios',
            success: function(dato){
                console.log(dato);
            },
            Type:'GET',
            dataType :"json",
            error: function(error){console.log(error)}
      });*/


                  function mapAll(dato){
                        $.map(dato,function(i){
                              $('tbody').append(
                                    '<tr>'+
                                          '<td>'+i.id+'</td>'+
                                          '<td>'+i.userName+'</td>'+
                                          '<td>'+i.password+'</td>'+
                                          '<td>'+i.rol+'</td>'+
                                    '</tr>'
                              )
                  });}



                     function mapById(dato){                      
                              $('tbody').append(
                                    '<tr>'+
                                          '<td>'+dato.id+'</td>'+
                                          '<td>'+dato.userName+'</td>'+
                                          '<td>'+dato.password+'</td>'+
                                          '<td>'+dato.rol+'</td>'+
                                    '</tr>'
                              )
                         }


                  function ajaxAllAndId(url,mapMethod,id){
                           console.log(url+'?'+'id='+id);
                        $.ajax({
                              url:url+'?'+'id='+id,
                              success: function(dato){
                              console.log(dato);
                                    mapMethod(dato)
                              },
                              Type:'GET',
                              dataType :"json",
                              error: function(error){console.log(error)}
                         });
                         
                  }
      




});