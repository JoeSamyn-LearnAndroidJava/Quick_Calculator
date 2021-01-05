package com.example.quickcalculator.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.quickcalculator.R;
import com.example.quickcalculator.databinding.ActivityMainBinding;
import com.example.quickcalculator.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    /* Constants */
    final String LOG_TAG = MainActivity.class.getSimpleName();

    /* Variables */
    MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        vm = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setMainViewModel(vm);

        // Set Observables
    }
}