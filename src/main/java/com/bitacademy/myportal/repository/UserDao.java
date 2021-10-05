package com.bitacademy.myportal.repository;

public interface UserDao {
	public int insert(UserVo vo);	//	가입 INSERT
	public UserVo selectUser(String email);	//	중복 이메일 체크 SELECT
	public UserVo selectUser(String email, String password);
	//	Login용 SELECT
	public UserVo updateUser(); // 회원 정보 수정하기
	
	
}
