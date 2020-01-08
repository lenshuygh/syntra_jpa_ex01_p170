package model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONS",
        indexes = {
                @Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"),
                @Index(name = "BIRTHDAY_INDEX", columnList = "BIRTHDAY")},
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ID")})
@SecondaryTable(name = "URLS")
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 40)
    private String lastName;

    @Column(name = "BIRTHDAY")
    private LocalDate birthDay;

    @Column(name = "GENDER", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(name = "PICTURE")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Column(name = "COMMNT")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String comment;

    @Column(name = "MARRIED")
    private boolean married;

    @Transient
    private int age;

    @Column(table = "URLS")
    private String homepage;

    @Embedded
    private Address address = new Address();

    public Person() {
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
