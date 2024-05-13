package com.example.dapaactividad15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText prompt1, prompt2;
    TextView prompt1name, prompt2name;
    Button conversion, conv1, conv2, conv3;
    public enum conversionType {pTD, dTE, pTE}
    conversionType type = conversionType.pTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prompt1 = findViewById(R.id.prompt1);
        prompt1name = findViewById(R.id.prompt1name);
        prompt2 = findViewById(R.id.prompt2);
        prompt2name = findViewById(R.id.prompt2name);

        prompt1name.setText("Pesos");
        prompt2name.setText("Dolares");

    }

    public void convert(View v) {
        String p1text = prompt1.getText().toString();
        String p2text = prompt2.getText().toString();

        double forwardConv = 0;
        double backwardConv = 0;

        switch (type) {
            case pTD:
                forwardConv = 0.05959;
                backwardConv = 16.782;
                break;
            case dTE:
                forwardConv = 0.9283;
                backwardConv = 1.0772;
                break;
            case pTE:
                forwardConv = 0.05531;
                backwardConv = 18.078;
                break;
            default:
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }

        if(!p1text.isEmpty()) {
            double num1 = Double.parseDouble(p1text);
            double num2 = num1 * forwardConv;
            prompt2.setText(String.format("%.2f",num2));
        } else if (!p2text.isEmpty()) {
            double num2 = Double.parseDouble(p2text);
            double num1 = num2 * backwardConv;
            prompt1.setText(String.format("%.2f",num1));
        } else {
            Toast.makeText(this,"Llena alguno de los campos para hacer la conversion.",Toast.LENGTH_SHORT).show();
        }
    }

    public void pesosToDollars(View v) {
        prompt1name.setText("Pesos");
        prompt2name.setText("Dolares");
        type = conversionType.pTD;
    }

    public void dollarsToEuros(View v) {
        prompt1name.setText("Dolares");
        prompt2name.setText("Euros");
        type = conversionType.dTE;
    }

    public void pesosToEuros(View v) {
        prompt1name.setText("Pesos");
        prompt2name.setText("Euros");
        type = conversionType.pTE;
    }
}