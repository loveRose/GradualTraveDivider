package com.app.lvyerose.item.recyclerviewitemdecoration;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
public class MeViewHolder extends RecyclerView.ViewHolder {
    public ImageView menuImv;
    public TextView titleTv;

    public MeViewHolder(View itemView) {
        super(itemView);
        menuImv = (ImageView) itemView.findViewById(R.id.item_icon_imv);
        titleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
    }
}
