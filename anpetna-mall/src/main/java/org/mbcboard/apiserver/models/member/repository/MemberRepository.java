package org.mbcboard.apiserver.models.member.repository;

import org.mbcboard.apiserver.models.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

}