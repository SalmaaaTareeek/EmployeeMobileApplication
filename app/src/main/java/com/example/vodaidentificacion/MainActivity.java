package com.example.vodaidentificacion;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;  //For Set Support Action
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer_Layout;
    ImageView GenerateQR;
    NavigationView navigation_View;
    Toolbar tool_Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Start Relating Variables with Layouts
        drawer_Layout = (DrawerLayout) findViewById(R.id.DL_DrawerLayout);
        navigation_View = (NavigationView) findViewById(R.id.nav_view);
        tool_Bar = (Toolbar) findViewById(R.id.TB_toolbar);
        //////////////////////////////////

        /* Tool Bar */
        setSupportActionBar(tool_Bar);



        /* Navigation Bar */

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_Layout, tool_Bar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_Layout.addDrawerListener(toggle);
        toggle.syncState();

        GenerateQR=(ImageView)findViewById(R.id.IM_QRCode);

        GenerateQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QRCodeGeneration.class);
                startActivity(intent);
            }

        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.userprofile:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}