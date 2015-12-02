package com.swk.basket.wang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SigninActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Spinner SignPosition = (Spinner)findViewById(R.id.sign_position);
        ArrayAdapter positionAdapter = ArrayAdapter.createFromResource(this,R.array.position,R.layout.support_simple_spinner_dropdown_item);
        SignPosition.setAdapter(positionAdapter);
    }
}
