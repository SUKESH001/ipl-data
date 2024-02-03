package QuestionService;


import IPLService.DeliveryDataService;
import IPLService.MatchesDataServiceInterface;
import Models.Deliveries;
import Models.Matches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

       for (Object key : map.keySet()) {
         System.out.println(map.get(key) + " matches were played in "  +key);
      }
   }

   HashMap<String, Integer> map2= new HashMap<>();
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
   public  void printHashMap2(HashMap map){

      for (Object key : map.keySet()) {
         System.out.println(key + " have  won "+ map.get(key) + " matches.");
      }
   }

  List<Matches> allMatches2016=  new ArrayList<>();
   public void matches2016(){

      for( Matches matches : allMatches){
         if(matches.getSeason()== 2016){
            allMatches2016.add(matches);
         }
      }
   }

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

   HashMap<String ,Integer> map3= new HashMap<>();
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
   public  void printHashMap3(HashMap map){

      for (Object key : map.keySet()) {
         System.out.println(key + " have  conceded "+ map.get(key) + " extra runs.");
      }
   }



}


//

//   private int getUniqueSeasons() {
//      for (Matches matches : allMatches) {
//         uniqueSeason.add(matches.getSeason()+1);
////         System.out.println(matches.getSeason());
//      }
//      return uniqueSeason.size();
//   }

//   int n = getMatchCount();
//   int n1= getUniqueSeasons();



//   public int getAnswer() {
////      System.out.println(n+" "+n1);
//      return (n / n1);
//
////      System.out.println(allMatches.get(1).);
//   }











