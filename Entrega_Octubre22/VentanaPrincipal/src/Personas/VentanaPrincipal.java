package Personas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Stefany
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private ListaPersonas lista; // El objeto ListaPersonas de la aplicación
    private Container contenedor; // Un contenedor de elementos gráficos
    private JLabel nombre, apellidos, telefono, direccion;
    private JTextField campoNombre, campoApellidos, campoTelefono, campoDireccion;
    private JButton anadir, eliminar, borrarLista;
    private JList listaNombres;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;

    // Constructor de la clase VentanaPrincipal
    public VentanaPrincipal() {
        lista = new ListaPersonas();
        inicio();
        setTitle("Personas");
        setSize(270, 350);
        setLocationRelativeTo(null); // La ventana está en el centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Boton para salir
        setResizable(false); // El tamaño de la ventana se puede cambiar
    }

    // Método que crea la ventana con sus componentes gráficos
    private void inicio() {
        contenedor = getContentPane(); // Obtiene el panel de contenidos de la ventana
        contenedor.setLayout(null); // El panel no tiene asociado ningún Layout

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(105, 20, 135, 23);

        apellidos = new JLabel();
        apellidos.setText("Apellidos");
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(105, 50, 135, 23);

        telefono = new JLabel();
        telefono.setText("Teléfono");
        telefono.setBounds(20, 80, 135, 23);
        campoTelefono = new JTextField();
        campoTelefono.setBounds(105, 80, 135, 23);

        direccion = new JLabel();
        direccion.setText("Dirección");
        direccion.setBounds(20, 110, 135, 23);
        campoDireccion = new JTextField();
        campoDireccion.setBounds(105, 110, 135, 23);

        anadir = new JButton();
        anadir.setText("Añadir");
        anadir.setBounds(105, 150, 80, 23);
        anadir.addActionListener(this);

        eliminar = new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20, 280, 80, 23);
        eliminar.addActionListener(this);

        borrarLista = new JButton();
        borrarLista.setText("Borrar Lista");
        borrarLista.setBounds(120, 280, 120, 23);
        borrarLista.addActionListener(this);

        listaNombres = new JList();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modelo = new DefaultListModel();

        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 190, 220, 80);
        scrollLista.setViewportView(listaNombres);

        // Añadir los elementos al contenedor
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(telefono);
        contenedor.add(campoTelefono);
        contenedor.add(direccion);
        contenedor.add(campoDireccion);
        contenedor.add(anadir);
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == anadir) {
            anadirPersona();
        }
        if (evento.getSource() == eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());
        }
        if (evento.getSource() == borrarLista) {
            borrarLista();
        }
    }

    // Método que agrega una persona al vector de personas y a la lista gráfica
    private void anadirPersona() {
        Persona p = new Persona(campoNombre.getText(), campoApellidos.getText(), campoTelefono.getText(), campoDireccion.getText());
        lista.anadirPersona(p);

        String elemento = campoNombre.getText() + "-" + campoApellidos.getText() + "-" + campoTelefono.getText() + "-" + campoDireccion.getText();
        modelo.addElement(elemento);
        listaNombres.setModel(modelo);

        campoNombre.setText("");
        campoApellidos.setText("");
        campoTelefono.setText("");
        campoDireccion.setText("");
    }

    // Método que elimina una persona de ambos
    private void eliminarNombre(int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            lista.eliminarPersona(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método que elimina todas las personas del vector personas
    private void borrarLista() {
        lista.borrarLista();
        modelo.clear();
    }
}
