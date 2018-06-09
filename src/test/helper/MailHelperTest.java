package test.helper; 

import helper.MailHelper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class MailHelperTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sendmail() 
* 
*/ 
@Test
public void testSendmail() throws Exception {
    MailHelper mail = new MailHelper();
    System.out.println(mail.sendmail("chenzl23@outlook.com","陈赵亮","您的成绩更新了"));
//TODO: Test goes here... 
} 


} 
