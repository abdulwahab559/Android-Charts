package abdulwahab.sirabdulwahabcharts.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import abdulwahab.sirabdulwahabcharts.Const;
import abdulwahab.sirabdulwahabcharts.R;
import abdulwahab.sirabdulwahabcharts.model.Data;
import abdulwahab.sirabdulwahabcharts.singletone.ChartApp;

public class HalfPieChart extends AppCompatActivity {

    PieChart deviceOneChart, deviceTwoChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_pie_chart);

        deviceOneChart = (PieChart) findViewById(R.id.device_one_pie_chart);
        deviceTwoChart = (PieChart) findViewById(R.id.device_two_pie_chart);

        Collections.sort(ChartApp.getInstance().getDataArrayLIST(), new Comparator<Data>() {
            @Override
            public int compare(Data left, Data right) {
                return left.getTemperature() - right.getTemperature();
            }
        });

        setUpChart(deviceOneChart, "Device One");
        setUpChart(deviceTwoChart, "Device Two");

        setDataForDeviceOne();
        setDataForDeviceTwo();

    }

    void setUpChart(PieChart mChart, String deviceNme) {
        mChart.setBackgroundColor(Color.WHITE);


        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);

        //mChart.setCenterTextTypeface(mTfLight);
        mChart.setCenterText(deviceNme);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationEnabled(false);
        mChart.setHighlightPerTapEnabled(true);

        mChart.setMaxAngle(180f); // HALF CHART
        mChart.setRotationAngle(180f);
        mChart.setCenterTextOffset(0, -20);


        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);


        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
        //mChart.setEntryLabelTypeface(mTfRegular);
        mChart.setEntryLabelTextSize(12f);
    }

 /*   private SpannableString generateCenterSpannableText(String deviceName) {

        SpannableString s = new SpannableString(deviceName);
        s.setSpan(new RelativeSizeSpan(1.7f), 0, deviceName.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), deviceName.length(), s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), deviceName.length(), s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), deviceName.length(), s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }*/


    private void setDataForDeviceOne() {

        int index = 0;
        ArrayList<PieEntry> values = new ArrayList<PieEntry>();

        for (int i = 0; i < ChartApp.getInstance().getDataArrayLIST().size(); i++) {
            Data data = ChartApp.getInstance().getDataArrayLIST().get(i);
            if (data.getDeviceId() == Const.DEVICE_ONE) {
                if (data.getTemperature() > 0) {
                    values.add(new PieEntry((float) data.getTemperature(), index));
                    index++;
                }
            }
            // values.add(new PieEntry((float) ((Math.random() * range) + range / 5), mParties[i % mParties.length]));
        }

        PieDataSet dataSet = new PieDataSet(values, "Device One");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
       dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(mTfLight);
        deviceOneChart.setData(data);
        deviceOneChart.invalidate();

    }

    private void setDataForDeviceTwo() {
        int index = 0;

        ArrayList<PieEntry> values = new ArrayList<PieEntry>();

        for (int i = 0; i < ChartApp.getInstance().getDataArrayLIST().size(); i++) {
            Data data = ChartApp.getInstance().getDataArrayLIST().get(i);
            if (data.getDeviceId() == Const.DEVICE_TWO) {
                if (data.getTemperature() > 0) {
                    values.add(new PieEntry((float) data.getTemperature(), index));
                    index++;
                }
            }
            // values.add(new PieEntry((float) ((Math.random() * range) + range / 5), mParties[i % mParties.length]));
        }

        PieDataSet dataSet = new PieDataSet(values, "Device Two");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        //data.setValueTypeface(mTfLight);
        deviceTwoChart.setData(data);
        deviceTwoChart.invalidate();

    }
}
