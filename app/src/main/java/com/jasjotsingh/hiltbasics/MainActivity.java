package com.jasjotsingh.hiltbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    //field injection
    @Inject
    SomeClass someClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        someClass = new SomeClass();
        Toast.makeText(this, someClass.doAThing(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, someClass.doSomeOtherThing(), Toast.LENGTH_LONG).show();
    }
}

 class SomeClass{
    SomeOtherClass otherClass;
    @Inject
     public SomeClass() {
        //Constructor Injection
         otherClass = new SomeOtherClass();
     }

     @Inject

     public String doAThing(){
         return "Look I did a thing";
     }

     public String doSomeOtherThing(){
        return otherClass.doSomeOtherThing();
     }
 }

 class SomeOtherClass{

     @Inject
     public SomeOtherClass() {
     }

     public String doSomeOtherThing(){
         return "Look I did some other thing";
     }
 }
