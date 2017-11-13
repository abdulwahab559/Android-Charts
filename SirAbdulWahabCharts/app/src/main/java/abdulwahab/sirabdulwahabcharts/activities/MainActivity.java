package abdulwahab.sirabdulwahabcharts.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

import abdulwahab.sirabdulwahabcharts.Const;
import abdulwahab.sirabdulwahabcharts.R;
import abdulwahab.sirabdulwahabcharts.model.Data;
import abdulwahab.sirabdulwahabcharts.singletone.ChartApp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button lineChart, semiPieChart, thChart, gaugeChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addDummyData();

        lineChart = (Button) findViewById(R.id.line_chart_btn);
        semiPieChart = (Button) findViewById(R.id.semi_pie_chart_btn);
        thChart = (Button) findViewById(R.id.th_chart_btn);
        gaugeChart = (Button) findViewById(R.id.gauge_chart_btn);


        lineChart.setOnClickListener(this);
        semiPieChart.setOnClickListener(this);
        thChart.setOnClickListener(this);
        gaugeChart.setOnClickListener(this);

    }


    void addDummyData() {

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                ChartApp.getInstance().getDataArrayLIST().add(new Data(String.valueOf(i), randTemp(), Const.DEVICE_ONE, formattedDate()));
            else
                ChartApp.getInstance().getDataArrayLIST().add(new Data(String.valueOf(i), randTemp(), Const.DEVICE_TWO, formattedDate()));

        }


    }

    public int randTemp() {

        int min = -100;
        int max = 100;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    String formattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String newFormat = formatter.format(new Date());
        return newFormat;
    }

    @Override
    public void onClick(View v) {

        if (v == lineChart) {
            Intent intent = new Intent(this, LineChartActivity.class);
            startActivity(intent);

        } else if (v == gaugeChart) {
            Intent intent = new Intent(this, GaugeActivity.class);
            startActivity(intent);
        } else if (v == thChart) {
            Toast.makeText(this, "Not Implemented yet", Toast.LENGTH_SHORT).show();
        } else if (v == semiPieChart) {
            Intent intent = new Intent(this, HalfPieChart.class);
            startActivity(intent);
        }

    }


}
