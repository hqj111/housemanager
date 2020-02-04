package com.house.manager.util;



import java.util.Collection;
import java.util.UUID;

/**

 * @Create 2020-01-11 4:29
 */
public class HouseUtils {

    /**
     *
     */
    public static String generatedToken(){
        return HouseConstant.REDIS_LOGIN_TOKEN_PREFIX + UUID.randomUUID().toString().replace("_", "");
    }
    /**
     * 验证集合是否有效
     * @param c		待验证集合
     * @return		验证结果（true：有效，false：无效）
     * @author 封捷
     */
    public static <E> boolean collectionEffectiveCheck(Collection<E> c) {
        return (c != null) && (c.size() > 0);
    }

    /**
     * 验证字符串是否有效
     * @param source	待验证字符串
     * @return			验证结果（true：有效，false：无效）
     * @author 封捷
     */
    public static boolean strEffectiveCheck(String source) {
        return (source != null) && (source.length() > 0);
    }

    /**
     * 生成随机验证码
     * @param length	验证码长度
     * @return			生成的验证码
     * @throws	RuntimeException 验证码长度必须大于0
     * @author 封捷
     */
    public static String randomCode(int length) {

        if(length <= 0) {
            throw new RuntimeException(HouseConstant.MESSAGE_RANDOM_CODE_LENGTH_INVALID);
        }

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; i++) {

            // 1.生成随机数
            double doubleRandom = Math.random();

            // 2.调整
            int integerRandom = (int) (doubleRandom * 10);

            // 3.拼接
            builder.append(integerRandom);
        }

        return builder.toString();
    }
}