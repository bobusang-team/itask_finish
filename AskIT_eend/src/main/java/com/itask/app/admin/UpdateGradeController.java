package com.itask.app.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.MypageMainDTO;

public class UpdateGradeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		// userNum 가져오기
	    int userNum = Integer.parseInt(request.getParameter("userNum"));
	    System.out.println("userNum: " + userNum + "--------------");
		String contextPath = request.getContextPath();

		String userNick = request.getParameter("userNick");
		
		adminDAO.UpdateGrade(userNum);
		MypageMainDTO userpage = adminDAO.Userpage(userNick);
	    request.setAttribute("userpage", userpage);
		 List<Map<String, String>> badges = new ArrayList<>();
		 List<Map<String, String>> mentoBadges = new ArrayList<>();
        mentoBadges.add(Map.of(
            "status", userpage.getUserMentoCert(),
            "name", "멘토",
            "imgSrc", contextPath + "/assets/img/profile_mento.png",
            "alt", "멘토뱃지이미지",
            "column","user_mento_cert"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsIPE(),
            "name", "정보처리기사",
            "imgSrc", contextPath + "/assets/img/cert_ipe.png",
            "alt", "정보처리기사이미지",
            "column", "CERTS_IPE"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsIPIE(),
            "name", "정보처리산업기사",
            "imgSrc", contextPath + "/assets/img/cert_ipie.png",
            "alt", "정보처리산업기사이미지",
            "column", "CERTS_IPIE"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsIPT(),
            "name", "정보처리기능사",
            "imgSrc", contextPath + "/assets/img/cert_ipt.png",
            "alt", "정보처리기능사이미지",
            "column", "CERTS_IPT"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsISE(),
            "name", "정보보안기사",
            "imgSrc", contextPath + "/assets/img/cert_ise.png",
            "alt", "정보보안기사이미지",
            "column", "CERTS_ISE"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsISIE(),
            "name", "정보보안산업기사",
            "imgSrc", contextPath + "/assets/img/cert_isie.png",
            "alt", "정보보안산업기사이미지",
            "column", "CERTS_ISIE"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsNetManager1(),
            "name", "네트워크관리사 1급",
            "imgSrc", contextPath + "/assets/img/cert_netmanager1.png",
            "alt", "네관1이미지",
            "column", "CERTS_NETMANAGER1"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsNetManager2(),
            "name", "네트워크관리사 2급",
            "imgSrc", contextPath + "/assets/img/cert_netmanager2.png",
            "alt", "네관2이미지",
            "column", "CERTS_NETMANAGER2"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsSqld(),
            "name", "SQLD",
            "imgSrc", contextPath + "/assets/img/cert_sqld.png",
            "alt", "sqld이미지",
            "column", "CERTS_SQLD"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsLinuxMaster1(),
            "name", "리눅스마스터 1급",
            "imgSrc", contextPath + "/assets/img/cert_linuxmaster1.png",
            "alt", "리마1이미지",
            "column", "CERTS_LINUXMASTER1"
        ));
        badges.add(Map.of(
            "status", userpage.getCertsLinuxMaster2(),
            "name", "리눅스마스터 2급",
            "imgSrc", contextPath + "/assets/img/cert_linuxmaster2.png",
            "alt", "리마2이미지",
            "column", "LINUXMASTER2"
        ));

		request.setAttribute("userpage", userpage);
		request.setAttribute("Tcount", userpage.getBadgeCount());
		request.setAttribute("badges", badges);
		request.setAttribute("mentoBadges", mentoBadges);
		System.out.println("=====Tcount 확인: " +  userpage.getBadgeCount());
       System.out.println("=====badges 정보 확인 : " + badges);

		
		result.setRedirect(true);
		result.setPath(contextPath + "/admin/userPage.ad?userNick=" + userNick); // 리다이렉트 경로 설정
		return result;
	}

}
