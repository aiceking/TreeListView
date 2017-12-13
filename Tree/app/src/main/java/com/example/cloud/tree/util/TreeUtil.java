package com.example.cloud.tree.util;

import com.example.cloud.tree.model.TreeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vmmet on 2016/8/11.
 */
public class TreeUtil {
    private static TreeUtil treeUtil;
    private HashMap<Integer,List<TreeModel>> treeModelHashMap;
    public static TreeUtil getInstance(){
        if (treeUtil==null){
            synchronized (TreeUtil.class){
                if(treeUtil==null){
                    treeUtil=new TreeUtil();
                }
            }
        }
        return treeUtil;
    }
    public void toTree(List<TreeModel>treeModelList) {
        treeModelHashMap=new HashMap<>();
        for (TreeModel treeModel:treeModelList){
            if (treeModel.getRight_level()-treeModel.getLeft_level()>1) {
                if (!treeModelHashMap.containsKey(treeModel.getLevel())) {
                    List<TreeModel> list = new ArrayList<>();
                    list.add(treeModel);
                    treeModelHashMap.put(treeModel.getLevel(), list);
                } else {
                    treeModelHashMap.get(treeModel.getLevel()).add(treeModel);
                }
            }
            if (treeModelHashMap.containsKey(treeModel.getLevel()-1)){
                if (treeModelHashMap.get(treeModel.getLevel()-1).get(treeModelHashMap.get(treeModel.getLevel()-1).size()-1).getChildrens()==null){
                    List<TreeModel> list_childs=new ArrayList<>();
                    list_childs.add(treeModel);
                    treeModelHashMap.get(treeModel.getLevel()-1).get(treeModelHashMap.get(treeModel.getLevel()-1).size()-1).setChildrens(list_childs);
                }else{
                    treeModelHashMap.get(treeModel.getLevel()-1).get(treeModelHashMap.get(treeModel.getLevel()-1).size()-1).getChildrens().add(treeModel);
                }
                treeModel.setParent(treeModelHashMap.get(treeModel.getLevel()-1)
                        .get(treeModelHashMap.get(treeModel.getLevel()-1).size()-1));

            }

        }
    }
    public  List<TreeModel> getVisibleNode(List<TreeModel> nodes) {
        List<TreeModel> result = new ArrayList<TreeModel>();
        List<TreeModel> rootNodes = new ArrayList<TreeModel>();
        for(TreeModel node:nodes){
            if(node.getParent()==null){
                rootNodes.add(node);
            }
        }
        for (TreeModel node : rootNodes) {
            filterNode(result, node);
        }
        return result;
    }
    //递归重新添加Node
    public   void filterNode(List<TreeModel> nodes, TreeModel node) {
        nodes.add(node);
        if (node.isExpand()) {
            if (node.getChildrens()!=null){
            for (int i = 0; i < node.getChildrens().size(); i++) {
                filterNode(nodes, node.getChildrens().get(i));
            }
            }
        }
    }
    //递归重新添加Node
    public  void SelectNode(TreeModel node, boolean isSelect) {
        node.setSelect(isSelect);
        if (node.getChildrens()!=null){
        for (int i = 0; i < node.getChildrens().size(); i++) {
            SelectNode(node.getChildrens().get(i), isSelect);
        }
    }
    }

}
