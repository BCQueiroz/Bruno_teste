package classes;
import model.ClienteDAO;

public class Cliente {
	private int idCliente;
	private String cpfCliente;
	private String nomeCliente;
	private boolean isActive;
	private double valorTotal;
	
	
	public Cliente(int idCliente,String cpfCliente, String nomeCliente, boolean isActive, double valorTotal) {
		this.idCliente = idCliente;
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		this.isActive = isActive;
		this.valorTotal = valorTotal;
	}


	
	public int getIdCliente() {
		return idCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public boolean isActive() {
		return isActive;
	}


	public double getValorTotal() {
		return valorTotal;
	}
	
	
}
