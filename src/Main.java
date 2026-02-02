public class Main {
    public static void main(String[] args) {
        MyArray myArray=new MyArray();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        System.out.println(myArray);
        myArray.addList(44);
        System.out.println(myArray);
        Integer getIndex=myArray.get(1);
        System.out.println(getIndex);
    }
}