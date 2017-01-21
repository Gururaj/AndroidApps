package com.gsmayya.corelibs.listener;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import corelibs.listener.ListViewListener;

import static org.mockito.Matchers.anyInt;

/**
 * Created by gsmayya on 1/21/17.
 */

public class ListViewListenerTest {

  @Mock private ListViewListener<String> listViewListener;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(listViewListener.getCount()).thenReturn(10);
    Mockito.when(listViewListener.getItem(anyInt())).thenReturn("Hello");
  }

  /**
   *
   */
  @Test
  public void testGetList() {
    Assert.assertEquals(10, listViewListener.getCount());
    Assert.assertTrue("Hello".equals(listViewListener.getItem(0)));
  }
}
