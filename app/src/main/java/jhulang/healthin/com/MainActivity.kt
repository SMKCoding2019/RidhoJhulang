package jhulang.healthin.com

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnTabSelectListener
import jhulang.healthin.com.fragment.*


class MainActivity : AppCompatActivity() {

    private var navigationDrawer: Drawer.Result? = null
    private var headerNavigation: AccountHeader.Result? = null
    private var bottomBar: BottomBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        headerNavigation = AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(ProfileDrawerItem().withName("Ridho Jhulang Aqsha").withEmail("aqsharidho@gmail.com").withIcon(resources.getDrawable(R.drawable.ic_account2))
                )
                .build()

        navigationDrawer = Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigation)
                .withSelectedItem(0)
                .build()

        navigationDrawer!!.addItem(PrimaryDrawerItem().withName("History").withIcon(resources.getDrawable(R.drawable.ic_history)))
        navigationDrawer!!.addItem(PrimaryDrawerItem().withName("About").withIcon(resources.getDrawable(R.drawable.ic_about)))
        navigationDrawer!!.addItem(PrimaryDrawerItem().withName("Exit").withIcon(resources.getDrawable(R.drawable.ic_exit)))

        bottomBar = findViewById(R.id.Bottom_bar)
        bottomBar!!.setOnTabSelectListener(object : OnTabSelectListener {
            internal var fragment: Fragment? = null
            override fun onTabSelected(@IdRes tabId: Int) {
                if (tabId == R.id.tab_home) {
                    fragment = HomeFragment()
                } else if (tabId == R.id.tab_news) {
                    fragment = NewsFragment()
                } else if (tabId == R.id.tab_chat) {
                    fragment = ChatFragment()
                } else if (tabId == R.id.tab_history) {
                    fragment = HistoryFragment()
                } else if (tabId == R.id.tab_account) {
                    fragment = MyProfileFragment()
                }
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content, fragment!!)
                        .commit()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
