package com.examplm.just;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private final int PRICE_COFFEE = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view){
        //Log.d("MainActivity", "버튼 눌림");
        display(2);
        displayPrice(PRICE_COFFEE*2);

    }
    //수량을 화면에 표시
    private void display(int number){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);

    }
    public void displayPrice(int number){
        TextView priceTextView = findViewById(R.id.price_text_view);
        //통화 기호 numberformat 의미(나라에 따라 알아서 바뀜)
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
