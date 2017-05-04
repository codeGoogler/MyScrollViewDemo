package cv.yyh.com.mycrollviewdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.BaseAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/3/003.
 *
 */

public class MyService extends Service {
    private final  String  TAG = "yuyahao";
    private Timer timer ;
    private TimerTask task;
    private int anIntCount = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  1000:
                    Log.i(TAG,""+msg.obj.toString());
                    break;
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 1000;
                anIntCount++;
                msg.obj = anIntCount;
                handler.sendMessage(msg);
            }
        };
        timer.schedule(task,1000);
    }
   private  class MyBinder extends Binder {

       MyService getMyService(){
            return MyService.this;
       }
   }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

}
