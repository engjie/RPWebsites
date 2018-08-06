package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCat;
    Spinner spnSub;
    Button btnGo;
    TextView testing;
    ArrayList<String> alWeb;
    ArrayAdapter<String> aaWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing = findViewById(R.id.textViewTesting);
        spnCat = findViewById(R.id.spinnerCategory);
        spnSub = findViewById(R.id.spinnerSubCategory);
        btnGo = findViewById(R.id.buttonGo);

        alWeb = new ArrayList<>();
        aaWeb = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alWeb);

        spnSub.setAdapter(aaWeb);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        alWeb.clear();
                        String[] strArray0 = getResources().getStringArray(R.array.Sub_Category);
                        alWeb.addAll(Arrays.asList(strArray0));
                        aaWeb.notifyDataSetChanged();
                        break;

                    case 1:
                        alWeb.clear();
                        String[] strArray1 = getResources().getStringArray(R.array.Sub_CategorySOI);
                        alWeb.addAll(Arrays.asList(strArray1));
                        aaWeb.notifyDataSetChanged();
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[][] sites={
                        {
                            "https://www.rp.edu.sg/",
                                "https://www.rp.edu.sg/student-life"
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                        }
                };
                String url = sites[spnCat.getSelectedItemPosition()][spnSub.getSelectedItemPosition()];

                Intent intent = new Intent(getBaseContext(), webActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
                /*
                int pos1 = spnCat.getSelectedItemPosition();
                int pos2 = spnSub.getSelectedItemPosition();

                if (pos1 == 0){
                    if(pos2 == 0){

                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/");
                        startActivity(intent);

                    }
                    else{
                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/student-life");
                        startActivity(intent);

                    }
                }

                else{
                    if(pos2 == 0){
                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                        startActivity(intent);
                    }
                    else{

                        Intent intent = new Intent(getBaseContext(), webActivity.class);
                        intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        startActivity(intent);

                    }
                }
                */

            }
        });


    }
}

