package com.fragmentlessons;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.fragmentlessons.fragments.FragmentService;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static TableLayout tableLayout = null;
    private static int counter;
    private static Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = (Context) getApplicationContext();
        Objects.requireNonNull(getSupportActionBar()).hide();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.mainFragmentContainer, FragmentService.class, null)
                    .commit();
        }
        tableLayout = (TableLayout) findViewById(R.id.listDebug);
    }

    public static void PrintMessage(int type, String tag, String data) {
        Log.e("MainActivity", "start PrintMessage");
        counter++;

        if (type == mLog.ERROR) tableLayout.addView(mLog.e(tag, data, counter, context));
        else if (type == mLog.WARNING) tableLayout.addView(mLog.w(tag, data, counter, context));
        else if (type == mLog.VERBOSE) tableLayout.addView(mLog.v(tag, data, counter, context));
        else if (type == mLog.DEBUG) tableLayout.addView(mLog.d(tag, data, counter, context));
        else if (type == mLog.INFO) tableLayout.addView(mLog.i(tag, data, counter, context));

        Log.e("MainActivity", "PrintMessage - Complete" + String.format(" %d: %s : %s : %d",type, tag, data, counter));
    }
}