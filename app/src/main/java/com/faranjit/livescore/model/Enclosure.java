package com.faranjit.livescore.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@Root(name = "item", strict = false)
public class Enclosure {

    @Attribute(name = "length", required = false)
    private int length;

    @Attribute(name = "url", required = false)
    private String url;

    @Attribute(name = "type", required = false)
    private String type;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
