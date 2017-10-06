package wm.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static wm.bmicalculator.R.drawable.bmi;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi_value",0);
        bmi = (Math.round(bmi*10.0))/10.0;
        String result = intent.getStringExtra("bmi_result_text");
        TextView bmi_text = (TextView) findViewById(R.id.bmi_text);
        TextView result_text = (TextView)findViewById(R.id.result_text);
        bmi_text.setText("ค่า BMI ที่ได้คือ "+bmi);
        result_text.setText("อยู่ในเกณฑ์ : "+result);
    }
}
