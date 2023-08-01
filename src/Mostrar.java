import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mostrar {
    private JPanel sql;
    private JTextArea estudiantes_info;
    private JButton registros;
    static final String DB_URL ="jdbc:mysql://localhost/Principal";
    static final String USER="root";
    static final String PASS="poo123";
    static final String QUERY ="SELECT * FROM Estudiantes1";
public Mostrar() {
    registros.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try(
                    Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    Statement stmt= conn.createStatement();
                    ResultSet rs= stmt.executeQuery(QUERY);
            ){
                while (rs.next()){
                    System.out.println("id: "+rs.getString("id"));
                    System.out.println("Nombre:"+rs.getString("nombre"));
                    System.out.println("Edad: "+rs.getString("edad"));
                    System.out.println("Ciudad: "+rs.getString("ciudad"));
                    System.out.println("Cedula: "+rs.getString("cedula"));
                    System.out.println("Telefono: "+rs.getString("telefono"));
                    System.out.println("Contraseña: "+rs.getString("contra"));
                    System.out.println("--------------------------------------------------");

                    estudiantes_info.append("ID: "+rs.getString("id")+"\n"+" Nombre: "+rs.getString("nombre")+"\n"
                            +"Edad: "+rs.getString("edad")+"\n"+" Ciudad: "+rs.getString("ciudad")+"\n"+
                            " Cédula: "+rs.getString("cedula")+"\n"+" Telefono: "+rs.getString("telefono")+"\n"+" Contraseña: "+rs.getString("contra")+"\n"+"---------------------------------\n");


                }
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }


        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mostrar");
        frame.setContentPane(new Mostrar().sql);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
