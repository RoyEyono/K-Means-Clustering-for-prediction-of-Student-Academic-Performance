package studentacademicperformance;
/*
Author: Roy Eyono
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Point {

    private List<Double> var;
    private int cluster_number = 0;
    public static int size;

    public Point(double... x)
    {
    	
    	var = new ArrayList<Double>();
    	for (double n : x) {
            var.add(n);
        }
    }
    public Point(List<Double> list)
    {
    	
    	var = new ArrayList<Double>();
    	for (double n : list) {
            var.add(n);
        }
    }
    
    public List<Double> getList(){
    	return var;
    }
    
    public void setCluster(int n) {
        this.cluster_number = n;
    }
    
    public int getCluster() {
        return this.cluster_number;
    }
    
    
    
    //Calculates the distance between two points.
    protected static double distance(Point p, Point centroid) {
    	double dis = 0;
    	
    	for(int start=0;start<p.getList().size();start++){
    		dis=dis+Math.pow(p.getList().get(start)-centroid.getList().get(start),2);
    		}
    	dis=Math.sqrt(dis);
    	return dis;
    }
    
    //Creates random point
    public static Point createRandomPoint(int min, int max) {
    	Random r = new Random();
    	List<Double> list = new ArrayList<Double>();
    	for(int start=0;start<5;start++){
    	list.add( min + (max - min) * r.nextDouble() );
    	}
    	
    	return new Point(list);
    }
    
    protected static List<Point> createRandomPoints(int min, int max, int number) {
    	List<Point> points = new LinkedList<Point>();
    	for(int i = 0; i < number; i++) {
    		
    		points.add(createRandomPoint(min,max));
    	}
    	
    	return points;
    }
    
    public String toString() {
    	return var.toString();
    }
}
