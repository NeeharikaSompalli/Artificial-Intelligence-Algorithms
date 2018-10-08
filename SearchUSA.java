import java.util.*;

class Node
{		public String nodename;
		public HashMap<String, Double> coord;
		public HashMap<String, Integer> adj_cities;
		public Node() {
			this.adj_cities =new HashMap<>();
			this.coord =new HashMap<>();
		}
}

public class SearchUSA {
	static HashMap<String,Node> map = new HashMap<>();
	public static void main(String args[])
	{	
		String citiesmap ="albanyNY, montreal, 226.\n" + 
				"albanyNY, boston, 166 .\n" + 
				"albanyNY, rochester, 148.\n" + 
				"albanyGA, tallahassee, 120 .\n" + 
				"albanyGA, macon, 106.\n" + 
				"albuquerque, elPaso, 267  .\n" + 
				"albuquerque, santaFe, 61.\n" + 
				"atlanta, macon, 82 .\n" + 
				"atlanta, chattanooga, 117.\n" + 
				"augusta, charlotte, 161  .\n" + 
				"augusta, savannah, 131.\n" + 
				"austin, houston, 186  .\n" + 
				"austin, sanAntonio, 79.\n" + 
				"bakersfield, losAngeles, 112  .\n" + 
				"bakersfield, fresno, 107.\n" + 
				"baltimore, philadelphia, 102  .\n" + 
				"baltimore, washington, 45.\n" + 
				"batonRouge, lafayette, 50  .\n" + 
				"batonRouge, newOrleans, 80.\n" + 
				"beaumont, houston, 69  .\n" + 
				"beaumont, lafayette, 122.\n" + 
				"boise, saltLakeCity, 349 .\n" + 
				"boise, portland, 428.\n" + 
				"boston, providence, 51.\n" + 
				"buffalo, toronto, 105 .\n" + 
				"buffalo, rochester, 64  .\n" + 
				"buffalo, cleveland, 191.\n" + 
				"calgary, vancouver, 605  .\n" + 
				"calgary, winnipeg, 829.\n" + 
				"charlotte, greensboro, 91.\n" + 
				"chattanooga, nashville, 129.\n" + 
				"chicago, milwaukee, 90  .\n" + 
				"chicago, midland, 279.\n" + 
				"cincinnati, indianapolis, 110  .\n" + 
				"cincinnati, dayton, 56.\n" + 
				"cleveland, pittsburgh, 157  .\n" + 
				"cleveland, columbus, 142.\n" + 
				"coloradoSprings, denver, 70  .\n" + 
				"coloradoSprings, santaFe, 316.\n" + 
				"columbus, dayton, 72.\n" + 
				"dallas, denver, 792  .\n" + 
				"dallas, mexia, 83.\n" + 
				"daytonaBeach, jacksonville, 92  .\n" + 
				"daytonaBeach, orlando, 54.\n" + 
				"denver, wichita, 523  .\n" + 
				"denver, grandJunction, 246.\n" + 
				"desMoines, omaha, 135  .\n" + 
				"desMoines, minneapolis, 246.\n" + 
				"elPaso, sanAntonio, 580 .\n" + 
				"elPaso, tucson, 320.\n" + 
				"eugene, salem, 63  .\n" + 
				"eugene, medford, 165.\n" + 
				"europe, philadelphia, 3939.\n" + 
				"ftWorth, oklahomaCity, 209.\n" + 
				"fresno, modesto, 109.\n" + 
				"grandJunction, provo, 220.\n" + 
				"greenBay, minneapolis, 304 .\n" + 
				"greenBay, milwaukee, 117.\n" + 
				"greensboro, raleigh, 74.\n" + 
				"houston, mexia, 165.\n" + 
				"indianapolis, stLouis, 246.\n" + 
				"jacksonville, savannah, 140 .\n" + 
				"jacksonville, lakeCity, 113.\n" + 
				"japan, pointReyes, 5131  .\n" + 
				"japan, sanLuisObispo, 5451.\n" + 
				"kansasCity, tulsa, 249  .\n" + 
				"kansasCity, stLouis, 256 .\n" + 
				"kansasCity, wichita, 190.\n" + 
				"keyWest, tampa, 446.\n" + 
				"lakeCity, tampa, 169  .\n" + 
				"lakeCity, tallahassee, 104.\n" + 
				"laredo, sanAntonio, 154.\n" + 
				"laredo, mexico, 741.\n" + 
				"lasVegas, losAngeles, 275  .\n" + 
				"lasVegas, saltLakeCity, 486.\n" + 
				"lincoln, wichita, 277  .\n" + 
				"lincoln, omaha, 58.\n" + 
				"littleRock, memphis, 137 .\n" + 
				"littleRock, tulsa, 276.\n" + 
				"losAngeles, sanDiego, 124  .\n" + 
				"losAngeles, sanLuisObispo, 182.\n" + 
				"medford, redding, 150.\n" + 
				"memphis, nashville, 210.\n" + 
				"miami, westPalmBeach, 67.\n" + 
				"midland, toledo, 82.\n" + 
				"minneapolis, winnipeg, 463.\n" + 
				"modesto, stockton, 29.\n" + 
				"montreal, ottawa, 132.\n" + 
				"newHaven, providence, 110  .\n" + 
				"newHaven, stamford, 92.\n" + 
				"newOrleans, pensacola, 268.\n" + 
				"newYork, philadelphia, 101.\n" + 
				"norfolk, richmond, 92  .\n" + 
				"norfolk, raleigh, 174.\n" + 
				"oakland, sanFrancisco, 8 .\n" + 
				"oakland, sanJose, 42.\n" + 
				"oklahomaCity, tulsa, 105.\n" + 
				"orlando, westPalmBeach, 168 .\n" + 
				"orlando, tampa, 84.\n" + 
				"ottawa, toronto, 269.\n" + 
				"pensacola, tallahassee, 120.\n" + 
				"philadelphia, pittsburgh, 319 .\n" + 
				"philadelphia, newYork, 101 .\n" + 
				"philadelphia, uk1, 3548.\n" + 
				"philadelphia, uk2, 3548.\n" + 
				"phoenix, tucson, 117  .\n" + 
				"phoenix, yuma, 178.\n" + 
				"pointReyes, redding, 215  .\n" + 
				"pointReyes, sacramento, 115.\n" + 
				"portland, seattle, 174  .\n" + 
				"portland, salem, 47.\n" + 
				"reno, saltLakeCity, 520  .\n" + 
				"reno, sacramento, 133.\n" + 
				"richmond, washington, 105.\n" + 
				"sacramento, sanFrancisco, 95  .\n" + 
				"sacramento, stockton, 51.\n" + 
				"salinas, sanJose, 31  .\n" + 
				"salinas, sanLuisObispo, 137.\n" + 
				"sanDiego, yuma, 172.\n" + 
				"saultSteMarie, thunderBay, 442  .\n" + 
				"saultSteMarie, toronto, 436.\n" + 
				"seattle, vancouver, 115.\n" + 
				"thunderBay, winnipeg, 440";  
		
		String locations="albanyGA,31.58,  84.17.\n" + 
				"albanyNY,        42.66,  73.78.\n" + 
				"albuquerque,     35.11, 106.61.\n" + 
				"atlanta,         33.76,  84.40.\n" + 
				"augusta,         33.43,  82.02.\n" + 
				"austin,          30.30,  97.75.\n" + 
				"bakersfield,     35.36, 119.03.\n" + 
				"baltimore,       39.31,  76.62.\n" + 
				"batonRouge,      30.46,  91.14.\n" + 
				"beaumont,        30.08,  94.13.\n" + 
				"boise,           43.61, 116.24.\n" + 
				"boston,          42.32,  71.09.\n" + 
				"buffalo,         42.90,  78.85.\n" + 
				"calgary,         51.00, 114.00.\n" + 
				"charlotte,       35.21,  80.83.\n" + 
				"chattanooga,     35.05,  85.27.\n" + 
				"chicago,         41.84,  87.68.\n" + 
				"cincinnati,      39.14,  84.50.\n" + 
				"cleveland,       41.48,  81.67.\n" + 
				"coloradoSprings, 38.86, 104.79.\n" + 
				"columbus,        39.99,  82.99.\n" + 
				"dallas,          32.80,  96.79.\n" + 
				"dayton,          39.76,  84.20.\n" + 
				"daytonaBeach,    29.21,  81.04.\n" + 
				"denver,          39.73, 104.97.\n" + 
				"desMoines,       41.59,  93.62.\n" + 
				"elPaso,          31.79, 106.42.\n" + 
				"eugene,          44.06, 123.11.\n" + 
				"europe,          48.87,  -2.33.\n" + 
				"ftWorth,         32.74,  97.33.\n" + 
				"fresno,          36.78, 119.79.\n" + 
				"grandJunction,   39.08, 108.56.\n" + 
				"greenBay,        44.51,  88.02.\n" + 
				"greensboro,      36.08,  79.82.\n" + 
				"houston,         29.76,  95.38.\n" + 
				"indianapolis,    39.79,  86.15.\n" + 
				"jacksonville,    30.32,  81.66.\n" + 
				"japan,           35.68, 220.23.\n" + 
				"kansasCity,      39.08,  94.56.\n" + 
				"keyWest,         24.56,  81.78.\n" + 
				"lafayette,       30.21,  92.03.\n" + 
				"lakeCity,        30.19,  82.64.\n" + 
				"laredo,          27.52,  99.49.\n" + 
				"lasVegas,        36.19, 115.22.\n" + 
				"lincoln,         40.81,  96.68.\n" + 
				"littleRock,      34.74,  92.33.\n" + 
				"losAngeles,      34.03, 118.17.\n" + 
				"macon,           32.83,  83.65.\n" + 
				"medford,         42.33, 122.86.\n" + 
				"memphis,         35.12,  89.97.\n" + 
				"mexia,           31.68,  96.48.\n" + 
				"mexico,          19.40,  99.12.\n" + 
				"miami,           25.79,  80.22.\n" + 
				"midland,         43.62,  84.23.\n" + 
				"milwaukee,       43.05,  87.96.\n" + 
				"minneapolis,     44.96,  93.27.\n" + 
				"modesto,         37.66, 120.99.\n" + 
				"montreal,        45.50,  73.67.\n" + 
				"nashville,       36.15,  86.76.\n" + 
				"newHaven,        41.31,  72.92.\n" + 
				"newOrleans,      29.97,  90.06.\n" + 
				"newYork,         40.70,  73.92.\n" + 
				"norfolk,         36.89,  76.26.\n" + 
				"oakland,         37.80, 122.23.\n" + 
				"oklahomaCity,    35.48,  97.53.\n" + 
				"omaha,           41.26,  96.01.\n" + 
				"orlando,         28.53,  81.38.\n" + 
				"ottawa,          45.42,  75.69.\n" + 
				"pensacola,       30.44,  87.21.\n" + 
				"philadelphia,    40.72,  76.12.\n" + 
				"phoenix,         33.53, 112.08.\n" + 
				"pittsburgh,      40.40,  79.84.\n" + 
				"pointReyes,      38.07, 122.81.\n" + 
				"portland,        45.52, 122.64.\n" + 
				"providence,      41.80,  71.36.\n" + 
				"provo,           40.24, 111.66.\n" + 
				"raleigh,         35.82,  78.64.\n" + 
				"redding,         40.58, 122.37.\n" + 
				"reno,            39.53, 119.82.\n" + 
				"richmond,        37.54,  77.46.\n" + 
				"rochester,       43.17,  77.61.\n" + 
				"sacramento,      38.56, 121.47.\n" + 
				"salem,           44.93, 123.03.\n" + 
				"salinas,         36.68, 121.64.\n" + 
				"saltLakeCity,    40.75, 111.89.\n" + 
				"sanAntonio,      29.45,  98.51.\n" + 
				"sanDiego,        32.78, 117.15.\n" + 
				"sanFrancisco,    37.76, 122.44.\n" + 
				"sanJose,         37.30, 121.87.\n" + 
				"sanLuisObispo,   35.27, 120.66.\n" + 
				"santaFe,         35.67, 105.96.\n" + 
				"saultSteMarie,   46.49,  84.35.\n" + 
				"savannah,        32.05,  81.10.\n" + 
				"seattle,         47.63, 122.33.\n" + 
				"stLouis,         38.63,  90.24.\n" + 
				"stamford,        41.07,  73.54.\n" + 
				"stockton,        37.98, 121.30.\n" + 
				"tallahassee,     30.45,  84.27.\n" + 
				"tampa,           27.97,  82.46.\n" + 
				"thunderBay,      48.38,  89.25.\n" + 
				"toledo,          41.67,  83.58.\n" + 
				"toronto,         43.65,  79.38.\n" + 
				"tucson,          32.21, 110.92.\n" + 
				"tulsa,           36.13,  95.94.\n" + 
				"uk1,             51.30,   0.00.\n" + 
				"uk2,             51.30,   0.00.\n" + 
				"vancouver,       49.25, 123.10.\n" + 
				"washington,      38.91,  77.01.\n" + 
				"westPalmBeach,   26.71,  80.05.\n" + 
				"wichita,         37.69,  97.34.\n" + 
				"winnipeg,        49.90,  97.13.\n" + 
				"yuma,            32.69, 114.62";

		getcitynames(citiesmap,map);
		getlatlongforcities(locations,map);
		if(args.length==3)
		{
			if(map.containsKey(args[1].toString()) && map.containsKey(args[2].toString()))
			{
				if(args[0].equals("astar"))
				{
					System.out.println(" AStar Algorithm Selected");
					System.out.println(" Solution  : "+ AStar(map.get(args[1]), map.get(args[2])));
				}
				else if(args[0].equals("greedy"))
				{
					System.out.println(" Greedy Algorithm Selected");
					System.out.println(" Solution : "+ Greedy(map.get(args[1]), map.get(args[2])));
				}
				else if( args[0].equals("dynamic"))
				{
					System.out.println(" Dynamic Programming Algorithm Selected");
					System.out.println(" Solution : "+ Dynamic(map.get(args[1]), map.get(args[2])));
				}
				else
				{
					System.out.println("Incorrect Input");
				}
			}
			else
			{
				System.out.println(" Give Correct city names");
				return;
			}
		}
		else
		{
			System.out.println(" Wrong input arguments");
			return;
		}
		
	}
	
