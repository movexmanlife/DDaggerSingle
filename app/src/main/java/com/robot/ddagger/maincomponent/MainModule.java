package com.robot.ddagger.maincomponent;

import android.content.Context;

import com.robot.ddagger.App;
import com.robot.ddagger.bean.Student;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private static int count = 0;
    public MainModule() {
    }

    @Provides
    @Singleton
    Student providerStudent() {
        return new Student(23, "jack" + String.valueOf(count++));
    }

}
