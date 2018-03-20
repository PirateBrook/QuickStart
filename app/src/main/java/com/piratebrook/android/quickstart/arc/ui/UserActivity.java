package com.piratebrook.android.quickstart.arc.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.piratebrook.android.quickstart.R;
import com.piratebrook.android.quickstart.arc.Injection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Main screen of the app. Displays a user name and gives the option to update the user name.
 */
public class UserActivity extends AppCompatActivity {

    private static final String TAG = UserActivity.class.getSimpleName();

    private TextView mUserName;

    private EditText mUserNameInput;

    private Button mUpdateButton;

    private ViewModelFactory mViewModelFactory;

    private UserViewModel mViewModel;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mUserName = findViewById(R.id.user_name);
        mUserNameInput = findViewById(R.id.user_name_input);
        mUpdateButton = findViewById(R.id.update_user);

        mViewModelFactory = Injection.provideViewModelFactory(this);
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(UserViewModel.class);
        mUpdateButton.setOnClickListener(view -> updateUserName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Subscribe to the emissions of the user name of the view model.
        // Update the user name text view, at every onNext emission.
        // In case of error, log the exception.
        mDisposable.add(mViewModel.getUserName()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userName -> mUserName.setText(userName),
                throwable -> Log.e(TAG, "Unable to update username", throwable)));
    }

    @Override
    protected void onStop() {
        super.onStop();

        // clear all subscriptions
        mDisposable.clear();
    }

    private void updateUserName() {
        String userName = mUserNameInput.getText().toString();
        // Disable the update button until the user name update has been done
        mUpdateButton.setEnabled(false);
        // Subscribe to updating the user name.
        // Re-enable the button once the user name has been updated
        mDisposable.add(mViewModel.updateUserName(userName)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(() -> mUpdateButton.setEnabled(true),
                throwable -> Log.e(TAG, "Unable to update username", throwable)));
    }
}
