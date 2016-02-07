package studentacademicperformance;
/*
Author: Roy Eyono
*/

import java.util.ArrayList;
import java.util.List;

public class KMeans {

	//Number of Clusters. This metric should be related to the number of points
    private int NUM_CLUSTERS = 5;    
    //Number of Points
    private int NUM_POINTS = 100;
    //Min and Max X and Y
    private static final int MIN_COORDINATE = 1;
    private static final int MAX_COORDINATE = 100;
    
    private List<Point> points;
    private List<Cluster> clusters;
    
    public KMeans() {
    	this.points = new ArrayList<Point>();
    	this.clusters = new ArrayList<Cluster>();    	
    }
    
    
    
    //Initializes the process
    public void init() {
    	//Create Points
    	points = Point.createRandomPoints(MIN_COORDINATE,MAX_COORDINATE,NUM_POINTS);
    	
    	//Create Clusters
    	//Set Random Centroids
    	for (int i = 0; i < NUM_CLUSTERS; i++) {
    		Cluster cluster = new Cluster(i);
    		Point centroid = Point.createRandomPoint(MIN_COORDINATE,MAX_COORDINATE);
    		cluster.setCentroid(centroid);
    		clusters.add(cluster);
    	}
    	
    	//Print Initial state
    	plotClusters();
    }

	private void plotClusters() {
    	for (int i = 0; i < NUM_CLUSTERS; i++) {
    		Cluster c = clusters.get(i);
    		c.plotCluster();
    	}
    }
    
	//The process to calculate the K Means, with iterating method.
    public void calculate() {
        boolean finish = false;
        int iteration = 0;
        
        // Add in new data, one at a time, recalculating centroids with each new one. 
        while(!finish) {
        	//Clear cluster state
        	clearClusters();
        	
        	List<Point> lastCentroids = getCentroids();
        	
        	//Assign points to the closer cluster
        	assignCluster();
            
            //Calculate new centroids.
        	calculateCentroids();
        	
        	iteration++;
        	
        	List<Point> currentCentroids = getCentroids();
        	
        	//Calculates total distance between new and old Centroids
        	double distance = 0;
        	for(int i = 0; i < lastCentroids.size(); i++) {
        		distance += Point.distance(lastCentroids.get(i),currentCentroids.get(i));
        	}
        	System.out.println("#################");
        	System.out.println("Iteration: " + iteration);
        	System.out.println("Centroid distances: " + distance);
        	plotClusters();
        	        	
        	if(distance == 0) {
        		finish = true;
        	}
        }
    }
    
    private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
    
    private List<Point> getCentroids() {
    	List<Point> centroids = new ArrayList<Point>(NUM_CLUSTERS);
    	for(Cluster cluster : clusters) {
    		Point aux = cluster.getCentroid();
    		Point point = new Point(aux.getList());
    		centroids.add(point);
    	}
    	return centroids;
    }
    
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;                 
        double distance = 0.0; 
        
        for(Point point : points) {
        	min = max;
            for(int i = 0; i < NUM_CLUSTERS; i++) {
            	Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }
    
    private void calculateCentroids() {
        for(Cluster cluster : clusters) {
            
            List<Point> list = cluster.getPoints();
            int n_points = list.size();
            List<Double> sum = new ArrayList<Double>();
            
            
            
            for(Point point : list) {
            	
            	if(sum.isEmpty())
            		for(int start=0;start<5;start++)
                    	sum.add(point.getList().get(start));
            	else
            		for(int start=0;start<5;start++)
            			sum.set(start,point.getList().get(start)+sum.get(start));
            	
            }
            
            Point centroid = cluster.getCentroid();
            if(n_points > 0) {
            	for(int start=0;start<5;start++)
            		centroid.getList().set(start,sum.get(start)/n_points);
            }
        }
    }
}
