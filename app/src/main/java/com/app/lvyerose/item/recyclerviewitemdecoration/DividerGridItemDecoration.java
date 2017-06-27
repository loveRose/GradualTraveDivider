package com.app.lvyerose.item.recyclerviewitemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;

/************************************************************************
 * .::::.                                            *
 * .::::::::.                                          *
 * :::::::::::  FUCK YOU                                *
 * ..:::::::::::'                                           *
 * '::::::::::::'                                             *
 * .::::::::::                                              *
 * '::::::::::::::..                                             *
 * ..::::::::::::.                                          *
 * ``::::::::::::::::                                         *
 * ::::``:::::::::'        .:::.                             *
 * ::::'   ':::::'       .::::::::.                           *
 * .::::'      ::::     .:::::::'::::.                          *
 * .:::'       :::::  .:::::::::' ':::::.                        *
 * .::'        :::::.:::::::::'      ':::::.                      *
 * .::'         ::::::::::::::'         ``::::.                    *
 * ...:::           ::::::::::::'              ``::.                   *
 * ```` ':.          ':::::::::'                  ::::..                *
 * '.:::::'                    ':'````..             *
 * ━━━━━━━━━━━━━━━━━━━━━                                   *
 * ***********************************************************************
 * <p>
 * 项目名称：RecyclerViewItemDecoration
 * 类描述：
 * 创建人：lvyerose
 * 邮箱：lvyerose@163.com
 * 创建时间：17/6/26
 * <p>
 * 修改人：
 * 修改时间：
 * 修改备注：
 * <p>
 * ......
 */
