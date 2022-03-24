public class ConditionalStatement { 

  public static void main(String[] args) {	  
	  int     age     = 0;
    boolean sex_man = false;
    float   growth  = 0f;
    char    name    = 'N';
  
    if (age > 20) {
    	  System.out.println("age <= 20");
    } 
    if (sex_man) {
    	  System.out.println("sex_man");
    }
    if (!sex_man) {
    	  System.out.println("!sex_man");
    }

    if (growth < 1.80) {
    	  System.out.println("growth < 1.80");
    }
    else {
    	  System.out.println("else");
    }

    if (name == 'M') {
    	  System.out.println("M");
    } else if (name == 'I') {
    	  System.out.println("I");
    } else {
    	  System.out.println("N");
    }
    
  }
}