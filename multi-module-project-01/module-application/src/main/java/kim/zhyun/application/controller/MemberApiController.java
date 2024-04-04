package kim.zhyun.application.controller;

import kim.zhyun.application.request.MemberRequest;
import kim.zhyun.application.service.MemberService;
import kim.zhyun.library.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberApiController {
    private final MemberService service;
    
    @PostMapping
    public MemberEntity create(@RequestBody MemberRequest request) {
        return service.create(request);
    }
    
    @PostMapping("/confirm")
    public ResponseEntity<Object> confirm(@RequestBody MemberRequest request) {
        service.confirm(request);
        return ResponseEntity.ok("Hi! %s 💐😆".formatted(request.getUsername()));
    }
    
}
