package com.example.PracticaSpringBoot.dao;

import com.example.PracticaSpringBoot.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
}
