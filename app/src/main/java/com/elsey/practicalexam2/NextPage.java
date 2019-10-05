package com.elsey.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NextPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
        setTitle("SUMMARY");

        FileInputStream reader = null;

        try{
            reader=openFileInput("data1.txt");
            int c;
            String temp="";
            while ((c=reader.read()) != -1){
                temp = temp + (char)c;
            }
            String[] list = temp.split("/");
            try {
                ((TextView) (findViewById(R.id.textView5))).setText(list[0]);
                ((TextView) (findViewById(R.id.textView7))).setText(list[1]);
            } catch (Exception e){
                e.printStackTrace();
            }
            reader.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(View v) throws IOException {
        Toast.makeText(this,"Request sent", Toast.LENGTH_LONG).show();

    }

    public void previous (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}



//        ((TextView) (findViewById(R.id.textView5))).setText(list[0]);
//        ((TextView)(findViewById(R.id.textView7))).setText((list[1]));
