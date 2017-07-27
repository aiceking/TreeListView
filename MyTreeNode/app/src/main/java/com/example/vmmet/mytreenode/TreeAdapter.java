package com.example.vmmet.mytreenode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vmmet.mytreenode.adapter.TreeBaseAdapter;
import com.example.vmmet.mytreenode.bean.Node;
import com.example.vmmet.mytreenode.util.TreeHelper;

import java.util.List;
/**
 * Created by Vmmet on 2016/8/12.
 */
public class TreeAdapter extends TreeBaseAdapter{
    public TreeAdapter(ListView listView, Context context, List<Node> list) {
        super(listView, context, list);
    }
    @Override
    public View getConvertView(final Node node, final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.listview_tree,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)convertView.findViewById(R.id.tv);
            viewHolder.checkBox=(CheckBox)convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(node.getName());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TreeHelper.SelectNode(node, viewHolder.checkBox.isChecked());
                notifyDataSetChanged();
            }
        });
        viewHolder.checkBox.setChecked(node.isSelect());
        return convertView;
    }
    private class ViewHolder {
        TextView textView;
        CheckBox checkBox;
    }
}
