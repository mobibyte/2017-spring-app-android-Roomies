package mobi.roomies.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mobi.roomies.Fragments.ChatFragment;
import mobi.roomies.Fragments.TaskFragment;

/**
 * Created by Kevin on 10/28/2016.
 * hello
 */
public class FragmentAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ChatFragment.newInstance("0", "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return TaskFragment.newInstance("1", "Page # 2");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }



}
