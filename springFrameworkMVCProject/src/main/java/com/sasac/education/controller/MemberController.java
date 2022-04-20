package com.sasac.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sasac.education.model.MemberService;

import kr.co.sasac.vo.MemberVO;

@Controller
public class MemberController {

	
	@Autowired
	MemberService mService;

	@GetMapping("/member/list")
	public String memberlist(Model model) {
		model.addAttribute("memberList", mService.selectAll());
		return "member/memberList";
	}
	@GetMapping("/member/detail")
	public String memberDetail(String mid, Model model) {
		model.addAttribute("member", mService.selectById(mid));
		return "member/detailMember";
	}
	@PostMapping(value = "/member/update")
	public String memberUpdate(MemberVO member, Model model) {
		mService.updateMember(member);
		return "redirect:/member/list";
	}
	@GetMapping("/member/insert")
	public String memberinsert(String mid, Model model) {
		model.addAttribute("member", mService.selectById(mid));
		return "member/detailMember";
	}
	@PostMapping(value = "/member/insert")
	public String memberinsertPost(MemberVO member, Model model) {
		mService.insertMember(member);
		return "redirect:/member/list";
	}
}
