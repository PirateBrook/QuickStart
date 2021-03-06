package com.piratebrook.android.quickstart.arc.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * The Room database that contains the Users table
 */
@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {

    private static volatile UsersDatabase INSTANCE;

    public abstract UserDao userDao();

    public static UsersDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsersDatabase.class, "User.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
