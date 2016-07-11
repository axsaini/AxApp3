package com.example.ax.axapp3;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void setShared() {
        try {
            Toast.makeText(this,"set shared fired",Toast.LENGTH_LONG).show();
            EditText edit1 = (EditText) findViewById(R.id.editText);
            EditText edit2 = (EditText) findViewById(R.id.editText2);
            String e1=edit1.getText().toString();
            String e2=edit2.getText().toString();
            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putString(e1,e2);
            editor.commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this,"set shared problem",Toast.LENGTH_LONG).show();
        }
    }


    public void getShared(String s) {
        try {
            Toast.makeText(this,"get shared fired",Toast.LENGTH_LONG).show();
            TextView txt = (TextView) findViewById(R.id.textView);
            SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
            txt.setText(sharedPreferences.getString(s,null));
        }

        catch (Exception e){
            Toast.makeText(this,"getShared has problem",Toast.LENGTH_LONG).show();
        }
    }


    public void save(View view) {

        setShared();

        //  Toast.makeText(this,"save problem",Toast.LENGTH_LONG).show();


    }

    public void show(View view) {

        EditText edit3 = (EditText) findViewById(R.id.editText3);
        String e3=edit3.getText().toString();
        getShared(e3);

        //Toast.makeText(this,"show fired",Toast.LENGTH_LONG).show();

    }
    public  void  all(View view)
    {
        Intent intent=new Intent(this,AllData.class);
        startActivity(intent);

    }
}