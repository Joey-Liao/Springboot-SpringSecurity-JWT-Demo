package cn.echisan.springbootjwtdemo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class JwtUser implements UserDetails {

    //这里可以自定义自己的属性
    private Integer id;
    private String username;
    private String password;
    //这里的GrantedAuthority可以自定义子类
    //private List<Role> roles = new ArrayList<>();

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        //roles.add(new Role(1,user.getRole(),user.getRole()));
        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    //    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        roles.forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
//        return grantedAuthorities;
//    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }

}
