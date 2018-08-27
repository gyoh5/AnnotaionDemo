package gyoh.dev.annotaiondemo;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static gyoh.dev.annotaiondemo.Mode.DEFAULT;
import static gyoh.dev.annotaiondemo.Mode.SHARE;

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        DEFAULT, SHARE 
})
public @interface Mode {
    int DEFAULT = R.string.title_default;
    int SHARE = R.string.title_share;
}

