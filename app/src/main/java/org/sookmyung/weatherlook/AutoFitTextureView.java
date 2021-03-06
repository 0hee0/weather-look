package org.sookmyung.weatherlook;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;


public class AutoFitTextureView extends TextureView
{
    private int mRatioWidth = 0;
    private int mRatioHeight = 0;

    //Constructors
    public AutoFitTextureView(Context context){super(context);}
    public AutoFitTextureView(Context context, AttributeSet attrs){super(context,attrs);}
    public AutoFitTextureView(Context context, AttributeSet attrs, int defStyleAttr)
    {super(context,attrs,defStyleAttr);}

    public void setAspectRatio(int width, int height)
    {
        if(width < 0 || height < 0)
        {
            throw new IllegalArgumentException("Size can not be negative");
        }

        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }//end setAspectRatio

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if(mRatioHeight == 0 || mRatioHeight == 0){setMeasuredDimension(width,height);}
        else
        {
            if(width < height * mRatioWidth / mRatioHeight)
            {setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);}
            else
            {setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);}
        }
    }//End onMeasure
}//end class
