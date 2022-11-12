package clases;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;


public class Lanzadora extends JFrame {
	private JTextField txtJamon;
	private JTextField txtPollo;
	private JTextField txtQueso;
	private JTextField txtBacalao;
	Component jFrame = null;
	public static int cantidadJamon=0;
	public static int cantidadPollo=0;
	public static int cantidadQueso=0;
	public static int cantidadBacalao=0;
	public static int Total=0;
	public static int prioridadJamon=1;
	public static int prioridadPollo=1;
	public static int prioridadQueso=1;
	public static int prioridadBacalao=1;

/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * 
	 */
	public Lanzadora() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 267);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);																			//Centrar la ventana
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de croqueta y introduzca cantidad deseada.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(15, 10, 406, 33);
		getContentPane().add(lblNewLabel);
		
		txtJamon = new JTextField();
		txtJamon.setBounds(128, 72, 72, 21);
		getContentPane().add(txtJamon);
		txtJamon.setColumns(10);
		
		txtPollo = new JTextField();
		txtPollo.setColumns(10);
		txtPollo.setBounds(128, 107, 72, 21);
		getContentPane().add(txtPollo);
		
		txtQueso = new JTextField();
		txtQueso.setColumns(10);
		txtQueso.setBounds(128, 142, 72, 21);
		getContentPane().add(txtQueso);
		
		txtBacalao = new JTextField();
		txtBacalao.setColumns(10);
		txtBacalao.setBounds(128, 177, 72, 21);
		getContentPane().add(txtBacalao);
		
		JCheckBox chboxJamon = new JCheckBox("Jamón");
		chboxJamon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chboxJamon.setBounds(27, 63, 72, 41);
		getContentPane().add(chboxJamon);
		
		JCheckBox chboxPollo = new JCheckBox("Pollo");
		chboxPollo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chboxPollo.setBounds(27, 98, 72, 41);
		getContentPane().add(chboxPollo);
		
		JCheckBox chboxQueso = new JCheckBox("Queso");
		chboxQueso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chboxQueso.setBounds(27, 133, 72, 41);
		getContentPane().add(chboxQueso);
		
		JCheckBox chboxBacalao = new JCheckBox("Bacalao");
		chboxBacalao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chboxBacalao.setBounds(27, 168, 82, 41);
		getContentPane().add(chboxBacalao);
		
		JLabel lblNewLabel_1 = new JLabel("Prioridad");
		lblNewLabel_1.setBounds(220, 54, 61, 14);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chboxPJ = new JCheckBox("");
		chboxPJ.setBounds(230, 71, 21, 23);
		getContentPane().add(chboxPJ);
		
		JCheckBox chboxPP = new JCheckBox("");
		chboxPP.setBounds(230, 105, 21, 23);
		getContentPane().add(chboxPP);
		
		JCheckBox chboxPQ = new JCheckBox("");
		chboxPQ.setBounds(230, 140, 21, 23);
		getContentPane().add(chboxPQ);
		
		JCheckBox chboxPB = new JCheckBox("");
		chboxPB.setBounds(230, 175, 21, 23);
		getContentPane().add(chboxPB);
		
		JButton btnNewButton = new JButton("Producir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Procesadora p = new Procesadora();

				if (chboxJamon.isSelected()) {								//doy valor a las variables requeridas

					cantidadJamon=Integer.parseInt(txtJamon.getText());		//obtengo el valor del textarea si si checkbox esta seleccionado
					
					if (chboxPJ.isSelected()) {								//si el checkbox de prioridad esta seleccionado, dar prioridad 10 a la croqueta
						prioridadJamon=10;
					}else {
						prioridadJamon=1;
					}
				}
				if (chboxPollo.isSelected()) {
					cantidadPollo=Integer.parseInt(txtPollo.getText());
					if (chboxPP.isSelected()) {
						prioridadPollo=10;
					}else {
						prioridadPollo=1;
					}
				}
				if (chboxQueso.isSelected()) {
					cantidadQueso=Integer.parseInt(txtQueso.getText());
					if (chboxPQ.isSelected()) {
						prioridadQueso=10;
					}else {
						prioridadQueso=1;
					}
				}
				if (chboxBacalao.isSelected()) {
					cantidadBacalao=Integer.parseInt(txtBacalao.getText());
					if (chboxPB.isSelected()) {
						prioridadBacalao=10;
					}else {
						prioridadBacalao=1;
					}
				}
				
				Total = cantidadJamon+cantidadPollo+cantidadQueso+cantidadBacalao;												//suma total de croquetas insertadas en el texfield
				
				if (cantidadJamon % 6 == 0 && cantidadPollo % 6 == 0 && cantidadQueso % 6 == 0 && cantidadBacalao % 6 == 0) {  //ver si se pueden agrupar en 6
					long inicio = System.currentTimeMillis();																	//inicio el tiempo
					
					lanzarProcesadora();																						//inicio la procesadora
					
					long fin = System.currentTimeMillis();																		//cuando se termina de ejecutar la procesadora, paro el tiempo
					
					double tiempo = (double) ((fin - inicio)/1000); 
					System.out.println("Tiempo total "+ tiempo +" segundos");
					System.out.println("TERMINADO!");
					JOptionPane.showMessageDialog(jFrame,"Tiempo total: "+ tiempo +" segundos");
			        
				}else {
					
					JOptionPane.showMessageDialog(jFrame, "La cantidad tiene que ser multiplo de 6.");
				}

				
			}	
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(298, 106, 96, 56);
		getContentPane().add(btnNewButton);
		
		
	}
	
	/**
	 * 
	 */
	public void lanzarProcesadora() {

		String clase = "C:\\Users\\alvar\\eclipse-workspace\\Ejercicios T1 Acceso Datos\\AEV1-Multihilo\\src\\clases\\Procesadora.java";  //lanzar Procesadora.java por consola con los valores preferidos
		
			try {	
				String javaHome = System.getProperty("java.home");
				String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
				String classpath = System.getProperty("java.class.path");
				String className = clase;
				
				List<String> command = new ArrayList<>();
				command.add(javaBin);
				command.add("-cp");
				command.add(classpath);
				command.add(className);
				command.add(String.valueOf(cantidadJamon));
				command.add(String.valueOf(cantidadPollo));
				command.add(String.valueOf(cantidadQueso));
				command.add(String.valueOf(cantidadBacalao));
				command.add(String.valueOf(Total));
				command.add(String.valueOf(prioridadJamon));
				command.add(String.valueOf(prioridadPollo));
				command.add(String.valueOf(prioridadQueso));
				command.add(String.valueOf(prioridadBacalao));
				
				System.out.println(command);
				
				ProcessBuilder builder = new ProcessBuilder(command);
				Process process = builder.inheritIO().start();
				process.waitFor();
				//System.out.println(process.exitValue());
				cantidadJamon=0;
				cantidadPollo=0;												//inicializar los valores a 0
				cantidadQueso=0;
				cantidadBacalao=0;
				Total=0;
				prioridadJamon=0;
				prioridadPollo=0;
				prioridadQueso=0;
				prioridadBacalao=0;
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

