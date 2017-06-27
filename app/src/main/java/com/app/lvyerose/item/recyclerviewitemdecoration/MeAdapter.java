package com.app.lvyerose.item.recyclerviewitemdecoration;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/************************************************************************
 *                    .::::.                                            *
 *                  .::::::::.                                          *
 *                 :::::::::::  FUCK YOU                                *
 *             ..:::::::::::'                                           *
 *           '::::::::::::'                                             *
 *             .::::::::::                                              *
 *        '::::::::::::::..                                             *
 *             ..::::::::::::.                                          *
 *           ``::::::::::::::::                                         *
 *            ::::``:::::::::'        .:::.                             *
 *           ::::'   ':::::'       .::::::::.                           *
 *         .::::'      ::::     .:::::::'::::.                          *
 *        .:::'       :::::  .:::::::::' ':::::.                        *
 *       .::'        :::::.:::::::::'      ':::::.                      *
 *      .::'         ::::::::::::::'         ``::::.                    *
 *  ...:::           ::::::::::::'              ``::.                   *
 * ```` ':.          ':::::::::'                  ::::..                *
 *                    '.:::::'                    ':'````..             *
 *              ━━━━━━━━━━━━━━━━━━━━━                                   *
 ************************************************************************
 *
 * 项目名称：RecyclerViewItemDecoration
 * 类描述： 
 * 创建人：lvyerose
 * 邮箱：lvyerose@163.com
 * 创建时间：17/6/26
 *
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 *  ......
 */
public class MeAdapter extends RecyclerView.Adapter<MeViewHolder> {
    private int scrrentWidth;
    private LayoutInflater inflater;
    private Context mContext;
    private int[] imageResIds = new int[]{
            R.mipmap.icon_usercenter_01,
            R.mipmap.icon_usercenter_02,
            R.mipmap.icon_usercenter_03,
            R.mipmap.icon_usercenter_04,
            R.mipmap.icon_usercenter_05,
            R.mipmap.icon_usercenter_06,
            R.mipmap.icon_usercenter_07,
            R.mipmap.icon_usercenter_08,
            R.mipmap.icon_usercenter_09,
//            R.mipmap.icon_usercenter_09,
//            0
    };

    private String[] titles = new String[]{
            "车辆",
            "套餐",
            "联系人",
            "修改ID",
            "修改密码",
            "设置",
            "意见反馈",
            "常见问题",
            "版本信息",
//            "版本信息",
//            ""
    };

    public MeAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
//        WindowManager wm = (WindowManager) mContext
//                .getSystemService(Context.WINDOW_SERVICE);
//
//        scrrentWidth = wm.getDefaultDisplay().getWidth();

        DisplayMetrics metric = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metric);
        scrrentWidth = metric.widthPixels;     // 屏幕宽度（像素）
    }

    @Override
    public MeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.item_view_layout, parent, false);

        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.width = (scrrentWidth - 4) / 3;
        layoutParams.height = (scrrentWidth - 4) / 3;
        view.setLayoutParams(layoutParams);

        MeViewHolder holder = new MeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MeViewHolder holder, int position) {
        holder.menuImv.setImageResource(imageResIds[position]);
        holder.titleTv.setText(titles[position]);
    }


    @Override
    public int getItemCount() {
        return imageResIds.length;
    }
}
