package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class kakaoLoginController {
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback() {
		return "īī�� ���� �Ϸ�";
	}
}
