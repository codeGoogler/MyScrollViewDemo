package cv.yyh.com.mycrollviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/4/24/024.
 */
public class ActivityUtils {
    public static void showActivity(Context cnt, Class<? extends Activity> activity) {
        cnt.startActivity(new Intent(cnt,activity));
    }
}
