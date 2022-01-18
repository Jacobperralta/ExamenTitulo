var btnRegistrar = document.getElementById('Registrar');
btnRegistrar.addEventListener('click', Registrar);
var correo, contraseña;

var msg=document.getElementById('msg');
function Registrar(e){
    correo= document.getElementById('Correo').value;
    contraseña= document.getElementById('Contraseña').value;
    if(correo){
        if(contraseña){
            msg.innerHTML="";
            axios.post('http://localhost:4567/Registrar',{
                correo: correo,
                contraseña: contraseña,
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
