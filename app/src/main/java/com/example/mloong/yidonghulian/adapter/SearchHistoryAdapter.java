package com.example.mloong.yidonghulian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mloong.yidonghulian.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ItemViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<String> listData;

    public OnHistoryItemClickListener mGoodsItemListener;
    private LayoutInflater mInflater;

    public void setGoodsItemListener(OnHistoryItemClickListener goodsItemListener) {
        mGoodsItemListener = goodsItemListener;
    }

    public SearchHistoryAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.listData = data;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_search_history, viewGroup, false);

        view.setOnClickListener(this);

        SearchHistoryAdapter.ItemViewHolder holder = new SearchHistoryAdapter.ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
        if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.keyword.setText(listData.get(i));
            itemViewHolder.itemView.setTag(listData.get(i));
        }
    }

    //自定义的ViewHolder类
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.keyword)
        TextView keyword;
        @BindView(R.id.keyword_correct_layout)
        LinearLayout keywordCorrectLayout;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onClick(View v) {
        if (mGoodsItemListener != null) {
            mGoodsItemListener.onClick(v, (String) v.getTag());
        }
    }


}