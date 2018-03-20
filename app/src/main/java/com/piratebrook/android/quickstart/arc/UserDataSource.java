package com.piratebrook.android.quickstart.arc;

import com.piratebrook.android.quickstart.arc.persistence.User;

import io.reactivex.Flowable;

/**
 * Access point for managing user data.
 */
public interface UserDataSource {

    /**
     * Gets the user from the data source.
     *
     * @return the user form the data source.
     */
    Flowable<User> getUser();

    /**
     * Insert the user into the data source, or, if this is an existing user, updates it
     *
     * @param user the user to be inserted or updated.\
     */
    void insertOrUpdateUser(User user);

    /**
     * Deletes all users from the data source.
     */
    void deleteAllUsers();
}
