package project.colouring;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button answerButton;
    Button exitButton;

    ImageView imageView;

    EditText editText;

    Map<String, String> idNames = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle arguments = getIntent().getExtras();
        int srcId = 0;
        if(arguments != null){
            srcId = arguments.getInt("srcId");
        }
        answerButton = (Button) findViewById(R.id.btnAnswer);
        exitButton = (Button) findViewById(R.id.btnExit);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(srcId);

        editText = (EditText)findViewById(R.id.editText);
        idNames.put(Integer.toString(R.drawable.taipei), "TAIPEI");
        idNames.put(Integer.toString(R.drawable.paris), "PARIS");

        final String rightAnswer = idNames.get(srcId);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAnswer:
                        String answer = editText.getText().toString();
                        if (!answer.equals("")) {
                            Intent intentAnswer = new Intent(MainActivity.this, ResultActivity.class);
                            intentAnswer.putExtra("answered", answer);
                            intentAnswer.putExtra("right", rightAnswer);
                            startActivity(intentAnswer);
                        }
                        else {
                            editText.setText("Enter something!");
                        }
                        break;
                    case R.id.btnExit:
                        Intent intentExit = new Intent(MainActivity.this, SelectActivity.class);
                        startActivity(intentExit);
                        break;
                    default:
                        break;
                }
            }
        };

        answerButton.setOnClickListener(oclBtnOk);
        exitButton.setOnClickListener(oclBtnOk);

    }

    final String TAG = "States";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }
}







