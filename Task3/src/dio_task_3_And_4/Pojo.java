package dio_task_3_And_4;

public class Pojo implements Comparable <Pojo>{
    private String name;
    private int age;


    public Pojo(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (age != pojo.age) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", age= " + age;
    }

    @Override
    public int compareTo(Pojo o) {
        return this.name.compareTo(o.getName());
    }
}
