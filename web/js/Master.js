$(document).ready(function () {

    $('input[type=radio][name=rdPetenece]').change(function () {
        if (this.value === 'armada') {
            $('#divUsuarioUnidad').show();
            $('#divUsuarioEmpresa').hide();
            $('#divSigla').show();
        } else if (this.value === 'empresa') {
            $('#divUsuarioUnidad').hide();
            $('#divUsuarioEmpresa').show();
            $('#divSigla').hide();

        }
    });
    $('input[type=radio][name=rdTipo]').change(function () {
        if (this.value === 'persona') {
            $("#divTipoPersona :input").prop('required', true);
            $('#divTipoPersona').show();
            $('#divTipoUnidad').show();
            if ($('#divSigla').is(":visible"))
                $('#divSigla').hide();
            if ($('#rdarmada').is(':checked')) {
                $('#divSigla').show();
            }

        } else if (this.value === 'unidad') {
            $("#divTipoPersona :input").prop('required', null);
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

    $("select").on('change', function () {
        var getValue = $(this).val();
        $("#defaultVal").val(getValue);
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

function modalEnvio(nroExp) {
    $("#txtExpedienteEnvio").val(nroExp);
    $("#modalExpedienteLabel").html("Expediente N:" + nroExp);
    $("#modalExpediente").modal("show");

}

function controlTextoVacio(idForm, idTxt1, idTxt2, spanClass) {

    if ($("#" + idTxt1).val() && $("#" + idTxt2).val())
    {
        $("#" + idForm).submit();
    }

    if (!$("#" + idTxt1).val())
    {
        errorTextoVacio(idTxt1);
    }
    if (!$("#" + idTxt2).val())
    {
        if ($("." + spanClass + ":contains('*')").length <= 0)
        {
            $("." + spanClass).append("<strong> * </strong>");
            $("." + spanClass).css({'color': 'red'});
            $("#" + idTxt2).focusin(function () {
                $("." + spanClass).add("<span>").text("Plazo para tramitar");
                $("." + spanClass).css({'color': 'black'});
            });
        }
    }

}

function modalMotivos(id) {
    $("#txtActualizarMotivo").val($("#tdd" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}

function modalEmpresas(id) {
    $("#txtActualizarNombre").val($("#tdd" + id).text());
    $("#txtActualizarRUT").val($("#id" + id).val());
}

function agregarDestinatario() {
    var id = $("#selDestinatario").val();
    var destino = $("#selDestinatario option:selected").html();
    if (id !== '0') {
        $("#selDestinatario option:selected").hide();
        $("#selDestinatario").find('option:first').attr('selected', 'selected');
        $("#selDestinos").append("<option value=\"" + id + "\" selected=\"selected\">" + destino + "</option>");
    }

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

