package chanhee;

public class MovieUser {

    private String name; // 회원의 이름
    private int age; // 회원의 나이
    private Gender gender; // 회원의 성별
    private String id; // 회원이 사용할 아이디
    private String password; // 회원이 사용할 비밀번호

    public MovieUser(String name, int age, Gender gender, String id, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MovieUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
