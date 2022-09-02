package com.innovativecoding.fd_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText amt;
        EditText rate;
        EditText time;
        TextView maturity,interest,mat_text,in_text;
        Button Calc,clear;
        amt=findViewById(R.id.amount);
        rate=findViewById(R.id.rate);
        time=findViewById(R.id.time);
        maturity=findViewById(R.id.maturity);
        mat_text=findViewById(R.id.mat_text);
        in_text=findViewById(R.id.int_text);
        interest=findViewById(R.id.interest);
        Calc=findViewById(R.id.calculate);
        clear=findViewById(R.id.clear);

        maturity.setText("");
        mat_text.setText("");
        interest.setText("");
        in_text.setText("");
        clear.setVisibility(View.INVISIBLE);




        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!(amt.getText().toString().isEmpty()))&&(!(rate.getText().toString().isEmpty()))&&(!(time.getText().toString().isEmpty()))){

                    double p=Double.parseDouble(amt.getText().toString());
                    double r=Double.parseDouble(rate.getText().toString());
                    double t=Double.parseDouble(time.getText().toString());
                    double adj_r=r/400;
                    double Amount= p*(Math.pow((1+adj_r),4*t));
                    mat_text.setText("Matured Amount:- ");
                    maturity.setText("Rs "+String.format("%.2f",Amount));
                    in_text.setText("Interest Earned:- ");
                    double gain=Amount-p;
                    interest.setText("Rs "+String.format("%.2f",gain));
                    clear.setVisibility(View.VISIBLE);



                }
                else{

                    Toast.makeText(MainActivity.this,"Pls Enter Value",Toast.LENGTH_SHORT).show();

                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amt.getText().clear();
                rate.getText().clear();
                time.getText().clear();
                maturity.setText("");
                mat_text.setText("");
                interest.setText("");
                in_text.setText("");
                clear.setVisibility(View.INVISIBLE);

            }
        });



    }
}
