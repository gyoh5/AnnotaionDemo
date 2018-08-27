package gyoh.dev.annotaiondemo;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringDef;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://developer.android.com/studio/write/annotations?hl=ko

        setBackgroundColor(-1, android.R.color.holo_red_dark);

        Character character = getCharacter();
        loadThumbnail(R.drawable.ic_launcher_background, getImageUrl(character));

        Log.d(TAG, "Mode.DEFAULT : " + Mode.DEFAULT);
    }

    //권한 주석
    @RequiresPermission(allOf = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA})
    public static final void openCamera() {

    }

    private void loadThumbnail(@DrawableRes int defaultResId, @Nullable String imgUrl) {
        boolean isEmpty = false;
        if (imgUrl != null) {
            isEmpty = imgUrl.isEmpty();
        }
        Log.d(TAG, "isEmpty : " + isEmpty);
    }

    @Nullable
    private Character getCharacter() {
        if (hasWindowFocus()) {
            new Character();
        }
        return null;
    }

    //리소스 주석
    @UiThread
    private void setBackgroundColor(@ColorInt int colorInt, @ColorRes int colorResId) {
        getWindow().getDecorView().setBackgroundColor(colorInt);
        getWindow().getDecorView().setBackgroundResource(colorResId);
        getWindow().getDecorView().setVisibility(View.VISIBLE);
    }

    //nullness 주석
    @NonNull
    private String getImageUrl(@Nullable Character character) {
        return character != null ? character.getId() : null;
    }

    public void onClickNext(View view) {
        startNextActivity(Mode.SHARE);
    }

    private void startNextActivity(@Mode String mode) {
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("mode", mode);
        startActivity(intent);
    }

    //character
    private class Character {
        @NonNull
        String id = "";

        @NonNull
        public String getId() {
            return id;
        }
    }

    //def 주석
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {
            Error.UNKWON,
            Error.TIMEOUT,
            Error.SERVER
    }, flag = true)
    public @interface Error {
        int UNKWON = 1;
        int TIMEOUT = 2;
        int SERVER = 3;
    }
}
