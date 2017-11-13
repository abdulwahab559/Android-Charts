package abdulwahab.sirabdulwahabcharts.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Date;

import abdulwahab.sirabdulwahabcharts.Const;
import abdulwahab.sirabdulwahabcharts.R;
import abdulwahab.sirabdulwahabcharts.TempListAdapter;
import abdulwahab.sirabdulwahabcharts.model.Data;
import abdulwahab.sirabdulwahabcharts.singletone.ChartApp;


public class GaugeActivity extends AppCompatActivity {

    ListView mDeviceOneListView, mDeviceTwoListView;
    TempListAdapter mDeviceOneAdapter, mDeviceTwoAdapter;

    //Gauge gauge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauge);

        mDeviceOneListView = (ListView) findViewById(R.id.temp_device_one_listview);
        mDeviceTwoListView = (ListView) findViewById(R.id.temp_device_two_listview);
        final ArrayList<Data> deviceOneList = filterDataList(Const.DEVICE_ONE);
        final ArrayList<Data> deviceTwoList = filterDataList(Const.DEVICE_TWO);


        mDeviceOneAdapter = new TempListAdapter(this,deviceOneList );
        mDeviceOneListView.setAdapter(mDeviceOneAdapter);


        mDeviceTwoAdapter = new TempListAdapter(this, deviceTwoList);
        mDeviceTwoListView.setAdapter(mDeviceTwoAdapter);


        mDeviceOneListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GaugeActivity.this,GaugeDetailActivity.class);
                intent.putExtra(GaugeDetailActivity.PARAM_GAUGE_VAL,deviceOneList.get(position).getTemperature());
                startActivity(intent);
            }
        });

        mDeviceTwoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GaugeActivity.this,GaugeDetailActivity.class);
                intent.putExtra(GaugeDetailActivity.PARAM_GAUGE_VAL,deviceTwoList.get(position).getTemperature());
                startActivity(intent);
            }
        });
    }


    public ArrayList<Data> filterDataList(int deviceId) {
        ArrayList<Data> dataArrayList = new ArrayList<>();

        for (int i = 0; i < ChartApp.getInstance().getDataArrayLIST().size(); i++) {
            Data data = ChartApp.getInstance().getDataArrayLIST().get(i);
            if (data.getDeviceId() == deviceId) {
               // if (data.getTemperature() > 0) {
                    dataArrayList.add(data);
                //}
            }
        }
        return dataArrayList;

    }
}
