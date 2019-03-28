package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfileFriend extends AppCompatActivity implements View.OnClickListener {
    Button chat;
    TextView name;
    TextView interest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        name = findViewById(R.id.namefriendinfo);
        interest = findViewById(R.id.infintfriendinfo);
        chat = findViewById(R.id.monbutfriendinfo);
        chat.setOnClickListener(this);
        name.setText(String.format("%s %s", getIntent().getStringExtra("userFirstName"), getIntent().getStringExtra("userLastName")));
        interest.setText(getIntent().getStringExtra("userListInterests"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.monbutfriendinfo: {
                AdapterProfileFriend adapterProfileFriend = new AdapterProfileFriend(getIntent().getStringExtra("userId"),
                        getIntent().getStringExtra("userFirstName"), getIntent().getStringExtra("userLastName"),
                        getIntent().getStringExtra("userAge"), getIntent().getStringExtra("userSex"), getIntent().getStringExtra("userListInterests"));
                adapterProfileFriend.startActivityChat(this);
            }
        }
    }
}
