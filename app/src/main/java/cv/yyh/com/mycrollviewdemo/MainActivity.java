package cv.yyh.com.mycrollviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_test01)
    Button btn_test01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.btn_test01,R.id.btn_test02})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_test01:
                try {
                    ActivityUtils.showActivity(MainActivity.this,TestScrollTest.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_test02:
                ActivityUtils.showActivity(MainActivity.this,ScrollTestLiniearActivity.class);
                break;
        }
    }
}
