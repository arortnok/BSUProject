package project.colouring;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {
    EditText editText;
    Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle arguments = getIntent().getExtras();
        String result = "";
        if (arguments != null) {
            result += "aoao";
        }
        editText = (EditText)findViewById(R.id.editTextAnswer);
        editText.setText(result);

        homeButton = (Button)findViewById(R.id.btnHome);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnHome:
                        Intent intentAnswer = new Intent(ResultActivity.this, SelectActivity.class);
                        startActivity(intentAnswer);
                        break;
                    default:
                        break;
                }
            }
        };

        homeButton.setOnClickListener(oclBtnOk);

    }
}

