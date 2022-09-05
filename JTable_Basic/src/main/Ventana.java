package main;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		// Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// Panel contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		// Tabla
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// Crear lista de personas a mostrar en la tabla
		LinkedList<Persona> lista = new LinkedList<Persona>();
		lista.add(new Persona(1, "Ana", "Bolena"));
		lista.add(new Persona(2, "Napoleón", "Bonaparte"));
		lista.add(new Persona(3, "Marie", "Curie"));
		lista.add(new Persona(4, "Albert", "Einstein"));
		lista.add(new Persona(5, "Ada", "Lovelace"));
		lista.add(new Persona(6, "Alan", "Turing"));
		lista.add(new Persona(7, "Mark", "Twain"));
		
		// Crear un modelo para la tabla
		DefaultTableModel modelo = new DefaultTableModel();
		
		// Crear un array con los nombres de los encabezados de la tabla
		// (todos o algunos de los atributos de la clase Persona)
		String[] encabezados = {"Id", "Nombre", "Apellido"};
		
		// Setear los encabezados de las columnas con el array anterior
		modelo.setColumnIdentifiers(encabezados);

		// Crear un array de objetos para almacenar los datos de cada fila
		Object[] fila;

		// Con un bucle for each, por cada persona de la lista...
		for (Persona persona : lista) {

			// ... instanciar una fila (array de objetos)...
			fila = new Object[3]; // (Largo del array de objetos = cantidad de columnas)
			// ... guardar el valor de cada campo de la persona en un objeto del array
			fila[0] = persona.getId();
			fila[1] = persona.getNombre();
			fila[2] = persona.getApellido();

			// ... y agregar cada fila al modelo de la tabla.
			modelo.addRow(fila);
		}
		
		// Asignar a la tabla el modelo que creamos y configuramos
		table.setModel(modelo);

	}
}
