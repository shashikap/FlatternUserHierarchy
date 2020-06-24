package com.dbs.codetest.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "useraccess")
public class UserAccess {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Column(name = "empid")
    private String empId;

    @NonNull
    @Column(name = "accesskey")
    private String accessKey;

    @NonNull
    @Column(name = "country")
    private String country;

    @Column(name = "subuser")
    private String subUser;

    @Column(name = "subuseraccesskey")
    private String subUseraccessKey;

    @Column(name = "subusercountry")
    private String subUserCountry;

}