	private static void getlatlongforcities(String locations, HashMap<String, Node> map) {
		String data[]= locations.split(".\n");
		int len1= data.length;
		for(int i=0;i< len1;i++)
		{
			String location[]= data[i].split(",");
			Node b1=map.get(location[0].trim());
			b1.coord.put("lat", Double.parseDouble(location[1].trim()));
			b1.coord.put("lon", Double.parseDouble(location[2].trim()));
		}
	}

	public static void getcitynames(String citiesmap, HashMap<String, Node>map)
	{	String[] cities = citiesmap.split(".\n");
		int len =cities.length;
		for(int i=0;i<len;i++)
		{
			String[] cityrows = cities[i].split(",");
			for(int j=0;j<2;j++)
			{
				cityrows[j]=cityrows[j].trim();
				if(!map.containsKey(cityrows[j]))
				{
					Node n= new Node();
					n.nodename=cityrows[j];
					map.put(cityrows[j], n);
				}
			}
			
			Node c1 = map.get(cityrows[0].trim());
			Node c2 = map.get(cityrows[1].trim());
			c1.adj_cities.put(c2.nodename, Integer.parseInt(cityrows[2].trim()));
			c2.adj_cities.put(c1.nodename, Integer.parseInt(cityrows[2].trim()));
		}
	}
	
