package com.example.recyclesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cName,cContact,cMail;
    Button cAdd;
    ImageButton cView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cName = (EditText) findViewById(R.id.nameData);
        cContact = (EditText)findViewById(R.id.contactData);
        cMail =(EditText) findViewById(R.id.mailData);
        cAdd =(Button) findViewById(R.id.addBtn);
        cView = (ImageButton) findViewById(R.id.viewBtn);

       cAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               processInsert(cName.getText().toString(),cContact.getText().toString(),cMail.getText().toString());
           }
       });

       cView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),FetchData.class));
           }
       });


    }

    private void processInsert(String n, String c, String e)
    {   if(n.trim().equals("") || n.isEmpty()){
        Toast.makeText(getApplicationContext(),"Field Cannot be Empty",Toast.LENGTH_SHORT).show();
        return;
          }
        if(c.trim().length()!=10)
        {
            Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
            return;
        }

        if(!e.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(e).matches()){
            String res = new DBmanager(this).addrecord(n, c, e);
            cName.setText("");
            cContact.setText("");
            cMail.setText("");
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_SHORT).show();
            return;
        }



    }





}