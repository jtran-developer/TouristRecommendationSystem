package register_information;

public class City {
	String name;
	double latitude;
	double longitude;
	public City(String n, double lat, double lon)
	{
		this.name = n;
		this.latitude = lat;
		this.longitude = lon;
	}
	public City()
	{
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
