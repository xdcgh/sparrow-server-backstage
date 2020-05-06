package com.xdc.sparrowShop.entity.myEntity;

import com.xdc.sparrowShop.generate.Fresh;
import com.xdc.sparrowShop.generate.FreshType;

import java.util.List;

public class TypeFreshList extends FreshType {
    int currentCount;
    List<Fresh> freshList;

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public List<Fresh> getFreshList() {
        return freshList;
    }

    public void setFreshList(List<Fresh> freshList) {
        this.freshList = freshList;
    }
}
