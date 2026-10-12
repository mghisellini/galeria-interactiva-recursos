function validarFormulario() {

    alert("Entró a validar");

    let nombre = document.getElementById("nombre").value.trim();
    let correo = document.getElementById("correo").value.trim();
    let empresa = document.getElementById("empresa").value.trim();
    let asunto = document.getElementById("asunto").value.trim();
    let mensaje = document.getElementById("mensaje").value.trim();

    if (nombre === "" || correo === "" || empresa === "" || asunto === "" || mensaje === "") {
        alert("Todos los campos son obligatorios.");
        return false;
    }

    let regexNombre = /^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$/;
    let regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!regexNombre.test(nombre)) {
        alert("El nombre solo debe contener letras.");
        return false;
    }

    if (!regexCorreo.test(correo)) {
        alert("Ingrese un correo electrónico válido.");
        return false;
    }

    alert("Formulario enviado correctamente.");
    return true;
}

function mostrarDatos() {
    let contacto = {
        nombre: "Juan Pérez",
        empresa: "Empresa ABC",
        correo: "juan@empresa.com"
    };

    let servicios = [
        "Atención al cliente",
        "Soporte técnico",
        "Asesoría empresarial"
    ];

    document.getElementById("resultadoDatos").innerHTML =
        "<p><strong>Nombre:</strong> " + contacto.nombre + "</p>" +
        "<p><strong>Empresa:</strong> " + contacto.empresa + "</p>" +
        "<p><strong>Correo:</strong> " + contacto.correo + "</p>" +
        "<p><strong>Servicio:</strong> " + servicios[0] + "</p>";
}

function mostrarServicios() {
    let empresa = {
        nombre: "Empresa ABC",
        ciudad: "Santo Domingo"
    };

    let servicios = [
        "Atención al cliente",
        "Soporte técnico",
        "Asesoría empresarial",
        "Información de productos"
    ];

    let texto = "<strong>" + empresa.nombre + "</strong><br>";
    texto += "Ciudad: " + empresa.ciudad + "<br><br>";
    texto += "Servicios:<br>";

    for (let i = 0; i < servicios.length; i++) {
        texto += "- " + servicios[i] + "<br>";
    }

    document.getElementById("resultado").innerHTML = texto;
}

function mostrarMensajeApplet() {
    document.getElementById("mensajeApplet").innerHTML =
        "Este formulario utiliza HTML5, CSS y JavaScript como reemplazo moderno de los Applets de Java.";
}