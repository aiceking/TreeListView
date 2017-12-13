package com.example.cloud.tree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.cloud.tree.model.TreeModel;
import com.example.cloud.tree.util.TreeUtil;

import java.util.List;

/**
 * Created by Vmmet on 2016/8/11.
 */
public abstract class TreeBaseAdapter extends BaseAdapter{
    protected ListView lv;
    protected Context mContext;
    /** 存储所有可见的Node*/
    protected List<TreeModel> mNodes;
    protected LayoutInflater mInflater;
    /**存储所有的Node*/
    protected List<TreeModel> mAllNodes;
    /**叶子节点的点击事件接口*/
    private OnTreeNodeClickListener onTreeNodeClickListener;
    public void setOnTreeNodeClickListener(
            OnTreeNodeClickListener onTreeNodeClickListener)
    {
        this.onTreeNodeClickListener = onTreeNodeClickListener;
    }
    public TreeBaseAdapter(ListView listView , Context context, List<TreeModel> list){
        mContext = context;
        mAllNodes=list;
        this.lv=listView;
        mInflater = LayoutInflater.from(context);
        mNodes = TreeUtil.getInstance().getVisibleNode(mAllNodes);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /**展开或关闭某节点*/
                expandOrCollapse(i);
                /**叶子节点的点击事件*/
                if (onTreeNodeClickListener != null)
                {
                    onTreeNodeClickListener.onClick(mNodes.get(i),
                            i);
                }
            }
        });
    }
    /** 相应ListView的点击事件 展开或关闭某节点*/
    public void expandOrCollapse(int position)
    {
        TreeModel n = mNodes.get(position);
        if (n != null)
        {
            if (n.getChildrens()!=null)// 不是叶子节点
            {
                n.setExpand(!n.isExpand());
                mNodes = TreeUtil.getInstance().getVisibleNode(mAllNodes);
                notifyDataSetChanged();// 刷新视图
            }
        }
    }
    @Override
    public int getCount()
    {
        return mNodes.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mNodes.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TreeModel node = mNodes.get(position);
        convertView = getConvertView(node, position, convertView, parent);
        // 设置内边距:根据level
        convertView.setPadding((node.getLevel() ) * 60, 0, 0, 0);
        return convertView;
    }

    public abstract View getConvertView(TreeModel node, int position,
                                        View convertView, ViewGroup parent);
    /**
     * 点击的回调接口
     */
    public interface OnTreeNodeClickListener
    {
        void onClick(TreeModel node, int position);
    }
}
