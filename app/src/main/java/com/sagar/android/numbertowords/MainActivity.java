package com.sagar.android.numbertowords;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sagar.android.numberconvertercore.ConversionResult;
import com.sagar.android.numberconvertercore.ConvertIND;
import com.sagar.android.numberconvertercore.ConvertWS;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ConvertIND.CallbackConvertIND, ConvertWS.CallbackConvertWS {

    EditText editText;
    ProgressBar progressBar;
    Button button;
    RecyclerView recyclerView;
    RadioButton radioButtonInd;
    RadioButton radioButtonWs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.edittext);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        radioButtonInd = (RadioButton) findViewById(R.id.radiobutton_ind);
        radioButtonWs = (RadioButton) findViewById(R.id.radiobutton_ws);

        progressBar.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                if (editText.getText().length() == 0 || (!radioButtonInd.isChecked() && !radioButtonWs.isChecked()))
                    return;
                progressBar.setVisibility(View.VISIBLE);
                if (radioButtonInd.isChecked())
                    new ConvertIND(MainActivity.this).convertNumberToWord(editText.getText().toString());
                if (radioButtonWs.isChecked())
                    new ConvertWS(MainActivity.this).convertNumberToWord(editText.getText().toString());
            }
        });
    }

    @Override
    public void conversionResultWS(ConversionResult conversionResult) {
        progressBar.setVisibility(View.GONE);
        if (conversionResult.getResultCode() == ConversionResult.ResultCode.FAIL) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<String> dataSet = new ArrayList<>();
        for (int i = 0; i < conversionResult.getResult().size(); i++) {
            dataSet.add(conversionResult.getResult().get(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new Adapter(dataSet));
    }

    @Override
    public void conversionResultIND(ConversionResult conversionResult) {
        progressBar.setVisibility(View.GONE);
        if (conversionResult.getResultCode() == ConversionResult.ResultCode.FAIL) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<String> dataSet = new ArrayList<>();
        for (int i = 0; i < conversionResult.getResult().size(); i++) {
            dataSet.add(conversionResult.getResult().get(i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new Adapter(dataSet));
    }
}
