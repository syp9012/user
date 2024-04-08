package com.example.demo.controller;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.KakaoOAuthToken;
import com.example.demo.model.KakaoProfile;
import com.example.demo.model.NaverOAuthToken;
import com.example.demo.model.NaverProfile;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	//네이버 application.yaml 파일을 가져와 변수에 저장
	//네이버
	//네이버 clientid
	@Value("${spring.security.oauth2.client.registration.naver.clientId}")
	private String naverClientId;
	
	//네이버 clientSecret
	@Value("${spring.security.oauth2.client.registration.naver.clientSecret}")
	private String naverClientSecret;
	
	//네이버 clientAuthenticationMethod
	@Value("${spring.security.oauth2.client.registration.naver.clientAuthenticationMethod}")
	private String naverClientAuthenticationMethod;
	
	//네이버 authenticationGrantType
	@Value("${spring.security.oauth2.client.registration.naver.authorizationGrantType}")
	private String naverAuthorizationGrantType;
	
	//네이버 redirectUri
	@Value("${spring.security.oauth2.client.registration.naver.redirectUri}")
	private String naverRedirectUri;
	
	//네이버 clientName
	@Value("${spring.security.oauth2.client.registration.naver.clientName}")
	private String naverClientName;
	

	
	//카카오
	//카카오 clientid
	@Value("${spring.security.oauth2.client.registration.kakao.clientId}")
	private String kakaoClientId;
	
	//카카오 clientAuthenticationMethod
	@Value("${spring.security.oauth2.client.registration.kakao.clientAuthenticationMethod}")
	private String kakaoClientAuthenticationMethod;
	
	//카카오 authorizationGrantType
	@Value("${spring.security.oauth2.client.registration.kakao.authorizationGrantType}")
	private String kakaoAuthorizationGrantType;
	
	//카카오 redirectUri
	@Value("${spring.security.oauth2.client.registration.kakao.redirectUri}")
	private String kakaoRedirectUri;
	
	//카카오 clientName
	@Value("${spring.security.oauth2.client.registration.kakao.clientName}")
	private String kakaoClientName;
		

	
	@Autowired
	UserService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	// ID중복검사 ajax함수로 처리
	@RequestMapping(value = "user_idcheck.do", method = RequestMethod.POST)
	public String user_idcheck(@RequestParam("u_id") String u_id, Model model) throws Exception {
		
		int result = service.checkUserId(u_id);
		model.addAttribute("result", result);

		return "user/idcheckResult";
	}
	
	//로그인 폼
	@RequestMapping("user_login.do")
	public String user_login() {
		return "user/login";
	}
	
	//카카오톡 회원가입 로그인
	@GetMapping("/oauth/kakao/callback")
		public String kakaoCallback(@RequestParam("code") String code, HttpSession session, Model model) { // Data를 리턴해주는 컨트롤러 

		//post 방식으로 key=value  데이터를 요청(카카오쪽으로
		//Retrofit2
		//OkHttp
		//RestTemplate
		
		//HttpHeader 오브젝트 생성
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
		params.add("grant_type", kakaoAuthorizationGrantType);
		params.add("client_id", kakaoClientId);
		params.add("redirect_uri", kakaoRedirectUri);
		params.add("code", code);
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest=
				new HttpEntity<>(params,headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답받음
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);	
		
		System.out.println(response.getBody());
		//Gson,
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoOAuthToken oauthToken =null;
		
		//json으로 받아온 토큰값 파싱
		try {
			oauthToken = objectMapper.readValue(response.getBody(),KakaoOAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//HttpHeader 오브젝트 생성
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		
		headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2=
				new HttpEntity<>(headers2);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답받음
		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoProfileRequest2, String.class);	
		
		//Gson,
		ObjectMapper objectMapper2 = new ObjectMapper();
		//ObjectMapper를 사용하여 JSON 데이터를 DTO 객체로 변환할 때 FAIL_ON_UNKNOWN_PROPERTIES 기능을 비활성화하는 것은 유효한 접근 방법입니다. 
		//이렇게 하면 DTO 클래스에 정의되지 않은 속성이 JSON 데이터에 포함되어 있더라도 예외가 발생하지 않고 객체 변환이 계속됩니다.
		
		objectMapper2.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		KakaoProfile kakaoProfile =null;
		
		//json으로 받아온 토큰값 파싱
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//User 오브젝트 : id password email
		System.out.println("카카오아이디:" + kakaoProfile.getId());
		System.out.println("카카오이메일:" + kakaoProfile.getKakao_account().getEmail());
		
		System.out.println("카카오 id :" + kakaoProfile.getId()+"temp");
		UUID garbagePwd=UUID.randomUUID();
		System.out.println("카카오 비밀번호 :" + garbagePwd);
		System.out.println("카카오 닉네임:"+ "임시 닉네임");
		System.out.println("카카오 휴대폰번호:"+ "01000000000");
		
		User user = new User();
		user.setU_id(kakaoProfile.getId()+"temp");
		user.setU_pwd(garbagePwd.toString());
		user.setU_nickname("임시 닉네임");
		user.setU_phone("01000000000");
		
		
		if(service.checkUser(user.getU_id())==null&&service.checkUser(user.getU_withdraw()).equals("1")) {
			service.insertUser(user);
			session.setAttribute("u_id", user.getU_id());
			
			model.addAttribute("u_profile",user.getU_profile());
			model.addAttribute("u_nickname",user.getU_nickname());
		} else {
			user = service.checkUser(user.getU_id());
			session.setAttribute("u_id", user.getU_id());
			
			model.addAttribute("u_profile",user.getU_profile());
			model.addAttribute("u_nickname",user.getU_nickname());
			System.out.println(session.getAttribute("u_id"));
			System.out.println(model.getAttribute("u_nickname"));
		}
	    // utf8로 인코딩
		String encodedNickname  = URLEncoder.encode(user.getU_nickname(), StandardCharsets.UTF_8);

		return "redirect:/myPage.do?nickname=" + encodedNickname ;
	}
	
	//네이버 회원가입 로그인
	@GetMapping("/oauth/naver/callback")
		public String naverCallback(@RequestParam("code") String code, HttpSession session, Model model) { // Data를 리턴해주는 컨트롤러 
		
		//post 방식으로 key=value  데이터를 요청(카카오쪽으로
		//Retrofit2
		//OkHttp
		//RestTemplate
		
		//HttpHeader 오브젝트 생성
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Naver-Client-Id",naverClientId);
		headers.add("X-Naver-Client-Secret", naverClientSecret);
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
		params.add("grant_type", naverAuthorizationGrantType);
		params.add("client_id", naverClientId);
		params.add("client_secret", naverClientSecret);
		params.add("redirect_uri", naverRedirectUri);
		params.add("code", code);
		params.add("state", "1234");
		
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> naverTokenRequest=
				new HttpEntity<>(params,headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답받음
		ResponseEntity<String> response = rt.exchange("https://nid.naver.com/oauth2.0/token?", HttpMethod.POST, naverTokenRequest, String.class);	
		
		System.out.println(response.getBody());
		//Gson,
		ObjectMapper objectMapper = new ObjectMapper();
		NaverOAuthToken oauthToken =null;
		
		
		//json으로 받아온 토큰값 파싱
		try {
			oauthToken = objectMapper.readValue(response.getBody(),NaverOAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		//HttpHeader 오브젝트 생성 RestTemplate
		RestTemplate rt2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		  
		headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> naverProfileRequest2= new HttpEntity<>(headers2);
		  
		 // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답받음 ResponseEntity<String>
		ResponseEntity<String>  response2 = rt2.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.POST, naverProfileRequest2, String.class);
		  
		//Gson, 
		ObjectMapper objectMapper2 = new ObjectMapper(); 
		//ObjectMapper를 사용하여 JSON 데이터를 DTO 객체로 변환할 때 FAIL_ON_UNKNOWN_PROPERTIES 기능을 비활성화하는 것은 유효한 접근 방법입니다. 
		//이렇게 하면 DTO 클래스에 정의되지 않은 속성이 JSON 데이터에 포함되어 있더라도 예외가 발생하지 않고 객체 변환이 계속됩니다.
		  
		objectMapper2.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		NaverProfile naverProfile =null;

		//json으로 받아온 토큰값 파싱 
		try { 
			naverProfile = objectMapper2.readValue(response2.getBody(),NaverProfile.class); 
		} catch(JsonMappingException e) { 
			e.printStackTrace(); 
		} catch(JsonProcessingException e) { 
			e.printStackTrace(); }
		
		//User 오브젝트 : id password email 
		System.out.println("네이버 아이디:" +naverProfile.getResponse().getId()); 
		System.out.println("네이버 이메일:" + naverProfile.getResponse().getEmail());
		
		System.out.println("네이버 id :" + naverProfile.getResponse().getId()+"temp"); 
		UUID garbagePwd=UUID.randomUUID(); 
		System.out.println("네이버 비밀번호 :" + garbagePwd);
		System.out.println("네이버 닉네임:"+ "임시 닉네임"); 
		System.out.println("네이버 휴대폰번호:"+ "01000000000");
		
		User user = new User(); 
		user.setU_id(naverProfile.getResponse().getId()+"temp");
		user.setU_pwd(garbagePwd.toString()); 
		user.setU_nickname("임시 닉네임");
		user.setU_phone("01000000000");
		
		// 가입자 혹은 비 가입자 체크 해서 처리 // service.checkUser(user.getU_id())
		 
		if(service.checkUser(user.getU_id())==null) { 
			service.insertUser(user);
			session.setAttribute("u_id", user.getU_id());
			model.addAttribute("u_profile",user.getU_profile());
			model.addAttribute("u_nickname",user.getU_nickname()); 
		} else { 
		user = service.checkUser(user.getU_id()); session.setAttribute("u_id", user.getU_id());
		model.addAttribute("u_profile",user.getU_profile());
		model.addAttribute("u_nickname",user.getU_nickname());
		System.out.println(session.getAttribute("u_id"));
		System.out.println(model.getAttribute("u_nickname")); } 
		// utf8로 인코딩 
		String encodedNickname = URLEncoder.encode(user.getU_nickname(),StandardCharsets.UTF_8);
		
		
		return "redirect:/myPage.do?nickname=" + encodedNickname;
	}
	
	
	//myPage 이동
	@RequestMapping("myPage.do")
	public String myPage(HttpSession session, Model model) {
		String id = (String) session.getAttribute("u_id");
		System.out.println(id);
		User user = service.checkUser(id);
		model.addAttribute("u_nickname", user.getU_nickname());
		System.out.println("model:"+model.getAttribute("u_nickname"));
		model.addAttribute("u_profile", user.getU_profile());
	
		return "user/myPage";
	}

	
	//회원가입 폼
	@RequestMapping("user_join.do")
	public String user_join() {
		return "user/join";
	}
	
	//회원가입
	@RequestMapping("user_join_ok.do")
	public String user_join_ok(User user, Model model, HttpSession session) throws Exception {
		
		
		service.insertUser(user);
		
		
		return "redirect:user_login.do";
	}	

	
	// 로그인 : 회원인증
	@RequestMapping("/user_login_ok.do")
	public String user_login_ok(@RequestParam("u_id") String u_id,
								@RequestParam("u_pwd")String u_pwd,
			                      HttpSession session, 
			                      Model model) throws Exception {
		int result=0;		
		User user = service.checkUser(u_id);
		
		if (user == null) {		// 등록되지 않은 회원일때			
			result = 1;
			model.addAttribute("result", result);
			
			return "user/loginResult";
			
		} else if(user.getU_withdraw().equals("1")){				// 등록된 회원일때
			if (user.getU_pwd().equals(u_pwd)) {			// 비번이 같을때
				session.setAttribute("u_id", u_id);         	// 세션 설정

				String u_nickname = user.getU_nickname();

				model.addAttribute("u_nickname", u_nickname);
				model.addAttribute("u_profile", user.getU_profile());
				return "user/myPage";
				
			} else {									// 비번이 다를때
				result = 2;
				model.addAttribute("result", result);
			}
		}
			return "user/loginResult";				

	}
	
	//로그아웃
	@RequestMapping("user_logout.do")
	public String user_logout(HttpSession session) {
		session.invalidate();
		return "redirect:user_login.do";
	}
	
	//회원정보 수정폼
	@RequestMapping("user_edit.do")
	public String user_edit(HttpSession session, Model model) {
		String id = (String) session.getAttribute("u_id");
		
		User user = service.checkUser(id);
		
		model.addAttribute("user",user);
		
		return "user/edit";
	}

	
	//회원정보 수정
	@RequestMapping("user_edit_ok.do")
	public String user_edit_ok(@RequestParam("u_profile1") MultipartFile mf, 
								@ModelAttribute User user,
								 HttpSession session, 
								 HttpServletRequest request, 
								 Model model)  throws Exception {
		System.out.println("user 아이디"+user.getU_id());

		String id = (String) session.getAttribute("u_id");
		user.setU_id(id);
		
		
		String filename = mf.getOriginalFilename();
		int size = (int) mf.getSize();		
		
		String path = session.getServletContext().getRealPath("upload");
		System.out.println("path:"+path);
		
		int result=0;		
		String newfilename = "";
		
	  if(size > 0){	 	// 첨부파일이 전송된 경우		
		
		// 파일 중복문제 해결
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		System.out.println("extension:"+extension);
				
		UUID uuid = UUID.randomUUID();
				
		newfilename = uuid.toString() + extension;
		System.out.println("newfilename:"+newfilename);			
		
		if(size > 100000){		// 100KB
			result=1;
			model.addAttribute("result", result);
			
			return "user/uploadResult";
			
		}else if(!extension.equals(".jpg")  &&
				 !extension.equals(".jpeg") &&
				 !extension.equals(".gif")  &&
				 !extension.equals(".png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "user/uploadResult";
		}	
     }
		
	  if (size > 0) {		 		// 첨부파일 전송
			mf.transferTo(new File(path + "/" + newfilename));
	  }		


		User db = this.service.checkUser(id);		
		
		if (size > 0 ) { 			// 첨부 파일이 수정되면
			user.setU_profile(newfilename);			
		} else { 					// 첨부파일이 수정되지 않으면
			user.setU_profile(db.getU_profile());
		}
		//user 객체에 id 값을 주입
		user.setU_id(id);		
		// update SQL문 
		service.updateUser(user);		

		model.addAttribute("u_nickname", user.getU_nickname());
		model.addAttribute("u_profile", user.getU_profile());
		System.out.println(user.getU_profile());
		
		return "user/myPage";
	}
	
	// 회원 탈퇴
	@RequestMapping("user_delete.do")
	public String deleteUser(HttpSession session) {
		
		service.deleteUser((String) session.getAttribute("u_id"));
		session.invalidate();
		
		
		return "redirect:user_login.do";
	}

	
	
	
	
	
}

