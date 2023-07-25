import java.sql.*;
public class Miprimerselect {
//cadenas de conexion, pueden estar en otra clase
                          //"UBICACION DE LA BASE/nombase"
    static final String DB_URL ="jdbc:mysql://localhost/Principal";
    static final String USER="root";
    static final String PASS="root_bas3";
    static final String QUERY ="SELECT * FROM Estudiantes1";//nombretabla


//genero main
    public static void main(String[] args) {
        try(Connection conn=DriverManager.getConnection(DB_URL,USER, PASS);
        Statement stmt= conn.createStatement();
        ResultSet rs=stmt.executeQuery(QUERY);){
            while(rs.next()){
                                                      //nombre columna
                System.out.println("id: "+rs.getString("id"));
                System.out.println("Nombre:"+rs.getString("nombre"));
                System.out.println("Edad: "+rs.getString("edad"));
                System.out.println("Ciudad: "+rs.getString("ciudad"));
                System.out.println("Cedula: "+rs.getString("cedula"));
                System.out.println("Telefono: "+rs.getString("telefono"));
                System.out.println("Contraseña: "+rs.getString("pasword"));
                System.out.println("--------------------------------------------------");
                //los numeric los pogo como string porque con float se pone decimal

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
