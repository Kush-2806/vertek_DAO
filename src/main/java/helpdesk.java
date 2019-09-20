
public final class helpdesk extends ticket{
    private static int count=0;;
	public helpdesk(int id, String desc, String appl, int prio) {
		super(id, desc,appl,prio);
		count++;
	}
	public static int helpdesk_count() {return count;}
    public static void decr_count() {count--;}
	@Override
    public String toString() { 
        return String.format("Helpdesk Ticket : \n "+super.toString()); 
    }
}
