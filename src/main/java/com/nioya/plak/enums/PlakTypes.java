package com.nioya.plak.enums;

public enum PlakTypes {

    TSM("Türk Sanat Müziği"),
    THM("Türk Halk Müziği"),
    POP("Pop Müzik"),
    FOR("Yabancı Müzik"),
    OZG("Özgün Müzik"),
    ARA("Arabesk");

    private final String value;

    PlakTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static String getEnumValue(String name) {
        for (PlakTypes v : values()) {
            if (v.name().equals(name)) {
                return v.getValue();
            }
        }
        return "";
    }
}
