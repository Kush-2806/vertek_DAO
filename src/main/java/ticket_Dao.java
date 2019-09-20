import java.util.*;

public class ticket_Dao implements Dao<ticket>{
	LinkedHashMap<Integer, ticket> tick_list = new LinkedHashMap<Integer, ticket>();
	public ticket get(int id) {
		ticket t= tick_list.get(id);
		return t;
	}
	public boolean exists(int id) {
		return tick_list.containsKey(id);
	}
	public boolean isbug(int id) {
		if(tick_list.get(id) instanceof bugs) {
			return true;
		}else {
			return false;
		}
	}
	public boolean ishelpdesk(int id) {
		if(tick_list.get(id) instanceof helpdesk) {
			return true;
		}else {
			return false;
		}
	}
	public Map<Integer, ticket> getAll() {
		return tick_list;
	}
	public ticket get_ticket(int id) {
		return tick_list.get(id);
	}
	public void save(ticket t) {
		tick_list.put(t.getId(),t);
	}

	public void delete(int t) {
		if(tick_list.get(t) instanceof bugs) {
			bugs.decr_count();
		}else {
			helpdesk.decr_count();
		}
		tick_list.remove(t);
	}

	public List<ticket> get_bugs() {
		List<ticket> res= new ArrayList<ticket>();
		Iterator<Map.Entry<Integer, ticket>> ticket_it = tick_list.entrySet().iterator();
        while (ticket_it.hasNext()) {
            Map.Entry<Integer, ticket> entry = ticket_it.next();
            ticket temp = entry.getValue();
            if(temp instanceof bugs) {
            	res.add(temp);
            }
        }
		return res;
	}

	public List<ticket> get_helpdesk() {
		List<ticket> res= new ArrayList<ticket>();
		Iterator<Map.Entry<Integer, ticket>> ticket_it = tick_list.entrySet().iterator();
        while (ticket_it.hasNext()) {
            Map.Entry<Integer, ticket> entry = ticket_it.next();
            ticket temp = entry.getValue();
            if(temp instanceof helpdesk) {
            	res.add(temp);
            }
        }
		return res;
	}

}
