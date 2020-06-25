import com.spring.example.model.MemberVO;
import com.spring.example.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class MemberDAOTest {
    @Inject
    private MemberDAO memberDAO;

    @Test
    public void testTime() throws Exception {
        System.out.println(memberDAO.getTime());
    }

    @Test
    public void testInsertMember() throws Exception {
        MemberVO memberVO = new MemberVO();
        memberVO.setUserid("user01");
        memberVO.setUserpw("user01");;
        memberVO.setUsername("user01");
        memberVO.setEmail("user01@gmail.com");
        memberDAO.insertMember(memberVO);
    }

    @Test
    public void testReadMember() throws Exception {
        memberDAO.readMember("user01");
    }

    @Test
    public void testReadWithPW() throws Exception {
        memberDAO.readWithPW("user01", "user01");
    }
}
