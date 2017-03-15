package edu.shu.styluo.search.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by a1056 on 2017/3/15.
 */

public class ToastUtil {

    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
