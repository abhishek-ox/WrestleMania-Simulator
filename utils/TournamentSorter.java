package utils;

import wrestlers.Wrestler;
import java.util.*;

public class TournamentSorter {
    public static Map<Wrestler, Integer> getSortedPointsTable(Map<Wrestler, Integer> pointsTable) {
        List<Map.Entry<Wrestler, Integer>> sortedList = new ArrayList<>(pointsTable.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort in descending order

        Map<Wrestler, Integer> sortedTable = new LinkedHashMap<>();
        for (Map.Entry<Wrestler, Integer> entry : sortedList) {
            sortedTable.put(entry.getKey(), entry.getValue());
        }
        return sortedTable;
    }
}
