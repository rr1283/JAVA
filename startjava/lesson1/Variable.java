public class Variable { 

  public static void main(String[] args) {	  
	  int    frequency_ghz = 5000;
	  byte   cpu_cores = 10;
	  short  video_card_memory_size_gb = 3; 
	  long   memory_ram_gb = 32;
	  float  free_space_hard_drive_gb = 100.35f;
    double cpu_cores_num = 20;
    char   windows_version = '1';
    boolean i_like = true;
    //string  windows_version_full = "10.222";

/*
	  System.out.println(
	    "frequency_ghz "+frequency_ghz+
	    "cpu_cores "+cpu_cores+
	    "video_card_memory_size_gb "+video_card_memory_size_gb+
	    "memory_ram_gb "+memory_ram_gb+
	    "cpu_cores_num "+cpu_cores_num+
	    "windows_version "+windows_version+
	    "i_like "+i_like+
	    "free_space_hard_drive_gb "+free_space_hard_drive_gb);

    //System.out.println(System.lineSeparator());
    System.out.println();
*/

	  System.out.println(
	    "Frequency_ghz = "            +frequency_ghz            +System.lineSeparator()+
	    "Cpu_cores = "                +cpu_cores                +System.lineSeparator()+
	    "Video_card_memory_size_gb = "+video_card_memory_size_gb+System.lineSeparator()+
	    "Memory_ram_gb = "            +memory_ram_gb            +System.lineSeparator()+
	    "Cpu_cores_num = "            +cpu_cores_num            +System.lineSeparator()+
	    "Windows_version = "          +windows_version          +System.lineSeparator()+
	    "I_like = "                   +i_like                   +System.lineSeparator()+
	    "Free_space_hard_drive_gb = " +free_space_hard_drive_gb);

  }
}