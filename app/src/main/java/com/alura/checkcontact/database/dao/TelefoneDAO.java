package com.alura.checkcontact.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alura.checkcontact.model.Telefone;

import java.util.List;

@Dao
public interface TelefoneDAO {

    @Insert
    void salva(Telefone... telefones);

    @Query("SELECT * FROM TELEFONE WHERE usuarioId = :usuarioId")
    List<Telefone> buscaTelefonesDoUsuario(String usuarioId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(Telefone... telefones);

    @Delete
    void deleteTelefone(Telefone telefone);
}
