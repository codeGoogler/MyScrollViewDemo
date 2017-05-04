package cv.yyh.com.mycrollviewdemo;

import android.app.Activity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/24/024.
 */
public class ScrollTestLiniearActivity extends Activity {
    @Bind(R.id.lcol_view)
    LinearScrollView lcol_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolltestliniear);
        ButterKnife.bind(this);
    }
}
