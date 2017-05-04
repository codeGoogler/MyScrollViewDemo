package cv.yyh.com.mycrollviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/24/024.
 */
public class TestScrollTest extends Activity{
    @Bind(R.id.textView)
    TextView textView;
    private  int widht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testscrolltest);
        ButterKnife.bind(this);
        try {
            widht = DensityUtil.getScreenIntWidth(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.btn_scroby01,R.id.btn_scroby02, R.id.btn_scroto01,R.id.btn_scroto02, R.id.btn_reverse})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_scroby01:
                textView.scrollBy(20,0);
                break;
            case R.id.btn_scroby02:
                textView.scrollBy(-10,0);
                break;
           case R.id.btn_scroto01:

               textView.scrollTo(widht / 2,0);
                break;
            case R.id.btn_scroto02:
                textView.scrollTo( -100 ,0);
                break;
            case R.id.btn_reverse:
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,DensityUtil.dip2px(this,200));
                params.gravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                textView.setLayoutParams(params);
                break;
        }
    }
}
