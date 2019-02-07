package uv.edu.tarea2;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import uv.edu.customlog.InfoLog;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * <a href="https://developer.android.com/training/testing/ui-testing/">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {
    private static long PAUSE = 1500;


    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception ex) {
        }
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    private UiDevice mDevice;
    private String name;
    private String nombre = "Liskova Petrova";
    private String edad = "33";
    private String correo = "liskpet@alumni.uv.es";

    @Before
    public void setUp() throws Exception {
        Instrumentation ins = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(ins);
        name = mActivityRule.getActivity().getResources().getString(R.string.app_name);
    }

    @Test
    public void test1() throws Exception {
        onView(withId(R.id.editText)).perform(typeText(nombre));
        ApplicationTest.pause(PAUSE);
        onView(withId(R.id.editText2)).perform(typeText(edad));
        ApplicationTest.pause(PAUSE);
        onView(withId(R.id.editText3)).perform(typeText(correo), closeSoftKeyboard());

        ApplicationTest.pause(PAUSE);

        onView(withId(R.id.editText)).check(matches(withText(nombre)));
        onView(withId(R.id.editText2)).check(matches(withText(edad)));
        onView(withId(R.id.editText3)).check(matches(withText(correo)));

        InfoLog.log(name,"Test 1: el texto aparece en la primera ventana");
    }

    @Test
    public void test2() throws Exception {

        onView(withId(R.id.editText)).perform(typeText(nombre));
        ApplicationTest.pause(PAUSE);
        onView(withId(R.id.editText2)).perform(typeText(edad));
        ApplicationTest.pause(PAUSE);
        onView(withId(R.id.editText3)).perform(typeText(correo), closeSoftKeyboard());

        ApplicationTest.pause(PAUSE);

        onView(withId(R.id.button)).perform(click());

        ApplicationTest.pause(PAUSE);

        onView(withId(R.id.textView5)).check(matches(withText(nombre)));
        onView(withId(R.id.textView6)).check(matches(withText(edad)));
        onView(withId(R.id.textView7)).check(matches(withText(correo)));

        InfoLog.log(name, "Test 2-a: el texto aparece en la segunda actividad");

        ApplicationTest.pause(100);

        onView(withId(R.id.button2)).perform(click());

        onView(withId(R.id.editText)).check(matches(withText(nombre)));
        onView(withId(R.id.editText2)).check(matches(withText(edad)));
        onView(withId(R.id.editText3)).check(matches(withText(correo)));

        InfoLog.log(name, "Test 2-b: se cierra la segunda actividad y se vuelve a la primera");

        mDevice.pressHome();
    }
}