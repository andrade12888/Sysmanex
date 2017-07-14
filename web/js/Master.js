$(document).ready(function () {
      
   // $('#divRolesUnidad').hide();  
    
    $('input[type=radio][name=rdPetenece]').change(function () {
        if (this.value === 'armada') {
            $('#divUsuarioUnidad').show();
            $('#divUsuarioEmpresa').hide();              
        } else if (this.value === 'empresa') {
            $('#divUsuarioUnidad').hide();
            $('#divUsuarioEmpresa').show();            
            
        }
    });
    $('input[type=radio][name=rdTipo]').change(function () {
        if (this.value === 'persona') {  
            $('#divTipoPersona').show();            
            $('#divTipoUnidad').show();  
            $('#divSigla').hide();
      
        } else if (this.value === 'unidad') {
            $('#divTipoPersona').hide();
            $('#divTipoUnidad').show();
            $('#divRolesUnidad').show();
            $('#divSigla').show();
        }
    });
    $("#input-1a").fileinput({'showUpload': false, 'previewFileType': 'any'});

    $(":text").click(function () {
        $("#errorMotivo").empty();
    });

    $(".bodyContent").click(function () {
        if (!$("#errorMotivo").empty())
            $("#errorMotivo").empty();
    });
    

    $("#lstRolesId").on('change',function(){
    var getValue=$(this).val();
    $("#defaultVal").val(getValue);
    alert(getValue);
  });
});

function errorTextoVacio(id)
{
    $("#" + id).val("Campo Mandatorio");
    $("#" + id).css({'color': 'red'});
    $("#" + id).focusin(function () {
        $("#" + id).val("");
        $("#" + id).css({'color': 'black'});
    });
}

function modalTramite(id) {
    $("#txtActualizarTramite").val($("#tdd" + id).text());
    $("#txtActualizarPlazo").val($("#tdp" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}

function modalEnvio(nroExp){
    $("#txtExpedienteEnvio").val(nroExp);
    $("#modalExpedienteLabel").html("Expediente N:"+nroExp);
    $("#modalExpediente").modal("show");
    
}

function controlTextoVacio(idForm,idTxt1,idTxt2,spanClass) {

   if ($("#" + idTxt1).val() && $("#" + idTxt2).val())
     {                  
         $("#"+idForm).submit();
      }

    if (!$("#" + idTxt1).val())
    {
        errorTextoVacio(idTxt1);
    }
    if (!$("#"+idTxt2).val())
    {
       if($("."+spanClass+":contains('*')").length<=0)
        {
            $("."+spanClass).append("<strong> * </strong>");
             $("."+spanClass).css({'color': 'red'});
             $("#"+idTxt2).focusin(function () {
                 $("."+spanClass).add("<span>").text("Plazo para tramitar");
                 $("."+spanClass).css({'color': 'black'});
            });
        }
    }

}

function modalMotivos(id) {
    $("#txtActualizarMotivo").val($("#tdd" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}

function agregarDestinatario() {
    var id = $("#selDestinatario").val();
    var destino = $("#selDestinatario option:selected").html();
    $("#selDestinatario option:selected").hide();
    $("#selDestinatario").find('option:first').attr('selected', 'selected');
    $("#selDestinos").append("<option value=\"" + id + "\" selected=\"selected\">" + destino + "</option>");
}

function quitarDestinatario() {
    var id = $("#selDestinos").val();
    $("#selDestinos option:selected").remove();

    $("#" + id).show();
}

function ExpedSiguiente() {

    if (!$("#idExpediente").val())
    {
        $("#idExpediente").val("Campo Mandatorio");
    }

    if (!$("#idAsunto").val())
    {
        $("#idAsunto").val("Campo Mandatorio");
        $('#idAsunto').css({'color': 'red'});
        $('#idAsunto').focusin(function () {
            $('#idAsunto').val("");
            $('#idAsunto').css({'color': 'black'});
        });

    } else {
        $("#pnlExpediente").fadeOut(500, function () {
            $("#txtExpedienteEnvio").val($("#txtExpediente").val());
            $("#fromExpediente").submit();
            $("#pnlDestinatarios").fadeIn(300);
        });
        return false;
    }
}

function ExpedAtras() {
    $("#pnlDestinatarios").fadeOut(500, function () {
        $("#pnlExpediente").fadeIn(300);
    });
    return false;
}

