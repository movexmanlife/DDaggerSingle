package com.robot.ddagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.Student;
import com.robot.ddagger.maincomponent.DaggerMainComponent;
import com.robot.ddagger.maincomponent.MainComponent;
import com.robot.ddagger.maincomponent.MainModule;

import javax.inject.Inject;

public class TestSingleActivity extends AppCompatActivity {

    @Inject
    Student student;

    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_single);

        MainComponent mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        student = mainComponent.getStudent();

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
     * 这里并没有在MainComponent并没有在Application中获取的。所以
     * @Singleton并不是代表它就是单例。只是说明性质的，要实现单例，需要依靠在Application中。
     */
    private void test() {
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
        student.setName("test test");
    }

    /**
     * 这里的现象就是每次都会生成一个新的Student实例。
     */
    private void test2() {
        MainComponent mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        student = mainComponent.getStudent();
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }
}
