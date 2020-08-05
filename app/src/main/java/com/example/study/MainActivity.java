package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener { // implements AdapterView.OnItemSelectedListener реакция на выбор
    int quant = 0;//переменная хранящая в себе количесвто
    Spinner spinner;//спинер(меню с выпадающими элементами)
    ArrayList spinnerBar;//массив для спиннера
    ArrayAdapter spinnerAdapter;//связь массива со спинером
    HashMap instruments;//словарь
    String name;//имя товара
    double summa=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBar = new ArrayList();//создание массива
        spinnerBar.add("piano");
        spinnerBar.add("guitar");
        spinnerBar.add("drum");

        instruments = new HashMap();//создание словаря
        instruments.put("piano", 1500.0);
        instruments.put("guitar",  1000.0);
        instruments.put("drum", 1200.0);

        spinner = findViewById(R.id.spinner); //связь спиннера с переменной spinner
        spinner.setOnItemSelectedListener(this);//установка лисенера для спинера

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerBar);//неведомая хрень
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//установка выпадающего списка для спиннера
        spinner.setAdapter(spinnerAdapter);//установка адаптера для спиннера


    }

    public void quantityInc(View view) { //метод увеличения счетчика количества при нажатии кнопки плюс
        TextView quantity = findViewById(R.id.Quant); //связь текста "количества" с переменной quantity
        TextView price = findViewById(R. id.orderPrice); //связь текста "цены" с переменной price
        quant++;
        quantity.setText(""+quant);//изменение текста "количество"
        price.setText(""+quant*summa);
    }

    public void quantityDec(View view) { //метод уменьшения счетчика количества при нажатии кномпки минус
        TextView quantity = findViewById(R.id.Quant);//связь текста "количества" с переменной quantity
        TextView price = findViewById(R. id.orderPrice); //связь текста "цены" с переменной price
        quant--;
        if (quant <0)//проверка чтобы количество не было отрицательным
            quant=0;
        quantity.setText(""+quant);//изменение текста "количество"
        price.setText(""+quant*summa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { //переопределение реакции на выбор
        name = spinner.getSelectedItem().toString();//значение которе в спиннере присвоить имени товара
        summa = (double)instruments.get(name);//стоимости товара присвоить значение по ключу из словаря
        TextView price = findViewById(R. id.orderPrice); //связь текста "цены" с переменной price
        price.setText(""+quant*summa);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}