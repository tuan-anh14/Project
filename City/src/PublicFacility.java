public class PublicFacility {
    private String name;
    private String address;
    private double area;
    private String facilityType;

    public PublicFacility(String name, String address, double area, String facilityType) {
        this.name = name;
        this.address = address;
        this.area = area;
        this.facilityType = facilityType;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public String getFacilityType() {
        return facilityType;
    }
}