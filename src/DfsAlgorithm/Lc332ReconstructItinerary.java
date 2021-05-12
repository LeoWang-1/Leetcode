package DfsAlgorithm;

import java.util.*;

public class Lc332ReconstructItinerary {
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            // Corner case
            if (tickets == null || tickets.size() == 0 || tickets.get(0) == null || tickets.get(0) == null) return new ArrayList<>();

            Map<String, List<String>> graph = new HashMap<>();
            for (List<String> ticket : tickets) {
                if (graph.containsKey(ticket.get(0))) {
                    graph.get(ticket.get(0)).add(ticket.get(1));
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(ticket.get(1));
                    graph.put(ticket.get(0), temp);
                }
            }

            for (List<String> list : graph.values()) {
                Collections.sort(list);
            }

            List<String> res = new ArrayList<>();
            int airportSize = tickets.size() + 1;
            res.add("JFK");

            if(findItineraryHelper(res, graph, airportSize, "JFK")) {
                return res;
            }
            return new ArrayList<>();
        }

        private boolean findItineraryHelper(List<String> res, Map<String, List<String>> graph, int airportSize, String start) {
            // Base case
            if (res.size() == airportSize) return true;
            if (!graph.containsKey(start)) return false;

            // Next step
            List<String> des = graph.get(start);
            for (int i = 0; i < des.size(); i++) {
                String nextCity = des.get(i);
                des.remove(i);
                res.add(nextCity);
                if (findItineraryHelper(res, graph, airportSize, nextCity)) return true;
                res.remove(res.size() - 1);
                des.add(i, nextCity);
            }
            return false;
        }
    }
}
