package com.faranjit.livescore.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
@Root(name = "parameter", strict = false)
public class Parameter {

    @Attribute(name = "name", required = false)
    private String name;

    @Attribute(name = "value", required = false)
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
