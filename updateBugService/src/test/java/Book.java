import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class Book implements Cloneable{

    @NotBlank(message = "name")
    private String name;
    @NotBlank(message = "nums")
    private List<Integer> nums;

    private Date date;
    public Book(@NotBlank(message = "name") String name, @NotEmpty(message = "nums") List<Integer> nums) {
        this.name = name;
        this.nums = nums;
    }

    public Book() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", nums=" + nums +
                '}';
    }

    public <T>void get(T t){
       t.toString();
    }

    @Override
    public Object clone(){
        Book b=null;
        try {
            b = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }
}
