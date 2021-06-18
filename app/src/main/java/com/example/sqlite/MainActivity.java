package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        //INSERT DATA
        insertUser();

        //GET DATA
        getAllUser();

        //UPDATE DATA
        updateUser();

        //DELETE DATA
        deleteUser();

    }

    private void deleteUser() {
        db.deleteUser(5);
    }

    private void updateUser() {
        User user = new User();
        user.setId(3);
        user.setName("Hoang Phuong Dung update");
        user.setAge(15);
        String message = db.updateUser(user);
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    private void getAllUser() {
        List<User> listUser = db.getAllUser();
        for(User user : listUser){
            Log.d("USER", "name: " + user.getName() + "id : " +user.getId() + "age : " +user.getAge());
        }
    }

    private void insertUser() {
        User user = new User("Nguyen Xuan Huy", "Male", 20);
        String message = db.insertDB(user);
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        db.close();
    }
}
