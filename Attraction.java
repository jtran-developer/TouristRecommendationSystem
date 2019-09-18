package register_information;

public class Attraction implements Comparable {
	int attractionID; 
	String attractionName;
	double latitude;
	double longitude;
	String featureClass;
	String featureCode;
	String state;
	int rating;
	double distance;
	String activity;
	
	public Attraction(int attractionID2, String attractionName, double latitude2,
	double longitude2, String featureClass, String featureCode, String state, int rating2, String a)
	{
		this.attractionID = attractionID2;
		this.attractionName = attractionName;
		this.latitude = latitude2;
		this.longitude = longitude2;
		this.featureClass = featureClass;
		this.featureCode = featureCode;
		this.state = state;
		this.rating = rating2;
		this.distance = -1;
		this.activity = a;
	}
	public int getAttractionID() {
		return attractionID;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getFeatureClass() {
		return featureClass;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public String getState() {
		return state;
	}

	public int getRating() {
		return rating;
	}	
	
	public double getDistance() {
		return this.distance;
	}
	public void setDistance(double d)
	{
		this.distance = d;
	}
	
	public String getActivity() {
		return this.activity;
	}
	public void setActivity(String a)
	{
		this.activity = a;
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int i = 0;
		if (this.distance < ((Attraction)o).getDistance())
			i = -1;
		else
		{
			i = 1;
		}
		return i;
	}
	public void print()
	{
		System.out.println(this.attractionName + "rating:" + this.rating + ":" + this.distance*68.703 + " miles");;
	}
}
