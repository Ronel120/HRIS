package com.example.employee.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Department {
    ADMIN("ADM", "Admin"),
    ENGINEERING("ENG", "Engineering"),
    MARKETING("MKT", "Marketing"),
    ACCOUNTING("ACT", "Accounting");

    private final String code;
    private final String value;

    Department(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private final static Map<String, String> departmentEnum = new HashMap<>();

    static {
        for(Department department : Department.values()){
            departmentEnum.put(department.getCode(), department.getValue());
        }
    }

    public static String getValue(String code){
        return departmentEnum.get(code);
    }



}
