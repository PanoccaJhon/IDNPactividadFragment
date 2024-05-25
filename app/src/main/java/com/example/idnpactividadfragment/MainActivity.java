package com.example.idnpactividadfragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    //Variables de los fragmentos
    private final BlueFragment blueFragment = BlueFragment.newInstance("param1", "param2");
    private final RedFragment redFragment = RedFragment.newInstance("param1", "param2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Botones de los fragmentos
        Button buttonBlue = findViewById(R.id.btnBlue);
        Button buttonRed = findViewById(R.id.btnRed);

        //Funcion OnClick de boton Azul
        buttonBlue.setOnClickListener(v -> replaceFragment(blueFragment));

        //Funcion OnClick de boton Rojo
        buttonRed.setOnClickListener(v -> replaceFragment(redFragment));
    }

    //Funcion para reemplazar fragmentos
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}