
package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// muchos imports

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.curso; 
import modelo.TareaAcademica;

/**
 *
 * @author Joponcios
 */
public class VentanaPrincipal extends JFrame {
    
    // cursos modulo
    private JLabel  TituloCurso_jl  , Codigo_jl , NombreCurso_jl , Tutor_jl;
    private JTextField Codigo_txt ,  NombreCurso_txt , Tutor_txt;
    private JButton GuardarCurso_bt;
    
    // modulos tareas
    
    private JLabel TituloTareaSeccion_jl ,  TituloTarea_jl ,  Descripcion_jl , Fecha_jl;
    private JTextField TituloTarea_txt , Descripcion_txt , Fecha_txt;
    private JButton GuardarTarea_bt;
    
    // visual modulo

    private JTextArea Visual_area;
    private JScrollPane Scroll_pn;
    private JButton MostrarInfo_bt;
    
    // conversion temp
    private JLabel TituloTemp_jl , Celcius_jl;
    private JTextField Celcius_txt;
    private JButton ConvertirF_bt , ConvertirK_bt;
    
    
    // muchos cosos
    
    private ArrayList<curso> Curso_lista = new ArrayList<>();
    private ArrayList<TareaAcademica> Tarea_lista = new ArrayList<>();
    
  public VentanaPrincipal() {
    setTitle("Gestor Académico y Conversor de Temperatura");
    setSize(700, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null); 
    
    Ventana();
    Botones();
    
}  
  private void Ventana(){
      
     // cursos modulo
     TituloCurso_jl = new JLabel("Registro del curso");
     TituloCurso_jl.setBounds(20, 10, 200, 20);
     add(TituloCurso_jl);

     Codigo_jl = new JLabel("Codigo :");
     Codigo_jl.setBounds(20, 40, 60, 20);
     add(Codigo_jl);
        
     Codigo_txt = new JTextField();
     Codigo_txt.setBounds(80, 40, 80, 20);
     add(Codigo_txt);

     NombreCurso_jl = new JLabel("Nombre: ");
     NombreCurso_jl.setBounds(180, 40, 60, 20);
     add(NombreCurso_jl);
        
     NombreCurso_txt = new JTextField();
     NombreCurso_txt.setBounds(240, 40, 150, 20);
     add(NombreCurso_txt);

     Tutor_jl = new JLabel("Tutor: ");
     Tutor_jl.setBounds(410, 40, 50, 20);
     add(Tutor_jl);
        
     Tutor_txt = new JTextField();
     Tutor_txt.setBounds(460, 40, 150, 20);
     add(Tutor_txt);

     GuardarCurso_bt = new JButton("Guardar curso ");
     GuardarCurso_bt.setBounds(240, 70, 150, 30);
     add(GuardarCurso_bt);
     
     
    
     
      // componente modulo de tareas
      
     TituloTareaSeccion_jl = new JLabel("Registro de tareas");
     TituloTareaSeccion_jl.setBounds(20, 110, 200, 20);
     add(TituloTareaSeccion_jl);

     TituloTarea_jl = new JLabel("Título: ");
     TituloTarea_jl.setBounds(20, 140, 60, 20);
     add(TituloTarea_jl);
        
     TituloTarea_txt = new JTextField();
     TituloTarea_txt.setBounds(80, 140, 120, 20);
     add(TituloTarea_txt);

     Descripcion_jl = new JLabel("Descrip: ");
     Descripcion_jl.setBounds(210, 140, 60, 20);
     add(Descripcion_jl);
        
     Descripcion_txt = new JTextField();
     Descripcion_txt.setBounds(270, 140, 150, 20);
     add(Descripcion_txt);

     Fecha_jl = new JLabel("Fecha: ");
     Fecha_jl.setBounds(440, 140, 50, 20);
     add(Fecha_jl);
        
     Fecha_txt = new JTextField();
     Fecha_txt.setBounds(490, 140, 120, 20);
     add(Fecha_txt);

     GuardarTarea_bt = new JButton("Guardar tarea");
     GuardarTarea_bt.setBounds(240, 170, 150, 30);
     add(GuardarTarea_bt);
     
     
     
     
     // visual modulo
     
     Visual_area = new JTextArea();
     Visual_area.setEditable(false); // evita escribir
        
        // agrega barras si el texto es largo
     Scroll_pn = new JScrollPane(Visual_area);
     Scroll_pn.setBounds(20, 220, 640, 180);
     add(Scroll_pn);

     MostrarInfo_bt = new JButton("Mostrar info");
     MostrarInfo_bt.setBounds(240, 410, 150, 30);
     add(MostrarInfo_bt);
     
     
     
     // modulo conversion
     
     TituloTemp_jl = new JLabel(" convertidor de temperatura");
     TituloTemp_jl.setBounds(20, 460, 250, 20);
     add(TituloTemp_jl);

     Celcius_jl = new JLabel("Grados Celsius:");
     Celcius_jl.setBounds(20, 490, 100, 20);
     add(Celcius_jl);
        
     Celcius_txt = new JTextField();
     Celcius_txt.setBounds(130, 490, 80, 20);
     add(Celcius_txt);

     ConvertirF_bt = new JButton("Convertir a fahreheit");
     ConvertirF_bt.setBounds(230, 485, 180, 30);
     add(ConvertirF_bt);

     ConvertirK_bt = new JButton("Convertir a kelvin");
     ConvertirK_bt.setBounds(430, 485, 160, 30);
     add(ConvertirK_bt);
     
     
     
     
  }
  
    
  
