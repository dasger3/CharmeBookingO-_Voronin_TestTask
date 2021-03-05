package BackToStock;

public class User {
    private String name;
    private boolean premium;
    private int age;

    public User (String name, boolean premium, int age) {
        this.name = name;
        this.premium = premium;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (premium == true) {
            str.append("Premium ");
        } else {
            str.append("Default ");
        }
        str.append(name + " is "+age + " years old");
        return str.toString();
    }
}
