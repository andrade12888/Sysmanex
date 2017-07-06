$(document).ready(function () {
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
            $('#divTipoUnidad').hide();
        } else if (this.value === 'unidad') {
            $('#divTipoPersona').hide();
            $('#divTipoUnidad').show();
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
});

function controlTextoVacio(id)
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

function controlTextoVacio(idForm,idTxt1,idTxt2,spanClass) {

    if ($("#" + idTxt1).val() && $("#" + idTxt2).val())
    {                  
        $("#"+idForm).submit();
    }

    if (!$("#" + idTxt1).val())
    {
        controlTextoVacio(idTxt1);
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

function modalDestinatarios(id) {
    $("#modalExpedienteLabel").html("Enviar expediente N:" + id);
}

function agregarDestinatario() {
    var id = $("#selDestinatario").val();
    var destino = $("#selDestinatario option:selected").html();
    $("#selDestinatario option:selected").hide();
    $("#selDestinatario").find('option:first').attr('selected', 'selected');
    $("#selDestinos").append("<option value=\"" + id + "\">" + destino + "</option>");
}

function quitarDestinatario() {
    var id = $("#selDestinos").val();
    $("#selDestinos option:selected").remove();

    $("#" + id).show();
}

function ExpedSiguiente() {
    
    if ($("#idExpediente").val()&&$("#idAsunto").val())
    {
        $("#pnlExpediente").fadeOut(500, function () {
            $("#txtExpedienteEnvio").val($("#txtExpediente").val());
            $("#fromExpediente").submit();
            $("#pnlDestinatarios").fadeIn(300);
        });
    }

    if (!$("#idExpediente").val())
    {
        $(".spanExpeditene").append("<strong> * </strong>");

            $(".spanExpeditene").css({'color': 'red'});
            $(".bodyContent").focusin(function () {
                $(".spanExpeditene").add("<span>").text("Nº Expediente");
                $(".spanExpeditene").css({'color': 'black'});
            });
    }

    if (!$("#idAsunto").val())
    {
        $("#idAsunto").val("Campo Mandatorio");
        $('#idAsunto').css({'color': 'red'});
        $('#idAsunto').focusin(function () {
            $('#idAsunto').val("");
            $('#idAsunto').css({'color': 'black'});
        });

    } 
        return false;
    
}

function ExpedAtras() {
    $("#pnlDestinatarios").fadeOut(500, function () {
        $("#pnlExpediente").fadeIn(300);
    });
    return false;
}

