package jhulang.healthin.com

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnTabSelectListener
import jhulang.healthin.com.fragment.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var bottomBar: BottomBar? = null
    private var cardView: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        cardView = findViewById(R.id.CardView)
        cardView!!.setOnTouchListener


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
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_history -> {

            }
            R.id.nav_about -> {

            }
            R.id.nav_exit -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