	public static void addValuesToArrayList(String newpath, int goal, double start, ArrayList<ArrayList> al)
	{
		ArrayList a= new ArrayList<>();
		a.add(newpath);
		a.add(goal);
		a.add(start);
		al.add(a);	
	}
	public  static double calad(int d, double h) {
		return d+h;
	}
	
	public static double heuristic(Node s, Node g)
	{
		return Math.sqrt(Math.pow((69.5 * (s.coord.get("lat") - g.coord.get("lat"))),2) + Math.pow((69.5 * Math.cos((s.coord.get("lat") + g.coord.get("lat"))/360 * (22/7)) * (s.coord.get("lon") - g.coord.get("lon"))),2));
	}
	
	public static String AStar(Node s, Node g) {
		ArrayList<ArrayList> alist = new ArrayList<>();
		HashSet<Node>  visitednodes = new HashSet<Node>();
		HashMap<String, Integer>expandednodes = new HashMap();
		ArrayList<String> expandedlist = new ArrayList<>();
		ArrayList mincostpath;
		addValuesToArrayList(s.nodename,0,0 + heuristic(map.get(s.nodename),g), alist);
		int count =0;
	
		while(!alist.isEmpty())
		{
			int minidx= 0;
			for (int i=0;i<alist.size();i++)
			{
				if((double)alist.get(i).get(2)<(double)alist.get(minidx).get(2))
				{
					minidx =i;
				}
			}
			mincostpath=alist.remove(minidx);
			//System.out.println("mincostpath"+mincostpath);
			String  arr[] = mincostpath.get(0).toString().split("-->");
			String last = arr[arr.length-1];
			Node node = map.get(last);
			visitednodes.add(node);
			expandednodes.put(node.nodename, count++);
			if(node.nodename == g.nodename)
			{
				//System.out.println(" Expanded  Nodes  are :  " + expandednodes);
				//System.out.println(" Number of nodes expanded are :  "+ expandednodes.size());
				
				for ( String key : expandednodes.keySet())
					expandedlist.add(key);
				System.out.println(" Expanded  Nodes  are :" + expandedlist);
				System.out.println(" Number of nodes expanded are :  "+ expandednodes.size());
				String[] soln =mincostpath.get(0).toString().split("-->");
				ArrayList<String> solnnodes =new ArrayList<String>();
				for(String c : soln)
				{
					solnnodes.add(c);
				}
				System.out.println(" List of nodes in the solution path : "+solnnodes + "\n" + " Number of Solution nodes :  "+ solnnodes.size());
				return mincostpath.get(0).toString()+" \n Total distance is  : "+mincostpath.get(1);
				
			}
			for(Map.Entry<String, Integer>  entry : node.adj_cities.entrySet())
			{
				if(!visitednodes.contains(map.get(entry.getKey())))
				{
					String newpath =mincostpath.get(0).toString()+"-->"+entry.getKey().toString();
					//System.out.println(newpath);
					int goal = (int)(mincostpath.get(1))+entry.getValue();
					double heu=heuristic(map.get(entry.getKey()),g);
					double addn = calad(goal,heu);
					//System.out.println(addn);
					addValuesToArrayList(newpath,goal,addn,alist);
				}
			}	
		}
		return "There is no path between the given cities";
		}
	
