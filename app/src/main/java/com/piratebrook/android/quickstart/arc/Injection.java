package com.piratebrook.android.quickstart.arc;

import android.content.Context;

import com.piratebrook.android.quickstart.arc.persistence.LocalUserDataSource;
import com.piratebrook.android.quickstart.arc.persistence.UsersDatabase;
import com.piratebrook.android.quickstart.arc.ui.ViewModelFactory;

/**
 * Enables injection of data source.
 */
public class Injection {

    public static UserDataSource provideUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
