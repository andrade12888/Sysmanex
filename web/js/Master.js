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
function agregarDestinatario(){
    var id = $("#selDestinatario").val();
    var destino = $("#selDestinatario option:selected").html();
    $("#selDestinos").append("<option value=\""+id+"\">"+destino+"</option>");
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