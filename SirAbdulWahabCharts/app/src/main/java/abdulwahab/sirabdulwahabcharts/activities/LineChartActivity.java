package abdulwahab.sirabdulwahabcharts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import abdulwahab.sirabdulwahabcharts.Const;
import abdulwahab.sirabdulwahabcharts.R;
import abdulwahab.sirabdulwahabcharts.model.Data;
import abdulwahab.sirabdulwahabcharts.singletone.ChartApp;

public class LineChartActivity extends AppCompatActivity {

    LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        mLineChart = (LineChart) findViewById(R.id.line_chart);

        //mLineChart.setOnChartValueSelectedListener(this);

        mLineChart.setDrawGridBackground(true);
        mLineChart.getDescription().setEnabled(false);
        mLineChart.setDrawBorders(false);

        mLineChart.getAxisLeft().setEnabled(false);
        mLineChart.getAxisRight().setDrawAxisLine(false);
        mLineChart.getAxisRight().setDrawGridLines(false);
        mLineChart.getXAxis().setDrawAxisLine(false);
        mLineChart.getXAxis().setDrawGridLines(false);

        // enable touch gestures
        mLineChart.setTouchEnabled(true);

        // enable scaling and dragging
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mLineChart.setPinchZoom(false);

        addEntriesinChart();


    }

    void addEntriesinChart() {
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        LineDataSet d = new LineDataSet(getDeviceOneEntries(), "Device One");
        d.setLineWidth(2.5f);
        d.setCircleRadius(4f);

        int color = mColors[0];
        d.setColor(color);
        d.setCircleColor(color);
        dataSets.add(d);


        LineDataSet dTwo = new LineDataSet(getDeviceTwoEntries(), "Device Two");
        dTwo.setLineWidth(2.5f);
        dTwo.setCircleRadius(4f);

        int colorTwo = mColors[1];
        d.setColor(colorTwo);
        d.setCircleColor(colorTwo);
        dataSets.add(dTwo);


        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.invalidate();
    }


    List<Entry> getDeviceOneEntries() {
        ArrayList<Entry> values = new ArrayList<Entry>();
        int index = 0;

        for (int i = 0; i < ChartApp.getInstance().getDataArrayLIST().size(); i++) {
            Data data = ChartApp.getInstance().getDataArrayLIST().get(i);
            if (data.getDeviceId() == Const.DEVICE_ONE) {

                values.add(new Entry(index, (float) data.getTemperature()));
                index++;
            }

        }

        return values;

    }


    List<Entry> getDeviceTwoEntries() {
        ArrayList<Entry> values = new ArrayList<Entry>();
        int index = 0;

        for (int i = 0; i < ChartApp.getInstance().getDataArrayLIST().size(); i++) {
            Data data = ChartApp.getInstance().getDataArrayLIST().get(i);
            if (data.getDeviceId() == Const.DEVICE_TWO) {
                values.add(new Entry(index, (float) data.getTemperature()));
                index++;

            }
        }
        return values;

    }

    private int[] mColors = new int[]{
            ColorTemplate.VORDIPLOM_COLORS[0],
            ColorTemplate.VORDIPLOM_COLORS[1]
    };

}
