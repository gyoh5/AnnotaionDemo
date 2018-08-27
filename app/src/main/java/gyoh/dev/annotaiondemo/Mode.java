package gyoh.dev.annotaiondemo;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static gyoh.dev.annotaiondemo.Mode.DEFAULT;
import static gyoh.dev.annotaiondemo.Mode.SHARE;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        DEFAULT, SHARE
})
public @interface Mode {
    String DEFAULT = "대화";
    String SHARE = "대화공유";
}

