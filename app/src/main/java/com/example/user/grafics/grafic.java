package com.example.user.grafics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.user.grafics.MainActivity.bs;
import static com.example.user.grafics.MainActivity.cs;
import static com.example.user.grafics.MainActivity.ids;
import static com.example.user.grafics.MainActivity.ks;

public class grafic extends AppCompatActivity {
    int y, x,Id;
    float K, B, C;
    Paint pP;
    Paint e;
    float xMax = 20F;
    float xMin = 0F;
    float yMax = 20F;
    float yMin = 0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        float kP, bP, cP;
        int defK, defB, defC, defId,idP;
        defK = 1;
        defB = 0;
        defC = 0;
        defId = 1;
        kP = intent.getFloatExtra(ks, defK);
        bP = intent.getFloatExtra(bs, defB);
        cP = intent.getFloatExtra(cs, defC);
        idP = intent.getIntExtra(ids, defId);
        K = kP;
        B = bP;
        C = cP;
        Id=idP;
        final DrawView drawView =new DrawView(this);
        setContentView(drawView);
        final LinearLayout grafic=(LinearLayout) findViewById(R.id.grafic) ;
        drawView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                x = drawView.getWidth();
                y = drawView.getHeight();
                if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                    drawView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                else
                    drawView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }
    class DrawView extends View {
        Paint pP,e;
        public DrawView(Context context) {
            super(context);
            pP=new Paint();
            e=new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.save();
            float xMax=20F;
            float xMin=0F;
            float yMax=20F;
            float yMin=0F;
            canvas.scale(x/(xMax-xMin),-y/(yMax-yMin));
            canvas.translate(-xMin+0.2F,-yMax+0.2F);
            pP.setStrokeWidth((float) 0.1);
            e.setStrokeWidth((float) 0.03);
            canvas.drawLine(10F,-1F,10F,20F,pP);
            canvas.drawLine(-1F,10F,20F,10F,pP);
            int p=0;
            for(int i = (int) 0F;i<=20F;i+=1F){
                canvas.drawLine(0F,i,20F,i,e);
                canvas.drawLine(9.75F,i,10.25F,i,pP);
                canvas.drawLine(i,0F,i,20F,e);
                canvas.drawLine(i,9.75F,i,10.25F,pP);
            }
            float op1,op2;
            op2=0;

            switch (Id){
                case 1:
                    for(float i = -10;i<=10;i+=0.01){
                        op2=K*i+B;
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 2:
                    for(float i=-10;i<=10;i+=0.01){
                        op2=K*i*i+B*i+C;
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 3:
                    for(float i=-10;i<=10;i+=0.001){
                        op2=K*i*i*i+B;
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 4:
                    for(float i=-10;i<=10;i+=0.001){
                        op2= (float) (K*Math.pow(i,0.5));
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 5:
                    for(float i=-10;i<=10;i+=0.001){
                        op2=K/i;
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 6:
                    for(float i=-10;i<=10;i+=0.01){
                        op2= (float) (K*Math.sin(i*B)+C);
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 7:
                    for(float i=-10;i<=10;i+=0.01){
                        op2=(float) (K*Math.cos(i*B)+C);
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 8:
                    for(float i=-10;i<=10;i+=0.001){
                        op2=(float) (K*Math.tan(i*B)+C);
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
                case 9:
                    for(float i=-10;i<=10;i+=0.001){
                        op2=(float) (K/Math.tan(i*B)+C);
                        canvas.drawPoint(i+10,op2+10,pP);
                    }
                    break;
            }
            canvas.restore();
        }

    }
}