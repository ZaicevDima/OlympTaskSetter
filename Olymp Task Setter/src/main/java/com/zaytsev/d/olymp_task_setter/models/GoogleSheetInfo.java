package com.zaytsev.d.olymp_task_setter.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GoogleSheetInfo {
    @Getter
    @Setter
    private String sheetName;
    @Getter
    @Setter
    private List<List<Object>> dataToUpdated;


}
