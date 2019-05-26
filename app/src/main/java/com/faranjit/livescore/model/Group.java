package com.faranjit.livescore.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
@Root(name = "group", strict = false)
public class Group {

    @ElementList(name = "match", inline = true)
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
