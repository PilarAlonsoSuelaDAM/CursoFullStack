// Call the dataTables jQuery plugin
$(document).ready(function() {
//llama a la función antes de que se inicie
cargarUsers();
  $('#usuariosTabla').DataTable();
});


//función asincronica porque utilizamos await, es decir esperará a una respuesta
async function cargarUsers(){
//URL
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
    //El contenido va a ser json
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }

  });
  //almacena un listado de usuarios en json
  const users = await request.json();
  console.log(users);

  let listadoHtml='';
  for(let usuario of users){
  //Almaceno el usuario en una variable
  let usuarioHTML=' <tr><td>'+usuario.nombre+'</td><td>'+usuario.apellidos+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'
  +usuario.id+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td> </tr>' ;
  listadoHtml+=usuarioHTML;
  }
  //muestro en el tbody los usuarios recorridos
  document.querySelector('#usuariosTabla tbody').outerHTML=listadoHtml;

}