	public static String Greedy(Node s, Node g) {
		ArrayList<ArrayList> alist = new ArrayList<>();
		HashSet<Node>  visitednodes = new HashSet<Node>();
		HashMap<String, Integer>expandednodes = new HashMap();
		ArrayList<String> expandedlist = new ArrayList<>();
		ArrayList mincostpath;
		addValuesToArrayList(s.nodename,0,0 + heuristic(map.get(s.nodename),g), alist);
		int count =0;
	
		while(!alist.isEmpty())
		{
			int minidx= 0;
			for (int i=0;i<alist.size();i++)
			{
				if((double)alist.get(i).get(2)<(double)alist.get(minidx).get(2))
				{
					minidx =i;
				}
			}
			mincostpath=alist.remove(minidx);
			String  arr[] = mincostpath.get(0).toString().split("-->");
			String vertex = arr[arr.length-1];
			Node node = map.get(vertex);
			visitednodes.add(node);
			expandednodes.put(node.nodename, count++);
			if(node.nodename == g.nodename)
			{	//System.out.println(" Expanded  Nodes  are :  " + expandednodes.keySet());
				for ( String key : expandednodes.keySet())
					expandedlist.add(key);
				System.out.println(" Expanded  Nodes  are :" + expandedlist);
				System.out.println(" Number of nodes expanded are :  "+ expandednodes.size());
				String[] soln =mincostpath.get(0).toString().split("-->");
				ArrayList<String> solnnodes =new ArrayList<String>();
				for(String c : soln)
				{
					solnnodes.add(c);
				}
				System.out.println(" List of nodes in the solution path : "+solnnodes + "\n" + " Number of Solution nodes :  "+ solnnodes.size());
				return mincostpath.get(0).toString()+" \n Total distance is  : "+mincostpath.get(1);
				
			}
			for(Map.Entry<String, Integer>  entry : node.adj_cities.entrySet())
			{
				if(!visitednodes.contains(map.get(entry.getKey())))
				{
					String newpath =mincostpath.get(0).toString()+"-->"+entry.getKey().toString();
					int goal = (int)(mincostpath.get(1))+entry.getValue();
					double heu=heuristic(map.get(entry.getKey()),g);
					double addn = heu;
					addValuesToArrayList(newpath,goal,addn,alist);
				}
			}	
		}
		return "There is no path between the given cities";
		
	}
	
