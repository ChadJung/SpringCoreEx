package com.springcorex.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberID);

}
