package com.example.mloong.yidonghulian.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.bean.GoodsCat;
import com.example.mloong.yidonghulian.utils.DesityUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CategoryRightListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context mContext;
    private List<GoodsCat> mRightData;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public CategoryRightListAdapter(Context context, List<GoodsCat> rightData) {
        mContext = context;
        mRightData = rightData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_right, viewGroup, false);
        //获取左侧列表的宽度
        int left_width = (int) mContext.getResources().getDimension(R.dimen.category_list_left_width);
        //获取手机的屏幕宽度
        int width = DesityUtils.getWidth(mContext);
        //设置右侧列表的每个选项的宽度和高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (width - left_width) / 3,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        ViewHolder holder = new ViewHolder(view);

        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof CategoryRightListAdapter.ViewHolder){
            final CategoryRightListAdapter.ViewHolder newHolder = ( CategoryRightListAdapter.ViewHolder) viewHolder;
            GoodsCat entity = mRightData.get(i);
            //适配item数据
            newHolder.categoryItemHavePictureText1.setText(entity.getName());

            //写一个监听器 监听图片加载
            ControllerListener listener = new BaseControllerListener() {

                /**
                 * 当图片加载成功时会执行的方法
                 * @param id
                 * @param imageInfo
                 * @param animatable
                 */
                @Override
                public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    //设置图片的高度

                }


                /**
                 * 图片加载失败时调用的方法
                 * @param id
                 * @param throwable
                 */
                @Override
                public void onFailure(String id, Throwable throwable) {
                    super.onFailure(id, throwable);
                }


                /**
                 *  如果图片使用渐进式，这个方法将会被回调
                 * @param id
                 * @param throwable
                 */
                @Override
                public void onIntermediateImageFailed(String id, Throwable throwable) {
                    super.onIntermediateImageFailed(id, throwable);
                }
            };

            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(entity.getImage())
                    .setAutoPlayAnimations(true)
                    .setControllerListener(listener)
                    .build();

            newHolder.categoryItemHavePictureImage1.setController(controller);


            viewHolder.itemView.setTag(entity);
        }
    }

    @Override
    public int getItemCount() {
        return mRightData.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (GoodsCat) v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView categoryItemHavePictureImage1;
        private TextView categoryItemHavePictureText1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryItemHavePictureImage1 = (SimpleDraweeView) itemView.findViewById(R.id.category_item_have_picture_image_1);
            categoryItemHavePictureText1 = (TextView) itemView.findViewById(R.id.category_item_have_picture_text_1);
        }
    }
}
