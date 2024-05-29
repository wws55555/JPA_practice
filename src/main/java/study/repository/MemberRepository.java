package study.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void insertMember(Member member) {
        em.persist(member);
    }
    public Member selectMember(Long id) {
        return em.find(Member.class, id);
    }
}
