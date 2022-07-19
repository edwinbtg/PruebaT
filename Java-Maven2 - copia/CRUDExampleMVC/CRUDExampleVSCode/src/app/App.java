package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import model.Person;
import model.PersonDAO;

public class App {
    public static void main(String[] args) throws Exception {
     
        PersonDAO model = new PersonDAO();

        int menu = Integer.parseInt(JOptionPane.showInputDialog("KONECTA\n"+
                                                               "1- Insertar producto.\n"+
                                                               "2- Listar productos.\n"+
                                                               "3- Actualizar producto.\n"+
                                                               "4- Eliminar producto.\n"+
                                                               "5- Exit."));

        switch(menu){

            case 1:
                
                Person person = new Person();

                person.setId(1345);
                person.setNombrep("goma");
                person.setReferencia(42121);
                person.setPrecio(432323);
                person.setPeso(43);
                person.setCategoria("dulces");
                person.setStock(312);
                person.setFecha("2 de noviembre");
        
                if(model.addPerson(person)){
                    System.out.println("Guardado");
                }else{
                    System.out.println("No Guardado");
                }

            break;

            case 2:

                ArrayList<String> data=new ArrayList<>();
                data.add("goma");
                data.add("1345");
                
                ArrayList<Person> list = model.selectPerson("id", data);

                for(int i=0; i<list.size(); i++){

                    System.out.println(list.get(i).getId() + " " + list.get(i).getNombrep() + " "+ list.get(i).getCategoria());
                
                }
                
            break;

            case 3:

                person = new Person();
                person.setId(1345);
                person.setNombrep("goma");
                person.setReferencia(42121);
                person.setPrecio(432323);
                person.setPeso(43);
                person.setCategoria("chicles");
                person.setStock(312);
                person.setFecha("2 de noviembre");
        
        
                if(model.updatePerson(person)){
                    System.out.println("Los datos han sido modificados de manera exitosa");
                }else{
                    System.out.println("No se pudo modificar la informacion");
                }

            break;

            case 4:

                int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea realizar el proceso?\n"
                                                                 +"Todos los datos se perderan");

                if(confirm == JOptionPane.YES_OPTION){
                    if(model.deletePerson(1345)){
                        System.out.println("Los datos han sido eliminados de manera exitosa");
                    }else{
                        System.out.println("No se pudo eliminar la información");
                    }
                }

            break;

            case 5:
                System.out.println("Saliendo del sistema...");
                System.out.println("Proceso finalizado");
            break;

        }

    }
    }
