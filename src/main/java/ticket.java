
public abstract class ticket {
	private int id;
	private static int count=0;
    private String description;
    private String application;
    private Priority p1;
    
    public static int getcount() {return count;}
    public ticket(int id, String desc, String appl, int prio) {
    	this.setId(id);
    	this.description = desc;
    	this.application = appl;
    	if(prio ==1) {
    		this.p1 = Priority.high;
    	}else if(prio==2) {
    		this.p1= Priority.medium;
    	}else {
    		this.p1= Priority.low;
    	}
    	increment_count();
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void increment_count() {
		count++;
	}
	public static int get_count() {
		return count;
	}
	public String toString() {
		if (description.length() > 15) {
			return String.format("Id : "+id+"\n Description : "+description.substring(0, 14)+"... \n Application : "+application+"\n Priority : "+p1.toString());	
		}else {
			return String.format("Id : "+id+"\n Description : "+description+" \n Application : "+application+"\n Priority : "+p1.toString());
		}
	}
}
