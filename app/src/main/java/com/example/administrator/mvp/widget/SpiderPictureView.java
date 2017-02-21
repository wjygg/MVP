package com.example.administrator.mvp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义 蜘蛛图
 *
 *
 * Created by wangjingyun on 2017/2/20.
 *
 */

public class SpiderPictureView extends View{

    private int mWidth=0;

    private int mHeight=0;

    //蜘蛛图的整个半径
    private float maxRadii=0;

    //数据的个数
    private int count=6;

    private float radii;

    private float angle=(float)(Math.PI*2)/count;

    private Paint paint;
    public SpiderPictureView(Context context) {
       this(context,null);
    }

    public SpiderPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint=new Paint();
      //  paint.setColor(0xFF6495ED);
        paint.setAntiAlias(true);
        paint.setColor(0xFF6495ED);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        maxRadii= (float) (Math.min(w,h)*0.9);

        mHeight=h;
        mWidth=w;

        super.onSizeChanged(w, h, oldw, oldh);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path=new Path();

        canvas.translate(mWidth/2,mHeight/2);

        //每个六边形的半径
        radii=maxRadii/(count-1);

        //绘制六边形

        for(int i=1;i<count;i++){

            float r=radii*1;
            //重置path的属性
            path.reset();
            //开始绘制点
            for(int j=0;j<count;j++){


                if(j==0){
                    //移动第一个点
                    path.moveTo(mWidth+r,mHeight);
                }else{
                    //
                    float x=(float) (Math.cos(angle*j)*r+mWidth);

                    float y=(float) (Math.sin(angle*j)*r+mHeight);

                    path.lineTo(x,y);
                }
            }

            path.close();//闭合路径
            canvas.drawPath(path, paint);
        }

    }
}
