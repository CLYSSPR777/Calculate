package com.example.spr7.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity_Calculate extends AppCompatActivity {

    private EditText field_lend;
    private EditText field_rate;
    private EditText field_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__calculate);

        findViews();
        setlisteners();
    }

    private void setlisteners() {
        button_calo.setOnClickListener(caloMoney);
    }

    private Button button_calo;
    private TextView view_result;

    private void findViews() {
        button_calo = (Button)findViewById(R.id.btn_total);
        field_lend = (EditText)findViewById(R.id.input_lend);
        field_rate = (EditText)findViewById(R.id.input_rate);
        field_number = (EditText)findViewById(R.id.input_number);
        view_result = (TextView)findViewById(R.id.view_result);
    }

    private Button.OnClickListener caloMoney = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            double lend = Double.parseDouble(field_lend.getText().toString());
            double rate = Double.parseDouble(field_rate.getText().toString());
            double number = Double.parseDouble(field_number.getText().toString());

            double total = lend * Math.pow(1+rate/12/100,number);

            view_result.setText("本利合為" + nf.format(total));
        }
    };
}
