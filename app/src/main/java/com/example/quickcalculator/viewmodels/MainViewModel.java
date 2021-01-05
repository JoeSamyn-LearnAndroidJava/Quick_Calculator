package com.example.quickcalculator.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    /* Constants */
    private final String LOG_TAG = MainViewModel.class.getSimpleName();
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String TIMES = "*";
    private final String DIVIDE = "/";


    /* Two-way Binding View Properties */
    public MutableLiveData<String> valueOne = new MutableLiveData<>();
    public MutableLiveData<String> valueTwo = new MutableLiveData<>();

    /* Private Properties */
    private String operand;
    private String result;

    public MainViewModel(){ }

    /* Getters/Setters */
    public String getOperand(){  return this.operand; }
    public void setOperand(String operand){ this.operand = operand; }

    public String getResult(){ return this.result; }
    public void setResult(String result) { this.result = result; }

    /* onClick Handlers */
    public void onPlusClicked(){ setOperand(PLUS); }

    public void onMinusClicked() { setOperand(MINUS); }

    public void onTimesClicked() { setOperand(TIMES); }

    public void onDivideClicked() { setOperand(DIVIDE); }

    public void onEqualsClicked() {
        int valueOne = Integer.parseInt(this.valueOne.getValue());
        int valueTwo = Integer.parseInt(this.valueTwo.getValue());

        String operand = getOperand();
        switch(operand){
            case PLUS:
                add(valueOne, valueTwo);
                break;
            case MINUS:
                subtract(valueOne, valueTwo);
                break;
            case TIMES:
                multiply(valueOne, valueTwo);
                break;
            case DIVIDE:
                divide(valueOne, valueTwo);
                break;
        }
    }

    /* Private Methods */
    /**
     * Sum of two parameters
     * @param valueOne - first value in sum
     * @param valueTwo - second value in sum
     */
    private void add(int valueOne, int valueTwo){

        this.result = Integer.toString(valueOne + valueTwo);
        Log.d(LOG_TAG, "RESULT: " + this.result);
    }

    /**
     * Difference of two values
     * @param valueOne - minuend, number being subtracted from
     * @param valueTwo - subtrahend, value being subtracted
     */
    private void subtract(int valueOne, int valueTwo){
        this.result = Integer.toString(valueOne - valueTwo);
        Log.d(LOG_TAG, "RESULT: " + this.result);
    }

    /**
     * Product of two values
     * @param valueOne - value one
     * @param valueTwo - value two
     */
    private void multiply(int valueOne, int valueTwo){
        this.result = Integer.toString(valueOne * valueTwo);
        Log.d(LOG_TAG, "RESULT: " + this.result);
    }

    /**
     * Quotient of two values
     * @param valueOne - dividend, number being divided
     * @param valueTwo - divisor, number you are dividing by
     */
    private void divide(int valueOne, int valueTwo){
        this.result = Integer.toString(valueOne / valueTwo);
        Log.d(LOG_TAG, "RESULT: " + this.result);
    }
}
