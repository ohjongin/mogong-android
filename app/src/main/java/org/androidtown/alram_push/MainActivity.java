package org.androidtown.alram_push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    //DatePicker datePicker;
    AlarmReceiver alarmReceiver;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Log.w(TAG, "NOW: " + getDateTimeString(now));

        TimePickerDialog dlg = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("", "hourOfDay: " + hourOfDay + ", minute: " + minute);

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                cal.set(Calendar.SECOND, now.get(Calendar.SECOND));

                Log.w(TAG, "SET: " + getDateTimeString(cal));

                setAlarm(getBaseContext(), cal.getTimeInMillis());
            }
        }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);
        dlg.show();
    }

    public void setAlarm(Context context, long alarmAt) {
        Log.i("error", "aaaaaaaaaaaaaaaaaa");
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //textAlarmPrompt.setText("\n" + "Alarm is set " + targetCal.getTime() + "\n");
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        Log.i("error", "bbbbbbbbbbbbbbbbbbbbb");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 0, intent, 0);
        //AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmAt, pendingIntent);
    }

        /*
        WebView webView = (WebView)findViewById(R.id.web_view);
        webView.loadUrl("172.16.0.87:3000");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(this), "app");


        datePicker = (DatePicker) findViewById(R.id.datepicker);

        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dataOfMonth) {
                String msg = String.format("%d / %d / %d", year, monthOfYear + 1, dataOfMonth);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        */
        //}
        /*
    public class WebViewJavaScriptInterface
    {
        private Context context;

        public WebViewJavaScriptInterface(Context context)
        {
            this.context = context;
        }
    }
    */

    protected String getDateTimeString(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(cal.getTimeInMillis()));
    }

}
