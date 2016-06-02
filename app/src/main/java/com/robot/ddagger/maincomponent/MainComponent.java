package com.robot.ddagger.maincomponent;


import com.robot.ddagger.bean.Student;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    Student getStudent();
}
