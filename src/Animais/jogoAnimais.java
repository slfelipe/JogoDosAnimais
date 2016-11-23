package Animais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;





public class jogoAnimais {

static public int contador=1;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animais");
		JLabel label = new JLabel("Pense em um animal");
		JButton btOkay = new JButton("OK");
		
		Animal animal = new Animal();
		animal.nome = "Vive na �gua";
		
		Animal tubarao = new Animal();
		tubarao.nome = " Tubar�o";
		Animal macaco = new Animal();
		macaco.nome = " Macaco";
		
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(230, 100);
		frame.setLocationRelativeTo(null);
		frame.add(label);
		frame.add(btOkay);
		
		label.setBounds(45, -10, 150, 50);
				
		btOkay.setBounds(65, 30, 80, 20);

	
		animal.sim = tubarao;
		animal.nao = macaco;
		
		btOkay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				encontrarAnimal(animal);

			}
		});
	}



	public static void encontrarAnimal(Animal animal) {

		int optionPane = JOptionPane.YES_NO_OPTION;
				int opcao = JOptionPane.showConfirmDialog(null, "O animal que voc� pensou " + animal.nome + "?", "Confirmar",
				optionPane);

		if (opcao == 0) {
			if (animal.sim == null) {
				if(contador==1){
					JOptionPane.showMessageDialog(null, "Acertei!");
				}else{
				JOptionPane.showMessageDialog(null, "Acertei de Novo!");
				}
				contador++;
			} else {
				encontrarAnimal(animal.sim);
			}

		} else {
			if (animal.nao == null) {

				String animalNovo = JOptionPane.showInputDialog("Qual o animal que voc� pensou?");
				String detalhesAnimal = JOptionPane
						.showInputDialog("Um(a) " + animalNovo + "  _______ mas um(a)" + animal.nome + " n�o.");
				
				Animal caracteristica = new Animal();
				Animal novo = new Animal();
				
				caracteristica.nome =  detalhesAnimal;
				novo.nome = " � um " + animalNovo;
				
				caracteristica.sim = novo;
				animal.nao= caracteristica;
				
				
				
			} else {
				encontrarAnimal(animal.nao);
			}
		}

	}

}