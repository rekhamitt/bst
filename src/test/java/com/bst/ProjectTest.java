package com.bst;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rekhamittal on 8/25/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@ContextConfiguration(classes=Application.class)  // 2
public class ProjectTest {

    @Test
    public void contextLoads() {


    }

}
