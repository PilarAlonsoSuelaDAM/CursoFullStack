package com.example.PracticaSpringBoot.dao;

import com.example.PracticaSpringBoot.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{
    //nos sirve para hacer la conexion a la bd
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();


    }

    @Override
    public void deleteUser(long id) {

        Usuario usuario= entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);

    }

}
