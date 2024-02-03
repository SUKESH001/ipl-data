package QuestionService;


import IPLService.DeliveryDataService;
import IPLService.MatchesDataServiceInterface;
import Models.Deliveries;
import Models.Matches;

import java.util.*;

public class Questions {

//   public MatchesDataServiceInterface matchesDataServiceInterface;
//   public  DeliveryDataService deliveryDataService;
//   HashSet<Integer> uniqueMatchIds = new HashSet<>();
//   HashSet<Integer> uniqueSeason = new HashSet<>();

   List<Matches> allMatches = MatchesDataServiceInterface.getAllMatchData();
   List<Deliveries> allDeliveries = DeliveryDataService.getAllDeliveryData();


   HashMap<Integer, Integer> map1 = new HashMap<>();
   public void questionOne() {

      for (Matches matches : allMatches) {
         int count;
         if (map1.containsKey(matches.getSeason())) {

            count = map1.get(matches.getSeason());
            count += 1;

            map1.put(matches.getSeason(), count);
         } else {
            map1.put(matches.getSeason(), 1);
         }
      }
      printHashMap(map1);
   }
   private void printHashMap(HashMap map) {

      System.out.println("Question 1");

       for (Object key : map.keySet()) {
         System.out.println(map.get(key) + " matches are played in "  +key);
      }
      System.out.println();
   }

   //question2

   Map<String, Integer> map2= new HashMap<>();
   public void questionTwo(){

      for(Matches matches : allMatches){

         int count;
         if(map2.containsKey(matches.getWinner())){

            count= map2.get(matches.getWinner());
            count+=1;
            map2.put(matches.getWinner(), count);

         }
         else{
            map2.put(matches.getWinner(), 1);
         }

      }
      printHashMap2(map2);
   }
   public  void printHashMap2(Map map){

      System.out.println("Question 2");

      for (Object key : map.keySet()) {
         System.out.println(key + " have  won "+ map.get(key) + " matches.");
      }
      System.out.println();
   }

// Question 3

   List<Deliveries> allDeliveries2016 = new ArrayList<>();
   public  void deliveries2016(){

      for(Matches matches : allMatches) {

         if (matches.getSeason() == 2016) {
            int val = matches.getMatchId();

            for (Deliveries deliveries : allDeliveries) {
               if (deliveries.getMatch_id() == val) {
                  allDeliveries2016.add(deliveries);
               }
            }
         }
      }
   }
   Map<String ,Integer> map3= new HashMap<>();
   public void questionThree(){
      deliveries2016();

      for(Deliveries deliveries : allDeliveries2016){

         int runs;
         if(map3.containsKey(deliveries.getBowlingTeam())){

            runs= map3.get(deliveries.getBowlingTeam());
            runs= runs+deliveries.getExtraRuns();
            map3.put(deliveries.getBowlingTeam() , runs);
         }
         else{
            map3.put(deliveries.getBowlingTeam(), deliveries.getExtraRuns());
         }
      }
      printHashMap3(map3);

   }
   public  void printHashMap3(Map map){

      System.out.println("Question 3");

      for (Object key : map.keySet()) {
         System.out.println(key + " have  conceded "+ map.get(key) + " extra runs.");
      }
      System.out.println();
   }

   //question 4
   List<Deliveries> allDeliveries2015 = new ArrayList<>();
   public  void deliveries2015(){

      for(Matches matches : allMatches) {

         if (matches.getSeason() == 2015) {
            int val = matches.getMatchId();

            for (Deliveries deliveries : allDeliveries) {
               if (deliveries.getMatch_id() == val) {
                  allDeliveries2015.add(deliveries);
               }
            }
         }
      }
   }

   Map<String , Integer> map4= new HashMap<>();
   Map<String , Integer> map5= new HashMap<>();
   Map<String , Float> map6= new HashMap<>();
   public void questionFour(){

      deliveries2015();
      for(Deliveries deliveries : allDeliveries2015) {
         int runs;


         if (map4.containsKey(deliveries.getBowler())) {

            runs = map4.get(deliveries.getBowler()) + deliveries.getWideRuns()
                    + deliveries.getBatsmanRuns() + deliveries.getNoBallRuns();

            map4.put(deliveries.getBowler(), runs);
         } else {
            map4.put(deliveries.getBowler(), deliveries.getWideRuns()
                    + deliveries.getBatsmanRuns() + deliveries.getNoBallRuns());
         }
         int ball;

         if(map5.containsKey(deliveries.getBowler())){

            map5.put(deliveries.getBowler(), map5.get(deliveries.getBowler())+1);
         }
         else{
            map5.put(deliveries.getBowler(), 1);
         }
      }

      for(String key : map4.keySet()){
         if(map5.containsKey(key)){
            float val1 =map4.get(key);
            float val2 = map5.get(key);
            map6.put(key, (float) (val1 / val2));
         }
      }

      printHashMap4();


   }
   public void printHashMap4(){

      int count=0;
      List<Map.Entry<String, Float>> entryList = new ArrayList<>(map6.entrySet());
      entryList.sort(Map.Entry.comparingByValue());

      LinkedHashMap<String, Float> sortedMap = new LinkedHashMap<>();
      for (Map.Entry<String,Float> entry : entryList) {
         sortedMap.put(entry.getKey(), entry.getValue());
      }

      System.out.println("Question4" );
      System.out.println("Top bowlers with best economy");

      for (Map.Entry<String, Float> entry : sortedMap.entrySet()) {
         System.out.println( entry.getKey() + " economy of " + (entry.getValue()*6));
         count++;
         if( count==20){
            break;
         }
      }

   }
}














