package com.example.cloud.tree.model;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */
public class TreeModel {
    private String title;
    private int left_level;
    private int right_level;
    private int level;
    private TreeModel parent;          /**父节点*/
    private List<TreeModel> childrens;/**所有子节点*/
    private boolean isExpand;
    /**是否展开*/
    private boolean isSelect;   /**是否被选择*/

    public TreeModel(String title, int level, int left_level, int right_level) {
        this.level = level;
        this.title = title;
        this.left_level = left_level;
        this.right_level = right_level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLeft_level() {
        return left_level;
    }

    public void setLeft_level(int left_level) {
        this.left_level = left_level;
    }

    public int getRight_level() {
        return right_level;
    }

    public void setRight_level(int right_level) {
        this.right_level = right_level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeModel getParent() {
        return parent;
    }

    public void setParent(TreeModel parent) {
        this.parent = parent;
    }

    public List<TreeModel> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TreeModel> childrens) {
        this.childrens = childrens;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }
    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}