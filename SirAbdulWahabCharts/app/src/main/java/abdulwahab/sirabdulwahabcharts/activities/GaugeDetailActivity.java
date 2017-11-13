package abdulwahab.sirabdulwahabcharts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abdulwahab.sirabdulwahabcharts.R;
import de.nitri.gauge.Gauge;

public class GaugeDetailActivity extends AppCompatActivity {

    Gauge gaugeView;
    int value = 0;
    public static final String PARAM_GAUGE_VAL = "gauge_val";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauge_detail);

        value = getIntent().getIntExtra(PARAM_GAUGE_VAL, 0);

        gaugeView = (Gauge) findViewById(R.id.gauge);

        gaugeView.moveToValue(value);


    }
}
