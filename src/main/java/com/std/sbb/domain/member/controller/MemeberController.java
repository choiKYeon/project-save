package com.std.sbb.domain.member.controller;

import com.std.sbb.domain.member.form.MemberForm;
import com.std.sbb.domain.member.service.MemberService;
import com.std.sbb.global.email.entity.MailVo;
import com.std.sbb.global.email.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemeberController {

    private final MemberService memberService;
    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
    @GetMapping("/signup")
    public String signup(Model model, MemberForm memberForm) {
        model.addAttribute("memberForm", new MemberForm());
        return "signup_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid MemberForm memberForm, BindingResult bindingResult){
        if (!memberForm.getPassword1().equals(memberForm.getPassword2())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        try {
            this.memberService.join(
                    memberForm.getNickname(),
                    memberForm.getPassword1(),
                    memberForm.getUsername(),
                    memberForm.getPhoneNumber(),
                    memberForm.getEmail(),
                    memberForm.getGender(),
                    memberForm.getBirthDate(),
                    null);
        } catch(DataIntegrityViolationException e) {
        e.printStackTrace();
        bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
        return "signup_form";
    }catch(Exception e) {
        e.printStackTrace();
        bindingResult.reject("signupFailed", e.getMessage());
        return "signup_form";
    }

        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(){
        return "member_detail";
    }
}