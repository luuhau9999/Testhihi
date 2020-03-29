import java.util.Arrays;

public class MinHeap {
    private int size;
    private final int MAX = 1000;
    private int[] a = new int[MAX];
    public MinHeap(int[] array){
        size = array.length;
        System.arraycopy(array, 0, a, 1, array.length);
        this.toMinHeap();

    }
    private void toMinHeap(){
        for(int i = size/2; i > 0; i--){
            down(i);
        }
    }
    public MinHeap(){
        size = 0;
    }
    private void down(int k){
        int temp = a[k];
        int child;
        while(2 * k <= this.size){
            child = 2 * k;
            if(child < size && a[child] > a[child + 1]) child = child + 1;
            if(temp > a[child]) a[k] = a[child];
            else break;
            k = child;
        }
        a[k] = temp;
    }
    public int[] MinHeapSort(){
        int originalSize = size;
        for(int i = size; i > 1; i-- ){
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            size -= 1;
            down(1);
        }
        int[] result = new int[originalSize];
        System.arraycopy(a, 1, result, 0, originalSize);
        return result;

    }
    public void insert(int value){
        size = size + 1;
        int i = size;
        while(i > 1){
            if(value < a[i/2]) a[i] = a[i/2];
            else break;
            i = i / 2;
        }
        a[i] = value;
    }

    @Override
    public String toString() {
        int[] output = new int[size];
        System.arraycopy(a,1,output, 0, size);
        return Arrays.toString(output);
    }

    public static void main(String[] args) {
        // write your code here
        MinHeap MinHeap1 = new MinHeap();
        int[] data = {1, 4, 5, 6, 2, 3};
        for(int i = 0; i < data.length; i++){
            MinHeap1.insert(data[i]);
        }
        System.out.println(MinHeap1);
        MinHeap MinHeap2 = new MinHeap(data);
        String str = Arrays.toString(MinHeap2.MinHeapSort());
        System.out.println(str);

    }
}
// day la cmt update
//Duy da sua file nay
//fix conflict
//fix loi
//duy fix conflict
//aaaaaaaa
//fix loi conflict
