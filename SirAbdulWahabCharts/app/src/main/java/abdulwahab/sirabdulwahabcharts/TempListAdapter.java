package abdulwahab.sirabdulwahabcharts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import abdulwahab.sirabdulwahabcharts.R;
import abdulwahab.sirabdulwahabcharts.model.Data;

/**
 * Created by LENOVO on 11/12/2017.
 */

public class TempListAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater layoutInflater;
    ArrayList<Data> dataArrayList;

    public TempListAdapter(Context mContext, ArrayList<Data> dataArrayList) {
        this.mContext = mContext;
        this.dataArrayList = dataArrayList;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.item_gauge_list_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTempTitle.setText(dataArrayList.get(position).getSensorDate());
        holder.mTemp.setText(String.valueOf(dataArrayList.get(position).getTemperature()));


        return convertView;
    }


    class ViewHolder {
        TextView mTemp, mTempTitle;

        public ViewHolder(View view) {
            mTempTitle = (TextView) view.findViewById(R.id.gauge_title_text);
            mTemp = (TextView) view.findViewById(R.id.gauge_temp_text);

        }
    }
}
