package com.piratebrook.android.quickstart.arc.persistence;

import com.piratebrook.android.quickstart.arc.UserDataSource;

import io.reactivex.Flowable;

/**
 * Using the Room database as a data source.
 */
public class LocalUserDataSource implements UserDataSource {

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao mUserDao) {
        this.mUserDao = mUserDao;
    }

    @Override
    public Flowable<User> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public void insertOrUpdateUser(User user) {
        mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
