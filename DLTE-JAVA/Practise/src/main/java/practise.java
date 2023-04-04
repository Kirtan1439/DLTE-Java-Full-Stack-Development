public class practise {
    public static void main(String[] args) {
        abc obj=new abc();
        System.out.println(obj.setId());


    }


    }
class abc{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
