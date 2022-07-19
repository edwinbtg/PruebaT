package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonDAO {

    private PreparedStatement pst;
    private ResultSet rs;
    
    public boolean addPerson (Person person){

        boolean state = false;
        Connection connect = null;

        try{

            connect = ConnectionPool.getInstance().getConnection();

            if(connect != null){

                String sql = "INSERT INTO productos (id, nombre, referencia, precio, peso, categoria, stock, fecha) VALUES (?,?,?,?,?,?,?,?)";

                pst = connect.prepareStatement(sql);

                pst.setInt(1, person.getId());
                pst.setString(2, person.getNombrep());
                pst.setInt(3, person.getReferencia());
                pst.setInt(4, person.getPrecio());
                pst.setInt(5, person.getPeso());
                pst.setString(6, person.getCategoria());
                pst.setInt(7, person.getStock());
                pst.setString(8, person.getFecha());
                

                int res = pst.executeUpdate();

                state = res > 0;

            }else{
                System.out.println("Conexión Fallida");
            }


        }catch(Exception ex){

            System.out.println(ex.getMessage());
        
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        return state;
    }

    public ArrayList<Person> selectPerson(String filter, ArrayList<String> data){

        ArrayList<Person> list = new ArrayList<>();
        Person person;

        Connection connect = null;

        try{

            connect = ConnectionPool.getInstance().getConnection();

            if(connect != null){

                String sql="";

                switch (filter) {
                    
                    case "Nombre":  
                        sql = "SELECT * FROM productos WHERE nombre REGEXP ? ";
                        pst = connect.prepareStatement(sql);
                        pst.setString(1, data.get(0));
                        pst.setString(2, data.get(0));                                             
                    break;
                
                    case "Id":                        
                        sql = "SELECT * FROM productos WHERE id=? ";
                        pst = connect.prepareStatement(sql);
                        pst.setString(1, data.get(0));
                        pst.setInt(2, Integer.parseInt(data.get(1)));                                             
                    break;

                    default:
                        sql = "SELECT * FROM productos WHERE 1 ";
                        pst = connect.prepareStatement(sql);                    
                    break;

                }

                rs = pst.executeQuery();

                while(rs.next()){

                    person = new Person();
                    
                    person.setId(rs.getInt("id"));
                    person.setNombrep(rs.getString("nombre"));
                    person.setReferencia(rs.getInt("referencia"));
                    person.setPrecio(rs.getInt("precio"));
                    person.setPeso(rs.getInt("peso"));
                    person.setCategoria(rs.getString("categoria"));
                    person.setStock(rs.getInt("stock"));
                    person.setFecha(rs.getString("fecha"));
                   

                    list.add(person);

                }


            }else{
                System.out.println("Conexión Fallida");
            }


        }catch(Exception ex){

            System.out.println(ex.getMessage());
        
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }        


        return list;

    } 

    public boolean updatePerson(Person person){

        boolean state = false;
        Connection connect = null;

        try{

            connect = ConnectionPool.getInstance().getConnection();

            if(connect != null){

                String sql = "UPDATE productos SET nombre=?, referencia=?, precio=?, peso=?, categoria=?, stock=?, fecha=? WHERE id=?";

                pst = connect.prepareStatement(sql);
                pst.setString(1, person.getNombrep());
                pst.setInt(2, person.getReferencia());
                pst.setInt(3, person.getPrecio());
                pst.setInt(4, person.getPeso());
                pst.setString(5, person.getCategoria());
                pst.setInt(6, person.getStock());
                pst.setString(7, person.getFecha());
                pst.setInt(8, person.getId());

                int res = pst.executeUpdate();

                state = res > 0;

            }else{
                System.out.println("Conexión Fallida");
            }


        }catch(Exception ex){

            System.out.println(ex.getMessage());
        
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        return state;


    }

    public boolean deletePerson(int id){

        boolean state = false;
        Connection connect = null;

        try{

            connect = ConnectionPool.getInstance().getConnection();

            if(connect != null){

                String sql = "DELETE FROM productos WHERE id=?";

            

                pst = connect.prepareStatement(sql);
                pst.setInt(1,id);
             

                int res = pst.executeUpdate();

                state = res > 0;

            }else{
                System.out.println("Conexión Fallida");
            }


        }catch(Exception ex){

            System.out.println(ex.getMessage());
        
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        return state;


    }



}