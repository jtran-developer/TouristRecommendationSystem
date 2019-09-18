package register_information;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchPage {
	int boxSelected;
	ArrayList<City> allCities;
	ArrayList<String> allCitiesNames;
	ArrayList<String> activities;
	City destination; 
	search_db q = new search_db();
	JTextField finalDestinationTextField;
	JFrame jf;
	Comparator<Attraction> distanceOrder;
	Comparator<Attraction> ratingOrder;
	GridBagConstraints c;
	HashMap<String, String> m;
	
	public SearchPage() throws SQLException
	{
		jf = new JFrame();
		jf.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		setUpHashMap();
		JPanel destinationPanel = new JPanel();
		JPanel profilePanel = new JPanel();
		
		destinationPanel.setBackground(Color.GREEN);
		profilePanel.setLayout(new GridBagLayout());
		
		// Set destination Panel
		JLabel finalDestinationLabel = new JLabel("Destination");
		finalDestinationLabel.setBackground(Color.YELLOW);
		finalDestinationTextField = new JTextField();
		finalDestinationTextField.setPreferredSize(new Dimension(350, 25));
		
		JButton searchButton = new JButton("Search");
        searchButton.setSize(100, 100);
		searchButton.setBackground(Color.orange);
        searchButton.addActionListener(enterSearch());

		destinationPanel.add(finalDestinationLabel);
		destinationPanel.add(finalDestinationTextField);
		destinationPanel.add(searchButton);
		
		destinationPanel.setBackground(Color.GREEN);
		profilePanel.setBackground(Color.MAGENTA);
		
		JPanel mountainPanel   = makePanel("Mountain", "Hiking", "Camping", "Visiting Waterfall");
		JPanel parkPanel       = makePanel("Park", "Sports", "Exercise", "Picnic");
		JPanel lakePanel       = makePanel("Lake", "Jet Ski", "Row Boat", "Fishing");
		JPanel mallPanel       = makePanel("Mall", "Miniature Golf", "Bowling", "Live Events");
		JPanel museumPanel     = makePanel("Museum", "History", "Science", "Technology");
		JPanel beachPanel      = makePanel("Beach", "Whale Watching", "Deep Sea Fishing", "Bonfire");
		JPanel restaurantPanel = makePanel("Restaurant", "Seafood", "Ethnic", "Fast Food");
		JPanel stadiumPanel    = makePanel("Stadium", "Football", "Baseball", "Soccar");
		JPanel amusementPanel  = makePanel("Amusement Park", "Roller Coaster", "Water Park", "Famous Mascot");
		JPanel casinoPanel     = makePanel("Casino", "Shows", "Buffet", "Free Gambling");

		c.gridx = 0;
	    c.gridy = 0;
	    profilePanel.add(mountainPanel, c);
	    c.gridy = 1;
	    profilePanel.add(parkPanel, c);
	    c.gridy = 2;
	    profilePanel.add(lakePanel, c);
	    c.gridy = 3;
	    profilePanel.add(mallPanel, c);
	    c.gridy = 4;
	    profilePanel.add(museumPanel, c);
	    c.gridy = 5;
	    profilePanel.add(beachPanel, c);
	    c.gridy = 6;
	    profilePanel.add(restaurantPanel, c);
	    c.gridy = 7;
	    profilePanel.add(stadiumPanel, c);
	    c.gridy = 8;
	    profilePanel.add(amusementPanel, c);
	    c.gridy = 9;
	    profilePanel.add(casinoPanel, c);
	    
		boxSelected = 1;
		//destination = new City();
		allCities = q.runCitiesQuery();
		allCitiesNames = getAllCitiesNames();
		activities = new ArrayList<String>();
		setUpComparers();

		c.gridx = 0;
	    c.gridy = 0;
	    jf.add(destinationPanel, c);
		
	    c.gridx = 0;
	    c.gridy = 1;
		jf.add(profilePanel, c);

		jf.setTitle("Search Page");
		//jf.setBounds(200,200,800,500);
	    jf.pack();
		//jf.setSize(600, 500);
		jf.getContentPane().setLayout(null);
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setResizable(true);
	
	
	}

	private void setUpHashMap() {
		m = new HashMap<String, String>();
		m.put("MT", "Mountains");
		m.put("PRK", "Parks");
		m.put("LK", "Lakes");
		m.put("MALL", "Malls");
		m.put("MUS", "Museums");
		m.put("BCH", "Beaches");
		m.put("STDM", "Stadiums");
		m.put("AMUS", "Amusement Parks");
		m.put("CSNO", "Casino");
	}

	private JPanel makePanel(final String n, final String a1, final String a2, final String a3)
	{       
		JPanel p1 = new JPanel();
		p1.add(new JLabel(n));
		
		JPanel p2 = new JPanel();
		
		JLabel activity = new JLabel("Activities:");
		final JCheckBox c1 = new JCheckBox(a1);
		final JCheckBox c2 = new JCheckBox(a2);
		final JCheckBox c3 = new JCheckBox(a3);
	
		c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (c1.isSelected()){
					activities.add(a1);
				}
				else if (!c1.isSelected()){
					activities.remove(a1);
				}}});
		c2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (c2.isSelected()){
					activities.add(a2);
				}
				else if (!c2.isSelected()){
					activities.remove(a2);
				}}});
		c3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (c3.isSelected()){
					activities.add(a3);
				}
				else if (!c3.isSelected()){
					activities.remove(a3);
				}}});
		
		
		
	    //p.setBounds(200,200,300,175);
		//p.setSize(100,  100);  
	    
		c.gridx = 0;
	    c.gridy = 0;
	    
	    c.gridx = 0;
	    c.gridy = 1;
	    p2.add(activity, c);
	    
	    c.gridx = 1;
	    c.gridy = 1;
	    p2.add(c1, c);
	    
	    c.gridx = 2;
	    c.gridy = 1;
	    p2.add(c2, c);
	    
	    c.gridx = 3;
	    c.gridy = 1;
	    p2.add(c3, c);
	    
	    JPanel p3 = new JPanel();
	    p3.setSize(1000, 100);
	    p3.setLayout(new FlowLayout(FlowLayout.LEFT));
	    p3.add(p1);
	    p3.add(p2);
	    p3.setBackground(Color.CYAN);
	    
		return p3;
	}

	private void setUpComparers() 
	{
		distanceOrder =  new Comparator<Attraction>() {
		    public int compare(Attraction a1, Attraction a2) {
		    	int i = 0;
		    	if (a1.getDistance() < a2.getDistance()){i = -1;}
		    	else {i = 1;}
		        return i;}};

        ratingOrder =  new Comparator<Attraction>() {
	        public int compare(Attraction a1, Attraction a2) {
	        	int i = 0;
	    		if (a1.getRating() == a2.getRating()) {i=0;}
	    		else if (a1.getRating() > a2.getRating()){i = -1;}
	    		else {i = 1;}
	            return i;}};	
	}

	
	private ActionListener enterSearch() {
		
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(activities.toString());
				final JFrame resultPage = new JFrame();
				resultPage.setLayout(new GridBagLayout());
				
				for (City c : allCities)
				{
					if (c.getName().toLowerCase().equals(finalDestinationTextField.getText().toLowerCase()))
					{
						destination = c;
						System.out.println("found");
					}
				}
				
				if (destination == null)
				{
					JPanel p = new JPanel();
					p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
					
					JButton closeButton = new JButton("Close");
					closeButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							resultPage.setVisible(false);
						}});
					p.add(new JLabel("Destination Not Found"));
					p.add(closeButton);
					resultPage.setLocationRelativeTo(null);
					resultPage.setSize(150, 100);
					resultPage.setVisible(true);
					resultPage.add(p);
					
				}
				
				else 
				{
					JPanel p = new JPanel();
					p.setLayout(new FlowLayout(FlowLayout.LEFT));
					
					// Search for Attractions			
					//ArrayList<Attraction> contentList = runAlgo(.65, distanceOrder);
					//ArrayList<Attraction> collaboList = runAlgo(.65, ratingOrder);
					ArrayList<Attraction> demograList = runAlgo(.29, ratingOrder);
					
					resultPage.add((makeResultJPanel(demograList)));
					resultPage.pack();
					resultPage.setTitle("Result Page");
					resultPage.setVisible(true);
				}
				destination = null;
				}};
	}
	
	protected Component makeResultJPanel(ArrayList<Attraction> list) {
		JPanel p = new JPanel();
		
		p.setLayout(new GridBagLayout());
		int gridYValue = 0;
		c.gridx = 0;
	    c.gridy = gridYValue;
		//JTextArea a = new JTextArea();		
		DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Attraction Name", "Rating", "Distance" },0);
		
		//a.append("Try these attractions!" + "\n");
		ArrayList<Attraction> temp = new ArrayList<Attraction>();

		while (list.size() > 0)
		{
			temp.add(list.remove(0));
			for (Attraction fa : list)
			{
				if (temp.get(0).getFeatureCode().equals(fa.getFeatureCode()))
				{
					temp.add(fa);
				}
			}
			for (Attraction at : temp)
			{
				list.remove(at);
			}
			while (temp.size() > 5)
			{
				temp.remove(temp.size()-1);
			}

			JLabel t = new JLabel("\nFor " + m.get(temp.get(0).getFeatureCode()) + ", try:" + "\n");
			tableModel = new DefaultTableModel(new String[] { "Attraction Name", "Rating", "Distance" },0);
			tableModel.addRow(new Object[] {"<html><b>Attraction Name</b></html>", "<html><b>Rating</b></html>", "<html><b>Distance</b></html>"});
			
			for (Attraction ta : temp)
			{
				tableModel.addRow(new Object[] {ta.getAttractionName(), ta.getRating(), round(ta.getDistance()*68.703) + " miles"});
			}
			
			JTable tab = new JTable();
			tableModel.setNumRows(tableModel.getRowCount());
			tab.setModel(tableModel);
			tab.getColumnModel().getColumn(0).setPreferredWidth(250);
			tab.getColumnModel().getColumn(1).setPreferredWidth(50);
			tab.getColumnModel().getColumn(2).setPreferredWidth(100);
		
			c.gridy = gridYValue;
			p.add(t, c);
			gridYValue++;
	
			c.gridy = gridYValue;
			p.add(tab, c);
			gridYValue++;
			temp.clear();
		}
		return p;
	}
	
	public String outputData(Attraction a)
	{
		return a.attractionName + "\tRating=" + a.getRating() + "\tDistance=" + round(a.getDistance()*68.703) + " miles";
	}
	public String round(double d)
	{
		String num = d + "";
		num = num.substring(0, num.indexOf(".") + 2);
		
		return num;
	}

	public ArrayList<Attraction> runAlgo(double distance, Comparator<Attraction> comparer )
	{
		ArrayList<Attraction> al = null;
		
		try {
			al = q.runAttractionQuery(destination, distance, activities);
		} catch (SQLException e) {e.printStackTrace();}
		
		for (Attraction a : al)
		{
			a.setDistance( Math.sqrt(Math.pow((a.getLatitude() - destination.getLatitude()), 2) + Math.pow((a.getLongitude() - destination.getLongitude()), 2)));
		}      
		
		Collections.sort(al, comparer);
		return al;
	}
		
	public JPanel addCheckBox()
	{
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		//GridBagConstraints c = new GridBagConstraints();
        
		JRadioButton r = new JRadioButton("Content");
		JRadioButton r1 = new JRadioButton("Collaborative");
		JRadioButton r2 = new JRadioButton("Demographic");
		JRadioButton r3 = new JRadioButton("All");
		
		r.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {boxSelected = 1;}});
		r1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {boxSelected = 2;}});
		r2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {boxSelected = 3;}});
		r3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {boxSelected = 4;}});
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r);
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		r.setSelected(true);
		
	    //p.setBounds(500,0,300,175);
		p.setSize(100, 100);
	    c.gridx = 0;
	    c.gridy = 0;
	    p.add(r, c);
	    
	    c.gridx = 0;
	    c.gridy = 1;
	    p.add(r1, c);
	    
	    c.gridx = 0;
	    c.gridy = 2;
	    p.add(r2, c);
	    
	    c.gridx = 0;
	    c.gridy = 3;
	    p.add(r3, c);
	    
		return p;
	}
	
	public ArrayList<String> getAllCitiesNames()
	{	
		ArrayList<String> names = new ArrayList<String>();
		for (City c : allCities)
		{
			names.add(c.getName());
		}

		Collections.sort(names);
		return names;
	}
	
	public static void main(String[] args) throws SQLException {
		SearchPage s= new SearchPage();
	}
}
