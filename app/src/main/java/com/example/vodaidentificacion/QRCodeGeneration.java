package com.example.vodaidentificacion;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.WriterException;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import android.os.Bundle;

public class QRCodeGeneration extends AppCompatActivity {

    private ImageView qrCodeIV;
    private Button generateQrBtn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    private DrawerLayout drawer_Layout;
    ImageView GenerateQR;
    NavigationView navigation_View;
    Toolbar tool_Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generation);

        drawer_Layout = (DrawerLayout) findViewById(R.id.DL_DrawerLayout);
        navigation_View = (NavigationView) findViewById(R.id.nav_view);
        tool_Bar = (Toolbar) findViewById(R.id.TB_toolbar);
        setSupportActionBar(tool_Bar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_Layout, tool_Bar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_Layout.addDrawerListener(toggle);
        toggle.syncState();
        Login login=new Login();

        String username= "salma.elmosalamy@vodafone.com";
        String password= "asd";
        qrCodeIV = findViewById(R.id.idIVQrcode);
        generateQrBtn = findViewById(R.id.idBtnGenerateQR);
        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                // initializing a variable for default display.
                Display display = manager.getDefaultDisplay();

                // creating a variable for point which
                // is to be displayed in QR Code.
                Point point = new Point();
                display.getSize(point);

                // getting width and
                // height of a point
                int width = point.x;
                int height = point.y;

                // generating dimension from width and height.
                int dimen = width < height ? width : height;
                dimen = dimen * 3 / 4;

                // setting this dimensions inside our qr code
                // encoder to generate our qr code.
                qrgEncoder = new QRGEncoder(username + password, null, QRGContents.Type.TEXT, dimen);
                try {
                    // getting our qrcode in the form of bitmap.
                    bitmap = qrgEncoder.encodeAsBitmap();
                    // the bitmap is set inside our image
                    // view using .setimagebitmap method.
                    qrCodeIV.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    // this method is called for
                    // exception handling.
                    Log.e("Tag", e.toString());
                }
            }

        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.userprofile:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}

