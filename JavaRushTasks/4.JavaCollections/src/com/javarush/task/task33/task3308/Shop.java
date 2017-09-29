package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Administrator on 29.09.2017.
 */
@XmlType
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods{
        List<String> names;
    }
}
