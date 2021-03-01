package ge.tsu.android.checknumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView high_or_Low;
    EditText editText;
    Button checkButton;
    public int generateNumber(){
        Random random=new Random();
        return random.nextInt(100);
    }
    public int previousNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        high_or_Low=findViewById(R.id.high_low);
        editText=findViewById(R.id.find_number);
        checkButton=findViewById(R.id.check_button);

        previousNumber=generateNumber();
//        Log.i(String.valueOf(previousNumber),"da________________________________________");

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                int inputedNumber = Integer.parseInt(s);

                if(inputedNumber==previousNumber){
                    high_or_Low.setText("Congrets");
                    previousNumber=generateNumber();

                }else if(inputedNumber>previousNumber){
                    high_or_Low.setText("Too high");
                }else{
                    high_or_Low.setText("Too Low");
                }
            }
        });
    }
}