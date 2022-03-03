package myy803.jpa.myy803_jpa_tutorial_1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_id")
	private Service service;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="route_id")
	private List<Stop> stops;
	
	public Route() {
		super();
		this.stops = new ArrayList<Stop>();
	}

	public Route(String name, Service service) {
		super();
		this.name = name;
		this.service = service;
		this.stops = new ArrayList<Stop>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
	
	public void addStop(Stop stop) {
		stops.add(stop);
	}

	@Override
	public String toString() {
//		String stopsString = null;
//		if(stops != null)
//			for(Stop stop : stops) {
//				stopsString += "\n" + stop.toString();
//			}
		
		return "Route [id=" + id + ", name=" + name + ", service=" + service + stops + "]";
	}
}
