package com.example.user.grafics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int id=1;
    public final static String ks="k";
    public final static String bs="b";
    public final static String cs="c";
    public final static String ids="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(ClickListener);
        TextView txt=(TextView)findViewById(R.id.txt);
        RadioGroup rg=(RadioGroup)findViewById(R.id.group) ;
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.one:
                        id=1;
                        break;
                    case R.id.two:
                        id=2;
                        break;
                    case R.id.three:
                        id=3;
                        break;
                    case R.id.four:
                        id=4;
                        break;
                    case R.id.five:
                        id=5;
                        break;
                    case R.id.six:
                        id=6;
                        break;
                    case R.id.seven:
                        id=7;
                        break;
                    case R.id.eight:
                        id=8;
                        break;
                    case R.id.nine:
                        id=9;
                        break;
                }
            }
        });
    }

    View.OnClickListener ClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                try {
                    EditText k = (EditText) findViewById(R.id.k);
                    EditText b = (EditText) findViewById(R.id.b);
                    EditText c = (EditText) findViewById(R.id.c);
                    Intent intent = new Intent(view.getContext(), grafic.class);
                    float kP = Float.parseFloat(k.getText().toString());
                    float bP = Float.parseFloat(b.getText().toString());
                    float cP = Float.parseFloat(c.getText().toString());
                    intent.putExtra(ks, kP);
                    intent.putExtra(bs, bP);
                    intent.putExtra(cs, cP);
                    intent.putExtra(ids,id);
                    startActivity(intent);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Введите переменные.",Toast.LENGTH_SHORT).show();
                }
        }
    };
}
