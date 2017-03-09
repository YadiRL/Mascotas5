package com.example.yadira.mascotasmenusfragments.fragment;

import com.example.yadira.mascotasmenusfragments.adapter.MascotaAdaptador;
import com.example.yadira.mascotasmenusfragments.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 6/3/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);
}
