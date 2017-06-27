$(document).ready(function () {
    $('input[type=radio][name=rdPetenece]').change(function () {
        if (this.value == 'armada') {
            $('#divUsuarioUnidad').show();
            $('#divUsuarioEmpresa').hide();
        } else if (this.value == 'empresa') {
            $('#divUsuarioUnidad').hide();
            $('#divUsuarioEmpresa').show();
        }
    });
    $('input[type=radio][name=rdTipo]').change(function () {
        if (this.value == 'persona') {
            $('#divTipoPersona').show();
            $('#divTipoUnidad').hide();
        } else if (this.value == 'unidad') {
            $('#divTipoPersona').hide();
            $('#divTipoUnidad').show();
        }
    });
    $("#input-1a").fileinput({'showUpload':false, 'previewFileType':'any'});
});
function modalTramite(id) {
    $("#txtActualizarTramite").val($("#tdd" + id).text());
    $("#txtActualizarPlazo").val($("#tdp" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}
function modalDestinatarios(id) {
    $("#modalExpedienteLabel").html("Enviar expediente N:"+id);
}
function agregarDestinatario(){
    var id = $("#selDestinatario").val();
    var destino = $("#selDestinatario option:selected").html();
    $("#selDestinatario option:selected").hide();
    $("#selDestinatario").find('option:first').attr('selected', 'selected');
    $("#selDestinos").append("<option value=\""+id+"\">"+destino+"</option>");
}
function quitarDestinatario(){
    var id = $("#selDestinos").val();
    $("#selDestinos option:selected").remove();

    $("#"+id).show();
}

function ExpedSiguiente(){
    $("#pnlExpediente").fadeOut(500, function(){
        $("#pnlDestinatarios").fadeIn(300);
    });    
  return false;
}
function ExpedAtras(){
    $("#pnlDestinatarios").fadeOut(500, function(){
        $("#pnlExpediente").fadeIn(300);
    });    
  return false;
}