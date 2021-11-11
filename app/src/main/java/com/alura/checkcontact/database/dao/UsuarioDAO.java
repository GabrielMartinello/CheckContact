package com.alura.checkcontact.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.alura.checkcontact.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Insert
    Long save(Usuario usuario);

    @Delete
    void remove(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Query("SELECT * FROM USUARIO")
    List<Usuario> getAll();

    @Query("SELECT count(*)!=0 FROM USUARIO WHERE ID = :uid ")
    boolean validPrimaryKey(String uid);

    @Query("SELECT ID, SENHA FROM USUARIO WHERE ID = :idUsuario")
    Usuario getUserById(String idUsuario);
}
