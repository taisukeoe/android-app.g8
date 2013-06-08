package $package$.tests

import $package$._
import junit.framework.Assert._
import _root_.android.test.AndroidTestCase
import _root_.android.test.ActivityInstrumentationTestCase2
import _root_.android.widget.TextView

class AndroidTests extends AndroidTestCase {
  def testPackageIsCorrect() {
    assertEquals("$package$", getContext.getPackageName)
  }
}

class ActivityTests extends ActivityInstrumentationTestCase2(classOf[$main_activity$]) {
  var activity:$main_activity$ = _
  var textview:TextView = _

  override def setUp() {
    super.setUp()
    setActivityInitialTouchMode(false)
    activity = getActivity
    textview = activity.findViewById($package$.R.id.textview).asInstanceOf[TextView]
  }
  def testHelloWorldIsShown() {
    assertEquals(textview.getText, "hello, world!")
  }
}