  // poquitas tus lineas de codigo
  
  private void Botones(){
  // boton guardar curso
        GuardarCurso_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // compruba si estan vacio los campos
                if (Codigo_txt.getText().isEmpty() || NombreCurso_txt.getText().isEmpty() || Tutor_txt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "LLene los campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    // verifica si es un numero
                    int codigo = Integer.parseInt(Codigo_txt.getText());
                    String nombre = NombreCurso_txt.getText();
                    String tutor = Tutor_txt.getText();
                    
                    // crea objeto y lo guarda
                    curso Curso_nuevo = new curso(codigo, nombre, tutor);
                    Curso_lista.add(Curso_nuevo);
                    JOptionPane.showMessageDialog(null, "Curso guardado ");
                    
                    // limpia las cajas de texto
                    Codigo_txt.setText("");
                    NombreCurso_txt.setText("");
                    Tutor_txt.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "el codigo debe ser numerico", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // boton guardar tarera
        GuardarTarea_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TituloTarea_txt.getText().isEmpty() || Descripcion_txt.getText().isEmpty() || Fecha_txt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                String titulo = TituloTarea_txt.getText();
                String descripcion = Descripcion_txt.getText();
                String fecha = Fecha_txt.getText();
                
                TareaAcademica Tarea_nueva = new TareaAcademica(titulo, descripcion, fecha);
                Tarea_lista.add(Tarea_nueva);
                JOptionPane.showMessageDialog(null, "tarea guardada");
                
                TituloTarea_txt.setText("");
                Descripcion_txt.setText("");
                Fecha_txt.setText("");
            }
        });

        //boton mostrar info
        MostrarInfo_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visual_area.setText(""); //limpiar antes de empezar
                
                Visual_area.append("cursos registrados \n");
                for (curso c : Curso_lista) {
                    Visual_area.append("codigo: " + c.getCodigo() + " | nombre: " + c.getNombre() + " | tutor: " + c.getTutor()+ "\n");
                    
                }
                
                Visual_area.append("tareas registradas \n");
                for (TareaAcademica t : Tarea_lista) {
                    Visual_area.append("titulo: " + t.getTitulo() + " | fecha: " + t.getFecha_entrega()+ "\n");
                    Visual_area.append("   detalle: " + t.getDescripcion()+ "\n" );
                }
            }
        });

        //boton conversion a f
        ConvertirF_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(Celcius_txt.getText());
                    double fahrenheit = (celsius * 9/5) + 32;
                    JOptionPane.showMessageDialog(null, celsius + " °C  a = " + fahrenheit + " °F");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ingrese un numero", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // boton conversion a k 
        ConvertirK_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(Celcius_txt.getText());
                    double kelvin = celsius + 273.15;
                    JOptionPane.showMessageDialog(null, celsius + " °C  a = " + kelvin + " K");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ingrese un numero", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
}
