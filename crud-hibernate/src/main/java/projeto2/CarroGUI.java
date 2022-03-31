package projeto2;

import java.util.List;

import javax.swing.JOptionPane;

public class CarroGUI {
	
	public static void main(String[] args) {
		try {
		CarroGUI carroGUI = new CarroGUI();
		carroGUI.exibirMenu();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}  
	
	
	public void exibirMenu() {
		int op = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE A OPÇÃO DESEJADA\n\n"+
				"01 - INSERIR \n"+
				"02 - CONSULTAR \n"+
				"03 - ATUALIZAR \n"+
				"04 - EXCLUIR \n"+
				"05 - LISTAR TODOS"));
		
		switch (op) {
			case 1: inserir();
				break;
			case 2: consultar();
				break;
			case 3: atualizar();
				break;
			case 4: excluir();
				break;
			case 5: listarTodos();
				break;
		}
	}
	
	public void inserir() {
		Carro c = new Carro();
		CarroCRUD carroCRUD = new CarroCRUD();
		carroCRUD.setup();
		c.setNome(JOptionPane.showInputDialog(null, "Insira o nome do carro: "));
    	c.setMarca(JOptionPane.showInputDialog(null, "Insira a marca do carro: "));
    	c.setCor(JOptionPane.showInputDialog(null, "Insira a cor do carro: "));
    	c.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do carro: ")));
    	carroCRUD.create(c);
	}
	
	public void consultar() {
		Carro c = new Carro();
		CarroCRUD carroCRUD = new CarroCRUD();
		carroCRUD.setup();
		int idCarro = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do carro que deseja consultar: "));
		c = carroCRUD.read(idCarro);
		System.out.println("Nome: " + c.getNome());
        System.out.println("Marca: " + c.getMarca());
        System.out.println("Cor: " + c.getCor());
        System.out.println("Ano: " + c.getAno());
	}
	
	public void atualizar() {
		Carro c = new Carro();
		CarroCRUD carroCRUD = new CarroCRUD();
		carroCRUD.setup();
		c.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do carro que deseja atualizar: ")));
		c.setNome(JOptionPane.showInputDialog(null, "Insira o novo nome do carro: "));
	    c.setMarca(JOptionPane.showInputDialog(null, "Insira a nova marca do carro: "));
	    c.setCor(JOptionPane.showInputDialog(null, "Insira a nova cor do carro: "));
	   	c.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o novo ano do carro: ")));
	    carroCRUD.update(c);
	}
	
	public void excluir() {
		CarroCRUD carroCRUD = new CarroCRUD();
		carroCRUD.setup();
		int idCarro = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ID do carro que deseja deletar: "));
        carroCRUD.delete(idCarro);
	}
	
	public void listarTodos() {
		CarroCRUD carroCRUD = new CarroCRUD();
		carroCRUD.setup();
		List<Carro> carros = carroCRUD.listAll();
		for (Carro carro : carros) {
			System.out.println("ID: " + carro.getId());
			System.out.println("Nome: " + carro.getNome());
			System.out.println("Marca: " + carro.getMarca());
			System.out.println("Cor: " + carro.getCor());
			System.out.println("Ano: " + carro.getAno());
			System.out.println("======================================");
		}
	}
}
