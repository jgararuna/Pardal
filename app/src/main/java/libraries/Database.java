package libraries;

import android.database.sqlite.SQLiteDatabase;

import com.modesteam.pardal.Pardal;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by andrebsguedes on 13/04/15.
 */
public class Database extends SQLiteAssetHelper{

    private static final int DATABASE_VERSION = 1;
    protected SQLiteDatabase database;

    public Database() {
        super(Pardal.getInstance(), "database.sqlite3.db", null, DATABASE_VERSION);
    }

    public void openConnection(){
        database = this.getReadableDatabase();
    }

    public void closeConnection(){
        database.close();
    }
}
