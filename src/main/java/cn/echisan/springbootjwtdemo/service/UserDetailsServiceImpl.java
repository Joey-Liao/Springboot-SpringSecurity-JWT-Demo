package cn.echisan.springbootjwtdemo.service;

import cn.echisan.springbootjwtdemo.entity.JwtUser;
import cn.echisan.springbootjwtdemo.entity.User;
import cn.echisan.springbootjwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        return new JwtUser(user);
    }

    public String trans (String s, int n) {
        // write code here
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='a'&&ch<='z'){
                sb.append((char)(ch-'a'+'A'));
            }else if(ch>='A'&&ch<='Z'){
                sb.append((char)(ch-'A'+'a'));
            }else{
                sb.append(" ");
            }
        }
        String[] ss=sb.toString().split(" ");

        sb=new StringBuilder();
        if(s.charAt(n-1)==' ') sb.append(" ");
        for(int i=ss.length-1;i>=0;i--){
            sb.append(ss[i]);
            if(i!=0) {
                sb.append(" ");
            }
        }
        if(s.charAt(0)==' ') sb.append(" ");
        return sb.toString();
    }

}
