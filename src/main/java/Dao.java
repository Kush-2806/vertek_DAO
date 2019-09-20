import java.util.*;

public interface Dao<T> {
	ticket get(int id);
    
    Map<Integer,ticket> getAll();
     
    void save(T t);
     
    void delete(int t);
    
    List<ticket> get_bugs();
    List<ticket> get_helpdesk();
}
