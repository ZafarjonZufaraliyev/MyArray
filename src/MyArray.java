public class MyArray {
    private Integer values[];
    private int currentIndex = 0;

    public MyArray() {
        values = new Integer[10];
    }

    public void add(Integer value) {
        increat();
        values[currentIndex] = value;
        currentIndex++;
    }

    public void add(int index, Integer value) {
        if (index<0 || index>=currentIndex ){
            System.err.println("shiftToRigthe--> ERROR");
            return;
        }
        shiftToRigthe(index);
        values[index]=value;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < currentIndex; i++) {
            str = str + values[i];
            if (i != currentIndex - 1) {
                str = str + ",";
            }
        }
        str = str + "]";
        return str;
    }

    private void shiftToRigthe(int index) {
        if (index<0 || index>=currentIndex ){
            System.err.println("shiftToRigthe--> ERROR");
            return;
        }
        increat();
        for (int i = currentIndex; i != index; i--) {
            values[i]=values[i-1];
        }
        values[index]=null;
        currentIndex++;
    }

    private void increat(){
        if (currentIndex >= values.length) {
            Integer[] newValues = new Integer[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
    }

    public void addFist(Integer value){
        add(0,value);
    }
    public void addList(Integer value){
        add(value);
    }
    ///
    public Integer get(int index){
        for (int i=0;i<values.length;i++){
            if (i==index){
                return values[i];
            }
        }
        return null;
    }
}
