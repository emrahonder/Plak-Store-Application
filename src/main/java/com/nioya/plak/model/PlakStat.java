package com.nioya.plak.model;

import lombok.Data;

@Data
public class PlakStat {

    public PlakStat(String code, long count) {
        this.code = code;
        this.count = count;
    }

    String visibleName;
    String code;
    long count;

}
