package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int number;
	private EditText num;
	private Button tebak,reset_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		num = findViewById(R.id.number_input);
		tebak = findViewById(R.id.guess_button);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random random = new Random();
		number = random.nextInt( 100) + 1;
		return;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int no = Integer.parseInt(String.valueOf(num.getText()));
		if(no < number){
			Toast.makeText(this, "Nomor Tebakan Anda Terlalu Kecil", Toast.LENGTH_SHORT).show();
		}
		else if(no > number){
			Toast.makeText(this, "Nomor Tebakan Anda Terlalu Besar", Toast.LENGTH_SHORT).show();
		}
		else{
			tebak.setEnabled(false);
			Toast.makeText(this, "Tebakan Anda Sudah Benar", Toast.LENGTH_SHORT).show();
		}


	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		num.setText("");
		tebak.setEnabled(true);
	}
}
