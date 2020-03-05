package com.example.configclient;


import com.example.configclient.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    MemberProfileConfiguration memberProfileConfiguration;

    @RequestMapping("/profile")
    public MemberProfileConfiguration getMemberProfileConfiguration(){
        System.out.println("foekkkkk");
        System.out.println(memberProfileConfiguration);
        return memberProfileConfiguration;
    }
}
