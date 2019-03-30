package jhulang.healthin.com;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;



import jhulang.healthin.com.fragment.ChatFragment;
import jhulang.healthin.com.fragment.HistoryFragment;
import jhulang.healthin.com.fragment.HomeFragment;
import jhulang.healthin.com.fragment.MyProfileFragment;
import jhulang.healthin.com.fragment.NewsFragment;


public class MainActivity extends AppCompatActivity {
    private Drawer.Result navigationDrawer;
    private AccountHeader.Result headerNavigation;
    private BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        headerNavigation = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(new ProfileDrawerItem().withName("Ridho Jhulang Aqsha").withEmail("aqsharidho@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_account2))
                )
                .build();

        navigationDrawer = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigation)
                .withSelectedItem(0)
                .build();

        navigationDrawer.addItem(new PrimaryDrawerItem().withName("History").withIcon(getResources().getDrawable(R.drawable.ic_history)));
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("About").withIcon(getResources().getDrawable(R.drawable.ic_about)));
        navigationDrawer.addItem(new PrimaryDrawerItem().withName("Exit").withIcon(getResources().getDrawable(R.drawable.ic_exit)));

        bottomBar = (BottomBar)findViewById(R.id.Bottom_bar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            Fragment fragment = null;
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home){
                    fragment = new HomeFragment();
                }else if (tabId == R.id.tab_news){
                    fragment = new NewsFragment();
                }else if(tabId == R.id.tab_chat){
                    fragment = new ChatFragment();
                }else if (tabId == R.id.tab_history){
                    fragment =  new HistoryFragment();
                }else if (tabId == R.id.tab_account){
                    fragment = new MyProfileFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
