


import com.hk.oa.auth.utils.JwtHelper;
import com.hk.oa.auth.utils.JwtUserInfo;
import com.hk.oa.auth.utils.Token;

/**
 * jwt 生成和解析 测试类
 *
 * @author zuihou
 * @date 2019/07/31
 */
public class JwtHelperTest {


    /**
     * 验证自己生成的 公钥私钥能否 成功生成token 解析token
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JwtUserInfo jwtInfo = new JwtUserInfo("", "zuihou", "最后", "", "");
        int expire = 7200;

        //生成
        Token token = JwtHelper.generateUserToken(jwtInfo, "pri.key", expire);
        System.out.println(token);

        //解析
        JwtUserInfo jwtFromToken = JwtHelper.getJwtFromToken(token.getToken(), "pub.key");
        System.out.println(jwtFromToken);

    }

}
