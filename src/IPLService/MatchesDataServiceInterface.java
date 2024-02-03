package IPLService;

import Models.Matches;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchesDataServiceInterface implements iplDataServiceInterface {

    public static List<Matches> allMatchData= new ArrayList<Matches>();

    public static List<Matches> getAllMatchData() {
        return allMatchData;
    }


    @Override
    public void readData() {

        int i =0;
        BufferedReader bufferedReader= null;

        try {
            bufferedReader= new BufferedReader(new FileReader("src/matches.csv"));

            String l;

            while((l=bufferedReader.readLine())!=null){

                if(i==0) {
                    i++;
                    continue;
                }

                String [] currentMatch= l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                storeData(currentMatch);


            }


        } catch (FileNotFoundException e) {
            System.out.println("check your file location");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();

                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        matches.setDlApplied(Integer.parseInt(currentMatch[9]));
        matches.setWinner(currentMatch[10]);
        matches.setWinByRuns(Integer.parseInt(currentMatch[11]));
        matches.setWinByWickets(Integer.parseInt(currentMatch[12]));
        matches.setPomName(currentMatch[13]);
        matches.setVenue(currentMatch[14]);
//        matches.setUmpireOneName(currentMatch[15]);
//        matches.setUmpireTwoName(currentMatch[16]);


        allMatchData.add(matches);

    }

}
