package register_information;

import java.sql.*;
import java.util.ArrayList;

public class search_db extends conn_db {
	Connection con;
	Statement stmt;
	public search_db() throws SQLException
	{
		
		try {
			connection();
			con = super.con;
			
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//stmt = con.createStatement();
	}
	public ArrayList<City> runCitiesQuery() throws SQLException
	{
		ArrayList<City> al = new ArrayList<City>();
		Statement stmt = con.createStatement();
		String sql = "select * from cities";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			String cityName = rs.getString(1);
			double latitude = Double.parseDouble(rs.getString(2));
			double longitude = Double.parseDouble(rs.getString(3));
			al.add(new City(cityName, latitude, longitude));
		}
		return al;
	}

	public ArrayList<Interest> runInterestsQuery() throws SQLException
	{
		ArrayList<Interest> al = new ArrayList<Interest>();
		Statement stmt = con.createStatement();
		String sql = "select * from attraction_cd";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			String code = rs.getString(1);
			String desc = rs.getString(2);
			al.add(new Interest(code, desc));
		}
		return al;
	}
	
	public ArrayList<Attraction> runAttractionQuery(City c, double distance, ArrayList<String> hobby) throws SQLException
	{
		String hobbyString = "";
		String sep = "";
		for (String s : hobby)
		{
			hobbyString += sep + "\"" + s + "\"";
			sep = ", ";
		}
		
		ArrayList<Attraction> al = new ArrayList<Attraction>();
		
		String sql = "SELECT * FROM cpsc531.us_la " 
				+ "where Latitude > " + (c.getLatitude()-distance) + " AND Latitude < " + (c.getLatitude()+distance) + " "
				+ "AND Longitude > " + (c.getLongitude()-distance) + " AND Longitude < " + (c.getLongitude()+distance);
					
		if (hobby.size() > 0)
		{
			sql += " AND Activity in (" +hobbyString + ");";	
		}
		else
		{
			sql += ";";
		}
		
		System.out.println(sql);;
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			int attractionID = Integer.parseInt(rs.getString(1));
			String attractionName = rs.getString(2);
			double latitude = Double.parseDouble(rs.getString(3));
			double longitude = Double.parseDouble(rs.getString(4));
			String featureClass = rs.getString(5);
			String featureCode = rs.getString(6);
			String state = rs.getString(7);
			int rating = Integer.parseInt(rs.getString(8));
			String activity = rs.getString(9);
			al.add(new Attraction(attractionID, attractionName, latitude, longitude, featureClass, featureCode, state, rating, activity));
		}
		return al;
	}
}
