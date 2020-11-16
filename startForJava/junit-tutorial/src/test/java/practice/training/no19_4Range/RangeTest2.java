package practice.training.no19_4Range;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest2 {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test1() {
//    setup
    Range range = new Range(-5.1, 5.1);

//    verify
    assertThat(false, is(range.contains(-5.2)));

  }

  @Test
  public void test2() {
//  setup
    Range range = new Range(-5.1, 5.1);

//    verify
    assertThat(true, is(range.contains(-5.1)));

  }

  @Test
  public void test3() {
//  setup
    Range range = new Range(-5.1, 5.1);

//    verify
    assertThat(true, is(range.contains(5.1)));

  }

  @Test
  public void test4() {
//  setup
    Range range = new Range(-5.1, 5.1);

//    verify
    assertThat(false, is(range.contains(5.2)));

  }

}
