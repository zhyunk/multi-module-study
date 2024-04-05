package kim.zhyun.application.service;

import kim.zhyun.application.request.MemberRequest;
import kim.zhyun.library.entity.MemberEntity;
import kim.zhyun.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    
    public MemberEntity create(MemberRequest request) {
        MemberEntity entity = MemberEntity.builder()
                .username(request.getUsername())
                .confirm(request.getConfirm())
                .build();
        
        return memberRepository.save(entity);
    }
    
    public void confirm(MemberRequest request) {
        Optional<MemberEntity> memberContainer = memberRepository.findByUsername(request.getUsername());
        
        if (memberContainer.isEmpty()) {
            throw new RuntimeException("등록되지 않은 사용자입니다.");
        }
        
        MemberEntity entity = memberContainer.get();
        if (!entity.getConfirm().equals(request.getConfirm())) {
            throw new RuntimeException("인증 실패!!");
        }
    }
}
