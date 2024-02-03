import IPLService.MatchesDataServiceInterface;
import ProblemService.Problem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        String file= "";
//        System.out.printf(file);

//        String file="src/deliveries.csv";
//        try{
//            BufferedReader br= new BufferedReader(new FileReader(file));
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        ProblemOne problemOne= new ProblemOne();
//        problemOne.getAnswer();

//        DeliveryDataService deliveryDataService= new DeliveryDataService();
//        deliveryDataService.answe



        MatchesDataServiceInterface matchesDataServiceInterface= new MatchesDataServiceInterface();
        matchesDataServiceInterface.readData();

//        DeliveryDataService deliveryDataService= new DeliveryDataService();
//        deliveryDataService.readData();
        Problem problemOne= new Problem();
        problemOne.getMatchesPerSeason();



    }
}