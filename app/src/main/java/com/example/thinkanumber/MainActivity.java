package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonplus, buttonminus, buttonsend;
    private TextView textviewnumber;
    private ImageView heart1, heart2, heart3, heart4, heart5;
    private int kuldottszam = 0;
    private int gondoltszam;
    private int szivek = 0;
    private Random rnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rnd = new Random();
        gondoltszam = rnd.nextInt(10);
        buttonplus.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonsend.setOnClickListener(this);
    }

    public void init()
    {
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus = findViewById(R.id.buttonminus);
        buttonsend = findViewById(R.id.buttonsend);
        textviewnumber = findViewById(R.id.textviewnumber);
        heart1 = findViewById(R.id.heart1);
        heart2 = findViewById(R.id.heart2);
        heart3 = findViewById(R.id.heart3);
        heart4 = findViewById(R.id.heart4);
        heart5 = findViewById(R.id.heart5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonplus:
                if (kuldottszam <10)
                {
                    kuldottszam++;
                }
                if (kuldottszam == 10)
                {
                    String text = "Elértük a maximumot!";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
                textviewnumber.setText(String.valueOf(kuldottszam));
                break;
            case R.id.buttonminus:
                if (kuldottszam >0)
                {
                    kuldottszam--;
                }
                if (kuldottszam == 0)
                {
                    String text = "Elértük a minimumot!";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
                textviewnumber.setText(String.valueOf(kuldottszam));
                break;
            case R.id.buttonsend:
                if (gondoltszam == kuldottszam)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Gratula");
                    alertDialog.setMessage("Nyertél, akarsz újat játszani?");
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Új játék!",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                                    finish();
                                    startActivity(main_activity);
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Kilépés",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    finish();
                                }
                            });
                    alertDialog.show();
                }
                else if (gondoltszam > kuldottszam)
                {
                    String text = "A gondolt szam nagyobb!";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    szivek++;
                    Szivek();
                }
                else if (gondoltszam < kuldottszam)
                {
                    String text = "A gondolt szam kisebb!";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                    szivek++;
                    Szivek();
                }
                break;
        }
    }
    public void Szivek()
    {
        if (szivek == 1)
        {
            heart1.setImageResource(R.drawable.heart1);
        }
        if (szivek == 2)
        {
            heart2.setImageResource(R.drawable.heart1);
        }
        if (szivek == 3)
        {
            heart3.setImageResource(R.drawable.heart1);
        }
        if (szivek == 4)
        {
            heart4.setImageResource(R.drawable.heart1);
        }
        if (szivek == 5)
        {
            heart5.setImageResource(R.drawable.heart1);
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("GAME OVER");
            alertDialog.setMessage("Vesztettél, akarsz újat játszani?");
            alertDialog.setCancelable(false);
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Új játék!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(main_activity);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Kilépés",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            alertDialog.show();
        }
    }
}
