package com.styz.enums;

/**
 * creat date:2019-07-25 13:38
 * author:xxydliuyss
 * note:
 */
public enum  MenuEnum {
    TOP(1),SECONDE(2);
    private MenuEnum(Integer level){
        this.level = level;
    }
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }}
