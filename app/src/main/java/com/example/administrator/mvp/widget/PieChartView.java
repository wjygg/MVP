package com.example.administrator.mvp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.mvp.R;

/**
 * 自定义饼状图
 *
 * Created by wangjingyun on 2017/2/16.
 */

public class PieChartView extends View {

    private Paint paint=null;
    //弧形初始角度为0
    private int angle=0;

    private Context context;

    private int mWidth=0;

    private int mHeight=0;

    private int[] color=new int[]{0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69};

    public PieChartView(Context context) {
        this(context,null);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }
    //初始化画笔
    public void initPaint(){

        paint=new Paint();
        //设置画笔 为填充
        paint.setStyle(Paint.Style.FILL);
        //设置为抗锯齿
        paint.setAntiAlias(true);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight=h;
        mWidth=w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画布的绘制点到 屏幕中间

        canvas.translate(mWidth/2,mHeight/2);

        RectF rect=new RectF(-300,-300,300,300);

    //  canvas.drawRoundRect(rect,300,150,paint);

    //    canvas.drawRect(rect,paint);

        paint.setColor(getResources().getColor(R.color.orange));

        canvas.drawRect(rect,paint);

        //循环绘制 圆弧  每个圆弧占60度

        for(int i=0;i<=5;i++){

            paint.setColor(color[i]);

            canvas.drawArc(rect,angle,60,true,paint);

            angle+=60;
        }

    }
}
