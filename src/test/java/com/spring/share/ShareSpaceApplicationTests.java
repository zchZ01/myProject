package com.spring.share;

import com.share.tools.vo.ResultVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareSpaceApplicationTests {

    @Test
    public void contextLoads() {
        ResultVO resultVO = new ResultVO();
        Object[] obj = new Object[]{"成功"};
        resultVO.addReturnMsg(1L,obj);
    }

}
