package mail;

import com.fendou.moudle.UpdateBugApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: cjx
 * @Date: 2020-11-20 14:15
 * @Description;
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UpdateBugApplication.class)
public class TestMail {

    private String fromMail="cjianxun@126.com";

    @Autowired
    private JavaMailSender sender;

    @Test
    public void test1(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo("cuijianxun@synqci.com");
        message.setText("from java");
        message.setSubject("主题");
        sender.send(message);
    }

}
