package com.alura.checkcontact.database.converter;

import androidx.room.TypeConverter;

import com.alura.checkcontact.model.TipoTelefone;

public class ConversorTelefone {

    @TypeConverter
    public String paraString(TipoTelefone valor) {
        return valor.name();
    }

    @TypeConverter
    public TipoTelefone paraTipoTelefone(String valor) {
        if(valor != null) {
            return TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }
}
