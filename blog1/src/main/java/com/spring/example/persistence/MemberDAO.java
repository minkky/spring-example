package com.spring.example.persistence;

import com.spring.example.model.MemberVO;

public interface MemberDAO {
    public String getTime();
    public void insertMember(MemberVO memberVO);
    public MemberVO readMember(String userid) throws Exception;
    public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
