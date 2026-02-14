
// Creating a class to store the word and its frequency (Same class as the one shown in the assignment description)
class WordFreq {
    String word;
    int frequency;
}

// Main class to create the array of WordFreq objects, build a max heap, and print the results
public class Main {

    // Method to create an array of WordFreq objects with the words and frequencies as given in the assignment description
    public static WordFreq[] createWordFreqArray() {

        WordFreq[] arr=new WordFreq[10];        // creating an array of WordFreq objects with a size of 10

        // Initializing each element of the array with a new WordFreq object and setting the word and frequency
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

        return arr;         // returning the array of WordFreq objects
    }

    // Method to maintain the max heap property for a given index in the array
    public static void maxHeapify(WordFreq[] arr, int n, int i) {

        int largest=i;          // initializing largest as the current index
        int left=2*i+1;         // calculating the index of the left child
        int right=2*i+2;        // calculating the index of the right child

        // Comparing the frequency of the left child with the largest and updating the largest if necessary
        if(left<n && arr[left].frequency>arr[largest].frequency) {
            largest=left;
        }

        // Comparing the frequency of the right child with the largest and updating the largest if necessary
        if(right<n && arr[right].frequency>arr[largest].frequency) {
            largest=right;
        }

        // If the largest is not the current index, swap the elements at the current index and the largest index
        if(largest!=i) {
            WordFreq temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            // Recursively calling the maxHeapify method for the largest index to maintain the heap property
            maxHeapify(arr, n, largest);
        }

    }

    // Method to build a max heap from the given array of WordFreq objects
    public static void buildMaxHeap(WordFreq[] arr) {

        // Getting the size of the array
        int n=arr.length;

        // Calling the maxHeapify method for each non-leaf node starting from the last non-leaf node down to the root node
        for(int i=(n/2)-1; i>=0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void main(String[] args) {

        // Creating an array of WordFreq objects using the createWordFreqArray method
        WordFreq[] arr=createWordFreqArray();

        // Building a max heap from the array of WordFreq objects using the buildMaxHeap method
        buildMaxHeap(arr);

        // Printing the word and frequency of each wordFreq object in the array after building the max heap
        for(var WordFreq: arr) {
            System.out.println(WordFreq.word+ ": " +WordFreq.frequency);
        }


    }
}