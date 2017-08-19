$(document).ready(function () {

    $('INPUT[type="file"]').change(function (){
        $("span[class='hidden-xs']").click(function(){              
              $("#uploadButton").prop('disabled',null);        
    });
});
    
    $('INPUT[type="file"]').change(function () {
    var ext = this.value.match(/\.(.+)$/)[1];
    switch (ext) {
        case 'jpg':$('#uploadButton').attr('disabled', true);
            break;
        case 'jpeg':$('#uploadButton').attr('disabled', true);
            break;
        case 'png':$('#uploadButton').attr('disabled', true);
            break;
        case 'exe':
            $('#uploadButton').attr('disabled', true);
            break;
        case '':$('#uploadButton').attr('disabled', true);
            break;
        case 'txt':
        break;
        case 'pdf':
        break;
        case 'docx':
        break;
        case 'doc':
        break;        
        default:
            alert('This is not an allowed file type.');
            this.value = '';
    }
});
    
    $(".doc").fancybox({
        openEffect: 'none',
        closeEffect: 'none',
        iframe: {
            preload: false
        }
    });
    $('.dropdown-submenu a.test').on("click", function (e) {
        $(this).next('ul').toggle();
        e.stopPropagation();
        e.preventDefault();
    });
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
            $("#divTipoPersona :input").prop('required', true);
            $('#divTipoPersona').show();
            $('#divTipoUnidad').hide();

        } else if (this.value === 'unidad') {
            $("#divTipoPersona :input").prop('required', null);
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

    $("select").on('change', function () {
        var getValue = $(this).val();
        $("#defaultVal").val(getValue);
    });

    $("#borrarButton").click(function () {        
            $("#uploadButton").prop('disabled',null);        
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

function doSearch()
{
    var tablaDatos = document.getElementById('datos');
    var textoBuscado = document.getElementById('txtBuscar').value.toLowerCase();
    var celdasDelRow = "";
    var encontro = false;
    var comparCon = "";
    for (var i = 1; i < tablaDatos.rows.length; i++)
    {
        celdasDelRow = tablaDatos.rows[i].getElementsByTagName('td');
        encontro = false;
        for (var j = 0; j < celdasDelRow.length && !encontro; j++)
        {
            comparCon = celdasDelRow[j].innerHTML.toLowerCase();
            if (textoBuscado.length === 0 || (comparCon.indexOf(textoBuscado) > -1))
            {
                encontro = true;
            }
        }
        if (encontro)
        {
            tablaDatos.rows[i].style.display = '';
        } else {
            tablaDatos.rows[i].style.display = 'none';
        }
    }
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

function modalEliminarTramite(id) {
    
    $("#btnEliTramite").val(id);
}

function modalEliminarExpediente(id) {
    
    $("#btnEliExp").val(id);
}

function modalEliminarMotivo(id) {
    
    $("#btnEliMotivo").val(id);
}

function modalEliminarPersona(id) {
    
    $("#btnEliPer").val("Delete"+id);
}

function modalEliminarUnidad(id) {    
    $("#btnEliUni").val("Delete"+id);
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

function modalPersonas(id) {
    $("#txtActualizarNombre").val($("#tdd" + id).text());
    $("#txtActualizarApellido").val($("#apellido" + id).text());
    $("#txtActualizarEmail").val($("#email" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}

function modalUnidades(id) {
    $("#txtActualizarNombre").val($("#tdd" + id).text());
    $("#txtActualizarId").val($("#id" + id).val());
}
function modalEmpresas(id) {
    $("#txtActualizarNombre").val($("#tdd" + id).text());
    $("#txtActualizarRUT").val($("#id" + id).val());
    $("#txtViejoRUT").attr("value", id);

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