package com.kfc.julianalmanza.kfc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Productos extends AppCompatActivity {
    private ViewPager mViewPager;

    String nombre,contraseña,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Bundle extra =getIntent().getExtras();
        nombre=extra.getString("nombre");
        contraseña=extra.getString("contraseña");
        correo=extra.getString("correo");

        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Pollo").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Sandwiches").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Refrescos").setTabListener(tabListener);
        actionBar.addTab (tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });

}

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Pollo_fragment();
            case 1:
                return new sandwiches_fragment();
            case 2:
                return new Refrescos_fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case (R.id.Miperfil):
                Intent intent= new Intent(this,Miperfil.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("contraseña",contraseña);
                intent.putExtra("correo",correo);
                finish();
                startActivity(intent);
            break;
            case(R.id.MainActivity):
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
