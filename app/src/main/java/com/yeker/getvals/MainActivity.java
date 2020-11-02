package com.yeker.getvals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    public String FliePath = "/sys/class/yk_d6t/yk_d6t";//温度传感器
//    public String FliePath = "/sys/class/gpio_getVal/gpio_getVal";//电平检测
    public TextView textView = null;
    private String value = null;

    private Handler handler = new Handler();
    private Runnable task = new Runnable() {
        public void run() {
            // TODO Auto-generated method stub
            handler.postDelayed(this,500);//设置循环时间，此处是0.5秒
            //需要执行的代码
            value = readFile(FliePath);
//            textView.setText("电平为：" + value);//电平检测
            textView.setText("此时温度为：" + value);//温度检测
        }
    };

    public static String readFile(String fileName) {
        String readBuf = "";
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            int length = fis.available();
            byte[] buffer = new byte[length];
            fis.read(buffer);
            readBuf = new String(buffer, 0, length, StandardCharsets.UTF_8);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readBuf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_main);

        handler.postDelayed(task,500);//延迟调用
        handler.post(task);//立即调用
    }
}
