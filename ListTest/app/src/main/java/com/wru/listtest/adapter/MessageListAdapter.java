package com.wru.listtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wru.listtest.R;
import com.wru.listtest.valueobject.MessageVO;

/**
 * Created by SANG-ASUS on 2018/4/19.
 */

public class MessageListAdapter extends RecyclerView.Adapter {
    public DataSource dataSource;
    public Context context;

    public MessageListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_message_send, parent, false);
        return new MessageItemVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageItemVH vh = (MessageItemVH) holder;
        vh.bind(dataSource.messageAtIndex(position));
    }

    @Override
    public int getItemCount() {
        return dataSource.numberOfMessages();
    }

    public class MessageItemVH extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView message;
        public MessageItemVH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);
        }

        public void bind(MessageVO vo) {
            name.setText(vo.name);
            message.setText(vo.message);
        }
    }

    public interface DataSource {
        int numberOfMessages();
        MessageVO messageAtIndex(int index);
    }
}
