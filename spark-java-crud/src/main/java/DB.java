import org.sql2o.*;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/java_spark_things", null, null);
}