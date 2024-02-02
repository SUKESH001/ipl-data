package IPLService;

import Models.Matches;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchesDataServiceInterface implements iplDataServiceInterface {

    List<Matches> allMatchData= new ArrayList<Matches>();

    @Override
    public void readData() {

        try {
            BufferedReader bufferedReader= new BufferedReader(new FileReader("src/matches.csv"));

            String l;

            while((l=bufferedReader.readLine())!=null){

                if(l.startsWith("match")) {
                    continue;
                }

                String [] currentMatch= l.split(",");
                storeData(currentMatch);


            }


        } catch (FileNotFoundException e) {
            System.out.println("check your file location");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void storeData(String[] currentMatch) {

        Matches matches= new Matches();

        matches.setMatchId(Integer.parseInt(currentMatch[0]));
        matches.setSeason(Integer.parseInt(currentMatch[1]));
        matches.setCity(currentMatch[2]);
        matches.setDate(currentMatch[3]);
        matches.setTeamOneName(currentMatch[4]);
        matches.setTeamTwoName(currentMatch[5]);
        matches.setTossWinner(currentMatch[6]);
        matches.setTossDecision(currentMatch[7]);
        matches.setMatchResult(currentMatch[8]);
        matches.setDlApplied(currentMatch[9]);
        matches.setWinByRuns(Integer.parseInt(currentMatch[10]));
        matches.setWinByWickets(Integer.parseInt(currentMatch[11]));
        matches.setPomName(currentMatch[12]);
        matches.setVenue(currentMatch[13]);
        matches.setUmpireOneName(currentMatch[14]);
        matches.setUmpireTwoName(currentMatch[15]);
        matches.setUmpireThreeName(currentMatch[16]);

        allMatchData.add(matches);

    }
}
