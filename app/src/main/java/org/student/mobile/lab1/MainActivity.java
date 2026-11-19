package org.student.mobile.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;

public class MainActivity extends Activity {
    private void applySystemBarInsets(View root) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            final int left = root.getPaddingLeft();
            final int top = root.getPaddingTop();
            final int right = root.getPaddingRight();
            final int bottom = root.getPaddingBottom();
            root.setOnApplyWindowInsetsListener((view, insets) -> {
                android.graphics.Insets bars = insets.getInsets(WindowInsets.Type.systemBars());
                view.setPadding(left + bars.left, top + bars.top,
                        right + bars.right, bottom + bars.bottom);
                return insets;
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applySystemBarInsets(findViewById(R.id.root_container));
    }
}
