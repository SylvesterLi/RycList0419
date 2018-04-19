package com.wru.ryclist0419.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wru.ryclist0419.R;
import com.wru.ryclist0419.ValueObject.MessageValueObject;

import javax.sql.DataSource;

/**
 * Created by SANG-ASUS on 2018/4/19.
 */

public class RecycleAdapter extends RecyclerView.Adapter {

    public DataSource dataSource;
    public Context context;
    //构造函数
    //将传进来的MainActivity的Context
    public RecycleAdapter(Context context)
    {
        this.context= context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //将Context转为View
        View view= LayoutInflater.from(context).inflate(R.layout.layout_message_send,parent,false);
        //将MainActivity的View传给ItemViewHolder  并返回
        return new MessageItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        //将View Holder类型转为（继承于ViewHolder的）MessageItemViewHolder
        MessageItemViewHolder viewHolder=(MessageItemViewHolder) holder;
        //进行数据绑定
        viewHolder.bindData(dataSource.MessageAtIndex(position));

    }

    @Override
    public int getItemCount()
    {
        return dataSource.numberOfMessage();

    }

    //用于接收别人传过来的 Name + message
    public class MessageItemViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView message;
        public MessageItemViewHolder(View itemView)
        {
            super(itemView);
            //绑定元素
            name=itemView.findViewById(R.id.txt_Name);
            message=itemView.findViewById(R.id.txt_Message);
        }
        public void bindData(MessageValueObject msgVO)
        {
            name.setText(msgVO.Name);
            message.setText(msgVO.Message);
        }
    }



    public interface DataSource
    {
        int numberOfMessage();
        MessageValueObject MessageAtIndex(int index);
    }
}
