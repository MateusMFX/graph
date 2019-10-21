package graph.mockup;

/**
 *
 * @author uniaodk
 */
public class City {
    
    private String name;
    private double latitude, longitude, heuristic;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public City withHeuristic(City city) {
        this.heuristic = Math.abs(latitude - city.latitude)
                + Math.abs(longitude - city.longitude);
        return this;
    }

    @Override
    public String toString() {
        return name;
    }    
}
