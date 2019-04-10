package com.e.numbertowords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNum;
    private TextView tvOutput;
    private Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btnCOnvert);
        etNum= findViewById(R.id.etNum);
        tvOutput = findViewById(R.id.tvOutput);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCOnvert) {
            if (validation()) {
                String numberz =etNum.getText().toString();
                final long number = Long.parseLong(numberz);
                String returnz = Converter.convert(number);
                tvOutput.setText(returnz);

            }
        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etNum.getText().toString())){
            etNum.setError("Please enter Height");
            etNum.requestFocus();
            flag = false;
        }

        return flag;
    }

}
