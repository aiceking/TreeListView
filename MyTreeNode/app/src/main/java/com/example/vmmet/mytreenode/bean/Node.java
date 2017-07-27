package com.example.vmmet.mytreenode.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vmmet on 2016/8/11.
 */
public class Node {
    private String id;
    private String pid;         /**子的pid等于父的id*/
    private String name;
    private boolean isRoot;     /**是否为根节点*/
    private boolean isLeaf;     /**是否为叶子节点*/
    private boolean isExpand;   /**该节点是否展开*/
    private Node parent;    /**父节点*/
    private List<Node> children=new ArrayList<>();  /**子节点*/
    private int level;          /**该节点所属的层级*/
    private boolean isSelect;   /**是否被选择*/
    public boolean isSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    /**构造器*/
    public Node(){}
    public Node(String id, String pid, String name){
        this.id=id;
        this.pid=pid;
        this.name=name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setIsRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setIsExpand(boolean isExpand) {
        this.isExpand = isExpand;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
