package com.example.mloong.yidonghulian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.bean.Goods;
import com.example.mloong.yidonghulian.common.ImageLoaderManager;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<Goods> listData;

    public OnGoodsItemClickListener mGoodsItemListener;

    public GoodsListAdapter(Context context, List<Goods> data) {
        this.mContext = context;
        this.listData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods_list, viewGroup, false);

        view.setOnClickListener(this);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Goods entity = listData.get(i);
        ImageLoaderManager.displayImage(entity.getSmall(), viewHolder.imageView);
        viewHolder.title.setText(entity.getName());
        viewHolder.price.setText("￥" + String.format("%.2f", entity.getPrice()));

        viewHolder.itemView.setTag(entity);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onClick(View v) {
        if (mGoodsItemListener != null) {
            mGoodsItemListener.onClick(v, (Goods) v.getTag());
        }
    }

    public void setOnGoodsItemClickListener(OnGoodsItemClickListener listener) {
        this.mGoodsItemListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView imageView;//商品图片
        private TextView title;//商品名称
        private TextView price;//商品价格

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.goodslist_img);
            title = (TextView) itemView.findViewById(R.id.goodslist_name);
            price = (TextView) itemView.findViewById(R.id.goodslist_price);
        }
    }
}
