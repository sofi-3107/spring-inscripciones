$(function() {
	$(".delete").click(function() {
		confirm("desea eliminar al alumno??");
	});

	$(".alert").click(function() {
		$(".alert").hide("slow");
	});
	// PRUEBA AJAX
	$("#ajaxbtn").click(function() {
		$.get("url", function(data) {
			console.log(data[0]);
		});

	});

	// DATEPICKER JQUERY.U, CONFIGURADO

	$("#fechaNac").datepicker(
			{
				changeMonth : true,
				changeYear : true,
				yearRange : '2000:2020',
				dateFormat : 'dd-mm-yy',
				firstDay : 1,
				closeText : 'Cerrar',
				prevText : '< Ant',
				nextText : 'Sig >',
				currentText : 'Hoy',
				monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
						'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre',
						'Noviembre', 'Diciembre' ],
				monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
						'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
				dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miércoles',
						'Jueves', 'Viernes', 'Sábado' ],
				dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie',
						'Sáb' ],
				dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá' ],
				weekHeader : 'Sm'
			});

	/* HASTA AQUI LA CONFIGURACION */

	if ($("#fechaNac").val() == "" || $("#fechaNac").val() == null) {

		$("#fechaNulaError").show().text("Este campo es obligatorio");
	}

	$("#fechaNac").change(function() {
		console.log($("#fechaNac").val());

	});

	

});
