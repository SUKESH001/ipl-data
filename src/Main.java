import IPLService.DeliveryDataService;
import IPLService.MatchesDataServiceInterface;
import QuestionService.Questions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        MatchesDataServiceInterface matchesDataServiceInterface= new MatchesDataServiceInterface();
        matchesDataServiceInterface.readData();

        DeliveryDataService deliveryDataService= new DeliveryDataService();
        deliveryDataService.readData();

        Questions problem= new Questions();

        problem.questionOne();
        problem.questionTwo();
        problem.questionThree();
        problem.questionFour();









    }
}