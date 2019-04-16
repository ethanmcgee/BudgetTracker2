package com.example.budgettracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;

public class OverViewBudget extends AppCompatActivity {

    private static String TAG = "OverViewBudget";



    private float[] yData = {10.1f, 12.4f, 13.5f, 6.3f, 90.5f};
    private String[] xData = {"Entertainment", "Bills", "Health", "Savings", "Custom"};
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_budget);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: starting to create pie chart");

        pieChart = (PieChart) findViewById(R.id.PieChart);
        pieChart.getDescription().setText("Pie chart showing spendings in each category");
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Budget Divisons Chart");
        pieChart.setCenterTextSize(10f);
        pieChart.setDrawEntryLabels(true);

        addDataSet();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value Select from chart");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

            }


            @Override
            public void onNothingSelected() {

            }
        });


    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet: started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        // For Loops to pull yData
        for (int i = 0; i < yData.length; i++) {
            yEntrys.add(new PieEntry(yData[i], i));
        }
        // For loops to bull xData
        for (int i = 0; i < xData.length; i++) {
            xEntrys.add(xData[i]);

        }
        // Create Data SetD
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Spending Types");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        // Colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.GRAY);

        pieDataSet.setColors(colors);

        //Legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);

        //Create Pie Data Object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.overview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        // Pass data to enter budgers screen
        if (id == R.id.enter_budget) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return true;

        }
        // pass data to enter show list screen
        if (id == R.id.show_list) {
            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);


    }
}

