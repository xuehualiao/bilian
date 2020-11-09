import com.itxingrui.DemoApplication;
import com.itxingrui.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MailTest {

    @Autowired
    private MailService mailService;

    private static final String TO = "841988299@qq.com";
    private static final String SUBJECT = "每日通知";
    private static final String CONTENT = "短信测试，每日通知";

    /**
     * 测试发送普通邮件
     */
    @Test
    public void sendSimpleMailMessage() {
        mailService.sendSimpleMailMessge(TO, SUBJECT, CONTENT);
    }

    /**
     * 测试发送html邮件
     */
    @Test
    public void sendHtmlMessage() {
        String htmlStr = "<h1>Test</h1>";
        mailService.sendMimeMessge(TO, SUBJECT, htmlStr);
    }

    /**
     * 测试发送带附件的邮件
     * @throws FileNotFoundException
     */
    @Test
    public void sendAttachmentMessage() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:test.txt");
        String filePath = file.getAbsolutePath();
        mailService.sendMimeMessge(TO, SUBJECT, CONTENT, filePath);
    }

    /**
     * 测试发送带附件的邮件
     * @throws FileNotFoundException
     */
    @Test
    public void sendPicMessage() throws FileNotFoundException {
        String htmlStr = "<html><body>测试：图片1 <br> <img src=\'cid:pic1\'/> </body></html>";
        Map<String, String> rscIdMap = new HashMap<>(1);
        rscIdMap.put("pic1", ResourceUtils.getFile("classpath:pic.png").getAbsolutePath());
//        rscIdMap.put("pic2", ResourceUtils.getFile("classpath:pic02.jpg").getAbsolutePath());
        mailService.sendMimeMessge(TO, SUBJECT, htmlStr, rscIdMap);
    }
}