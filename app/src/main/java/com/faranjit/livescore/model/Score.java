package com.faranjit.livescore.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
@Root(name = "gsmrs", strict = false)
public class Score {

    @Path("method")
    @ElementList(name = "parameter", inline = true)
    private List<Parameter> parameters;

    @Path("competition/season/round/")
    @ElementList(name = "match", inline = true)
    private List<Group> groups;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
