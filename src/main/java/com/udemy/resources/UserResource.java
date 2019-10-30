package com.udemy.resources;

import com.udemy.api.Person;
import com.udemy.core.DbConnection;
import com.udemy.db.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/hellouser")
public class UserResource {

    UserDAO userDAO = new UserDAO();
    String Name = "no name";


    //de result hiervan moet dan bij de frontend komen zodat de gegevens van de user opgehaald worden hier en
    //vervolgens daar worden weergegeven
    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPersonById(@PathParam("id") int id) throws SQLException {
        Connection connect = null;
        System.out.println("ik ben in add new user");
        try {
            System.out.println("ik ben in de try");

            connect = DbConnection.getConnection();

            System.out.print(connect);
            //Statement statement = connect.createStatement();

            String query = userDAO.getUserNameFromId();
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1, id);


            System.out.println("hier gaat het goed 1");
            // create the mysql insert preparedstatement
            //PreparedStatement preparedStmt = connect.prepareStatement(query);
            //preparedStmt.setInt(1, 2);
            //System.out.println("hier gaat het goed2");

            //System.out.print(preparedStmt);

            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            // preparedStmt.execute();
            System.out.println("hier gaat het goed 4");


            while (rs.next()) {
                Name = rs.getString("firstName");
                System.out.println("Name:" + Name);
            }

            return Name;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (Exception e) {
            System.out.println("ik hier 2");
            e.printStackTrace();
        }
        return Name;
    }


    public void addNewUser(Person person) {

        Connection connect = null;
        System.out.println("ik ben in add new user");
        try {
            System.out.println("ik ben in de try");

            connect = DbConnection.getConnection();

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(userDAO.addUserQuery());
            preparedStmt.setInt(1, person.getId());
            preparedStmt.setString(2, person.getName());

            System.out.print(preparedStmt);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (Exception e) {
            System.out.println("ik hier 2");
            e.printStackTrace();
        }

    }

    // @DELETE
    //@Path("/delete/{id}")
    //@PathParam("id") int id
    public void removeUserWithId() {

        Connection conn = null;
        System.out.println("ik ben in remove user");
        try {
            System.out.println("ik ben in de try");

            conn = DbConnection.getConnection();

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(userDAO.removeUserWithIdQuery());
            preparedStmt.setInt(1, 2);

            System.out.print(preparedStmt);

            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (Exception e) {
            System.out.println("ik hier 2");
            e.printStackTrace();
        }

    }
}


