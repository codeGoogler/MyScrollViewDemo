package cv.yyh.com.mycrollviewdemo;

import android.app.Application;
import android.app.IntentService;
import android.content.Intent;
import android.os.CountDownTimer;

/**
 * Created by Administrator on 2017/5/3/003.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(MyApplication.this,MyIntentService.class);
        //IntentService myIntentService = new MyIntentService(MyApplication.this.getPackageName());
        startService(intent);
      //  MyIntentService.start(this);

}
    CountDownTimer timer = new CountDownTimer(5000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            LogUtil.e(TAG.TAG,millisUntilFinished+"");
        }
        @Override
        public void onFinish() {
            LogUtil.e(TAG.TAG,"onFinish  onFinish");
        }
    };

}
