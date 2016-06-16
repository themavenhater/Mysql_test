import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args) {
        int[] Tiles = new int[1000];
        int i=0 ,x=0;

        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesql", "root", "");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from maplvlone");
            while (myRs.next()) {
                //System.out.println(myRs.getString("id_row")+","+ myRs.getString("Rowcomp"));
                String row = myRs.getString("Rowcomp");
                System.out.println(row);
                System.out.println(row.length());

                for(i = 0; i < row.length(); i++) {
                    if (row.charAt(i) == 'n') {Tiles[x]=-16777216;x++;}
                    if (row.charAt(i) == 'b') {Tiles[x]=-15990529;x++;}

                }



            }for (int d = 0; d < Tiles.length; d++) {
                if (d > 0) {
                    System.out.print(", ");
                }
                System.out.print(Tiles[d]);
            }
            myConn.close();



        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("erreur");
        }
    }
}