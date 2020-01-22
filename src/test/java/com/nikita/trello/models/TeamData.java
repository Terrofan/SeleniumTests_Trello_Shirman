package com.nikita.trello.models;

public class TeamData {
    private String teamName;
    private String teamDesc;

    public TeamData setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamData setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    @Override
    public String toString() {
        return "TeamData{" +
                "teamName='" + teamName + '\'' +
                ", teamDesc='" + teamDesc + '\'' +
                '}';
    }
}
