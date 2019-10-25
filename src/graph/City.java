package graph;

import java.util.Objects;

/**
 *
 * @author uniaodk
 */
public class City {

    private String name, tag;
    private double latitude, longitude, heuristic;

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.tag = name.substring(0, 3);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public City(City copy) {
        this.name = copy.name;
        this.latitude = copy.latitude;
        this.longitude = copy.longitude;
        this.heuristic = copy.heuristic;
    }

    public void setName(String name) {
        this.name = name;
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
        return tag;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.tag);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final City other = (City) obj;
        if (!Objects.equals(this.tag, other.tag)) {
            return false;
        }
        return true;
    }

}
