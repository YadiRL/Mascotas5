package com.example.yadira.mascotasmenusfragments.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.yadira.mascotasmenusfragments.R;
import com.example.yadira.mascotasmenusfragments.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 6/3/2017.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);

        ArrayList<Mascota> temporal = db.obtenerTodasLasMascotas();

        int numeroMascotas = temporal.size();

        if(numeroMascotas == 0) {
            insertarMascotas(db);
            temporal =  db.obtenerTodasLasMascotas();
        }

        return temporal;
    }

    //Las mascotas ya debieron ser creadas al ingresar a la aplicacion
    public ArrayList<Mascota> obtenerDatosTopCinco(){
        BaseDatos db = new BaseDatos(context);
        //insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public  void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Bruto));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.chino);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Cocky));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.huesos);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Sammy));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.maylon);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Lebre));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dollar);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Kira));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.huitlacoche);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Tile));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.lucesita);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Lolo));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pansas);

        db.insertarMascotas(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Tile));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.ax);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.Rock));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dior);

        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
