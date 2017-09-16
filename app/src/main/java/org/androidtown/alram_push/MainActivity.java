package org.androidtown.alram_push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //DatePicker datePicker;
    AlarmReceiver alarmReceiver;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Time_Picker tp = new Time_Picker();
        //tp.openTimePickerDialog();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int second = 5000;

        TimePickerDialog dlg = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("", "hourOfDay: " + hourOfDay + ", minute: " + minute);
            }
        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false);
        dlg.show();
        setAlarm(this, second);
    }

    public void setAlarm(Context context, long second) {
        Log.i("error", "aaaaaaaaaaaaaaaaaa");
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //textAlarmPrompt.setText("\n" + "Alarm is set " + targetCal.getTime() + "\n");
        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        Log.i("error", "bbbbbbbbbbbbbbbbbbbbb");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 0, intent, 0);
        //AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + second, pendingIntent);
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


}
