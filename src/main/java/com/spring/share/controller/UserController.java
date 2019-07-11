package com.spring.share.controller;

import com.email.EmailTools;
import com.share.tools.vo.ResultVO;
import com.spring.share.logs.MyLogger;
import com.spring.share.model.UserModel;
import com.spring.share.service.IUserService;
import com.spring.share.service.Impl.RedisHelper;
import com.spring.share.util.Constants;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
public class UserController {

    ResultVO resultVO = new ResultVO();

    /**
     * 注入service
     */
    @Autowired
    private IUserService userService;

    @Autowired
    private RedisHelper redisHelper;

    /**
     * 登录方法
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "frame/comedy";
    }

    /**
     *
     * 注册方法
     *
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResultVO register(UserModel user) {

        //添加用户信息实现注册
       /* int row = userService.addUserInfo(user);
        if (row>0){
            resultVO.addReturnMsg(1L,new Object[]{"成功"});
        }else {
            resultVO.addReturnMsg(-1L,new Object[]{"失败"});
        }*/
        redisHelper.valuePut("test", "Redis测试");
        resultVO.addReturnMsg(1L, new Object[]{"成功"});
        System.out.println(redisHelper.getValue("test"));
        return resultVO;
    }


    /**
     * 获取邮箱验证码
     *
     * @param email
     * @return
     */
    @RequestMapping("/getEmailCode")
    @ResponseBody
    public ResultVO getEmailCode(String email, HttpSession session) {
        String title = "验证码";
        //设置验证码 内容为当前毫秒前四位拼接一个随机数
        long currentMill = System.currentTimeMillis();
        int i = Math.abs(new Random().nextInt());
        String code = String.valueOf(i).substring(0,3)+String.valueOf(currentMill).substring(0,3);
        MyLogger.info("验证码:"+code);
        //初始化map将邮箱以及验证码存放在map中
        Map<String,String> map = new HashMap();
        map.put(email,code);
        //发送邮件验证码
       int returnCode = EmailTools.sendMail(title, new Object[]{"您的验证码为：",code,",请勿泄露"}, email, Constants.senderAccount, Constants.senderPassword, Constants.senderAddress);
        if(returnCode>0){
            //生成的验证码存在session中
            session.setAttribute("code",map);
            //创建定时任务，5分钟后清除session 参数1为任务，参数2为延时多久开始执行任务，参数3为定时时间
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //通过email获取验证码
                    Object codeObj = new BeanMap(session.getAttribute("code")).get(email);
                    if(codeObj!=null){
                        session.removeAttribute("code");
                    }
                }
            },0L,5*60*1000);
            MyLogger.info("邮件发送成功");
            resultVO.addReturnMsg(1L, new Object[]{"验证码已成功发到邮箱"});
        }else{
            MyLogger.error("邮件发送失败");
            resultVO.addReturnMsg(-1L, new Object[]{"验证码发送失败"});
        }
        return resultVO;
    }
}
