package cv.yyh.com.mycrollviewdemo;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/5/3/003.
 * http://www.jb51.net/article/76490.htm
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService( ) {
        super("sadfs");
    }
    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.anly.githubapp.service.action.INIT";

    public static void start(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        LogUtil.e(TAG.TAG,"启动前");
        try {

            for (int i = 1; i < 6; i++) {
                Thread.sleep(1000);
                LogUtil.e(TAG.TAG,"耗时操作进行了: "+i+"  秒");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.e(TAG.TAG,"延迟了5秒的耗时操作.....");
    }
}
