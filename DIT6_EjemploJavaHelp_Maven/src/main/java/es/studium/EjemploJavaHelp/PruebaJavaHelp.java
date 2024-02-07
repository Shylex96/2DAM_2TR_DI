package es.studium.EjemploJavaHelp;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PruebaJavaHelp {
	/** Ventana secundaria */
	private JDialog secundaria;
	/** Ventana principal */
	private JFrame principal;
	/** Item de menú para la ayuda */
	private JMenuItem itemAyuda;
	/** Boton que despliega la ventana secundaria */
	private JButton botonMuestraSecundaria;

	public static void main(String[] args) {
		new PruebaJavaHelp();
	}

	public PruebaJavaHelp() {
		creaVentanaPrincipal();
		creaVentanaSecundaria();
		botonMuestraSecundaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secundaria.setVisible(true);
			}
		});
		ponLaAyuda();
		visualizaVentanaPrincipal();
	}

	private void visualizaVentanaPrincipal()
	{
		principal.pack();
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void ponLaAyuda() {
		try {
			// Carga el fichero de ayuda
			File fichero = new File("help/help_set.hs");
			/*
			 * Construimos en formato URL el path del fichero.
			 */
			URL hsURL = fichero.toURI().toURL();
			// Crea el HelpSet y el HelpBroker
			/*
			 * Instanciamos la clase HelpSet pasándole un ClassLoader y la URL del fichero.
			 */
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			// Pone ayuda a item de menu al pulsarlo y a F1 en ventana
			// principal y secundaria.
			/* Ayuda al hacer click en el JMenuItem itemAyuda */
			/* El itemAyuda es el JMenuItem */
			hb.enableHelpOnButton(itemAyuda, "aplicacion", helpset);
			/* Ayuda al pulsar F1 sobre la ventana principal */
			hb.enableHelpKey(principal.getContentPane(), "ventana_principal", helpset);
			/* Ayuda al pulsar F1 sobre la ventana secundaria */
			hb.enableHelpKey(secundaria.getContentPane(), "ventana_secundaria", helpset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void creaVentanaPrincipal() {
		principal = new JFrame("Ventana principal");
		JMenuBar menuBar = new JMenuBar();
		itemAyuda = new JMenuItem("Ayuda");
		menuBar.add(itemAyuda);
		botonMuestraSecundaria = new JButton("Pulsame");
		principal.setJMenuBar(menuBar);
		principal.getContentPane().setLayout(new FlowLayout());
		principal.getContentPane().add(botonMuestraSecundaria);
		principal.getContentPane().add(new JTextField(20));
	}

	private void creaVentanaSecundaria() {
		secundaria = new JDialog(principal, "Ventana secundaria");
		secundaria.getContentPane().setLayout(new FlowLayout());
		secundaria.getContentPane().add(new JLabel("Yo no hago nada"));
		secundaria.getContentPane().add(new JTextField(20));
		secundaria.pack();
	}
}