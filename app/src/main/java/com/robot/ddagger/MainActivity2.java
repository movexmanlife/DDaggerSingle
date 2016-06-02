package com.robot.ddagger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.Student;

import javax.inject.Inject;

public class MainActivity2 extends AppCompatActivity {
    @Inject
    Student student;
    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);

        Context context = ((App)getApplication()).getAppComponent().getApplicationContext();
        student = ((App)getApplication()).getAppComponent().getStudent();
        Toast.makeText(context, "Test dagger2", Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
    }

    /**
     * 这里主要测试这个Student是不是单例，经过测试这个Student果然是单例。
     *
     * student = ((App)getApplication()).getAppComponent().getStudent();
     * 这个会去实例化student，如果已经实例化了，则直接返回已经实例化的。
     *
     *
     * 特别要注意@Inject Student student并不代表实例化student。
     */
    private void test() {
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
        student.setName("22222222222222222222222222222");
    }

    private void test2() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}
