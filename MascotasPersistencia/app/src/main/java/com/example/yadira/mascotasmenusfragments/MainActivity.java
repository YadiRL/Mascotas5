package com.example.yadira.mascotasmenusfragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.internal.app.ToolbarActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yadira.mascotasmenusfragments.adapter.DetalleMascotaAdaptador;
import com.example.yadira.mascotasmenusfragments.adapter.MascotaAdaptador;
import com.example.yadira.mascotasmenusfragments.adapter.PageAdapter;
import com.example.yadira.mascotasmenusfragments.fragment.PerfilFragment;
import com.example.yadira.mascotasmenusfragments.fragment.RecyclerViewFragment;
import com.example.yadira.mascotasmenusfragments.pojo.Mascota;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //public ArrayList<Mascota> ListaMascotas;
    //public ArrayList<Mascota> ListaMascotaSeleccionada;
    ArrayList<Mascota> ListaMascotaSeleccionada = new ArrayList<Mascota>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListaMascotas = Mascota.inicialiarListaMascotas(this);
        ListaMascotaSeleccionada = Mascota.inicialiarListaBruto(this);

        setToolbar();
        setFloatingActionButton();
        setUpViewPager();
    }

    //pone en orbita los fragments
    private void setUpViewPager(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager_load(viewPager);
    }

    private void setUpViewPager_load(ViewPager viewPager){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_filled);
    }

    //Crea la lista de fragments que se agregan luego al viewpager
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        /*RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        recyclerViewFragment.setListaMascotas(ListaMascotas);

        PerfilFragment perfilFragment = new PerfilFragment();
        perfilFragment.setListaDetalleMascota(ListaMascotaSeleccionada);

        fragments.add(recyclerViewFragment);
        fragments.add(perfilFragment);*/
        PerfilFragment perfilFragment = new PerfilFragment();
        perfilFragment.setListaDetalleMascota(ListaMascotaSeleccionada);

        fragments.add(new RecyclerViewFragment());
        fragments.add(perfilFragment);

        return fragments;
    }

    //MENU OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_contact:
                Intent intentFC = new Intent(this, FormularioContactoActivity.class);
                startActivity(intentFC);
                break;

            case R.id.menu_about:
                Intent intentAD = new Intent(this, AcercaDeActivity.class);
                startActivity(intentAD);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);

            TextView tvTitulo = (TextView) findViewById(R.id.toolbar_tvTitulo);
            tvTitulo.setText(R.string.ap_titulo);

//            ImageView imgEstrella = (ImageView) findViewById(R.id.toolbar_imgEstrella);
//            imgEstrella.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    irTopCinco(v);
//                }
//            });
        }
    }

    public void setFloatingActionButton()
    {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.clic_fab), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void irTopCinco(View v){
        Toast.makeText(MainActivity.this, getString(R.string.clic_top_cinco), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, TopCincoActivity.class);
        intent.putExtra("dummy", true);
        //intent.putExtra(String.valueOf(R.string.lista_serializada_mascotas), ListaMascotas);

        MainActivity.this.startActivity(intent);
    }

    public void irDetalleMascota(View v) {
        ImageView imageView = (ImageView) v;

        Drawable drawable = imageView.getDrawable();


        ArrayList<Mascota> ListaTemporal = null;

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.chino)))){
            ListaTemporal = Mascota.inicialiarListaBruto(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.ax)))){
            ListaTemporal = Mascota.inicialiarListaCocky(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.huitlacoche)))){
            ListaTemporal = Mascota.inicialiarListaKira(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.dollar)))){
            ListaTemporal = Mascota.inicialiarListaJack(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.dior)))){
            ListaTemporal = Mascota.inicialiarListaLebre(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.lucesita)))){
            ListaTemporal = Mascota.inicialiarListaLolo(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.maylon)))){
            ListaTemporal = Mascota.inicialiarListaRock(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.pansas)))){
            ListaTemporal = Mascota.inicialiarListaSammy(this);
        }

        if(getBitmap(drawable).sameAs(getBitmap(getResources().getDrawable(R.drawable.huesos)))){
            ListaTemporal = Mascota.inicialiarListaTile(this);
        }


        for(int i = 0; i < ListaTemporal.size(); i++){

            ListaMascotaSeleccionada.set(i, ListaTemporal.get(i));
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager_load(viewPager);

        viewPager.setCurrentItem(1);
    }

    public static Bitmap getBitmap(Drawable drawable) {
        Bitmap result;
        if (drawable instanceof BitmapDrawable) {
            result = ((BitmapDrawable) drawable).getBitmap();
        } else {
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            // Some drawables have no intrinsic width - e.g. solid colours.
            if (width <= 0) {
                width = 1;
            }
            if (height <= 0) {
                height = 1;
            }

            result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        return result;
    }

}
