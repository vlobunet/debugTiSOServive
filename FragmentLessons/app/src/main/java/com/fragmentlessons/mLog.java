package com.fragmentlessons;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.content.Context;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

/**
 * Mock Log implementation for testing on non android host.
 */
public final class mLog {
/**
 * Constant type message
 */
    public static final int ERROR = 0;
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARNING = 3;
    public static final int VERBOSE = 4;

    private mLog() {
    }

    /**
     * Send a ERROR log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param id Row identification
     * @param context context for creating TableRow
     */
    public static TableRow e(String tag, String msg, int id, Context context) {
        TableRow row = new TableRow(context);
        row.setId(id);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView message = new TextView(context);
        message.setTextColor(Color.RED);
        message.setText(String.format("E: %s : %s", tag, msg));
        row.addView(message);
        return row;
    }
    /**
     * Send a DEBUG log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param id Row identification
     * @param context context for creating TableRow
     */
    public static TableRow d(String tag, String msg, int id, Context context) {
        TableRow row = new TableRow(context);
        row.setId(id);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView message = new TextView(context);
        message.setTextColor(Color.YELLOW);
        message.setText(String.format("D: %s : %s", tag, msg));
        row.addView(message);
        return row;
    }

    /**
     * Send a INFO log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param id Row identification
     * @param context context for creating TableRow
     */
    public static TableRow i(String tag, String msg, int id, Context context) {
        TableRow row = new TableRow(context);
        row.setId(id);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView message = new TextView(context);
        message.setTextColor(Color.WHITE);
        message.setText(String.format("I: %s : %s", tag, msg));

        row.addView(message);
        return row;
    }

    /**
     * Send a WARNING log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param id Row identification
     * @param context context for creating TableRow
     */
    public static TableRow w(String tag, String msg, int id, Context context) {
        TableRow row = new TableRow(context);
        row.setId(id);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView message = new TextView(context);
        message.setTextColor(0xFFFF5400);
        message.setText(String.format("W: %s : %s", tag, msg));

        row.addView(message);
        return row;
    }

    /**
     * Send a VERBOSE log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param id Row identification
     * @param context context for creating TableRow
     */
    public static TableRow v(String tag, String msg, int id, Context context) {
        TableRow row = new TableRow(context);
        row.setId(id);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView message = new TextView(context);
        message.setTextColor(Color.BLUE);
        message.setText(String.format("V: %s : %s", tag, msg));

        row.addView(message);
        return row;
    }
}
