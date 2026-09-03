import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, CheckInData> checkIns;
    private Map<String, RouteData> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckInData data = checkIns.get(id);

        String startStation = data.stationName;
        int checkInTime = data.time;

        int travelTime = t - checkInTime;

        String route = startStation + "#" + stationName;

        RouteData routeData = routes.getOrDefault(
            route,
            new RouteData(0, 0)
        );

        routeData.totalTime += travelTime;
        routeData.tripCount++;

        routes.put(route, routeData);

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "#" + endStation;

        RouteData routeData = routes.get(route);

        return (double) routeData.totalTime / routeData.tripCount;
    }

    // Class to store check-in information
    private static class CheckInData {
        String stationName;
        int time;

        CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Class to store route statistics
    private static class RouteData {
        int totalTime;
        int tripCount;

        RouteData(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}
