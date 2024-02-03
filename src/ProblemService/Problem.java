package ProblemService;


import IPLService.MatchesDataServiceInterface;
import Models.Matches;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem {

   public MatchesDataServiceInterface matchesDataServiceInterface;
   HashSet<Integer> uniqueMatchIds = new HashSet<>();
   HashSet<Integer> uniqueSeason = new HashSet<>();

   List<Matches> allMatches = MatchesDataServiceInterface.getAllMatchData();

   HashMap<Integer, Integer> map = new HashMap<>();

   public void getMatchesPerSeason() {

      for (Matches matches : allMatches) {
         int count;
         if (map.containsKey(matches.getSeason())) {

            count = map.get(matches.getSeason());
            count += 1;

            map.put(matches.getSeason(), count);
         } else {
            map.put(matches.getSeason(), count = 1);
         }
      }
      printHashMap(map);

   }


   private void printHashMap(HashMap map) {

      for (Object key : map.keySet()) {
         System.out.println(key + " " + map.get(key));

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











