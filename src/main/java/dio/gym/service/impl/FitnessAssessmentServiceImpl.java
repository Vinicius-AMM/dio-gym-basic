package dio.gym.service.impl;

import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.fitness_assessment.FitnessAssessmentForm;
import dio.gym.domain.fitness_assessment.FitnessAssessmentRepository;
import dio.gym.domain.fitness_assessment.FitnessAssessmentUpdateForm;
import dio.gym.domain.member.Member;
import dio.gym.domain.member.MemberRepository;
import dio.gym.exception.BusinessException;
import dio.gym.exception.NotFoundException;
import dio.gym.service.IFitnessAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class FitnessAssessmentServiceImpl implements IFitnessAssessmentService {
    private final FitnessAssessmentRepository fitnessAssessmentRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public FitnessAssessmentServiceImpl(FitnessAssessmentRepository fitnessAssessmentRepository, MemberRepository memberRepository) {
        this.fitnessAssessmentRepository = fitnessAssessmentRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public FitnessAssessment create(FitnessAssessmentForm fitnessAssessmentToCreate) {
        ofNullable(fitnessAssessmentToCreate).orElseThrow(() -> new BusinessException("FitnessAssessment to create must not be null"));
        FitnessAssessment fitnessAssessment = new FitnessAssessment();
        Member member = memberRepository.findById(fitnessAssessmentToCreate.getMemberId()).orElseThrow(() -> new BusinessException("Member not found"));
        fitnessAssessment.setMember(member);
        fitnessAssessment.setWeight(fitnessAssessmentToCreate.getWeight());
        fitnessAssessment.setHeight(fitnessAssessmentToCreate.getHeight());

        return fitnessAssessmentRepository.save(fitnessAssessment);
    }

    @Override
    public List<FitnessAssessment> findAll() {
        return fitnessAssessmentRepository.findAll();
    }

    @Override
    public FitnessAssessment findById(Long id) {
        return fitnessAssessmentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public FitnessAssessment update(Long id, FitnessAssessmentUpdateForm fitnessAssessmentToUpdate) {
        FitnessAssessment dbFitnessAssessment = this.findById(id);

        dbFitnessAssessment.setWeight(fitnessAssessmentToUpdate.getWeight());
        dbFitnessAssessment.setHeight(fitnessAssessmentToUpdate.getHeight());
        return fitnessAssessmentRepository.save(dbFitnessAssessment);
    }

    @Override
    public void deleteById(Long id) {
        fitnessAssessmentRepository.deleteById(id);
    }
}
