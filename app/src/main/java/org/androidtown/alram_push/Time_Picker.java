package org.androidtown.alram_push;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by samsung on 2017-09-16.
 */

public class Time_Picker extends Activity
{
        TimePicker myTimePicker;
        //Button buttonstartSetDialog, buttonCancelAlarm;
        TextView textAlarmPrompt;
        private String foramt = "";

        TimePickerDialog timePickerDialog;
        final static int RQS_1 = 1;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            myTimePicker = (TimePicker) findViewById(R.id.timePicker);
            textAlarmPrompt = (TextView) findViewById(R.id.alarmprompt);


            Calendar calendar = Calendar.getInstance();
            calendar = Calendar.getInstance();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myTimePicker.setHour(calendar.get(Calendar.HOUR_OF_DAY));
                myTimePicker.setMinute(calendar.get(Calendar.MINUTE));
            } else {
                myTimePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
                myTimePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
            }
        }

        public void openTimePickerDialog()
        {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            Calendar current = Calendar.getInstance();
            int second = 5000;

            Calendar cal = Calendar.getInstance();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                cal.set(myTimePicker.getHour(), myTimePicker.getMinute()+second, 00);
            }
            /*
            else
            {
                cal.set(myTimePicker.getCurrentHour(), myTimePicker.getCurrentMinute()+second, 00);
            }
            */
            //setAlarm(cal);
        }

        public void setAlarm(Context context)
        {
            Log.i("error", "aaaaaaaaaaaaaaaaaa");
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            //textAlarmPrompt.setText("\n" + "Alarm is set " + targetCal.getTime() + "\n");
            Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
            Log.i("error", "bbbbbbbbbbbbbbbbbbbbb");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
            //AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(), pendingIntent);
        }
}