	public static String Dynamic(Node s, Node g) {
		ArrayList<ArrayList> alist = new ArrayList<>();
		HashSet<Node>  visitednodes = new HashSet<Node>();
		HashMap<String, Integer>expandednodes = new HashMap();
		ArrayList<String> expandedlist = new ArrayList<>();
		ArrayList mincostpath;
		addValuesToArrayList(s.nodename,0,0, alist);
		int count =0;
	
		while(!alist.isEmpty())
		{
			int minidx= 0;
			for (int i=0;i<alist.size();i++)
			{
				if((int)alist.get(i).get(1)<(int)alist.get(minidx).get(1))
				{
					minidx =i;
				}
				
			}
			mincostpath=alist.remove(minidx);
			String  arr[] = mincostpath.get(0).toString().split("-->");
			String vertex = arr[arr.length-1];
			Node node = map.get(vertex);
			visitednodes.add(node);
			expandednodes.put(node.nodename, count++);
			if(node.nodename == g.nodename)
			{
				for ( String key : expandednodes.keySet())
					expandedlist.add(key);
				System.out.println(" Expanded  Nodes  are :" + expandedlist);
				System.out.println(" Number of nodes expanded are :  "+ expandednodes.size());
				String[] soln =mincostpath.get(0).toString().split("-->");
				ArrayList<String> solnnodes =new ArrayList<String>();
				for(String c : soln)
				{
					solnnodes.add(c);
				}
				System.out.println(" List of nodes in the solution path : "+solnnodes + "\n" + " Number of Solution nodes :  "+ solnnodes.size());
				return mincostpath.get(0).toString()+" \n Total distance is  : "+mincostpath.get(1);
				
			}
			for(Map.Entry<String, Integer>  entry : node.adj_cities.entrySet())
			{
				if(!visitednodes.contains(map.get(entry.getKey())))
				{
					String newpath =mincostpath.get(0).toString()+"-->"+entry.getKey().toString();
					int goal = (int)(mincostpath.get(1))+entry.getValue();
					addValuesToArrayList(newpath,goal,0,alist);
				}
			}	
		}
		return "There is no path between the given cities";
	}
}

