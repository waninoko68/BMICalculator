package wm.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    EditText eHeight;
    EditText eWeight;
    TextView tHeight;
    TextView tWeight;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eHeight = (EditText) findViewById(R.id.edit_text_height);
        eWeight = (EditText) findViewById(R.id.edit_text_weight);
        tHeight = (TextView) findViewById(R.id.text_height);
        tWeight = (TextView) findViewById(R.id.text_weight);
        cal = (Button)findViewById(R.id.button_calculate);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double height = Double.valueOf(eHeight.getText().toString());
                Double weight = Double.valueOf(eWeight.getText().toString());
                Double bmi = weight/((height/100.0)*(height/100.0));
                String bmi_result = get_bmi_text(bmi);
                Intent intent = new Intent(MainActivity.this,BmiResultActivity.class);
                intent.putExtra("bmi_value",bmi);
                intent.putExtra("bmi_result_text",bmi_result);
                startActivity(intent);
            }
        });

    }

    public String get_bmi_text(double bmi)
    {
        if(bmi<18.5)
        {
            return "น้ำหนักน้อยกว่าปกติ (ผอม)";
        }
        else if(bmi<25)
        {
            return "น้ำหนักปกติ (สมส่วน)";
        }
        else if(bmi<30)
        {
            return "น้ำหนักมากกว่าปกติ (ท้วม)";
        }
        else
        {
            return "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
    }
    /*private class myListener implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            Toast toast = Toast.makeText(MainActivity.this, "TOAST", Toast.LENGTH_SHORT);
            toast.show();
        }
    }*/

}
