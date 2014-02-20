/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */

import config.SpringMongoConfig;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = SpringMongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {

    @Autowired
    MongoOperations mongoOperations;



    @Test
    public void canRunApp() {
        Assert.assertNotNull(mongoOperations);
    }
}
