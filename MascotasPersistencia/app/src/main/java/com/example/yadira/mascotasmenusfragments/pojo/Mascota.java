package com.example.yadira.mascotasmenusfragments.pojo;

import android.content.Context;

import com.example.yadira.mascotasmenusfragments.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by fcarvajal on 19/2/2017.
 */

public class Mascota implements Serializable {

    private int id;
    private String nombre;
    private int raiting;
    private int foto;

    public Mascota(String nombre, int foto){
        this.nombre = nombre;
        //this.raiting = raiting;
        this.foto = foto;
    }
    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public String getRaiting_string() {
        return getRaiting() + "";
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void setRaiting() {
        this.raiting = this.raiting + 1;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public static ArrayList<Mascota> inicialiarListaMascotas(Context context) {

        ArrayList<Mascota> ListaMascotas = new ArrayList<Mascota>();

        ListaMascotas.add(new Mascota(context.getString(R.string.Bruto),  R.drawable.chino));
        ListaMascotas.add(new Mascota(context.getString(R.string.Cocky),  R.drawable.huesos));
        ListaMascotas.add(new Mascota(context.getString(R.string.Sammy),  R.drawable.maylon));
        ListaMascotas.add(new Mascota(context.getString(R.string.Lebre),  R.drawable.dollar));
        ListaMascotas.add(new Mascota(context.getString(R.string.Jack),  R.drawable.huitlacoche));
        ListaMascotas.add(new Mascota(context.getString(R.string.Kira),  R.drawable.lucesita));
        ListaMascotas.add(new Mascota(context.getString(R.string.Tile),  R.drawable.pansas));
        ListaMascotas.add(new Mascota(context.getString(R.string.Rock), R.drawable.ax));
        ListaMascotas.add(new Mascota(context.getString(R.string.Lolo), R.drawable.dior));
        return  ListaMascotas;
    }
    public static ArrayList<Mascota> inicialiarListaBruto(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Bruto), R.drawable.chino);
    }

    public static ArrayList<Mascota> inicialiarListaCocky(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Cocky), R.drawable.huesos);
    }

    public static ArrayList<Mascota> inicialiarListaJack(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Jack), R.drawable.huitlacoche);
    }

    public static ArrayList<Mascota> inicialiarListaKira(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Kira), R.drawable.lucesita);
    }

    public static ArrayList<Mascota> inicialiarListaLebre(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Lebre), R.drawable.dollar);
    }

    public static ArrayList<Mascota> inicialiarListaLolo(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Lolo), R.drawable.dior);
    }

    public static ArrayList<Mascota> inicialiarListaRock(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Rock), R.drawable.ax);
    }

    public static ArrayList<Mascota> inicialiarListaSammy(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Sammy), R.drawable.maylon);
    }

    public static ArrayList<Mascota> inicialiarListaTile(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.Tile), R.drawable.pansas);
    }


    public static ArrayList<Mascota> inicialiarListaMascotaIndividual(String nombre, int imagen) {

        ArrayList<Mascota> ListaMascotas = new ArrayList<Mascota>();

        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre,imagen));
        ListaMascotas.add(new Mascota(nombre,imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre,  imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));

        return  ListaMascotas;
    }

}
