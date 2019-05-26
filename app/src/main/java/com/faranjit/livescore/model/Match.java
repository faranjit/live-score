package com.faranjit.livescore.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
@Root(name = "match", strict = false)
public class Match {

    @Attribute(name = "team_A_name", required = false)
    private String homeTeam;

    @Attribute(name = "team_B_name", required = false)
    private String awayTeam;

    @Attribute(name = "fs_A", required = false)
    private String homeScore;

    @Attribute(name = "fs_B", required = false)
    private String awayScore;

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }
}
