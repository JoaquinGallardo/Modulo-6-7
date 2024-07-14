document.addEventListener('DOMContentLoaded', function() {
    const formulario = document.querySelector('form'); // Selecciona el formulario

    formulario.addEventListener('submit', function(event) {
        const nombre = document.getElementById("nombre").value;
        const rut = document.getElementById("rut").value;
        const password = document.getElementById("password").value;

        if (nombre.trim() === "" || rut.trim() === "" || password.trim() === "") {
            alert("Por favor, complete todos los campos.");
            event.preventDefault(); // Evitar que el formulario se envíe
        } else {
            alert("¡Usuario creado con éxito!");
            window.location.href="inicio.html"
        }
    });
});