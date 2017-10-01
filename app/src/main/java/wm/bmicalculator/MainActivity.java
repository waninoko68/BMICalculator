package wm.bmicalculator;

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
                String heightText = eHeight.getText().toString();
                Double height = Double.valueOf(heightText);
                Double weight = Double.valueOf(eWeight.getText().toString());
                Double bmi = weight/(height/100)*(height/100);
                //Toast t = Toast.makeText(MainActivity.this,"BMI : "+String.valueOf(bmi),Toast.LENGTH_LONG);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                String bmiText = get_bmi_text(bmi);
                dialog.setTitle("BMI Result");
                bmi = (double)Math.round(bmi*100)/100;
                dialog.setMessage(String.valueOf(bmi)+"\n"+bmiText);
                dialog.setPositiveButton("OK",null);
                dialog.show();
            }
        });

    }

    public String get_bmi_text(double bmi)
    {
        if(bmi<18.5)
        {
            return "Underweight";
        }
        else if(bmi<25)
        {
            return "Healthy";
        }
        else if(bmi<30)
        {
            return "Overweight";
        }
        else
        {
            return "Obese";
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
