package com.wru.listtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wru.listtest.adapter.MessageListAdapter;
import com.wru.listtest.valueobject.MessageVO;

import java.util.ArrayList;

public class MainActivity extends Activity implements MessageListAdapter.DataSource {
    private RecyclerView list;
    private EditText input;
    private Button send;

    private ArrayList<MessageVO> messages = new ArrayList<>();
    private MessageListAdapter adapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        input = findViewById(R.id.input);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) 
            {
                sendMessage();
            }
        });

        initData();

        adapter = new MessageListAdapter(this);
        adapter.dataSource = this;
        list.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(layoutManager);
    }

    private void initData() {
        messages.add(new MessageVO("tom", "hello", true));
        messages.add(new MessageVO("tom", "hello1", true));
        messages.add(new MessageVO("tom", "hello2", true));
        messages.add(new MessageVO("tom", "hello3", true));

    }

    private void sendMessage() 
    {
        String message = input.getText().toString();
        if (message.length() == 0) {
            return;
        }
        messages.add(new MessageVO("tom", message, true));
        adapter.notifyDataSetChanged();
        input.setText(null);
    }

    @Override
    public int numberOfMessages() {
        return messages.size();
    }

    @Override
    public MessageVO messageAtIndex(int index) {
        return messages.get(index);
    }
}
