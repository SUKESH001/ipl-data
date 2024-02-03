package IPLService;

import Models.Deliveries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class
DeliveryDataService implements iplDataServiceInterface {


    List<Deliveries> allDeliveryData = new ArrayList<>();
    @Override
    public void readData() {

        try{
            BufferedReader bufferedReader= new BufferedReader(new FileReader("src/deliveries.csv"));
            String l;

            //while loop runs till read line= null(till last line) and l stores each lines
            while((l=bufferedReader.readLine())!=null){

                //ignoring first line
                if(l.startsWith("match")){
                    continue;
                }

                String[] currentDelivery = l.split(",");//spltting every content and storing in current delivery..

                //store data method to store every data
                storeData(currentDelivery);
            }

        } catch (FileNotFoundException e) {

            System.out.println("Check your file location");
            throw new RuntimeException(e);
        } catch (IOException ignored) {

        }


    }

    @Override
    public void storeData(String[] currentDelivery) {

        Deliveries deliveries= new Deliveries();

        deliveries.setMatch_id(Integer.parseInt(currentDelivery[0]));
        deliveries.setInningsNumber(Integer.parseInt(currentDelivery[1]));
        deliveries.setBattingTeam(currentDelivery[2]);
        deliveries.setBowlingTeam(currentDelivery[3]);
        deliveries.setOver(Integer.parseInt((currentDelivery[4])));
        deliveries.setBall(Integer.parseInt(currentDelivery[5]));
        deliveries.setBatsmanName(currentDelivery[6]);
        deliveries.setBatsmanNameNS(currentDelivery[7]);
        deliveries.setBowler(currentDelivery[8]);
        deliveries.setIsMatchSuperOver(currentDelivery[9]);
        deliveries.setWideRuns(Integer.parseInt(currentDelivery[10]));
        deliveries.setByeRuns(Integer.parseInt(currentDelivery[11]));
        deliveries.setLegByesRuns(Integer.parseInt(currentDelivery[12]));
        deliveries.setNoBallRuns(Integer.parseInt(currentDelivery[13]));
        deliveries.setPenaltyRuns(Integer.parseInt(currentDelivery[14]));
        deliveries.setBatsmanRuns(Integer.parseInt(currentDelivery[15]));
        deliveries.setExtraRuns(Integer.parseInt(currentDelivery[16]));
        deliveries.setTotalRuns(Integer.parseInt(currentDelivery[17]));
        deliveries.setPlayerDismissedName(currentDelivery[18]);
        deliveries.setDismissalType(currentDelivery[19]);
        deliveries.setFielderName(currentDelivery[20]);

        allDeliveryData.add(deliveries);


    }
}

