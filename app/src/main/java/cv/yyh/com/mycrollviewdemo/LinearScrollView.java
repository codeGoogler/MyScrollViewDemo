package cv.yyh.com.mycrollviewdemo;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by Administrator on 2017/4/24/024.
 * http://blog.csdn.net/xyz_lmn/article/details/12517911
 * http://hunankeda110.iteye.com/blog/1944311
 * http://blog.csdn.net/yanbober/article/details/49904715
 */

public class LinearScrollView extends LinearLayout {
    private final String  TAG = "yuyahao";
    private int mSlop;
    private LayoutInflater layoutInflater;
    private Scroller scroller;
    int dx = 0;
    private int  leftBorder = 0;
    private int  rightBorder = 0;
    private int lastX;//上次触发action_down的坐标值
    private int mDownX;//手指按下去的屏幕坐标
    private int mMoveX;//当前的手指的坐标值
    public LinearScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        try {
          //  layoutInflater = LayoutInflater.from(context);
          //  View view = layoutInflater.inflate(R.layout.linearscrollview, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOrientation(HORIZONTAL);
//        View view = layoutInflater.inflate(R.layout.linearscrollview,null);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        //mSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        mSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();;
        scroller = new Scroller(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int chileCount = getChildCount();
        for (int i = 0; i < chileCount; i++) {
            View childView = getChildAt(i);
           measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            int childCount = getChildCount();
            int r2 =0  ;
            for (int i = 0; i < childCount; i++) {
                View chiledView = getChildAt(i);
                l =  chiledView.getLeft() * i;
                t = 0;
                r = chiledView.getRight()* i ;
                r2 = chiledView.getMeasuredWidth() + r2 ;
                int r1 = chiledView.getMeasuredWidth() * (i+1);
                Log.e("yyh",r+"     "+r1+ "    " +r2);
                b = chiledView.getMeasuredHeight();
                chiledView.layout(l,t,r2,b);
            }
            leftBorder = getChildAt(0).getLeft();
            rightBorder = getChildAt(childCount - 1).getRight();
            Log.i(TAG,"左边距:  " + leftBorder +"  右边距: " +rightBorder);
        }
    }

    //onInterceptTouchEvent是ViewGroup提供的方法，默认返回false，返回true表示拦截。
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //return false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int ss = (int) event.getRawX();
                mDownX = (int) event.getRawX();
                lastX = mDownX;
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveX = (int) event.getRawX();
                lastX = mMoveX;
                int ss2 = 0;
                int dexValyue = getScrollX() - leftBorder;
                if(0 > (dexValyue) ){
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:
                int s2s = 0;
                break;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public void computeScroll() {
      //  super.computeScroll();
        if(scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(), 0);
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int scrolledX = 0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
             int    dsx = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveX = (int) event.getRawX();
                scrolledX = (int) (lastX - mMoveX);
                if (getScrollX() + scrolledX < leftBorder) {
                  //  scrollTo(leftBorder, 0);
                    return true;
                } else if (getScrollX() + getWidth() + scrolledX > rightBorder) {
                //    scrollTo(rightBorder - getWidth(), 0);
                    return true;
                }




             int startX =  scroller.getStartX();//返回滚动起始点x的偏移量
             int finalX =    scroller.getFinalX();
             int currX =    scroller.getCurrX();
             int scrollx =    getScrollX();
             Log.i(TAG,"finalX:  "+finalX+"               "+"startX:  "+startX+""+"  currX: " +currX +"   scrollx:  "+scrollx+"        getScrollx():"+getScrollX()+"    getLeft(): "+ getLeft());
             scrollTo( scrolledX ,0);
//                lastX = mMoveX;
                break;
            case MotionEvent.ACTION_UP:

                scrolledX = (int) (lastX - mMoveX);
//                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
//                int dx = targetIndex * getWidth() - getScrollX();
                int  distanceX2 = (int)(event.getRawX() - dx);
                 scroller.startScroll(lastX,0,scrolledX,0);
                lastX = (int) event.getRawX();
                invalidate();
                break;
        }
        boolean falg = super.onTouchEvent(event);
        return true;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // 获取当前触摸的绝对坐标
//        int rawX = (int) event.getRawX();
//        int rawY = (int) event.getRawY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                // 上一次离开时的坐标
//                lastX = rawX;
//                lastY = rawY;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                // 两次的偏移量
//                int offsetX = rawX - lastX;
//                int offsetY = rawY - lastY;
//                moveView(offsetX, offsetY);
//                // 不断修改上次移动完成后坐标
//                lastX = rawX;
//                lastY = rawY;
//                break;
//            default:
//                break;
//        }
//        return true;
//    }

    private void moveView(int offsetX, int offsetY) {
        // 方法一
        // layout(getLeft() + offsetX, getTop() + offsetY, getRight() +
        // offsetX, getBottom() + offsetY);

        // 方法二
        // offsetLeftAndRight(offsetX);
        // offsetTopAndBottom(offsetY);

        // 方法三
        // LinearLayout.LayoutParams layoutParams = (LayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getTop() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法四
        // ViewGroup.MarginLayoutParams layoutParams = (MarginLayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getLeft() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法五
        ((View) getParent()).scrollBy(-offsetX, -offsetY);
    }
}
