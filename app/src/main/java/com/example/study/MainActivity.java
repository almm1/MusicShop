package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    int quant = 0;//переменная хранящая в себе количесвто
    int price = 0; //цена
    Spinner spinner;//спинер(меню с выпадающими элементами)
    ArrayList spinnerBar;//массив для спиннера
    ArrayAdapter spinnerAdapter;//связь массива со спинером
    HashMap instruments;//словарь
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner); //связь спиннера с переменной spinner
        ArrayList spinnerBar = new ArrayList();//создание массива
        spinnerBar.add("Guitar");
        spinnerBar.add("Piano");
        spinnerBar.add("Drum");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerBar);//неведомая хрень
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//установка выпадающего списка для спиннера
        spinner.setAdapter(spinnerAdapter);//установка адаптера для спиннера

        HashMap instruments = new HashMap();//создание словаря


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