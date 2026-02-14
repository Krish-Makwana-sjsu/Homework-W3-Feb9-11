//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class WordFreq {
    String word;
    int frequency;
}


public class Main {

    public static WordFreq[] createWordFreqArray() {

        WordFreq[] arr=new WordFreq[10];

        arr[0]=new WordFreq();
        arr[0].word="happy";
        arr[0].frequency=400;
        arr[1]=new WordFreq();
        arr[1].word="satisfied";
        arr[1].frequency=100;
        arr[2]=new WordFreq();
        arr[2].word="neutral";
        arr[2].frequency=300;
        arr[3]=new WordFreq();
        arr[3].word="would buy again";
        arr[3].frequency=200;
        arr[4]=new WordFreq();
        arr[4].word="terrible";
        arr[4].frequency=160;
        arr[5]=new WordFreq();
        arr[5].word="inconvenient";
        arr[5].frequency=900;
        arr[6]=new WordFreq();
        arr[6].word="difficult to use";
        arr[6].frequency=100;
        arr[7]=new WordFreq();
        arr[7].word="easy to use";
        arr[7].frequency=140;
        arr[8]=new WordFreq();
        arr[8].word="would recommend to friends";
        arr[8].frequency=800;
        arr[9]=new WordFreq();
        arr[9].word="visit the store";
        arr[9].frequency=700;

        return arr;
    }

    public static void maxHeapify(WordFreq[] arr, int n, int i) {

        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left].frequency>arr[largest].frequency) {
            largest=left;
        }

        if(right<n && arr[right].frequency>arr[largest].frequency) {
            largest=right;
        }

        if(largest!=i) {
            WordFreq temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            maxHeapify(arr, n, largest);
        }

    }

    public static void buildMaxHeap(WordFreq[] arr) {

        int n=arr.length;

        for(int i=(n/2)-1; i>=0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void main(String[] args) {

        WordFreq[] arr=createWordFreqArray();

        buildMaxHeap(arr);

        for(var WordFreq: arr) {
            System.out.println(WordFreq.word+ ": " +WordFreq.frequency);
        }


    }
}