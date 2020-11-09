package com.itxingrui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.control.TreeCell;

import java.util.*;
import java.util.function.Supplier;

public class Main {
    static HashMap<String, Object> A1 = new HashMap();
    static HashMap<String, Object> A2 = new HashMap();
    static HashMap<String, Object> A3 = new HashMap();
    static HashMap<String, Object> A4 = new HashMap();
    static HashMap<String, Object> A5 = new HashMap();
    static List<HashMap<String, Object>> val = new ArrayList();

    public static void put() {
        
        A1.put("id", "1");
        A1.put("parentId", "-1");
        A1.put("name", "3C");

        A2.put("id", "2");
        A2.put("parentId", "-1");
        A2.put("name", "服饰");


        A3.put("id", "3");
        A3.put("parentId", "1");
        A3.put("name", "耳机");

        A4.put("id", "4");
        A4.put("parentId", "3");
        A4.put("name", "头戴式");

        A5.put("id", "5");
        A5.put("parentId", "2");
        A5.put("name", "男装");

        val.add(A1);
        val.add(A2);
        val.add(A3);
        val.add(A4);
        val.add(A5);

    }

    //1.从root根开始往下递归，val是初始数据，rid是每一层递归根的pid，第一次传入是整个树的根pid
    public List<HashMap> build(List<Map<String, String>> val, String rId) {
//        2.创建trl作为每一层递归得到的树，也就是上一层的一个child，返回值需要set到上一层的child里面
        List<HashMap> trl = new ArrayList();
        for (int i = 0; i < val.size(); i++) {
//          3.  判断是为了找到当前传入这一级的child，如果能进入证明val.get(i)这个值是rid这个的child
            if (val.get(i).get("parentId").equals(rId)) {
//                4. 如果能进来，则证明有根，把val.get(i)，作为根，递归下一层来寻找 val.get(i)的child
                List<HashMap> child = build(val, val.get(i).get("id"));
                //5.如果得到的child size大于o，证明这个val.get(i)有子，需要加到setchild里面
                if (child.size() > 0) {
//                    val.get(i)值组长到chlidBean中
                    HashMap chlidBean = new HashMap();
                    chlidBean.put("name", val.get(i).get("name"));
                    chlidBean.put("child", child);
//                    把寻找到的childset到chlidBean中
//                  7.  无论是叶子还是chlidBean都需要添加到trl中返回上一级，然后把这个返回的set到上一级的child里面
                    trl.add(chlidBean);
//                   6.和5相反，属于叶子节点，不用添加child
                } else {
                    HashMap chlidBean = new HashMap();
                    chlidBean.put("name", val.get(i).get("name"));
//                    同7
                    trl.add(chlidBean);
                }
            }
        }
        return trl;
    }

    public static HashMap getByChildId(String childId) {

        //TODO 查询当前的child
        for (HashMap<String, Object> hashMap : val) {
            if (hashMap.get("id").equals(childId)){
                //当前个分类，查看是否有父类
                if (!hashMap.get("parentId").equals("-1")){
                    HashMap parent = getByChildId(hashMap.get("parentId").toString());
                    hashMap.put("parent",parent);
                    return hashMap;
                }else {
                    return hashMap;
                }
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        Main b = new Main();
//        b.put();
//        List<HashMap> tr = b.build(val, "-1");
//        Object o = JSON.toJSON(tr);
//        System.out.println(o);
//    }

    public static void main(String[] args) {
        put();
        HashMap byChildId = getByChildId("4");
        Object o = JSON.toJSON(byChildId);
        System.out.println(o);
    }
}


