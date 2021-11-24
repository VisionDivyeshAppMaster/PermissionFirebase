package com.example.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class FireBaseActivity extends AppCompatActivity {
    
    private EditText et_name, et_email, et_number;
    private Button btn_insert, btn_update, btn_delete, btn_display;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base);

        et_name=findViewById(R.id.et_name);
        et_email=findViewById(R.id.et_email);
        et_number=findViewById(R.id.et_number);
        btn_insert=findViewById(R.id.btn_insert);
        btn_update=findViewById(R.id.btn_update);
        btn_delete=findViewById(R.id.btn_delete);
        btn_display=findViewById(R.id.btn_display);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                insertdata();
                
            }
        });
        
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                updatedata();
            }
        });
        
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                deletedata();
            }
        });
        
        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                displaydata();
                
            }
        });

    }

    private void displaydata() {



        Toast.makeText(getApplicationContext(), "Display...", Toast.LENGTH_SHORT).show();
    }

    private void deletedata() {

        Toast.makeText(getApplicationContext(), "Delete...", Toast.LENGTH_SHORT).show();
        
    }

    private void updatedata() {

        Toast.makeText(getApplicationContext(), "Update...", Toast.LENGTH_SHORT).show();
    }

    private void insertdata() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("TAG", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });
        Toast.makeText(getApplicationContext(), "Insert...", Toast.LENGTH_SHORT).show();
        
    }
}