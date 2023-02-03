package transacciones;

public class Transacciones {
    //Nombre de la base de datos

    public static final String NameDatabase = "PM01DB";


    public static final String tablapersonas = "personas";

    /* Transacciones de la base de datos PM01BD */
    public static final String CreateTBPersonas =
    "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
    "apellidos TEXT, edad INTEGER, correo TEXT )";

    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";


    public static final String empty = "";



}
