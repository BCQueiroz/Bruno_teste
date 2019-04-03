package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Cliente;

public class ClienteDAO {
	
	//ArrayList<Cliente> result = new ArrayList<Cliente>();
	protected static Connection con = null;
	
	public static void createNewDatabase() {
		 
        String url = "jdbc:sqlite:sample.db" ;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    
	protected void getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:sample.db");
			DatabaseMetaData meta = con.getMetaData();
			ResultSet res = meta.getTables(null, null, "customer", 
			         new String[] {"TABLE"});
			//if(!res.next()) initialize();
		} 
		catch (ClassNotFoundException | SQLException err) {
			System.out.println(err);
		}
	}

	public void verifyConnection(){
		if(con == null) getConnection();
	}
	
	/*protected void initialize() {
		try {
			Statement state = con.createStatement();
			state.execute("create table tb_customer_account (id_customer integer primary key, cpf_cnpj char(15), "
					+ "nm_customer varchar(80), is_active boolean, vl_total decimal(10,2));");
			System.out.println(con);
		} 
		catch (SQLException err) {
			System.out.println(err);
		}
	}*/
	
	public void save(Cliente cliente) {
		String sql = "insert into tb_customer_account (id_customer, cpf_cnpj, nm_customer, is_active, vl_total) "
					+"values (?,?,?,?,?);";
		verifyConnection();
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, cliente.getIdCliente());
			prep.setString(2, cliente.getCpfCliente());
			prep.setString(3, cliente.getNomeCliente());
			prep.setBoolean(4, cliente.isActive());
			prep.setDouble(5, cliente.getValorTotal());
			prep.execute();
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	
	public double verificarMedia() {
		String sql = "select * from tb_customer_account where id_customer>1500 and id_customer<2700";
		
		double v = 0;
		verifyConnection();
		try{
			PreparedStatement prep = con.prepareStatement(sql);
			ResultSet listaClientes= prep.executeQuery();
			//result = (ArrayList<Cliente>) listaClientes;
			while(listaClientes.next()) {
				v += listaClientes.getDouble("vl_total");
			}
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
		return v;
	}
	
	/*public ArrayList<Cliente> usuariosAfetados(){
		return result;
	}*/
}
