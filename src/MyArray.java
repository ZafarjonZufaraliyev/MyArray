import java.util.IllegalFormatCodePointException;

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
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRigthe--> ERROR");
            return;
        }
        shiftToRigthe(index);
        values[index] = value;
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
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRigthe--> ERROR");
            return;
        }
        increat();
        for (int i = currentIndex; i != index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = null;
        currentIndex++;
    }

    private void shiftToLift(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRigthe--> ERROR");
            return;
        }
        for (int i = index; i < currentIndex - 1; i++) {
            values[i] = values[i + 1];
        }
        currentIndex--;
        values[currentIndex] = null;
    }

    private void increat() {
        if (currentIndex >= values.length) {
            Integer[] newValues = new Integer[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
    }

    ///
    public void removeFist() {
        remove(0);
    }

    public void removeLast() {
        remove(currentIndex - 1);
    }

    public int remove(Integer value) {
        int index = indexOf(value);
        if (index == -1) {
            return -1;
        }
        remove(index);
        return index;
    }

    public void clear() {
        values = new Integer[5];
        currentIndex = 0;
    }

    public void addFist(Integer value) {
        add(0, value);
    }

    public void addList(Integer value) {
        add(value);
    }

    ///
    public Integer get(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("get--> ERROR");
            return null;
        }
        return values[index];
    }

    public int indexOf(Integer value) {
        if (value == null) {
            System.err.println("indexOf --> ERROR");
        }
        for (int i = 0; i < values.length; i++) {
            if (value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    public int set(int index, Integer value) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("set--> ERROR");
            return -1;
        }
        int oldvalue = values[index];
        values[index] = value;
        return oldvalue;
    }

    public Integer remove(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRigthe--> ERROR");
            return -1;
        }
        int oldvalue = values[index];
        shiftToLift(index);
        return oldvalue;
    }

    public boolean isEmpty() {
        if (currentIndex == 0) {
            return true;
        }
        return false;
    }

    public boolean isContains(Integer value) {
        int index = indexOf(value);
        if (index != -1) {
            return true;
        }
        return false;
    }

    public int size() {
        return currentIndex;
    }

    public Object[] toArray() {
        Object[] objexrArray = new Object[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            objexrArray[i] = values[i];
        }
        return objexrArray;
    }
    public void printAll(){
        System.out.println(this.toString());
    }
    public void printFist(){
        if (currentIndex==0){
            System.out.println("Array bosh");
        }
        System.out.println("Fist element: "+values[0]);
        System.out.println("Last element: "+values[currentIndex-1]);

    }
}
