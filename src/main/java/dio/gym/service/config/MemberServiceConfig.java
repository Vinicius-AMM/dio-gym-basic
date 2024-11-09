package dio.gym.service.config;

import dio.gym.domain.member.MemberRepository;
import dio.gym.service.impl.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberServiceConfig {
    @Bean
    public MemberServiceImpl memberService(MemberRepository memberRepository) {
        return new MemberServiceImpl(memberRepository);
    }
}