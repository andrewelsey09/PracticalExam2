package com.elsey.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox cb0,cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    EditText et1;
    String data0,data1,data2,data3,data4,data5,data6,data7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.editText1);

        cb0=findViewById(R.id.checkBox0);
        cb1=findViewById(R.id.checkBox1);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox3);
        cb4=findViewById(R.id.checkBox4);
        cb5=findViewById(R.id.checkBox5);
        cb6=findViewById(R.id.checkBox6);
        cb7=findViewById(R.id.checkBox7);

        setTitle("SUBJECT REQUEST");
    }

    public void next(View v){
        Intent intent = new Intent(this, NextPage.class);
        startActivity(intent);
    }

    public void onClick(View v){
    }

    public void Save(View v){

        FileOutputStream writer = null;

        et1=findViewById(R.id.editText1);

        cb0=findViewById(R.id.checkBox0);
        cb1=findViewById(R.id.checkBox1);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox3);
        cb4=findViewById(R.id.checkBox4);
        cb5=findViewById(R.id.checkBox5);
        cb6=findViewById(R.id.checkBox6);
        cb7=findViewById(R.id.checkBox7);

        try{
            writer = openFileOutput("data1.txt",MODE_PRIVATE);

            if (cb0.isChecked()){
                writer.write((cb0.getText().toString()+", ").getBytes());
            }

            if (cb1.isChecked()){
                writer.write((cb1.getText().toString()+"," ).getBytes());
            }

            if (cb2.isChecked()){
                writer.write((cb2.getText().toString()+", ").getBytes());
            }

            if (cb3.isChecked()){
                writer.write((cb3.getText().toString()+", ").getBytes());
            }

            if (cb4.isChecked()){
                writer.write((cb4.getText().toString()+", ").getBytes());
            }

            if (cb5.isChecked()){
                writer.write((cb5.getText().toString()+", ").getBytes());
            }

            if (cb6.isChecked()){
                writer.write((cb6.getText().toString()+", ").getBytes());
            }

            if (cb7.isChecked()){
                writer.write((cb7.getText().toString()).getBytes());
            }
            writer.write(("/").getBytes());

            writer.write((et1.getText().toString()).getBytes());

        } catch (FileNotFoundException e){
            Log.d("error","file not found");
        } catch (IOException e){
            Log.d("error","IO Error...");
        } finally{
            try {
                writer.close();
            } catch (IOException e){
                Log.d("error","IO error");
            }
        }
        Toast.makeText(this,"Data saved . . . ", Toast.LENGTH_LONG).show();

    }
}
