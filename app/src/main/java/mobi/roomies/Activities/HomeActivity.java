package mobi.roomies.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import mobi.roomies.Adapters.FragmentAdapter;
import mobi.roomies.Fragments.TaskFragment;
import mobi.roomies.R;

public class HomeActivity extends AppCompatActivity {

    private Context context;
    private TabLayout tl;

    private FragmentAdapter fragmentAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = this;

        // holds layout that will hold tabs
        tl = (TabLayout) findViewById(R.id.tab_layout);
        // if using view pager, need following lines
        tl.setupWithViewPager((ViewPager)findViewById(R.id.container));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        // the adapter will determine which fragment to display, how many there are, etc
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(fragmentAdapter);

        //this will change the FAB icon based on which tab you go to. not yet implemented




        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("TAG", "New page selected " + position);
                Fragment selected = fragmentAdapter.getItem(tl.getSelectedTabPosition());
                if(selected instanceof TaskFragment) {
                    ((TaskFragment)selected).reloadData();
                }
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                switch(position){
                    case 0:fab.hide();
                            break;
                    case 1:fab.show();
                        break;
                    case 2:fab.show();
                        break;
                    case 3:fab.show();
                        break;
                    default:fab.show();
                        break;
                }
                final InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mViewPager.getWindowToken(), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                int currentTab = tl.getSelectedTabPosition();

                switch(currentTab){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(context, AddTaskActivity.class);
                        startActivityForResult(intent, Activity.RESULT_OK);
                        break;
                    case 2:
                        intent = new Intent(context,AddExpenseActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //whatever

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
