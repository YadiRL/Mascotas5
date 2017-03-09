package com.example.yadira.mascotasmenusfragments.presentador;

import android.content.Context;

import com.example.yadira.mascotasmenusfragments.db.ConstructorMascotas;
import com.example.yadira.mascotasmenusfragments.pojo.Mascota;
import com.example.yadira.mascotasmenusfragments.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 6/3/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> listaMascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        listaMascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(listaMascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
