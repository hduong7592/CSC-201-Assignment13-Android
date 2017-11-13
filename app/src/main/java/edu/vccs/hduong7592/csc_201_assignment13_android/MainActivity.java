package edu.vccs.hduong7592.csc_201_assignment13_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Create by hieuduong on 11/12/17
 *
 * CSC 201 - Assignment 13
 * Problem 13.3:
 *
 * (Sort ArrayList) Write the following method that sorts an ArrayList of numbers.
 *  public static void sort(ArrayList<Number> list)
 */

public class MainActivity extends AppCompatActivity {

    EditText input1, input2, input3, input4, input5;
    Button submitBtn;
    TextView resultLB;
    ArrayList<Integer> list;
    boolean isSorted;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        input3 = (EditText) findViewById(R.id.input3);
        input4 = (EditText) findViewById(R.id.input4);
        input5 = (EditText) findViewById(R.id.input5);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        resultLB = (TextView) findViewById(R.id.resultLB);

        list = new ArrayList<Integer>();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isSorted) {
                    int val1 = Integer.parseInt(input1.getText().toString());
                    int val2 = Integer.parseInt(input2.getText().toString());
                    int val3 = Integer.parseInt(input3.getText().toString());
                    int val4 = Integer.parseInt(input4.getText().toString());
                    int val5 = Integer.parseInt(input5.getText().toString());

                    list.add(val1);
                    list.add(val2);
                    list.add(val3);
                    list.add(val4);
                    list.add(val5);

                    result = displayList(sortArray(list));
                    resultLB.setText(result);
                }
                else{
                    resultLB.setText("Array already sorted.\nResult: "+result);
                }
            }
        });
    }

    /**
     * Display array list
     * @param list
     * @return
     */
    private String displayList(ArrayList<Integer> list) {
        String arrayList = "";
        for(int i=0; i < list.size(); i++){
            if(i==list.size()-1){
                arrayList+=list.get(i);
            }
            else{
                arrayList+=list.get(i)+",";
            }
        }
        return arrayList;
    }

    /**
     * Sort array list
     * @param list
     * @return
     */
    private ArrayList sortArray(ArrayList<Integer> list) {

        for(int index =0; index < list.size(); index++){
            int currentMinVal = list.get(index);
            int currentIndex = index;

            for(int nextIndex = index+1; nextIndex<list.size(); nextIndex ++){
                if(currentMinVal > list.get(nextIndex)){
                    currentMinVal = list.get(nextIndex);
                    currentIndex = nextIndex;
                }
            }

            if(currentIndex != index){
                list.set(currentIndex, list.get(index));
                list.set(index, currentMinVal);
            }
        }
        isSorted = true;
        return list;
    }
}
