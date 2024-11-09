package dio.gym.controller;

import dio.gym.domain.fitness_assessment.FitnessAssessment;
import dio.gym.domain.member.Member;
import dio.gym.domain.member.MemberForm;
import dio.gym.domain.member.MemberUpdateForm;
import dio.gym.service.impl.MemberServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping
    public Member create(@Valid @RequestBody MemberForm memberToCreate){
        return memberService.create(memberToCreate);
    }

    @GetMapping("/fitness-assessments/{id}")
    public List<FitnessAssessment> getAllFitnessAssessmentByMemberId(@PathVariable Long id){
        return memberService.getAllFitnessAssessmentByMemberId(id);
    }
    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id){
        return memberService.findById(id);
    }
    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody MemberUpdateForm memberToUpdate){
        return memberService.update(id, memberToUpdate);
    }
    @GetMapping
    public List<Member> findAll(){
        return memberService.findAll();
    }
    @DeleteMapping
    public void delete(@PathVariable Long id){
        memberService.deleteById(id);
    }
}
