package demo.mark.com.myskinviewdemo4;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.jia.jspermission.listener.JsPermissionListener;
import com.jia.jspermission.utils.JsPermission;
import com.jia.jspermission.utils.JsPermissionUtils;

public class MarkActivity extends AppCompatActivity  implements JsPermissionListener{

    private static final String TAG = "MarkActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        permisssion();
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(MarkActivity.this)) {
                //不需要授权
            } else {
                //打开设置去授权悬浮框权限
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(intent);
            }
        } else {
            //不需要授权
        }
    }

    private void permisssion() {
        if (JsPermissionUtils.needRequestPermission()) {
            JsPermission.with(this)
                    .requestCode(20)
                    .permission(Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.BODY_SENSORS,
                            Manifest.permission.SYSTEM_ALERT_WINDOW) // 不定长参数
                    .callBack(this)
                    .send();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        JsPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermit(int requestCode, String... permission) {
        Log.e(TAG, "onPermit: " + requestCode + " " + permission.toString());
    }

    @Override
    public void onCancel(int requestCode, String... permission) {
        Log.e(TAG, "onCancel: " + requestCode + " " + permission.toString());
    }

}
