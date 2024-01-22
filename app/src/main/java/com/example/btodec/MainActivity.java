package com.example.btodec;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input, output;
        Button binaryToDecimal, decimalToBinary, reset;

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        binaryToDecimal = findViewById(R.id.binaryToDecimal);
        decimalToBinary = findViewById(R.id.decimalToBinary);

        binaryToDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Binary to Decimal conversion
                String binaryString = input.getText().toString();
                if (isValidBinary(binaryString)) {
                    int decimal = Integer.parseInt(binaryString, 2);
                    output.setText(String.valueOf(decimal));
                } else {
                    output.setText("Enter a valid Binary Number");
                }
            }
        });

        decimalToBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decimal to Binary conversion
                String decimalString = input.getText().toString();
                if (isValidDecimal(decimalString)) {
                    int decimal = Integer.parseInt(decimalString);
                    String binary = Integer.toBinaryString(decimal);
                    output.setText(binary);
                } else {
                    output.setText("Enter a valid Decimal Number");
                }
            }
        });

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });
    }

    // Kontrol etmek için eklenen fonksiyonlar
    private boolean isValidBinary(String binaryString) {
        return binaryString.matches("[01]+"); // Sadece '0' ve '1' içermesi gerekir
    }

    private boolean isValidDecimal(String decimalString) {
        return decimalString.matches("\\d+"); // Sayısal bir değer içermesi gerekir
    }
}
