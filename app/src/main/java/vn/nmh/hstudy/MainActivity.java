package vn.nmh.hstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{
	private Toolbar mToolbar;
	private FragmentDrawer drawerFragment;
	private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, mDrawerLayout, mToolbar);
        drawerFragment.setDrawerListener(this);
        displayView(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onDrawerItemSelected(View view, int position) {
		// TODO Auto-generated method stub
		displayView(position);
		
	}

	@Override
	public void onBackPressed() {
		if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
			mDrawerLayout.closeDrawers();
			return;
		}
		super.onBackPressed();
	}
	
	 private void displayView(int position) {
	        Fragment fragment = null;
	        String title = getString(R.string.app_name);
	        switch (position) {
	            case 0:
	                fragment = new HomeFragment();
	                title = getString(R.string.title_home);
	                break;
	            case 1:
	                fragment = new SnackbarFragment();
	                title = getString(R.string.title_friends);
	                break;
	            default:
	                break;
	        }
	 
	        if (fragment != null) {
	            FragmentManager fragmentManager = getSupportFragmentManager();
	            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	            fragmentTransaction.replace(R.id.container_body, fragment);
	            fragmentTransaction.commit();
	 
	            // set the toolbar title
	            getSupportActionBar().setTitle(title);
	        }
	    }
}
