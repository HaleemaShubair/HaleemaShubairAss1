package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Button zeroButton;

    public static ActivityMainBinding mainBinding;

//    public TextView displayCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        displayCountText = findViewById(R.id.text_display_count);
      zeroButton=mainBinding.buttonZero;
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void showCount(View view) {
        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        if (count %2==0){
           view.setBackgroundColor(ContextCompat.getColor(this,android.R.color.holo_blue_light));
        }
        else {
            view.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        }

        zeroButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_light));
//        displayCountText.setText(String.valueOf(count));
    }
    public void showZero(View view){
        count =0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
        zeroButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray));
    }
}
