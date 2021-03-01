package ge.tsu.android.checknumber

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ge.tsu.android.checknumber.databinding.FragmentBlankBinding
import java.util.*

class BlankFragment : AppCompatActivity() {
    var previousNumber = 0

    fun generateNumber(): Int {
        val random = Random()
        return random.nextInt(100)
    }
    private lateinit var binding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentBlankBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        previousNumber = generateNumber()

        binding.checkButton.setOnClickListener{
            val inputedNumber = Integer.parseInt( binding.findNumber.text.toString());
            if (inputedNumber==previousNumber) {
                binding.highLow.setText("Congrets")
                previousNumber = generateNumber()
            } else if (inputedNumber > previousNumber) {
                binding.highLow.setText("Too high")
            } else {
                binding.highLow.setText("Too Low")
            }
        }
    }

}
