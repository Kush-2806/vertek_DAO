import java.util.*;
import java.util.Map.Entry;

public class vertek {
	private static Scanner sc = new Scanner(System.in);
	static ticket_Dao td=new ticket_Dao();
	public static void main(String a[]) {
		while(true) {
			System.out.println("Welcome, please enter your choice of action:");
			System.out.println(" 1 Create a help desk request \n 2 Create a bug report ticket \n 3 View a help desk request \n 4 View a bug report ticket \n 5 Delete a help desk request \n 6 Delete a bug report ticket \n 7 List all help desk requests \n 8 List all bug report tickets \n 9 List all Artifacts \n 10 Get a count report \n 11 Exit");
			int x = sc.nextInt();
			sc.nextLine();
			switch(x) {
			case 1:
				System.out.println("Creating a helpdesk ticket....");
				helpdest_create();
				break;
			case 2:
				System.out.println("Creating a bug request....");
				bug_create();
				break;
			case 3:
				System.out.println("Viewing a helpdesk ticket....");
				helpdesk_view();
				break;
			case 4:
				System.out.println("Viewing a bug request....");
				bug_view();
				break;
			case 5:
				System.out.println("DELETING a helpdesk ticket....");
				helpdesk_delete();
				break;
			case 6:
				System.out.println("DELETING a bug request....");
				bug_delete();
				break;
			case 7:
				System.out.println("Viewing all helpdesk tickets....");
				all_helpdesk();
				break;
			case 8:
				System.out.println("Viewing all Bug requests....");
				all_bugreports();
				break;
			case 9:
				System.out.println("Viewing EVERYTHING....");
				view_all();
				break;
			case 10:
				System.out.println("Ticket Stats: ");
				get_count();
				break;
			case 11:
				System.exit(0);
				break;
			}
				
		}

	}
	private static void get_count() {
		System.out.println("Total Tickets, including bugs and helpdesk requests are: "+ticket.getcount());
		System.out.println("Total bugs  are: "+bugs.bug_count());
		System.out.println("Total helpdesk requests are: "+helpdesk.helpdesk_count());
		
	}
	private static void view_all() {
		// TODO Auto-generated method stub
		Map<Integer, ticket> tick_list = td.getAll();
		for (Iterator<Entry<Integer, ticket>> iterator = tick_list.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, ticket> mapElement = iterator.next();
			ticket t =mapElement.getValue();
			System.out.println(t.toString());				
		} 
	}
	private static void all_bugreports() {
		// TODO Auto-generated method stub
		System.out.println("All Bug Reports");
		Map<Integer, ticket> tick_list = td.getAll();
		for (Iterator<Entry<Integer, ticket>> iterator = tick_list.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, ticket> mapElement = iterator.next();
			ticket t =mapElement.getValue();
			if(t instanceof bugs) {
				System.out.println(t.toString());				
			}
		}
		
	}
	private static void all_helpdesk() {
		System.out.println("All Helpdesk Tickets");
		// TODO Auto-generated method stub
		Map<Integer, ticket> tick_list = td.getAll();
		for (Iterator<Entry<Integer, ticket>> iterator = tick_list.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, ticket> mapElement = iterator.next();
			ticket t =mapElement.getValue();
			if(t instanceof helpdesk) {
				System.out.println(t.toString());
			}
		}
		
	}
	private static void bug_delete() {
		System.out.println("Please Enter id for the bug to delete : ");
		int id=sc.nextInt();
		sc.nextLine();
		if(td.exists(id)) {
			if(td.isbug(id)) {
				td.delete(id);
				System.out.println("Bug Deleted");
			}else {
				System.out.println("This is not a Bug Ticket ID!!!!!");
			}
		}else {
			System.out.println("This key does not exist");
		}	
	}
	private static void helpdesk_delete() {
		System.out.println("Please Enter id for the Helpdesk Ticket to delete : ");
		int id=sc.nextInt();
		sc.nextLine();
		if(td.exists(id)) {
			if(td.ishelpdesk(id)) {
				td.delete(id);
				System.out.println("HelpDesk ticket Deleted");
			}else {
				System.out.println("This is not a HelpDesk Ticket ID!!!!!");
			}
		}else {
			System.out.println("This key does not exist");
		}	
		
	}
	private static void bug_view() {
		System.out.println("Please Enter id for the bug : ");
		int id=sc.nextInt();
		sc.nextLine();
		if(td.exists(id)) {
			if(td.isbug(id)) {
				System.out.println(td.get_ticket(id).toString());
			}else {
				System.out.println("This is not a Bug Ticket ID!!!!!");
			}
		}else {
			System.out.println("This key does not exist");
		}
		
	}
	private static void helpdesk_view() {
		System.out.println("Please Enter id for the Helpdesk Ticket: ");
		int id=sc.nextInt();
		sc.nextLine();
		if(td.exists(id)) {
			if(td.ishelpdesk(id)) {
				System.out.println(td.get_ticket(id).toString());
			}else {
				System.out.println("This is not a HelpDesk Ticket ID!!!!!");
			}
		}else {
			System.out.println("This key does not exist");
		}
		
	}
	private static void bug_create() {
		// TODO Auto-generated method stub
		int id = ticket.get_count();
		id++;
		System.out.println("Please enter Description: ");
		String desc = sc.nextLine();
		
		while(desc == null || desc.isEmpty()) {
			System.out.println("Description cannot be blank/null/empty, Enter again");
			desc = sc.nextLine();
		}
		System.out.println("Please enter Application: ");
		String appl = sc.nextLine();
		while(appl== null || appl.isEmpty()) {
			System.out.println("Application cannot be blank/null/empty, Enter again");
			appl = sc.nextLine();
		}
		System.out.println("Please enter Priority value (High = 1, medium = 2, low = 3): ");
		int prior = sc.nextInt();
		sc.nextLine();
		while(prior > 3 || prior < 1) {
			System.out.println("Priority must be 1, 2 or 3, Enter again");
			prior = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("Please enter the Steps to reproduce the bug: ");
		String steps = sc.nextLine();
		while(steps== null || steps.isEmpty()) {
			System.out.println("Steps cannot be blank/null/empty, Enter again");
			steps = sc.nextLine();
		}
		ticket t1=new bugs(id,desc,appl,prior,steps);
		td.save(t1);
		System.out.println("BUG ADDED!");
		
	}
	private static void helpdest_create() {
		// TODO Auto-generated method stub
		int id = ticket.get_count();
		id++;
		System.out.println("Please enter Description: ");
		String desc = sc.nextLine();
		
		while(desc == null || desc.isEmpty()) {
			System.out.println("Description cannot be blank/null/empty, Enter again");
			desc = sc.nextLine();
		}
		System.out.println("Please enter Application: ");
		String appl = sc.nextLine();
		while(appl== null || appl.isEmpty()) {
			System.out.println("Application cannot be blank/null/empty, Enter again");
			appl = sc.nextLine();
		}
		System.out.println("Please enter Priority value (High = 1, medium = 2, low = 3): ");
		int prior = sc.nextInt();
		sc.nextLine();
		ticket t1=new helpdesk(id,desc,appl,prior);
		td.save(t1);
		System.out.println("HELPDESK Ticket ADDED!");
	}
}
