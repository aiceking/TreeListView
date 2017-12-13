package com.example.cloud.tree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cloud.tree.adapter.TreeBaseAdapter;
import com.example.cloud.tree.model.TreeModel;
import com.example.cloud.tree.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<TreeModel> treeModelList;
    private ListView lv_tree;
    private TreeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        //构造树形结构
        TreeUtil.getInstance().toTree(treeModelList);
        showTree();
    }

    private void showTree() {
        adapter=new TreeAdapter(lv_tree,this,treeModelList);
        lv_tree.setAdapter(adapter);
        adapter.setOnTreeNodeClickListener(new TreeBaseAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(TreeModel node, int position) {
                Toast.makeText(MainActivity.this, ""+node.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lv_tree=(ListView)findViewById(R.id.lv_tree);
    }

    private void initDatas() {
        treeModelList=new ArrayList<>();
        TreeModel treeModel_1=new TreeModel("水木优品",0,1,30);
        treeModelList.add(treeModel_1);

        TreeModel treeModel_2=new TreeModel("北京总部",1,2,29);
        treeModelList.add(treeModel_2);

        TreeModel treeModel_3=new TreeModel("1部",2,3,4);
        treeModelList.add(treeModel_3);

        TreeModel treeModel_4=new TreeModel("2部",2,5,6);
        treeModelList.add(treeModel_4);

        TreeModel treeModel_5=new TreeModel("3部",2,7,8);
        treeModelList.add(treeModel_5);

        TreeModel treeModel_6=new TreeModel("4部",2,9,10);
        treeModelList.add(treeModel_6);

        TreeModel treeModel_7=new TreeModel("6部",2,11,12);
        treeModelList.add(treeModel_7);

        TreeModel treeModel_8=new TreeModel("7部",2,13,14);
        treeModelList.add(treeModel_8);

        TreeModel treeModel_9=new TreeModel("8部",2,15,16);
        treeModelList.add(treeModel_9);

        TreeModel treeModel_11=new TreeModel("技术部",2,17,18);
        treeModelList.add(treeModel_11);

        TreeModel treeModel_12=new TreeModel("技术部2",2,19,26);
        treeModelList.add(treeModel_12);

        TreeModel treeModel_13=new TreeModel("后端",3,20,21);
        treeModelList.add(treeModel_13);

        TreeModel treeModel_14=new TreeModel("后端2",3,22,23);
        treeModelList.add(treeModel_14);

        TreeModel treeModel_15=new TreeModel("后端3",3,24,25);
        treeModelList.add(treeModel_15);

        TreeModel treeModel_16=new TreeModel("技术部3",2,27,28);
        treeModelList.add(treeModel_16);
    }
}
