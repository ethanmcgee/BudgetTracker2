package com.example.budgettracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //DatabaseHelper mDatabaseHelper;
    private Button btnEnter, showList;
    private EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        editText = (EditText) findViewById(R.id.editText);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        showList = (Button)  findViewById(R.id.show_list);



        // Store input
        /*btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if (editText.getText().toString().trim().length() > 0)
                    editor.putString("input", editText.getText().toString());

                int selectedPosition = spinner.getSelectedItemPosition();
                if (spinner.getSelectedItemPosition() > 0)
                    editor.putInt("spinnerSelection", selectedPosition);
                editor.apply(); */

        //mDatabaseHelper = new DatabaseHelper(this);

        //Create Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        // Array to store list elements
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.areas));
        //drop down action
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.total) {
            Intent intent = new Intent(getApplicationContext(), OverViewBudget.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.show_list) {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
