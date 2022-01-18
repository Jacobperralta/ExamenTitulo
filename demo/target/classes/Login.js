var btnIngresar = document.getElementById('Ingresar');
var correo, contraseña;

btnIngresar.addEventListener('click', Ingresar);
function Ingresar(e){
    correo = document.getElementById('Correo').value;
    contraseña= document.getElementById('Contraseña').value;
    if(correo){
        if(contraseña){
            axios.post('http://localhost:4567/Ingresar',{
                correo: correo,
                contraseña: contraseña,
                completed: false
            })
            .then(function(response){
                console.log(response.data);
                if(response.data === 'SI'){
                    document.getElementById('msg').innerHTML="Acceso concedido. ";
                    window.location.href="/DatosUsuario.html?correo=" + correo;
                }else{
                    document.getElementById('msg').innerHTML="Acceso denegado, verifique sus datos";
                }
            })
            .catch(function(error){
                console.log(error);
            });
        }else{
            document.getElementById('msg').innerHTML="Falta la contraseña";
        } 
    }else{
        document.getElementById('msg').innerHTML="Falta el correo";
    }
}

function registrarse(){
    window.location.href="Registrarse.html";
}