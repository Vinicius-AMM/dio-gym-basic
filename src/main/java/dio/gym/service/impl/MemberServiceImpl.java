package dio.gym.service.impl;

import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.member.Member;
import dio.gym.domain.member.MemberForm;
import dio.gym.domain.member.MemberRepository;
import dio.gym.domain.member.MemberUpdateForm;
import dio.gym.exception.BusinessException;
import dio.gym.exception.NotFoundException;
import dio.gym.service.IMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class MemberServiceImpl implements IMemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public Member create(MemberForm memberToCreate) {
        ofNullable(memberToCreate).orElseThrow(() -> new BusinessException("Member to create must not be null"));

        Member member = new Member();

        if(memberRepository.existsById(member.getId())) {
            throw new BusinessException("This Member ID already exists!");
        }

        member.setName(memberToCreate.getName());
        member.setCpf(memberToCreate.getCpf());
        member.setNeighborhood(memberToCreate.getNeighborhood());
        member.setBirthDate(memberToCreate.getBirthDate());
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Member update(Long id, MemberUpdateForm memberToUpdate) {
        Member dbMember = this.findById(id);

        dbMember.setName(memberToUpdate.getName());
        dbMember.setNeighborhood(memberToUpdate.getNeighborhood());
        dbMember.setBirthDate(memberToUpdate.getBirthDate());

        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new NotFoundException();
        }
        memberRepository.deleteById(id);
    }

    @Override
    public List<FitnessAssessment> getAllFitnessAssessmentByMemberId(Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getFitnessAssessments();
    }

    @Override
    public List<Member> findByCpf(String cpf) {
        return memberRepository.findByCpf(cpf);
    }
}
