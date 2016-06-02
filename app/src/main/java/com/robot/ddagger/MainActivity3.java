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

public class MainActivity3 extends AppCompatActivity {
    /**
     * 这里要注意：@Inject并不会去注入实例化。
     */
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
     * 会崩溃，原因是这里student并没有被实例化。
     * 特别要注意@Inject Student student并不代表实例化student。
     */
    private void test() {
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }
    private void test2() {
        Intent intent = new Intent(this, TestSingleActivity.class);
        startActivity(intent);
    }

}
