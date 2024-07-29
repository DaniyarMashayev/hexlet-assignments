package exercise;

class SafetyList {
    // BEGIN
    private int[] arr = new int[0];
    private int size;

    public int getSize() {
        return size;
    }

    public int get(int index) {
        return arr[index];
    }

    public synchronized void add(int data) {
        int[] destArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            destArray[i] = arr[i];
        }
        destArray[destArray.length - 1] = data;
        arr = destArray;
        size++;
    }
    // END
}
