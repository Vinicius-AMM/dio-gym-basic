package dio.gym.service;


import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.member.Member;
import dio.gym.domain.member.MemberForm;
import dio.gym.domain.member.MemberUpdateForm;

import java.util.List;

public interface IMemberService{
    Member create(MemberForm memberToCreate);
    List<Member> findAll();
    Member findById(Long id);
    Member update(Long id, MemberUpdateForm memberToUpdate);
    void deleteById(Long id);
    List<FitnessAssessment> getAllFitnessAssessmentByMemberId(Long id);
    List<Member> findByCpf(String cpf);
}
