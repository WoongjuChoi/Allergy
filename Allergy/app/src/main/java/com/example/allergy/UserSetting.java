package com.example.allergy;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserSetting extends AppCompatActivity {
    boolean checked1 ;
    boolean checked2 ;
    boolean checked3 ;
    boolean checked4 ;
    boolean checked5 ;
    boolean checked6 ;
    boolean checked7 ;
    boolean checked8 ;
    boolean checked9 ;
    boolean checked10 ;
    boolean checked11 ;
    boolean checked12 ;
    boolean checked13 ;
    boolean checked14 ;
    boolean checked15 ;
    boolean checked16 ;
    boolean checked17 ;
    boolean checked18 ;
    boolean checked19 ;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_setting);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Switch switch2 = (Switch) findViewById(R.id.switch2);
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        Switch switch4 = (Switch) findViewById(R.id.switch4);
        Switch switch5 = (Switch) findViewById(R.id.switch5);
        Switch switch6 = (Switch) findViewById(R.id.switch6);
        Switch switch7 = (Switch) findViewById(R.id.switch7);
        Switch switch8 = (Switch) findViewById(R.id.switch8);
        Switch switch9 = (Switch) findViewById(R.id.switch9);
        Switch switch10 = (Switch) findViewById(R.id.switch10);
        Switch switch11 = (Switch) findViewById(R.id.switch11);
        Switch switch12 = (Switch) findViewById(R.id.switch12);
        Switch switch13 = (Switch) findViewById(R.id.switch13);
        Switch switch14 = (Switch) findViewById(R.id.switch14);
        Switch switch15 = (Switch) findViewById(R.id.switch15);
        Switch switch16 = (Switch) findViewById(R.id.switch16);
        Switch switch17 = (Switch) findViewById(R.id.switch17);
        Switch switch18 = (Switch) findViewById(R.id.switch18);
        Switch switch19 = (Switch) findViewById(R.id.switch19);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch1.setChecked(isChecked);
                    checked1=isChecked;
                }else{
                    switch1.setChecked(false);
                    checked1=false;
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch2.setChecked(isChecked);
                    checked2=isChecked;
                }else{
                    switch2.setChecked(false);
                    checked2=false;
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch3.setChecked(isChecked);
                    checked3=isChecked;
                }else{
                    switch3.setChecked(false);
                    checked3=false;
                }
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch4.setChecked(isChecked);
                    checked4=isChecked;
                }else{
                    switch4.setChecked(false);
                    checked4=false;
                }
            }
        });
        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch5.setChecked(isChecked);
                    checked5=isChecked;
                }else{
                    switch5.setChecked(false);
                    checked5=false;
                }
            }
        });
        switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch6.setChecked(isChecked);
                    checked6=isChecked;
                }else{
                    switch6.setChecked(false);
                    checked6=false;
                }
            }
        });
        switch7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch7.setChecked(isChecked);
                    checked7=isChecked;
                }else{
                    switch7.setChecked(false);
                    checked7=false;
                }
            }
        });
        switch8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch8.setChecked(isChecked);
                    checked8=isChecked;
                }else{
                    switch9.setChecked(false);
                    checked9=false;
                }
            }
        });
        switch9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch9.setChecked(isChecked);
                    checked9=isChecked;
                }else{
                    switch9.setChecked(false);
                    checked9=false;
                }
            }
        });
        switch10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch10.setChecked(isChecked);
                    checked10=isChecked;
                } else{
                    switch10.setChecked(false);
                    checked10=false;
                }
            }
        });
        switch11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch11.setChecked(isChecked);
                    checked11=isChecked;
                }else{
                    switch11.setChecked(false);
                    checked11=false;
                }
            }
        });
        switch12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch12.setChecked(isChecked);
                    checked12=isChecked;
                }else{
                    switch12.setChecked(false);
                    checked12=false;
                }
            }
        });
        switch13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch13.setChecked(isChecked);
                    checked13=isChecked;
                }else{
                    switch13.setChecked(false);
                    checked13=false;
                }
            }
        });
        switch14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch14.setChecked(isChecked);
                    checked14=isChecked;
                }else{
                    switch14.setChecked(false);
                    checked14=false;
                }
            }
        });
        switch15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch15.setChecked(isChecked);
                    checked15=isChecked;
                }else{
                    switch15.setChecked(false);
                    checked15=false;
                }
            }
        });
        switch16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch16.setChecked(isChecked);
                    checked16=isChecked;
                }else{
                    switch16.setChecked(false);
                    checked16=false;
                }
            }
        });
        switch17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch17.setChecked(isChecked);
                    checked17=isChecked;
                }else{
                    switch17.setChecked(false);
                    checked17=false;
                }
            }
        });
        switch18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch18.setChecked(isChecked);
                    checked18=isChecked;
                }else{
                    switch18.setChecked(false);
                    checked18=false;
                }
            }
        });
        switch19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switch19.setChecked(isChecked);
                    checked19=isChecked;
                }else{
                    switch19.setChecked(false);
                    checked19=false;
                }
            }
        });
    }
}
