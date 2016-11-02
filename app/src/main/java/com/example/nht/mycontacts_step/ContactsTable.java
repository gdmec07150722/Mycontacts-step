package com.example.nht.mycontacts_step;

import android.content.ContentValues;
import android.content.Context;
public class ContactsTable {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context context){
        db =new MyDB(context);
        if (!db.isTableExits(TABLENAME))
        {
            String createTableSql ="CREATE TABLE IF NOT EXISTS"+TABLENAME+"(id_DB integer"+"primary key AUTOINCREMENT,"+
                   User.NAME+"VARCHAR,"+
                    User.MOBILE+"VARCHAR,"+
                    User.QQ+"VARCHAR,"+
                    User.DANWEI+"VARCHAR,"+
                    User.ADDRESS+"VARCHAR)";
                db.createTable(createTableSql);
        }
    }
    public boolean addDate(User user)
    {
        ContentValues values =new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMoblie());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.NAME,user.getQq());
        values.put(User.ADDRESS,user.getAddress());

        return db.save(TABLENAME,values);
    }
}
