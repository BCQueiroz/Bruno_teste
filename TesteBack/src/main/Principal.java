package main;
import classes.Cliente;
import model.ClienteDAO;

public class Principal {

	public static void main(String[] args) {
	
		ClienteDAO z = new ClienteDAO();
		//z.createNewDatabase();
		
		/*
		Cliente a = new Cliente(3045, "12345678950", "Alberto", true, 877.00);
		z.save(a);
		Cliente b = new Cliente(2000, "12345683464", "Bruno", true, 1250.00);
		z.save(b);
		Cliente c = new Cliente(250, "17898678950", "Fernando", false, 2237.00);
		z.save(c);
		Cliente d = new Cliente(304, "12345678950", "Amanda", false, 1877.00);
		z.save(d);
		Cliente e = new Cliente(395, "25945623950", "Anderson", true, 1677.00);
		z.save(e);
		Cliente f = new Cliente(2245, "12394038950", "Andressa", true, 2007.00);
		z.save(f);
		Cliente g = new Cliente(1754, "12345987564", "Guilherme", false, 2577.00);
		z.save(g);
		Cliente h = new Cliente(2698, "01987654321", "Rebeca", true, 3005.00);
		z.save(h);
		*/
		
		System.out.println(z.verificarMedia()); 
		
	}

}
