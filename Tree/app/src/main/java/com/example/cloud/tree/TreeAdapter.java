package com.example.cloud.tree;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cloud.tree.adapter.TreeBaseAdapter;
import com.example.cloud.tree.model.TreeModel;
import com.example.cloud.tree.util.TreeUtil;

import java.util.List;


/**
 * Created by Vmmet on 2016/8/12.
 */
public class TreeAdapter extends TreeBaseAdapter {
    public TreeAdapter(ListView listView, Context context, List<TreeModel> list) {
        super(listView, context, list);
    }
    @Override
    public View getConvertView(final TreeModel node, final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.listview_tree,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)convertView.findViewById(R.id.tv);
            viewHolder.checkBox=(CheckBox)convertView.findViewById(R.id.checkbox);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.iv_arrows);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        if (node.getChildrens()!=null){
            viewHolder.imageView.setVisibility(View.VISIBLE);
            if (node.isExpand()){
                viewHolder.imageView.setImageResource(R.drawable.open);
            }else{
                viewHolder.imageView.setImageResource(R.drawable.close);
            }
        }else{
            viewHolder.imageView.setVisibility(View.INVISIBLE);
        }
        viewHolder.textView.setText(node.getTitle());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TreeUtil.getInstance().SelectNode(node, viewHolder.checkBox.isChecked());
                notifyDataSetChanged();
            }
        });
        viewHolder.checkBox.setChecked(node.isSelect());
        return convertView;
    }
    private class ViewHolder {
        TextView textView;
        CheckBox checkBox;
        ImageView imageView;
    }
}
