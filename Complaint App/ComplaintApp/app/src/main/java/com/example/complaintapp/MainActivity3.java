package com.example.complaintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button b1;
    EditText e1,e2;
    Spinner s1;
    String[] ss1={" Ministry of Railway"," Ministry of Rural Development"," Ministry of Urban Development",
            " Ministry of Water Resource"," Municipal Corporation"," Ministry of Youth affair and Sports"};
    ArrayAdapter aa;
    String dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=findViewById(R.id.button);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        s1=findViewById(R.id.spinner);

        s1.setOnItemSelectedListener(this);
        aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ss1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(aa);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a1=e1.getText().toString();
                String b1=e2.getText().toString();


                if(a1.equals("")||b1.equals("")){
                    Toast.makeText(MainActivity3.this,"Please fill all the details", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(MainActivity3.this,"complaint sent successfully to"+dept, Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        e2.setText("");

                }



            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        dept=(String)aa.getItem(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}