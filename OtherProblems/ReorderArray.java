package OtherProblems;

public class ReorderArray {
    public int[] reorder(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return array;
        }
        // this is important, for odd size case, it may lead to stack overflow
        if (array.length % 2 == 0) {
            arrayReorder(array, 0, array.length - 1);
        } else {
            arrayReorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void arrayReorder(int[] arr, int l, int r) {
        if (r - l <= 1) {
            return;
        }

        int size = r - l + 1;
        int mid = l + size / 2;
        int lmid = l + size / 4;
        int rmid = l + size * 3 / 4;

        reverse(arr, lmid, mid - 1);
        reverse(arr, mid, rmid - 1);
        reverse(arr, lmid, rmid - 1);

        arrayReorder(arr, l, l + 2 * (lmid - l) - 1);
        arrayReorder(arr, l + 2 * (lmid - l), r);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l <= r) {
            swap(arr, l++, r--);
        }
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        ReorderArray solution = new ReorderArray();
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        solution.reorder(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
