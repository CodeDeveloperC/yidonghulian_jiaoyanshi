package com.example.mloong.yidonghulian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.bean.GoodsCat;

import java.util.List;

public class CategoryLeftListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View
        .OnClickListener {

    private Context mContext;
    private List<GoodsCat> mLeftData;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //选中的索引
    private int selectedCategoryId = 0;

    public CategoryLeftListAdapter(Context context, List<GoodsCat> leftData) {
        mContext = context;
        mLeftData = leftData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_left, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CategoryLeftListAdapter.ViewHolder) {
            CategoryLeftListAdapter.ViewHolder newHolder = (CategoryLeftListAdapter.ViewHolder) viewHolder;
            //填充数据
            GoodsCat entity = mLeftData.get(position);
            newHolder.textView.setText(entity.getName());
            //将数据保存在itemView的Tag中，以便点击时进行获取
            newHolder.itemView.setTag(entity);

            //修改状态
            if (entity.getCatId() == selectedCategoryId) {
                newHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_focus);
                newHolder.textView.setTextColor(viewHolder.itemView.getResources().getColor(R.color
                        .category_left_red_font));
            } else {
                viewHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_normal);
                newHolder.textView.setTextColor(viewHolder.itemView.getResources().getColor(R.color
                        .category_left_dark_font));
            }
        }
    }

    /**
     * 设置选中行
     *
     * @param categoryId
     */
    public void setSelection(int categoryId) {
        selectedCategoryId = categoryId;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mLeftData.size();
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            GoodsCat entity = (GoodsCat) v.getTag();
            mOnItemClickListener.onItemClick(v, entity);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
