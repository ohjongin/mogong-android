package org.androidtown.alram_push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //DatePicker datePicker;
    AlarmReceiver alarmReceiver;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Time_Picker tp = new Time_Picker();
        tp.openTimePickerDialog();
        /*
        WebView webView = (WebView)findViewById(R.id.web_view);
        webView.loadUrl("172.16.0.87:3000");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(this), "app");

        /*
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

}
