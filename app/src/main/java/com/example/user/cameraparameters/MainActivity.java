package com.example.user.cameraparameters;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    Camera camera = Camera.open();
    Camera.Parameters params;
    String parameters = null;
    TestSimpleton instance=TestSimpleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        params = camera.getParameters();

        params.set("zoom", 100);


        parameters = params.flatten();
        instance.setParameters(parameters);
        String instanceParams=instance.getParameters();
        HashMap table=separateParams(instanceParams);

      printall(table);
//        ArrayList arrayList=printKey(table);


    }
    public HashMap separateParams(String parameters) throws ArrayIndexOutOfBoundsException{
        HashMap table=new HashMap();
        String[] pairs=parameters.split(";");
        String novalue="no value found";
        for(int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            try {
                String[] splitter=pair.split("=");
                table.put(splitter[0],splitter[1]);
            }catch(ArrayIndexOutOfBoundsException e){
                table.put(pair,novalue);

            }

        }


        return table;
    }
//    public void optionParamTables(){
//        HashMap paramTable = separateParams(parameters);
//        LinkedList effList=new LinkedList();
//        Iterator it=paramTable.entrySet().iterator();
//        while(it.hasNext()){
//                HashMap.Entry pair = (HashMap.Entry) it.next();
//                if(pair.equals("effect-values")){
//                    Log.d("maria","maria");
//
//            }
//            it.remove();
//        }
////        return effList;
//    }
    public static ArrayList printOptionValues(HashMap<String,String> mp) {
        Iterator it = mp.entrySet().iterator();
        ArrayList array =new ArrayList();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            if(pair.getKey().toString().equalsIgnoreCase("effect-values"))
            {
                String values = pair.getValue().toString();
                String[] stringsplit = values.split(",");
                for(int i=0;i<stringsplit.length;i++){
                    array.add(stringsplit[i]);
                    Log.d("maria",stringsplit[i]);

                }
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return array;
    }
    public static void printall(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Log.d("panagiotis",pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
//    public static void printValues(Map mp) {
//        Iterator it = mp.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            Log.d("nikos", pair.getValue().toString());
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//    }
//    public static void printKey(Map mp) {
//        Iterator it = mp.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            Log.d("nikos", pair.getKey().toString());
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//    }
}
