
public final class bugs extends ticket{
    private String steps;
    private static int count=0;
    public bugs(int id, String desc, String appl, int prio, String steps) {
    	super(id,desc,appl,prio);
    	this.setSteps(steps);
    	count++;
    }
    public static int bug_count() {return count;}
    public static void decr_count() {count--;}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	@Override
    public String toString() { 
		if (steps.length() > 15) {
			 return String.format("Bug Ticket : \n "+super.toString()+" \n Steps to Reproduce: "+steps.substring(0, 14)+"..."); 	
		}else {
			 return String.format("Bug Ticket : \n "+super.toString()+" \n Steps to Reproduce: "+steps); 
		}
       
    }
}