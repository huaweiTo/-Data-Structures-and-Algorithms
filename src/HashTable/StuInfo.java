package HashTable;

public class StuInfo {
    private int age;
    private int count;

    public StuInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }

    /**
     * 散列函数
     * @return
     */
    public int hashcode(){
        return age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
