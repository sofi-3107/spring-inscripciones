$(function() {
	$(".delete").click(function() {
		confirm("desea eliminar al alumno??");
	});

	// Permite ocultar la alerta verde luego de una carga.
	$(".alert").click(function() {
		$(".alert").hide("slow");
	});
	// PRUEBA AJAX
	$("#ajaxBtn").click(
			function(data) {

				$.ajax({
					url : "/MyJson",
					type : "GET",
					dataType : "json",
					success : function(data) {
						$.each(data, function(key, value) {
							console.log(value.nombre + "\n" + value.apellido
									+ "\n" + value.dni);
						});

					},
					error : function(e) {
						console.log("There was an error, could not complete: "
								+ e);
					},
				});

			});
	// PRUEBA JSPDF

	$("#crearPdf").click(function() {
		var doc = new jsPDF();
		doc.text(60, 20, 'Datos Personales del alumno');
		doc.text(20, 30, 'Apellido: '+$("input[name='apellido']").val());
		doc.text(20, 40, 'Nombre: '+$("input[name='nombre']").val());
		doc.text(20, 50, 'DNI: '+$("input[name='dni']").val());
		doc.text(20,60, 'Edad: ');
		doc.text(40,60,$("input[name='nacimiento']").val());
		doc.text(20, 90, 'Firma del Tutor: ________________________');
		/* Add new page
		doc.addPage();
		doc.text(20, 20, 'Visita programacion.net');*/

		// Save the PDF
		doc.save('formulario.pdf');
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
