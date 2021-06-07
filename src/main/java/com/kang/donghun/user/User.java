package com.kang.donghun.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private  String email;

    @Column
    private String picture;

//    @Column
//    private String provider;
//
//    @Column
//    private String providerId;


    @Builder
    public User(String name, String email, String picture, Role role ) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
//        this.provider = provider;
//        this.providerId = providerId;
    }


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User update(String name , String picture){
        this.name = name;
        this.picture = picture;

        return this;

    }

    public String getRolekey(){
        return this.role.getKey();
    }

}
