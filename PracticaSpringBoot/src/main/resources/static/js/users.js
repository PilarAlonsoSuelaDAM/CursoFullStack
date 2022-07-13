// Call the dataTables jQuery plugin
$(document).ready(function() {
//llama a la función antes de que se inicie
cargarUsers();
  $('#usuariosTabla').DataTable();
});


//función asincronica porque utilizamos await, es decir esperará a una respuesta
async function cargarUsers(){
//URL
  const request = await fetch('api/usuarios', {
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
      let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

  //Almaceno el usuario en una variable
  let usuarioHTML=' <tr><td>'+usuario.nombre+'</td><td>'+usuario.apellidos+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'
  + '</td><td>' + botonEliminar + '</td></tr>'; ;
  listadoHtml+=usuarioHTML;
  }
  //muestro en el tbody los usuarios recorridos
  document.querySelector('#usuariosTabla tbody').outerHTML=listadoHtml;

  async function eliminarUsuario(id) {

    if (!confirm('¿Desea eliminar este usuario?')) {
      return;
    }

   const request = await fetch('api/usuarios/' + id, {
      method: 'DELETE',
      headers: getHeaders()
    });


  }

}