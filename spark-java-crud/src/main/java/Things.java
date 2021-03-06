import java.time.LocalDateTime;
import java.util.List;

import org.sql2o.Connection;

public class Things {

	private String description;
	private LocalDateTime createdat;
	private int id;
	 
	public Things(String description) {
		  this.description = description;
		  createdat = LocalDateTime.now();
	}
	
	public String getDescription() {
	  return description;
	}
	
	public LocalDateTime getCreatedAt() {
	    return createdat;
    }
	
	public int getId() {
	    return id; 
    }
	
//	public static Things find(int id) {
//	}
	
	public static List<Things> all() {
	    String sql = "SELECT id, description FROM java_spark_things";
	    try(Connection con = DB.sql2o.open()) {
	      return con.createQuery(sql).executeAndFetch(Things.class);
	    }
    }
	
	public void save(Things thing) {
	    try(Connection con = DB.sql2o.open()) {
	      String sql = "INSERT INTO java_spark_things (description) VALUES (:description)";
	      con.createQuery(sql)
	        .addParameter("description", this.description)
	        .executeUpdate();
	    }
	}
}
