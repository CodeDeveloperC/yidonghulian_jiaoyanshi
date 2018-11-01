package com.example.mloong.yidonghulian.common;

import android.content.Context;

import com.example.mloong.yidonghulian.MyApplication;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;

public class ImageLoaderManager {
    private static ImageLoaderManager mInstance;

    public static ImageLoaderManager getmInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderManager.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderManager();
                }
            }
        }

        return mInstance;
    }

    public ImageLoaderManager() {
        if (mInstance == null) {
            Fresco.initialize(MyApplication.getContext(),getImagePipelineConfig(MyApplication.getContext()));
        }
    }

    private ImagePipelineConfig getImagePipelineConfig(Context context) {
        ImagePipelineConfig.Builder imagePipelineConfigBuilder = ImagePipelineConfig.newBuilder(context);
        //设置磁盘缓存
        imagePipelineConfigBuilder.setMainDiskCacheConfig(DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryPath(context.getExternalCacheDir())//设置磁盘缓存的路径
                .setBaseDirectoryName(Share.APP_IMAGE)//设置磁盘缓存文件夹的名称
                .setMaxCacheSize(Share.MAX_DISK_CACHE_SIZE)//设置磁盘缓存的大小
                .build());

        //设置内存缓存
        imagePipelineConfigBuilder.setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
            public MemoryCacheParams get() {
                int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
                int MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 5;//取手机内存最大值的五分之一作为可用的最大内存数

                MemoryCacheParams bitmapCacheParams = new MemoryCacheParams( //
                        // 可用最大内存数，以字节为单位
                        MAX_MEMORY_CACHE_SIZE,
                        // 内存中允许的最多图片数量
                        Integer.MAX_VALUE,
                        // 内存中准备清理但是尚未删除的总图片所可用的最大内存数，以字节为单位
                        MAX_MEMORY_CACHE_SIZE,
                        // 内存中准备清除的图片最大数量
                        Integer.MAX_VALUE,
                        // 内存中单图片的最大大小
                        Integer.MAX_VALUE);
                return bitmapCacheParams;
            }
        });

        //设置渐进式显示的效果
        ProgressiveJpegConfig progressiveJpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                //返回下一个需要解码的扫描次数
                return scanNumber + 2;
            }

            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);
                //确定多少个扫描次数之后的图片才能开始显示。
                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };
        imagePipelineConfigBuilder.setProgressiveJpegConfig(progressiveJpegConfig);
        //允许解码时调整图片大小
        imagePipelineConfigBuilder.setDownsampleEnabled(true);

        return imagePipelineConfigBuilder.build();
    }
}
