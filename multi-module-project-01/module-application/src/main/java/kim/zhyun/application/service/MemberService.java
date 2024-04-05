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
        requestValid(request);
        
        MemberEntity entity = MemberEntity.builder()
                .username(request.getUsername())
                .confirm(request.getConfirm())
                .build();
        
        return memberRepository.save(entity);
    }
    
    public void confirm(MemberRequest request) {
        requestValid(request);
        
        Optional<MemberEntity> memberContainer = memberRepository.findByUsername(request.getUsername());
        
        if (memberContainer.isEmpty()) {
            throw new RuntimeException("등록되지 않은 사용자입니다.");
        }
        
        MemberEntity entity = memberContainer.get();
        if (!entity.getConfirm().equals(request.getConfirm())) {
            throw new RuntimeException("인증 실패!!");
        }
    }
    
    
    private void requestValid(MemberRequest request) {
        if (request.getConfirm().isEmpty() || request.getUsername().isEmpty()) {
            throw new RuntimeException("값을 모두 입력해주세요.");
        }
    }
}
