package com.wru.ryclist0419;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.wru.ryclist0419.Adapter.RecycleAdapter;
import com.wru.ryclist0419.ValueObject.MessageValueObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.DataSource {
    //声明页面元素，准备绑定
    private Button Btn_Send;
    private RecyclerView rycView;
    private EditText editText;

    private ArrayList<MessageValueObject> messageValueObjects=new ArrayList<>();
    //准备一个Adapter
    public RecycleAdapter rycAdapter;

    //程序的开始
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //进行页面元素绑定
        Btn_Send=findViewById(R.id.Btn_Send);
        editText=findViewById(R.id.editText);
        rycView=findViewById(R.id.recyclerView);
        //按钮绑定事件
        Btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        /*这需要初始化一下data（随意啦）*/




        //new一个Adapter给刚刚创建的Adapter
        //把MainActivity传进去
        rycAdapter=new RecycleAdapter(this);
        //这里需要重写DataSource的两个方法
        rycAdapter.dataSource=this;
        //dataSource有了，现在绑定到recyclerView控件上
        rycView.setAdapter(rycAdapter);
        //[没啥用]调整一下姿势
        LinearLayoutManager LLM=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rycView.setLayoutManager(LLM);

        //到这里咱就可以了，基本可以给按钮加NotifyChanged了





        //
    }

    //发送消息
    private void sendMessage() {
        //拿到EditText的文本
        String messageOnText=editText.getText().toString();
        if(messageOnText.length()!=0)
        {
            //将EditText的文本 Add到DataSource
            messageValueObjects.add(new MessageValueObject("Sangyu Li",messageOnText,true));
            rycAdapter.notifyDataSetChanged();

            //并清空editText控件的文本
            editText.setText(null);
        }
    }


    @Override
    public int numberOfMessage()
    {
        //这里需要返回ArrayList的Message的信息
        return messageValueObjects.size();
    }

    @Override
    public MessageValueObject MessageAtIndex(int index)
    {
        return messageValueObjects.get(index);
    }
}
