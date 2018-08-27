package com.examplm.just;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private final int PRICE_COFFEE = 2500;
    private int mQuantity =0;
    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private CheckBox mToopingCheckBox;
    private final int PRICE_WHIP = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = findViewById(R.id.price_text_view);
        mQuantityTextView = findViewById(R.id.quantity_text_view);
        mToopingCheckBox = findViewById(R.id.topping_checkbox);

    }
    public void submitOrder(View view){
        //Log.d("MainActivity", "버튼 눌림");
//        display(2);
//        displayPrice(PRICE_COFFEE*2);
//        int numberOfCoffees=2;
//        display(numberOfCoffees);
//        displayPrice(numberOfCoffees*5);
        int price = PRICE_COFFEE*mQuantity;
if(mToopingCheckBox.isChecked()){
    price += mQuantity*PRICE_WHIP;
}
        String name = "Name : 박종남";
        String quantity = "Quantity : " +mQuantity;
        String topping ="Add whipped cream :" + mToopingCheckBox.isChecked();
        String pricetx = "Total :"+NumberFormat.getCurrencyInstance()
                .format(price);

        String message = name + "\n"+
                getString(R.string.total)+"\n" +topping+"\n"+ quantity +"\n"+pricetx +"\n"+getString(R.string.Thx);
        displayMessage(message);
    }
    public void increment(View view){
        mQuantity++;
        display(mQuantity);
        displayPrice(mQuantity*PRICE_COFFEE);
    }
    public void decrement(View view){
        mQuantity--;
        if(mQuantity<0) mQuantity=0;
        display(mQuantity);
        displayPrice(mQuantity*PRICE_COFFEE);
    }
    //수량을 화면에 표시
    private void display(int number){
        //mQuantityTextView = findViewById(R.id.quantity_text_view);
        mQuantityTextView.setText(""+number);
    }
    private void displayPrice(int number){
        //mPriceTextView = findViewById(R.id.price_text_view);
        //통화 기호 numberformat 의미(나라에 따라 알아서 바뀜)
        mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message){
        //TextView priceTextView = findViewById(R.id.price_text_view);
        mPriceTextView.setText(message);
    }


}
