package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.myapp.bean.News;

class ViewPager2Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<News> datas;
    Context context;
    public ViewPager2Adapter(Context context, List<News> datas){
        this.datas = datas;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = datas.get(position);
        holder.title.setText(news.getTitle());
        holder.subTitle.setText(news.getInfo());
        //holder.content.setText(news.getText());
        holder.newsLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "对这篇文章感兴趣", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView title, subTitle;
    LinearLayout newsLy;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        subTitle =itemView.findViewById(R.id.subtitle);
        newsLy = itemView.findViewById(R.id.news_ly);
    }


}
