package singapore.mobiledata.com.mobiledatasingapore;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import singapore.mobiledata.com.mobiledatasingapore.adapter.MobileDataUsageAdapter;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;
import singapore.mobiledata.com.mobiledatasingapore.presenter.MobileDataPresenter;
import singapore.mobiledata.com.mobiledatasingapore.view.MobileDataUsageView;
import singapore.mobiledata.com.mobiledatasingapore.view.activity.HomeActivity;
import singapore.mobiledata.com.mobiledatasingapore.webservice.NoInternetException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    private MobileDataUsageView mobileDataUsageView;
    @Rule
    public ActivityTestRule<HomeActivity> mainActivityActivityTestRule=  new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void checkButtonStrings(){

        onView(allOf(withId(R.id.rvMobileDataUsageList), isDisplayed()));
    }

    @Test
    public void presenterAttachData() throws NoInternetException {
        MobileDataModel mobileDataModel=new MobileDataModel();

         MobileDataPresenter presenter = new MobileDataPresenter(mainActivityActivityTestRule.getActivity());
         presenter.getAllMobileDataUsageNUmbers();
         onView(allOf(withId(R.id.rvMobileDataUsageList), isDisplayed()));

    }

    @Test
    public void ensureListViewIsPresent() throws Exception {
        HomeActivity activity = mainActivityActivityTestRule.getActivity();
        RecyclerView viewById = activity.findViewById(R.id.rvMobileDataUsageList);
        RecyclerView listView = (RecyclerView) viewById;


    }
}
