package cuadroDeMarcha;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;
import cuota.Cuota;

public class ToHTML extends Convert{
     
	 private FileWriter filewriter;
	 private PrintWriter printw;
	 private Prestamo p;
	 private List<Cuota> cs;
	 
	 public ToHTML(Prestamo p) {
		this.p = p;
		this.cs = new ArrayList<Cuota>();
		cs = p.getCuotas();
	 }
	 
	 public void loadFile() throws IOException {	  
		 filewriter = new FileWriter("ejemplo.html");
	     printw = new PrintWriter(filewriter);
		 try{    
		     printw.println("<html>");
		     printw.println("<head><title>Cuadro de Marcha</title></head>");

		     printw.println("<body bgcolor=\"#99CC99\">");

		     printw.println("<center><h1><font color=\"navy\">"+"</font></h1></center>");
		     printw.println("<center><h4><font color=\"purple\">prueba</font></h4></center>");
		     
		     printw.println("</body>");
		     printw.println("</html>");
		     printw.close();
		            
		     System.out.println("Se gener� el HTML del cuadro de marcha");
		 }finally{}
	}
		 
	 }
}