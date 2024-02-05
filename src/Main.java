import IPLService.DeliveryDataService;
import IPLService.MatchesDataService;
import QuestionService.Questions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        MatchesDataService matchesDataServiceInterface= new MatchesDataService();
        matchesDataServiceInterface.readData();

        DeliveryDataService deliveryDataService= new DeliveryDataService();
        deliveryDataService.readData();

        Questions problem= new Questions();

        problem.questionOne();
        problem.questionTwo();
        problem.questionThree();
        problem.questionFour();

        // top 10 batsman with most runs in both 2015 and 2016 combined
        problem.questionFive();
    }
}
