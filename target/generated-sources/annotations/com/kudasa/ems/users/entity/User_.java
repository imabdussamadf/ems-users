package com.kudasa.ems.users.entity;

import com.kudasa.ems.users.entity.Credential;
import com.kudasa.ems.users.entity.Operations;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-16T14:06:51")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> unit;
    public static volatile SingularAttribute<User, Operations[]> operations;
    public static volatile SingularAttribute<User, Credential> credential;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> rank;
    public static volatile SingularAttribute<User, byte[]> photo;
    public static volatile SingularAttribute<User, String> otherName;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> department;
    public static volatile SingularAttribute<User, String> email;

}