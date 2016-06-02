package com.robot.ddagger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.Student;

import javax.inject.Inject;

/**
 * 测试dagger2单例的使用
 */
public class MainActivity extends AppCompatActivity {
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

    private void test() {
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }
    private void test2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}
