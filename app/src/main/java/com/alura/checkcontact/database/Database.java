package com.alura.checkcontact.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.alura.checkcontact.database.converter.ConversorTelefone;
import com.alura.checkcontact.database.dao.UsuarioDAO;
import com.alura.checkcontact.model.Telefone;
import com.alura.checkcontact.model.Usuario;

@androidx.room.Database(entities = {Usuario.class, Telefone.class}, version = 1, exportSchema = false)
@TypeConverters({ConversorTelefone.class})
public abstract class Database extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "checkcontact.db";
    public abstract UsuarioDAO getRoomUsuarioDAO();

    public static Database getInstance(Context context) {
        return Room.databaseBuilder(context, Database.class, NOME_BANCO_DE_DADOS).addMigrations().allowMainThreadQueries().build();
    }

}
