package cn.comment.service;

public interface MemberService {
	/**
     * 判断手机号是否存在
     * @param phone 手机号
     * @return true：存在，false：不存在
     */
    boolean exists(Long phone);

    /**
     * @param username 用户号码
     * @param code 生成的随机验证码
     * */
	boolean saveCode(Long username, String code);

	boolean sendCode(Long username, String code);

	String getCode(Long phone);

	void saveToken(String token, Long phone);
	
	Long getIdByPhone(Long phone);

	Long getPhone(String token);
}