public class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
    public static final int DIVIDER_TYPE_正常 = 0;
    public static final int DIVIDER_TYPE_START = 1;
    public static final int DIVIDER_TYPE_END = 2;

    private Drawable mDivider;

    private Drawable startHorizontalDivider;
    private Drawable endHorizontalDivider;

    private Drawable startVerticalDivider;
    private Drawable endVerticalDivider;

    public DividerGridItemDecoration(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.divider_background);
        startHorizontalDivider = context.getResources().getDrawable(R.drawable.divider_horizontal_start);
        endHorizontalDivider = context.getResources().getDrawable(R.drawable.divider_horizontal_end);
        startVerticalDivider = context.getResources().getDrawable(R.drawable.divider_vertical_start);
        endVerticalDivider = context.getResources().getDrawable(R.drawable.divider_vertical_end);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        drawHorizontal(c, parent);
        drawVertical(c, parent);
    }

    /**
     * 返回当前列数
     * 666
     *
     * @param parent
     * @return
     */
    private int getSpanCount(RecyclerView parent) {
        // 列数
        int spanCount = -1;
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {

            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return spanCount;
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        int spanCount = getSpanCount(parent);
        for (int i = 0; i < childCount; i++) {
            if (isLastRaw(parent, i, spanCount, childCount)) {// 如果是最后一行，则不需要绘制底部
                continue;
            }
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left;
            final int right;
            final int top;
            final int bottom;
            switch (dividerType(i, spanCount, childCount, true)) {
                case DIVIDER_TYPE_正常:
                    //无渐变绘制
                    left = child.getLeft() - params.leftMargin;
                    right = child.getRight() + params.rightMargin
                            + mDivider.getIntrinsicWidth();
                    top = child.getBottom() + params.bottomMargin;
                    bottom = top + mDivider.getIntrinsicHeight();
                    mDivider.setBounds(left, top, right, bottom);
                    mDivider.draw(c);
                    break;
                case DIVIDER_TYPE_START:
                    //左边端点渐变绘制
                    left = child.getLeft() - params.leftMargin;
                    right = child.getRight() + params.rightMargin
                            + startHorizontalDivider.getIntrinsicWidth();
                    top = child.getBottom() + params.bottomMargin;
                    bottom = top + startHorizontalDivider.getIntrinsicHeight();
                    startHorizontalDivider.setBounds(left, top, right, bottom);
                    startHorizontalDivider.draw(c);
                    break;
                case DIVIDER_TYPE_END:
                    //横向末端渐变绘制
                    left = child.getLeft() - params.leftMargin;
                    right = child.getRight() + params.rightMargin
                            + endHorizontalDivider.getIntrinsicWidth();
                    top = child.getBottom() + params.bottomMargin;
                    bottom = top + endHorizontalDivider.getIntrinsicHeight();
                    endHorizontalDivider.setBounds(left, top, right, bottom);
                    endHorizontalDivider.draw(c);
                    break;
            }
        }
    }

    /**
     * 逻辑需要再次调整
     *
     * @param c
     * @param parent
     */
    public void drawVertical(Canvas c, RecyclerView parent) {
        final int childCount = parent.getChildCount();
        int spanCount = getSpanCount(parent);
        for (int i = 0; i < childCount; i++) {
            if (isLastColumn(parent, i, spanCount, childCount)) {// 如果是最后一行，则不需要绘制底部
                continue;
            }
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top;
            final int bottom;
            final int left;
            final int right;
            switch (dividerType(i, spanCount, childCount, false)) {
                case DIVIDER_TYPE_正常:
                    top = child.getTop() - params.topMargin;
                    bottom = child.getBottom() + params.bottomMargin;
                    left = child.getRight() + params.rightMargin;
                    right = left + mDivider.getIntrinsicWidth();

                    mDivider.setBounds(left, top, right, bottom);
                    mDivider.draw(c);
                    break;
                case DIVIDER_TYPE_START:
                    top = child.getTop() - params.topMargin;
                    bottom = child.getBottom() + params.bottomMargin;
                    left = child.getRight() + params.rightMargin;
                    right = left + startVerticalDivider.getIntrinsicWidth();
                    startVerticalDivider.setBounds(left, top, right, bottom);
                    startVerticalDivider.draw(c);
                    break;
                case DIVIDER_TYPE_END:
                    top = child.getTop() - params.topMargin;
                    bottom = child.getBottom() + params.bottomMargin;
                    left = child.getRight() + params.rightMargin;
                    right = left + endVerticalDivider.getIntrinsicWidth();

                    endVerticalDivider.setBounds(left, top, right, bottom);
                    endVerticalDivider.draw(c);
                    break;
            }

        }
    }

    /**
     * 逻辑需要再次调整
     *
     * @param parent
     * @param pos
     * @param spanCount
     * @param childCount
     * @return
     */
    private boolean isLastColumn(RecyclerView parent, int pos, int spanCount,
                                 int childCount) {
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((pos + 1) % spanCount == 0) {   // 如果是最后一列，则不需要绘制右边
                return true;
            }
        }
        return false;
    }

    /**
     * 通过计算获取当前item是否该绘制底部横线
     *
     * @param parent
     * @param pos
     * @param spanCount
     * @param childCount
     * @return
     */
    private boolean isLastRaw(RecyclerView parent, int pos, int spanCount,
                              int childCount) {
        LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (childCount % spanCount == 0) { // 刚好排满
                if (pos >= (childCount - spanCount)) {//最后一行
                    return true;
                }
            } else { //排不满的 最后一行
                int count = childCount - childCount % spanCount;
                if (pos >= count) {
                    return true;
                }
            }

        }
        return false;
    }

    private int dividerType(int pos, int spanCount, int childCount, boolean isHorizontal) {
        if (isHorizontal) {
            if ((pos + spanCount) % spanCount == 0) {
                return DIVIDER_TYPE_START;
            } else if ((pos + 1) % spanCount == 0) {
                return DIVIDER_TYPE_END;
            } else {
                return DIVIDER_TYPE_正常;
            }
        } else {
            //竖线判断状态  是上起点还是下终点还是中间正常状态
            if (pos < spanCount) {
                return DIVIDER_TYPE_START;
            } else if (pos >= childCount - (childCount % spanCount == 0 ? spanCount : childCount % spanCount)) {/*最后一行 原本减去spanCount*/
                return DIVIDER_TYPE_END;
            } else {
                return DIVIDER_TYPE_正常;
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //可用于计算并设置对应 装饰线大小和位置
    }

}
