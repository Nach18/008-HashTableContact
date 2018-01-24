package Menu;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Menu {
    private int respuesta;
    private String repeticion;
    String asignar;
    public String ultimo;

    Hashtable <String /*DNI*/, String /*NOMBRE*/> contactos = new Hashtable<>();

    Enumeration<String> enumeration = contactos.elements();

    Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        do {
            System.out.println("");
            System.out.println("Gestión de Contactos 2.0, ahora con lector de texto incorporado");
            System.out.println("¿Que desea hacer hoy, ciudadano?");
            System.out.println("1) Añadir contacto");
            System.out.println("2) Eliminar contacto");
            System.out.println("3) Eliminar varios contactos");
            System.out.println("4) Mostrar contactos");
            System.out.println("0) Salir");
            System.out.println("");
            System.out.print("O_o ->");
            respuesta = sc.nextInt();

            switch (respuesta) {
                default:
                    System.out.println("");
                    System.out.println("La respuesta que has dado es invalida y totalmente ilogica.");
                    break;
                case 1:
                    System.out.println("");
                    addContacto();
                    break;
                case 2:
                    System.out.println("");
                    removeContact();
                    break;
                case 3:
                    System.out.println("");
                    removeMoreContacts();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Vamos a ver cuantos amigos tienes guardados: \n");
                    showContact();
                    break;


            }

        }while (respuesta != 0);{
            System.out.println("");
            System.out.println("Hasta la próxima ciudadano");
        }
    }


    public void addContacto () {
        String nombre;
        String DNI;

        do {


            System.out.println("Un contacto se completa por dos parametros que son:");
            System.out.print("Nombre: ");
            nombre = sc.next();

            System.out.println("");
            System.out.print("Y un DNI: ");
            DNI = sc.next();
            contactos.put(DNI, nombre);
            System.out.println("");

            for (String String : contactos.keySet()) {
                ultimo = contactos.get(String);
            }

            System.out.println("Genial, " + ultimo + " ya esta dentro de nuestro equipo!\n");
            System.out.print("Añadimos otro? (͡° ͜ʖ ͡°) (S/N)\n");
            repeticion = sc.next();
        }while (repeticion.equalsIgnoreCase("s"));


    }

    public void removeContact () {
        System.out.println("A si que quieres eliminar un contacto... \n");



        do {
            String eliminacion;
            String eliminado;

            showContact();

            System.out.println("Ahora solo necesito que me digas su DNI o su nombre para poder eliminarlo PARA SIEMPRE");
            System.out.print("DNI/Nombre: ");
            eliminacion = sc.next();
            if (contactos.containsKey(eliminacion)) {
                eliminado = contactos.get(eliminacion);
                contactos.remove(eliminacion);
                System.out.println("¡Eliminado!, hasta siempre " + eliminado + " nunca te olvidaremos!\n");
            } else {
                for (String K : contactos.keySet()) {
                   String comprobacion = contactos.get(K);
                   if (comprobacion.equalsIgnoreCase(eliminacion)) {
                       eliminado = contactos.get(K);
                       contactos.remove(K);
                       System.out.println("Muy bien, he eliminado a " + eliminado + " por el nombre que me has pasado\n");
                       System.out.print("¿Eliminamos a otro mas? (･ิω･ิ) (S/N)");
                       repeticion = sc.next();
                       if (repeticion.equalsIgnoreCase("s")) {
                           removeContact();
                       } else {
                           mostrarMenu();
                       }
                   }

                   else {
                       System.out.println("Tío, no encuentro el contacto que me has pasado ni por su nombre ni por su DNI");
                       System.out.print("¿Lo intentamos de nuevo? (・へ・) (S/N)");
                       repeticion = sc.next();
                       if (repeticion.equalsIgnoreCase("s")) {
                           removeContact();
                       } else {
                           mostrarMenu();
                       }
                   }
                }


            }




            System.out.print("¿Eliminamos a otro mas? (･ิω･ิ) (S/N)");
            repeticion = sc.next();
        }while (repeticion.equalsIgnoreCase("s"));




    }

    public void showContact () {

        if (contactos.size() == 0) {
            System.out.println("¡Vaya! No tienes ningún contacto añadido");
            System.out.println("¯\\_(ツ)_/¯ \n");
            mostrarMenu();
        }

        for (String String : contactos.keySet()) {
            System.out.println("[" + String + "]" + " - " + contactos.get(String));
        }

        System.out.println("");


    }

    public void removeMoreContacts (){
        System.out.println("En proceso! (¯―¯٥)");
    }
}

