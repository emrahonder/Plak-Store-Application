package com.nioya.plak.model;

import com.nioya.plak.enums.PlakTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlakType {

    String visibleName;
    PlakTypes code;
}
