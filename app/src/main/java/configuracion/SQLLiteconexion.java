package configuracion;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import transacciones.Transacciones;

public class SQLLiteconexion extends SQLiteOpenHelper {


    public SQLLiteconexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version){

super(context, dbname, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL(Transacciones.CreateTBPersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL(Transacciones.DropTablePersonas);
    }


}
