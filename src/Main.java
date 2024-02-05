import Models.Delivery;
import Models.Match;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final int MATCH_ID = 0;

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
                delivery.setInningsNumber(Integer.parseInt(currentDelivery[1]));
                delivery.setBattingTeam(currentDelivery[2]);
                delivery.setBowlingTeam(currentDelivery[3]);
                delivery.setOver(Integer.parseInt((currentDelivery[4])));
                delivery.setBall(Integer.parseInt(currentDelivery[5]));
                delivery.setBatsmanName(currentDelivery[6]);
                delivery.setBatsmanNameNS(currentDelivery[7]);
                delivery.setBowler(currentDelivery[8]);
                delivery.setIsMatchSuperOver(currentDelivery[9]);
                delivery.setWideRuns(Integer.parseInt(currentDelivery[10]));
                delivery.setByeRuns(Integer.parseInt(currentDelivery[11]));
                delivery.setLegByesRuns(Integer.parseInt(currentDelivery[12]));
                delivery.setNoBallRuns(Integer.parseInt(currentDelivery[13]));
                delivery.setPenaltyRuns(Integer.parseInt(currentDelivery[14]));
                delivery.setBatsmanRuns(Integer.parseInt(currentDelivery[15]));
                delivery.setExtraRuns(Integer.parseInt(currentDelivery[16]));
                delivery.setTotalRuns(Integer.parseInt(currentDelivery[17]));
                if (currentDelivery.length > 18) {
                    delivery.setPlayerDismissedName(currentDelivery[18]);
                }
                if (currentDelivery.length > 19) {
                    delivery.setDismissalType(currentDelivery[19]);
                }
                if (currentDelivery.length > 20) {
                    delivery.setFielderName(currentDelivery[20]);
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

                match.setMatchId(Integer.parseInt(currentMatch[0]));
                match.setSeason(Integer.parseInt(currentMatch[1]));
                match.setCity(currentMatch[2]);
                match.setDate(currentMatch[3]);
                match.setTeamOneName(currentMatch[4]);
                match.setTeamTwoName(currentMatch[5]);
                match.setTossWinner(currentMatch[6]);
                match.setTossDecision(currentMatch[7]);
                match.setMatchResult(currentMatch[8]);
                match.setDlApplied(Integer.parseInt(currentMatch[9]));
                match.setWinner(currentMatch[10]);
                match.setWinByRuns(Integer.parseInt(currentMatch[11]));
                match.setWinByWickets(Integer.parseInt(currentMatch[12]));
                match.setPomName(currentMatch[13]);
                match.setVenue(currentMatch[14]);

                if (currentMatch.length > 15) {
                    match.setUmpireOneName(currentMatch[15]);
                }
                if (currentMatch.length > 16) {
                    match.setUmpireTwoName(currentMatch[16]);
                }
                if (currentMatch.length > 17) {
                    match.setUmpireThreeName(currentMatch[17]);
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





