package ge.tsu.android.checknumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import ge.tsu.android.checknumber.databinding.FragmentBlankBinding;

public class MainActivity extends AppCompatActivity {

    public int generateNumber(){
        Random random=new Random();
        return random.nextInt(100);
    }
    public int previousNumber;
    private FragmentBlankBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=FragmentBlankBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        previousNumber=generateNumber();
//        Log.i(String.valueOf(previousNumber),"da________________________________________");

        binding.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=binding.findNumber.getText().toString();
                int inputedNumber = Integer.parseInt(s);

                if(inputedNumber==previousNumber){
                    binding.highLow.setText("Congrets");
                    previousNumber=generateNumber();
                }else if(inputedNumber>previousNumber){
                    binding.highLow.setText("Too high");
                }else{
                    binding.highLow.setText("Too Low");
                }
            }
        });
    }
}