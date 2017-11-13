package abdulwahab.sirabdulwahabcharts.singletone;

import java.util.ArrayList;

import abdulwahab.sirabdulwahabcharts.model.Data;

/**
 * Created by LENOVO on 11/12/2017.
 */

public class ChartApp {
    private static final ChartApp ourInstance = new ChartApp();
    private  ArrayList<Data> dataArrayLIST = new ArrayList<>();

    public static ChartApp getInstance() {
        return ourInstance;
    }

    private ChartApp() {
    }


    public  ArrayList<Data> getDataArrayLIST() {
        return dataArrayLIST;
    }

    public  void setDataArrayLIST(ArrayList<Data> dataArrayLIST) {
       dataArrayLIST = dataArrayLIST;
    }
}
