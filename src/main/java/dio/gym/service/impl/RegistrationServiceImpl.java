package dio.gym.service.impl;

import dio.gym.domain.member.Member;
import dio.gym.domain.member.MemberRepository;
import dio.gym.domain.registration.Registration;
import dio.gym.domain.registration.RegistrationForm;
import dio.gym.domain.registration.RegistrationRepository;
import dio.gym.exception.BusinessException;
import dio.gym.exception.NotFoundException;
import dio.gym.service.IRegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
    private final RegistrationRepository registrationRepository;

    private final MemberRepository memberRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, MemberRepository memberRepository) {
        this.registrationRepository = registrationRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public Registration create(RegistrationForm registrationToCreate) {
        Registration registration = new Registration();
        Member member = memberRepository.findById(registrationToCreate.getMemberId()).orElseThrow(() -> new BusinessException("Member not found"));;

        registration.setMember(member);

        return registrationRepository.save(registration);
    }

    @Override
    public Registration findById(Long id) {
        return registrationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new NotFoundException();
        }
        registrationRepository.deleteById(id);
    }
}
