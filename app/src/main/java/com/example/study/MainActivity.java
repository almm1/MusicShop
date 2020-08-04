package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quant = 0;//переменная хранящая в себе количесвто
    int price = 0; //цена
    Spinner spinner;//спинер(меня с выпадающими элементами)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner); //связь спиннера с переменной spinner
    }

    public void quantityInc(View view) { //метод увеличения счетчика количества при нажатии кнопки плюс
        TextView quantity = findViewById(R.id.Quant); //связь текста "количества" с переменной quantity
        quant++;
        quantity.setText(""+quant);//изменение текста "количество"
    }

    public void quantityDec(View view) { //метод уменьшения счетчика количества при нажатии кномпки минус
        TextView quantity = findViewById(R.id.Quant);//связь текста "количества" с переменной quantity
        quant--;
        if (quant <0)//проверка чтобы количество не было отрицательным
            quant=0;
        quantity.setText(""+quant);//изменение текста "количество"
    }
}