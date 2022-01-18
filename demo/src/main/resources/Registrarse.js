var btnRegistrar = document.getElementById("Registrarse");
btnRegistrar.addEventListener('click', registrarse);
var correo, contraseña;
var msg=document.getElementById('msg');
function registrarse(e){
    correo= document.getElementById('Correo');
    contraseña= document.getElementById('Contraseña');
    if(correo){
        if(contraseña){
            msg.innerHTML="";
            axios.post('http://localhost:4567/Registrar',{
                Correo: correo,
                Contraseña: contraseña,
                completed: false
            })

            .then(function (response){
                console.log(response.data);
                if(response.data === 'SI'){
                    msg.innerHTML="Registro completado";
                }else{
                    msg.innerHTML="Ese Correo ya está registrado";
                }
            })
            .catch(function(error){
                console.log(error);
            });
        }else{
            msg.innerHTML="Falta el correo";
        }
    }else{
        msg.innerHTML="Falta la contraseña";
    }
}

function volver(){
    window.location.href="Login.html";
}
