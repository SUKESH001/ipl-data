package Models;

import java.util.Date;

public class Matches {

    private int matchId;
    private int season;
    private String city;
    private String date;
    private String teamOneName;
    private String teamTwoName;
    private String tossWinner;
    private String tossDecision;
    private String matchResult;
    private String dlApplied;
    private int winByRuns;
    private int winByWickets;
    private String pomName;
    private String venue;
    private  String umpireOneName;
    private String umpireTwoName;
    private String umpireThreeName;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getDlApplied() {
        return dlApplied;
    }

    public void setDlApplied(String dlApplied) {
        this.dlApplied = dlApplied;
    }

    public int getWinByRuns() {
        return winByRuns;
    }

    public void setWinByRuns(int winByRuns) {
        this.winByRuns = winByRuns;
    }

    public int getWinByWickets() {
        return winByWickets;
    }

    public void setWinByWickets(int winByWickets) {
        this.winByWickets = winByWickets;
    }

    public String getPomName() {
        return pomName;
    }

    public void setPomName(String pomName) {
        this.pomName = pomName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getUmpireOneName() {
        return umpireOneName;
    }

    public void setUmpireOneName(String umpireOneName) {
        this.umpireOneName = umpireOneName;
    }

    public String getUmpireTwoName() {
        return umpireTwoName;
    }

    public void setUmpireTwoName(String umpireTwoName) {
        this.umpireTwoName = umpireTwoName;
    }

    public String getUmpireThreeName() {
        return umpireThreeName;
    }

    public void setUmpireThreeName(String umpireThreeName) {
        this.umpireThreeName = umpireThreeName;
    }
}
