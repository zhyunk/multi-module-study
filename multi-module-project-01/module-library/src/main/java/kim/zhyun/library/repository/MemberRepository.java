package kim.zhyun.library.repository;

import kim.zhyun.library.entity.MemberEntity;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MemberRepository extends Repository<MemberEntity, Long> {
    
    MemberEntity save(MemberEntity entity);
    Optional<MemberEntity> findByUsername(String username);
    
}
