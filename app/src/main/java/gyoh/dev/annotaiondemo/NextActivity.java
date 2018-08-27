package gyoh.dev.annotaiondemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        @Nullable @Mode String mode = getIntent().getStringExtra("mode");
        getSupportActionBar().setTitle(mode);

        switch (mode) {
            case Mode.DEFAULT:
                break;
            case Mode.SHARE:
                break;
        }
    }
}
