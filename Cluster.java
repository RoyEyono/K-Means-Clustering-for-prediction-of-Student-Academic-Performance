package studentacademicperformance;
/*
	Author: Roy Eyono
*/
import java.util.ArrayList;
import java.util.List;

public class Cluster {
	
	public List<Point> points;
	public Point centroid;
	public int id;
	
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<Point>();
		this.centroid = null;
	}

	public List<Point> getPoints() {
		return points;
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getCentroid() {
		return centroid;
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}
	
	public String PerformanceEq(double perf){
		
		if(perf>=70)
			return "Excellent";
		else if(perf>=60)
			return "Very Good";
		else if(perf>=50)
			return "Good";
		else if(perf>=45)
			return "Very Fair";
		else if(perf>=40)
			return "Fair";
		else
			return "Poor";
	}
	
	public double Performance(){
		double overall_perf=0;
		double perf=0;
		for(Point p: points){
			perf=0;
			for(int start=0;start<p.getList().size();start++){
				perf=perf + p.getList().get(start);
			}
			overall_perf=overall_perf+(perf/p.getList().size());
		}
		return overall_perf/points.size();
	}
	
	public void plotCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centroid: " + centroid + "]");
		System.out.println("[Points: \n");
		for(Point p : points) {
			System.out.println(p);
		}
		System.out.println("]");
		System.out.println("Overall Performance of Cluster "+id+": "+(int)Performance()+"("+PerformanceEq(Performance())+")");
	}

}
