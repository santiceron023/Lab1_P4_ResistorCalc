package com.udea.santiagoceron.lab1p4_v2;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner sFirst,sSecond,sThird,sFour;
    private String[] colors_b1_3,colors_b4,tolerance;
    private LinearLayout tFirst,tSecond,tThird,tFour;
    private int sel_first,sel_second,sel_third,sel_four;
    private TextView tDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors_b1_3 = new String[]{"#000000", "#a52a2a", "#ff0000",
                "#ffa500", "#ffff00","#32cd32", "#0000ff", "#9932cc",
                "#808080", "#ffffff"};
        colors_b4 = new String[]{"#a52a2a","#ff0000","#32cd32","#0000ff",
                "#9932cc","#808080","#ffd700","#c0c0c0"};
        tolerance = new String[]{"1 %","2 %","0.5 %","0.25 %","0.1 %","0.05 %",
                "5%","20%"};
        sFirst = (Spinner) findViewById(R.id.sFirst);
        sSecond = (Spinner) findViewById(R.id.sSecond);
        sThird = (Spinner) findViewById(R.id.sThird);
        sFour = (Spinner) findViewById(R.id.sFour);
        tFirst = (LinearLayout) findViewById(R.id.tFirst);
        tSecond = (LinearLayout) findViewById(R.id.tSecond);
        tThird = (LinearLayout) findViewById(R.id.tThird);
        tFour = (LinearLayout) findViewById(R.id.tFour);
        tDisplay = (TextView) findViewById(R.id.tDisplay);


        //SPINnER CONF-------------------------

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_1_3 = ArrayAdapter.createFromResource(this,
                R.array.band_1_3, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter_1_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sFirst.setAdapter(adapter_1_3);
        sSecond.setAdapter(adapter_1_3);
        sThird.setAdapter(adapter_1_3);

        ArrayAdapter<CharSequence> adapter_4 = ArrayAdapter.createFromResource(this,
                R.array.band_4,android.R.layout.simple_spinner_dropdown_item);
        adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sFour.setAdapter(adapter_4);
        //SPINERRR conf end



        sFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                sel_first = adapterView.getSelectedItemPosition();
                String col_select = colors_b1_3[sel_first];
                tFirst.setBackgroundColor(Color.parseColor(col_select));
                Calculate();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sSecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //tFirst.setBackgroundColor(Color.parseColor(String.valueOf(R.color.colorPrimary)));
                sel_second = adapterView.getSelectedItemPosition();
                String col_select = colors_b1_3[sel_second];
                tSecond.setBackgroundColor(Color.parseColor(col_select));
                Calculate();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sThird.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //tFirst.setBackgroundColor(Color.parseColor(String.valueOf(R.color.colorPrimary)));
                sel_third = adapterView.getSelectedItemPosition();
                String col_select = colors_b1_3[sel_third];
                tThird.setBackgroundColor(Color.parseColor(col_select));
                Calculate();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sFour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //tFirst.setBackgroundColor(Color.parseColor(String.valueOf(R.color.colorPrimary)));
                sel_four = adapterView.getSelectedItemPosition();
                String col_select = colors_b4[sel_four];
                tFour.setBackgroundColor(Color.parseColor(col_select));
                Calculate();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void Calculate() {
        float aux, multiplier,number,result;

        //satart condition
        aux = sel_first + sel_second + sel_third + sel_four;
        if (aux == 0) return;

        //take two first index as a number
        number = sel_first*10;
        number += sel_second;
        //calculate
        multiplier = (float) Math.pow(10,sel_third);
        result = number * multiplier;

        String str = String.format("%.0f",result);



        tDisplay.setText(str + " +/- " + tolerance[sel_four] + " Ω ");
    }






        //}
}
