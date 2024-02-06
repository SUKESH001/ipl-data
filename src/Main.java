import Models.Delivery;
import Models.Match;

import javax.swing.plaf.PanelUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int MATCH_ID = 0;
    public static final int INNINGS_NUMBER=1;
    public static final int BATTING_TEAM=2;
    public static final int  BOWLING_TEAM=3;
    public static final int OVER= 4;
    public static final int BALL=5;
    public static final int BATSMAN_NAME=6;
    public static final int BATSMAN_NAME_NS=7;
    public static final int BOWLER=8;
    public static final int IS_MATCH_SUPER_OVER=9;
    public static final int WIDER_RUNS=10;
    public static final int BYE_RUNS=11;
    public static final int LEG_BYE_RUNS=12;
    public static final int NO_BALL_RUNS=13;
    public static final int PENALTY_RUNS=14;
    public static final int BATSMAN_RUNS=15;
    public static final int EXTRA_RUNS=16;
    public static final int TOTAL_RUNS=17;
    public static final int PLAYER_DISMISSED_NAME=18;
    public static final int PLAYER_DISMISSED_TYPE=19;
    public static final int FIELDER_NAME=20;

    public static final int SEASON=1;
    public static final int CITY=2;
    public static final int DATE=3;

    public static final int TEAM_ONE=4;
    public static final int TEAM_TWO=5;
    public static final int TOSS_WINNER=6;
    public static final int TOSS_DECISION=7;
    public static final int MATCH_RESULT=8;
    public static final int DL_APLLIED=9;
    public static final int WINNER=10;
    public static final int WIN_BY_RUNS=11;
    public static final int WIN_BY_WICKETS=12;
    public static final int POM_NAME=13;
    public static final int  VENUE=14;
    public static final int  UMPIRE_ONE=15;
    public static final int UMPIRE_TWO=16;
    public static final int UMPIRE_THREE=17;

    public static void main(String[] args) {
        List<Match> matches = getMatchData();
        List<Delivery> deliveries = getDeliveryData();

        findMatchesPlayedPerSeason(matches);
        findMatchesWonByEachTeamInEveryYear(matches);
        findExtraRunsConcededPerTeamIn2016( getDeliveries(matches, deliveries, 2016));
        findMostEconomicalBowlersOf2015(getDeliveries(matches, deliveries, 2015));
        finsMostRunsByBatsmanInGivenTwoYear(getDeliveries(matches, deliveries , 2011), getDeliveries(matches , deliveries , 2017));
    }

    public static List<Delivery> getDeliveryData() {
        List<Delivery> allDeliveryData = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/deliveries.csv"));
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                if (l.startsWith("match")) {
                    continue;
                }
                String[] currentDelivery = l.split(",");
                Delivery delivery = new Delivery();
                delivery.setMatch_id(Integer.parseInt(currentDelivery[MATCH_ID]));
                delivery.setInningsNumber(Integer.parseInt(currentDelivery[INNINGS_NUMBER]));
                delivery.setBattingTeam(currentDelivery[BATTING_TEAM]);
                delivery.setBowlingTeam(currentDelivery[BOWLING_TEAM]);
                delivery.setOver(Integer.parseInt((currentDelivery[OVER])));
                delivery.setBall(Integer.parseInt(currentDelivery[BALL]));
                delivery.setBatsmanName(currentDelivery[BATSMAN_NAME]);
                delivery.setBatsmanNameNS(currentDelivery[BATSMAN_NAME_NS]);
                delivery.setBowler(currentDelivery[BOWLER]);
                delivery.setIsMatchSuperOver(currentDelivery[IS_MATCH_SUPER_OVER]);
                delivery.setWideRuns(Integer.parseInt(currentDelivery[WIDER_RUNS]));
                delivery.setByeRuns(Integer.parseInt(currentDelivery[BYE_RUNS]));
                delivery.setLegByesRuns(Integer.parseInt(currentDelivery[LEG_BYE_RUNS]));
                delivery.setNoBallRuns(Integer.parseInt(currentDelivery[NO_BALL_RUNS]));
                delivery.setPenaltyRuns(Integer.parseInt(currentDelivery[PENALTY_RUNS]));
                delivery.setBatsmanRuns(Integer.parseInt(currentDelivery[BATSMAN_RUNS]));
                delivery.setExtraRuns(Integer.parseInt(currentDelivery[EXTRA_RUNS]));
                delivery.setTotalRuns(Integer.parseInt(currentDelivery[TOTAL_RUNS]));
                if (currentDelivery.length > PLAYER_DISMISSED_NAME) {
                    delivery.setPlayerDismissedName(currentDelivery[PLAYER_DISMISSED_NAME]);
                }
                if (currentDelivery.length > PLAYER_DISMISSED_TYPE) {
                    delivery.setDismissalType(currentDelivery[PLAYER_DISMISSED_TYPE]);
                }
                if (currentDelivery.length > FIELDER_NAME) {
                    delivery.setFielderName(currentDelivery[FIELDER_NAME]);
                }
                allDeliveryData.add(delivery);
            }
        } catch (FileNotFoundException e) {

            System.out.println("Check your file location");
            throw new RuntimeException(e);
        } catch (IOException ignored) {

        }
        return allDeliveryData;
    }

    public static List<Match> getMatchData() {
        List<Match> allMatchData = new ArrayList<>();
        int i = 0;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/matches.csv"));
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] currentMatch = l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                Match match = new Match();

                match.setMatchId(Integer.parseInt(currentMatch[MATCH_ID]));
                match.setSeason(Integer.parseInt(currentMatch[SEASON]));
                match.setCity(currentMatch[CITY]);
                match.setDate(currentMatch[DATE]);
                match.setTeamOneName(currentMatch[TEAM_ONE]);
                match.setTeamTwoName(currentMatch[TEAM_TWO]);
                match.setTossWinner(currentMatch[TOSS_WINNER]);
                match.setTossDecision(currentMatch[TOSS_DECISION]);
                match.setMatchResult(currentMatch[MATCH_RESULT]);
                match.setDlApplied(Integer.parseInt(currentMatch[DL_APLLIED]));
                match.setWinner(currentMatch[WINNER]);
                match.setWinByRuns(Integer.parseInt(currentMatch[WIN_BY_RUNS]));
                match.setWinByWickets(Integer.parseInt(currentMatch[WIN_BY_WICKETS]));
                match.setPomName(currentMatch[POM_NAME]);
                match.setVenue(currentMatch[VENUE]);

                if (currentMatch.length > UMPIRE_ONE) {
                    match.setUmpireOneName(currentMatch[UMPIRE_ONE]);
                }
                if (currentMatch.length > UMPIRE_TWO) {
                    match.setUmpireTwoName(currentMatch[UMPIRE_TWO]);
                }
                if (currentMatch.length > UMPIRE_THREE) {
                    match.setUmpireThreeName(currentMatch[UMPIRE_THREE]);
                }
                allMatchData.add(match);
            }
        } catch (FileNotFoundException e) {
            System.out.println("check your file location");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allMatchData;
    }

    public static  void findMatchesPlayedPerSeason(List<Match> matches) {
        HashMap<Integer, Integer> matchesPerSeason = new HashMap<>();
        for (Match match : matches) {
            int count;
            if (matchesPerSeason.containsKey(match.getSeason())) {
                count = matchesPerSeason.get(match.getSeason());
                count += 1;
                matchesPerSeason.put(match.getSeason(), count);
            } else {
                matchesPerSeason.put(match.getSeason(), 1);
            }
        }
        System.out.println("Question 1");

        for (Object key : matchesPerSeason.keySet()) {
            System.out.println(matchesPerSeason.get(key) + " matches are played in " + key);
        }
        System.out.println();
    }

    public static void findMatchesWonByEachTeamInEveryYear(List<Match> matches) {
        Map<String, Integer> matchesWonPerTeam = new HashMap<>();
        for (Match match : matches) {
            int count;
            if (matchesWonPerTeam.containsKey(match.getWinner())) {
                count = matchesWonPerTeam.get(match.getWinner());
                count += 1;
                matchesWonPerTeam.put(match.getWinner(), count);

            } else {
                matchesWonPerTeam.put(match.getWinner(), 1);
            }
        }
        System.out.println("Question 2");

        for (Object key : matchesWonPerTeam.keySet()) {
            System.out.println(key + " have  won " + matchesWonPerTeam.get(key) + " matches.");
        }
        System.out.println();
    }

    public static List<Delivery> getDeliveries(List<Match> matches, List<Delivery> deliveries, int year) {
        List<Delivery> deliveriesPerYear = new ArrayList<>();
        for (Match match : matches) {
            if (match.getSeason() == year) {
                int val = match.getMatchId();

                for (Delivery delivery : deliveries) {
                    if (delivery.getMatch_id() == val) {
                        deliveriesPerYear.add(delivery);
                    }
                }
            }
        }
        return deliveriesPerYear;
    }

    public static void findExtraRunsConcededPerTeamIn2016(List<Delivery> deliveries) {
        Map<String, Integer> extraRunsPerTeam = new HashMap<>();
        for (Delivery delivery : deliveries) {
            int runs;
            if (extraRunsPerTeam.containsKey(delivery.getBowlingTeam())) {
                runs = extraRunsPerTeam.get(delivery.getBowlingTeam());
                runs = runs + delivery.getExtraRuns();
                extraRunsPerTeam.put(delivery.getBowlingTeam(), runs);
            } else {
                extraRunsPerTeam.put(delivery.getBowlingTeam(), delivery.getExtraRuns());
            }
        }
        System.out.println("Question 3");

        for (Object key : extraRunsPerTeam.keySet()) {
            System.out.println(key + " have  conceded " + extraRunsPerTeam.get(key) + " extra runs.");
        }
        System.out.println();
    }

    public static void findMostEconomicalBowlersOf2015(List<Delivery> deliveries) {
        Map<String, Integer> runsConcededByEachBowlerIn2015 = new HashMap<>();
        Map<String, Integer> ballsBowledByEachBowlerIn2015 = new HashMap<>();
        Map<String, Float> economyOfEachBowlerIn2015 = new HashMap<>();

        for (Delivery delivery : deliveries) {
            int runs;
            if (runsConcededByEachBowlerIn2015.containsKey(delivery.getBowler())) {
                runs = runsConcededByEachBowlerIn2015.get(delivery.getBowler()) + delivery.getWideRuns()
                        + delivery.getBatsmanRuns() + delivery.getNoBallRuns();
                runsConcededByEachBowlerIn2015.put(delivery.getBowler(), runs);
            } else {
                runsConcededByEachBowlerIn2015.put(delivery.getBowler(), delivery.getWideRuns()
                        + delivery.getBatsmanRuns() + delivery.getNoBallRuns());
            }
            if (ballsBowledByEachBowlerIn2015.containsKey(delivery.getBowler())) {
                int val = ballsBowledByEachBowlerIn2015.get(delivery.getBowler());
                if (delivery.getWideRuns() == 0 && delivery.getNoBallRuns() == 0) {
                    val = val + 1;
                }
                ballsBowledByEachBowlerIn2015.put(delivery.getBowler(), val);
            } else {
                int val = 0;
                if (delivery.getWideRuns() == 0 && delivery.getNoBallRuns() == 0) {
                    val = 1;
                }
                ballsBowledByEachBowlerIn2015.put(delivery.getBowler(), val);
            }
        }

        for (String key : runsConcededByEachBowlerIn2015.keySet()) {
            if (ballsBowledByEachBowlerIn2015.containsKey(key)) {
                float val1 = runsConcededByEachBowlerIn2015.get(key);
                float val2 = ballsBowledByEachBowlerIn2015.get(key);
                economyOfEachBowlerIn2015.put(key, (val1 / val2));
            }
        }
        int count = 0;
        List<Map.Entry<String, Float>> entryList = new ArrayList<>(economyOfEachBowlerIn2015.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        LinkedHashMap<String, Float> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Float> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Question4");
        System.out.println("Top bowlers with best economy");

        for (Map.Entry<String, Float> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " economy of " + (entry.getValue() * 6));
            count++;
            if (count == 20) {
                break;
            }
        }
    }

    public static void finsMostRunsByBatsmanInGivenTwoYear(List<Delivery> deliveries1, List<Delivery> deliveries2) {
        Map<String, Integer> mostRunsByBatsman = new HashMap<>();
        for (Delivery delivery : deliveries1) {
            if (mostRunsByBatsman.containsKey(delivery.getBatsmanName())) {
                int val = mostRunsByBatsman.get(delivery.getBatsmanName()) + delivery.getBatsmanRuns();
                mostRunsByBatsman.put(delivery.getBatsmanName(), val);
            } else {
                mostRunsByBatsman.put(delivery.getBatsmanName(), delivery.getBatsmanRuns());
            }
        }
        for (Delivery delivery : deliveries2) {
            if (mostRunsByBatsman.containsKey(delivery.getBatsmanName())) {
                int val = mostRunsByBatsman.get(delivery.getBatsmanName()) + delivery.getBatsmanRuns();
                mostRunsByBatsman.put(delivery.getBatsmanName(), val);
            } else {
                mostRunsByBatsman.put(delivery.getBatsmanName(), delivery.getBatsmanRuns());
            }
        }
        int count = 0;
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mostRunsByBatsman.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), (entry.getValue()));
        }

        System.out.println();
        System.out.println("Question 5");
        System.out.println("Top 10 Batsman with most runs ");

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " scored " + (entry.getValue()));
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}





