package com.piratebrook.android.quickstart.arc.ui;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.piratebrook.android.quickstart.arc.UserDataSource;
import com.piratebrook.android.quickstart.arc.persistence.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Unit test for {@link UserViewModel}
 */
public class UserViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private UserDataSource mUserDataSource;

    @Captor
    private ArgumentCaptor<User> mUserArgumentCaptor;

    private UserViewModel mViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mViewModel = new UserViewModel(mUserDataSource);
    }

    @Test
    public void getUserName() throws Exception {
    }

    @Test
    public void updateUserName() throws Exception {
    }

}