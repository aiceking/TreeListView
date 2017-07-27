package com.example.vmmet.mytreenode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vmmet.mytreenode.adapter.TreeBaseAdapter;
import com.example.vmmet.mytreenode.bean.Node;
import com.example.vmmet.mytreenode.util.TreeHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView lv;
    private TreeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        List<Node> list= TreeHelper.getAllNodes();
        adapter=new TreeAdapter(lv,this,list);
        lv.setAdapter(adapter);
        adapter.setOnTreeNodeClickListener(new TreeBaseAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                Toast.makeText(MainActivity.this, ""+node.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
