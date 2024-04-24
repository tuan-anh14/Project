import java.util.ArrayList;

public class City {
    private String cityName;
    private ArrayList<Person> residents;
    private ArrayList<PublicFacility> publicFacilities;

    public City(String cityName) {
        this.cityName = cityName;
        residents = new ArrayList<>();
        publicFacilities = new ArrayList<>();
    }

    public void addResident(Person person) {
        residents.add(person);
    }

    public void removeResident(Person person) {
        residents.remove(person);
    }

    public ArrayList<Person> getResidents() {
        return residents;
    }

    public void addPublicFacility(PublicFacility facility) {
        publicFacilities.add(facility);
    }

    public void removePublicFacility(PublicFacility facility) {
        publicFacilities.remove(facility);
    }

    public ArrayList<PublicFacility> getPublicFacilities() {
        return publicFacilities;
    }
}