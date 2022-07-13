package com.example.PracticaSpringBoot.controllers;

import com.example.PracticaSpringBoot.dao.UsuarioDao;
import com.example.PracticaSpringBoot.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController  {
    @Autowired
    // inyeccion de dependencias implementa la interfaz UsuarioDaoImpl
    private UsuarioDao usuarioDao;

    //devuelve un listado completo de usuarios
    @RequestMapping (value="api/usuarios")
    public List<Usuario> getUsers() {
        return usuarioDao.getUsuarios();


    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        usuarioDao.deleteUser(id);
    }
    /*
     //devuelve un usuario

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public Usuario deleteUser(@PathVariable String id) {
        Usuario u = new Usuario();
        u.setEmail("pilaralonsosuela@gmail.com");
        u.setNombre("Pilar");
        u.setPassword("123");
        u.setTelefono("645654563");

        u.setApellidos("Alonso");
        return u;
    }
   @RequestMapping (value="usuario")
    public Usuario updateUser()
   {
       Usuario u=new Usuario();
       u.setEmail("pilaralonsosuela@gmail.com");
       u.setNombre("Pilar");
       u.setPassword("123");
       u.setTelefono("645654563");

       u.setApellidos("Alonso");
       return u;

}
    @RequestMapping (value="usuario")
    public Usuario deleteUser()
    {
        Usuario u=new Usuario();
        u.setEmail("pilaralonsosuela@gmail.com");
        u.setNombre("Pilar");
        u.setPassword("123");
        u.setTelefono("645654563");

        u.setApellidos("Alonso");
        return u;}
    @RequestMapping (value="usuario")
    public Usuario createUser()
    {
        Usuario u=new Usuario();
        u.setEmail("pilaralonsosuela@gmail.com");
        u.setNombre("Pilar");
        u.setPassword("123");
        u.setTelefono("645654563");

        u.setApellidos("Alonso");
        return u;}
    @RequestMapping (value="usuario")
    public Usuario findUser() {
        Usuario u = new Usuario();
        u.setEmail("pilaralonsosuela@gmail.com");
        u.setNombre("Pilar");
        u.setPassword("123");
        u.setTelefono("645654563");

        u.setApellidos("Alonso");
        return u;
    }

*/
    }
